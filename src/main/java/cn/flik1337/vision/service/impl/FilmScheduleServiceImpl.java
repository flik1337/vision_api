package cn.flik1337.vision.service.impl;

import cn.flik1337.vision.common.exception.Asserts;
import cn.flik1337.vision.common.utils.DateCalcUtil;
import cn.flik1337.vision.common.utils.SeatUtil;
import cn.flik1337.vision.common.utils.StringsUtil;
import cn.flik1337.vision.dao.FilmScheduleDao;
import cn.flik1337.vision.mbg.mapper.FilmScheduleMapper;
import cn.flik1337.vision.mbg.mapper.HallMapper;
import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmSchedule;
import cn.flik1337.vision.mbg.model.Hall;
import cn.flik1337.vision.mbg.model.Ticket;
import cn.flik1337.vision.service.FilmScheduleService;
import cn.flik1337.vision.service.FilmService;
import cn.flik1337.vision.service.RedisService;
import cn.flik1337.vision.vo.CinemaFilmScheduleVo;
import cn.flik1337.vision.vo.FilmScheduleVo;
import cn.flik1337.vision.vo.FilmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static cn.flik1337.vision.common.api.ResultCode.FAILED;

@Service
public class FilmScheduleServiceImpl implements FilmScheduleService {
    @Autowired
    private FilmScheduleDao filmScheduleDao;
    @Autowired
    private RedisService redisService;
    @Autowired
    private FilmScheduleMapper filmScheduleMapper;
    @Autowired
    private HallMapper hallMapper;
    @Autowired
    private FilmService filmService;

    private static final String schedulePrefix  = "schedule_f_";
    private static final String scheduleSuffix  = "_c_";
    private static final String scheduleInfix  = "_id_";

    @Override
    public Hall getHallByScheduleId(int scheduleId) {
        List<Hall> halls = filmScheduleDao.getHallByScheduleId(scheduleId);
        if (halls.size() > 0){
            return halls.get(0);
        }
        return null;
    }

    public HashMap<String,Object> selectCinemaSchedule(int cinemaId, int certainFilmId){
        // 获取电影院可操作的电影列表
        HashMap<String,Object> map = new HashMap<>();
        int filmControlIndex = 0;
        List<FilmVo> filmList = filmService.getCinemaFilmList(cinemaId);
        if (filmList.size() == 0){
            return map;
        }
        int[] filmIds = new int[filmList.size()];
        List<CinemaFilmScheduleVo> cinemaFilmScheduleVoList = new ArrayList<>();
        for (int i = 0; i < filmList.size(); i++){
            int id = filmList.get(i).getFilm().getFilmId();
            if (certainFilmId != -1 && id == certainFilmId){
                System.out.println("certainFilmId="+certainFilmId+",index="+i);

                filmControlIndex = i;
            }
            filmIds[i] = id;
            // 遍历排片
            List<FilmScheduleVo> filmScheduleVoList = getAvailableSchedules(cinemaId,id);
            CinemaFilmScheduleVo cinemaFilmScheduleVo = new CinemaFilmScheduleVo();
            cinemaFilmScheduleVo.setFilmVo(filmList.get(i));
            cinemaFilmScheduleVo.setFilmScheduleVoList(filmScheduleVoList);

            cinemaFilmScheduleVoList.add(cinemaFilmScheduleVo);
        }
        map.put("films",cinemaFilmScheduleVoList);
        map.put("filmIndex",filmControlIndex);

        return map;

    }
    /**
     * @Description: 从redis中获取可使用的排片id，并从数据库中找
     * @Param:
     * @Date: 2021/6/2 08:51:53
     */
    @Override
    public List<FilmScheduleVo> getAvailableSchedules(int cinemaId, int filmId){
        List<Integer> ids = new ArrayList<>();
        String redisSchedulePattern = schedulePrefix + filmId + scheduleSuffix + cinemaId + scheduleInfix + "*";
        Set<String> keySet = redisService.keys(redisSchedulePattern);
        if (keySet.size() < 1 ){
            return null;
        }

        for (String key : keySet){
            String id = redisService.get(key);
            Integer filmScheduleId = Integer.parseInt(id);
            ids.add(filmScheduleId);
        }
        List<FilmScheduleVo> filmScheduleVoList = filmScheduleDao.queryScheduleByIds(ids);
        return filmScheduleVoList;

    }

    /**
    * @Description: 设置排片
    * @Param:
    * @Date: 2021/6/2 08:57:55
    */
    @Override
    public void setSchedule(FilmSchedule filmSchedule){
        // insert后 主键返回到对象中
        Integer insertCount =  filmScheduleMapper.insertSelective(filmSchedule);

        String redisScheduleKey = schedulePrefix + filmSchedule.getFilmId() + scheduleSuffix + filmSchedule.getCinemaId() + scheduleInfix + filmSchedule.getFilmScheduleId();

        // 截止日期为开场前5分钟
        long seconds = DateCalcUtil.getDay(filmSchedule.getScheduleDate()) - 5 * 60;


        // todo 暂时只存储排片的id 之后升级mongodb 可直接查询
        redisService.set(redisScheduleKey, String.valueOf( filmSchedule.getFilmScheduleId()));
        redisService.expire(redisScheduleKey,seconds);



    };
    /**
    * @Description: 设置排片过期
    * @Param:
    * @Date: 2021/6/4 07:32:33
    */
    public void setScheduleExpired(Integer id){
        filmScheduleDao.updateScheduleStatus(id);
    };




}
