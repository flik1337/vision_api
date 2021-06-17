package cn.flik1337.vision.service.impl;

import cn.flik1337.vision.common.exception.Asserts;
import cn.flik1337.vision.common.utils.StringsUtil;
import cn.flik1337.vision.dao.FilmDao;
import cn.flik1337.vision.mbg.mapper.FilmBroadcastMapper;
import cn.flik1337.vision.mbg.mapper.FilmMapper;
import cn.flik1337.vision.mbg.model.*;

import cn.flik1337.vision.service.FilmService;
import cn.flik1337.vision.service.OssService;
import cn.flik1337.vision.vo.FilmDetailVo;
import cn.flik1337.vision.vo.FilmVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.util.List;

import static cn.flik1337.vision.common.api.ResultCode.*;

@Service
public class FilmServiceImpl implements FilmService {
    @Resource
    private FilmMapper filmMapper;
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private StringsUtil stringsUtil;
    @Autowired
    private OssService ossService;
    @Resource
    private FilmBroadcastMapper filmBroadcastMapper;

    @Override
    public boolean checkParams(Film film){
        if (stringsUtil.hasEmpty(film.getFilmName())){
            return false;
        }
        if (film.getReleaseTime() == null){
            return false;
        }
        if (film.getOffTime() == null){
            return false;
        }
        if (stringsUtil.hasEmpty(film.getActor())){
            return false;
        }
        if (stringsUtil.hasEmpty(film.getArea())){
            return false;
        }
        if (stringsUtil.hasEmpty(film.getArea())){
            return false;
        }
        if (stringsUtil.hasEmpty(film.getDirector())){
            return false;
        }
        if (stringsUtil.hasEmpty(film.getProducer())){
            return false;
        }
        if (film.getFilmLength() == 0 || film.getFilmLength() == null){
            return false;
        }
        if (stringsUtil.hasEmpty(film.getFilmType())){
            return false;
        }

        return true;
    }

    @Override
    public void insertFilm(Film film){
        System.out.println(film.getOffTime().toString());
        if (!checkParams(film)){
            Asserts.fail(BODY_NOT_MATCH);
        }
        int filmId = filmMapper.insertSelective(film);
        if (filmId == 0){
            Asserts.fail(FAIL_UPDATE_TABLE);
        }

    }
    /**
    * @Description: 查询某个电影院可操作的电影列表
    * @Param:
    * @Date: 2021/5/28 07:29:00
    */

    @Override
    public List<FilmVo> getCinemaFilmList(int cinemaId){
        List<FilmVo> films = filmDao.getCinemaFilmList(cinemaId);

        return films;
    }

    @Override
    public List<FilmVo> getAllFilms() {
        List<FilmVo> films = filmDao.getAllFilmList();
        return films;
    }

    @Override
    public List<FilmVo> getFilmList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FilmVo> films = filmDao.getAllFilmList();
        return films;
    }

    @Override
    public FilmBroadcast setCinemaBroadcast(int filmId, MultipartFile poster,MultipartFile video,MultipartFile[] stages){
        Film film = filmMapper.selectByPrimaryKey(filmId);
        if (film == null){
            Asserts.fail(FILM_NOT_EXIST);
            return null;
        }
        FilmBroadcast filmBroadcast = new FilmBroadcast();
        filmBroadcast.setFilmId(filmId);

        if (poster != null){
            String posterName = ossService.uploadSingleFile(poster);
            filmBroadcast.setFilmPoster(posterName);
        }else{
            filmBroadcast.setFilmPoster(null);
        }
        if (video != null){
            String videoName = ossService.uploadSingleFile(video);
            System.out.println(videoName);
            filmBroadcast.setFilmVideo(videoName);
        }else{
            filmBroadcast.setFilmVideo(null);
        }

        if (!stages[0].isEmpty()){
            System.out.println(stages.toString());
            String stageNames = ossService.uploadMultiFile(stages);
            filmBroadcast.setFilmStage(stageNames);
        }else{
            filmBroadcast.setFilmStage(null);
        }

        // 判断是否已存在
        int broadcastId = checkBroadcastExist(filmId);
        if (broadcastId == -1){
            filmBroadcastMapper.insertSelective(filmBroadcast);

        }else{
            filmBroadcast.setFilmBroadcastId(broadcastId);
            filmBroadcastMapper.updateByPrimaryKey(filmBroadcast);

        }
        return filmBroadcast;

    }
    public int checkBroadcastExist(int filmId){
        FilmBroadcastExample example = new FilmBroadcastExample();
        FilmBroadcastExample.Criteria criteria = example.createCriteria();
        criteria.andFilmIdEqualTo(filmId);

        List<FilmBroadcast> broadcast = filmBroadcastMapper.selectByExample(example);
        if (broadcast.size() > 0){
            return broadcast.get(0).getFilmBroadcastId();
        }
        return -1;
    }
    /**
    * @Description: 获取电影的详情信息，包括评论
    * @Param:
    * @Date: 2021/6/1 10:58:01
    */
    @Override
    public FilmDetailVo  getFilmDetail(int filmId){
        FilmDetailVo filmVo = filmDao.getFilmDetail(filmId);

        // 设置评论总数
        filmVo.setCommentCount(filmDao.countFilmComments(filmId));


        return filmVo;
    }

}
