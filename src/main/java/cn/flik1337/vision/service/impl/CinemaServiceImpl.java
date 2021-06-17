package cn.flik1337.vision.service.impl;

import cn.flik1337.vision.common.utils.DistanceUtil;
import cn.flik1337.vision.common.utils.MapUtil;
import cn.flik1337.vision.dao.CinemaDao;
import cn.flik1337.vision.dao.FilmScheduleDao;
import cn.flik1337.vision.mbg.mapper.CinemaMapper;
import cn.flik1337.vision.mbg.mapper.CinemaSpecMapper;
import cn.flik1337.vision.mbg.model.Cinema;
import cn.flik1337.vision.mbg.model.CinemaExample;
import cn.flik1337.vision.mbg.model.CinemaSpec;
import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.service.CinemaService;
import cn.flik1337.vision.service.FilmService;
import cn.flik1337.vision.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CinemaServiceImpl implements CinemaService {
    private static String NO_LIMIT_SPECIAL = "blank";
    @Autowired
    private CinemaDao cinemaDao;
    @Autowired
    private FilmService filmService;
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private FilmScheduleDao filmScheduleDao;
    @Autowired
    private CinemaSpecMapper cinemaSpecMapper;
    @Autowired
    private MapUtil mapUtil;

    public Cinema getCinemaByCinemaId(int cinemaId){
        return cinemaMapper.selectByPrimaryKey(cinemaId);
    }

    public int getIndexByFilmId(List<FilmVo> films,int filmId){
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getFilm().getFilmId() == filmId){
                return i;
            }
        }
        return -1;
    }


    /**
    * @Description: 查询电影院的电影安排
     * 若选择路径为：选择电影->选择电影院，则fromCinema=false,且须附带certainFilmId
    * @Param: [cinemaId, filmId, first]
    * @Date: 2021/5/28 06:07:54
    */
    @Override
    public Map<String,Object> selectFilmScheduleByFilmAndCinema(int cinemaId, boolean first, boolean fromCinema,int certainFilmId){
        Map<String,Object> results = new HashMap<>();
        List<FilmScheduleVo> filmScheduleVos;
        // 若是页面首次加载
        if (first){
            int firstFilmId;
            // 1.存放电影院信息
            Cinema cinema = getCinemaByCinemaId(cinemaId);
            results.put("cinema",cinema);


            // 2.获取电影信息列表
            List<FilmVo> filmList = filmService.getCinemaFilmList(cinemaId);

            //3.获取某个电影的排片
            // 若是来自"影院页面"
            if (fromCinema){

                if (filmList == null || filmList.size() == 0 ){
                    // 若查询不到该
                    results.put("films",null);
                }else{
                    results.put("films",filmList);
                }

                firstFilmId = filmList.get(0).getFilm().getFilmId();
                System.out.println(firstFilmId);
                results.put("filmIndex",0);
            }else{

                firstFilmId = certainFilmId;
                int filmIndex = getIndexByFilmId(filmList,certainFilmId);
                results.put("filmIndex",filmIndex == -1 ? 0 : filmIndex);

            }
            filmScheduleVos = filmScheduleDao.queryScheduleByCinemaAndFilm(firstFilmId,cinemaId);
            System.out.println(filmScheduleVos.toString());
            results.put("films",filmList);
            results.put("schedule",filmScheduleVos);
            return results;
        }else{

            filmScheduleVos = filmScheduleDao.queryScheduleByCinemaAndFilm(certainFilmId,cinemaId);
            results.put("cinema",null);
            results.put("films",null);
            results.put("filmIndex",-1); // 前端自行设置
            results.put("schedule",filmScheduleVos);
            return results;
        }


    }

    @Override
    public List<CinemaVo> getCinemasByCondition(String spec,int rank,String cityName,double latitude,double longitude,int certainFilmId){
        // rank == 0 距离， 1价格
//        CinemaExample cinemaExample = new CinemaExample();
//        CinemaExample.Criteria criteria = cinemaExample.createCriteria();
//        criteria.andCityLike(cityName + "%");
//        if (!spec.equals(NO_LIMIT_SPECIAL)) {
//            criteria.andSpecialLike("%"+spec+"%");
//        }
        //List<Cinema> cinemaList = cinemaMapper.selectByExample(cinemaExample);
        List<Cinema> cinemaList = cinemaDao.getCinemaListWithFilm(cityName,spec,certainFilmId);
        if (cinemaList.size() == 0){
            return new ArrayList<>();
        }
        Integer[] ids = new Integer[cinemaList.size()];

        for (int i = 0; i < cinemaList.size(); i++) {
            int cinemaId = cinemaList.get(i).getCinemaId();
            ids[i] = cinemaId;
        }
        List<CinemaPriceVo>  prices = cinemaDao.getCinemaMinPrice(ids);
        System.out.println(prices.toString());


        if (rank == 1){
            // 根据价格排序
            List<CinemaVo> cinemaVos = sortByPrice(cinemaList,prices,latitude,longitude);
            return cinemaVos;
        }else{
            // 根据从远到近排序
            List<CinemaVo> cinemaVos = sortByDistance(cinemaList,prices,latitude,longitude);
            return cinemaVos;
        }

    }
//    @Override
//    public List<CinemaVo> getCinemasByCondition(String spec,int rank,String cityName,double latitude,double longitude){
//        // rank == 0 距离， 1价格
//        CinemaExample cinemaExample = new CinemaExample();
//        CinemaExample.Criteria criteria = cinemaExample.createCriteria();
//        criteria.andCityLike(cityName + "%");
//        if (!spec.equals(NO_LIMIT_SPECIAL)) {
//            criteria.andSpecialLike("%"+spec+"%");
//        }
//
//        List<Cinema> cinemaList = cinemaMapper.selectByExample(cinemaExample);
//        if (cinemaList.size() == 0){
//            return new ArrayList<>();
//        }
//        Integer[] ids = new Integer[cinemaList.size()];
//
//        for (int i = 0; i < cinemaList.size(); i++) {
//            int cinemaId = cinemaList.get(i).getCinemaId();
//            ids[i] = cinemaId;
//        }
//        List<CinemaPriceVo>  prices = cinemaDao.getCinemaMinPrice(ids);
//        System.out.println(prices.toString());
//
//
//        if (rank == 1){
//            // 根据价格排序
//            List<CinemaVo> cinemaVos = sortByPrice(cinemaList,prices,latitude,longitude);
//            return cinemaVos;
//        }else{
//            // 根据从远到近排序
//            List<CinemaVo> cinemaVos = sortByDistance(cinemaList,prices,latitude,longitude);
//            return cinemaVos;
//        }
//
//    }
    public List<CinemaVo> sortByPrice(List<Cinema> cinemaList,List<CinemaPriceVo> priceList,double latitude,double longitude){
        List<CinemaVo> cinemaVoList = generateCinemaVoList(cinemaList,priceList,latitude,longitude);
        Collections.sort(cinemaVoList, new Comparator<CinemaVo>() {
            @Override
            public int compare(CinemaVo o1, CinemaVo o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
        return cinemaVoList;

    }

    public List<CinemaVo> sortByDistance(List<Cinema> cinemaList,List<CinemaPriceVo>  priceList,double latitude,double longitude){
        List<CinemaVo> cinemaVoList = generateCinemaVoList(cinemaList,priceList,latitude,longitude);

        Collections.sort(cinemaVoList, new Comparator<CinemaVo>() {
            @Override
            public int compare(CinemaVo o1, CinemaVo o2) {
                return o1.getDistance().compareTo(o2.getDistance());
            }
        });
        return cinemaVoList;

    }
    public List<CinemaVo> generateCinemaVoList(List<Cinema> cinemaList,List<CinemaPriceVo>  priceList,double latitude,double longitude){
        // priceList 的顺序为价格从小到大
        Map<Integer,Integer> priceMap = MapUtil.transToMap(priceList);
        List<CinemaVo> cinemaVoList = new ArrayList<>();
        for (int i = 0; i < cinemaList.size(); i++) {
            Cinema cinema = cinemaList.get(i);
            CinemaVo cinemaVo = new CinemaVo();

            double distance = DistanceUtil.getDistance(latitude,longitude,Double.parseDouble(cinema.getLat()),Double.parseDouble(cinema.getLng()));
            cinemaVo.setCinema(cinema);
            cinemaVo.setDistance(distance);
            cinemaVo.setPrice(priceMap.get( cinema.getCinemaId()) );
            cinemaVoList.add(cinemaVo);
        }
        return cinemaVoList;
    }
    @Override
    public List<CinemaSpec> getCinemaSpecList(){
        List<CinemaSpec> cinemaSpecList = cinemaDao.getCinemaSpecList();
        cinemaSpecList.forEach( i -> {
            System.out.println(i.toString());
        });
        return cinemaSpecList;
    }


}
