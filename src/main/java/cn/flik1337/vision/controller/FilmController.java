package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonPage;
import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmBroadcast;
import cn.flik1337.vision.mbg.model.Hall;
import cn.flik1337.vision.service.FilmScheduleService;
import cn.flik1337.vision.service.FilmService;

import cn.flik1337.vision.vo.FilmDetailVo;
import cn.flik1337.vision.vo.FilmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmScheduleService filmScheduleService;

    /**
    * @Description: 后台新增电影信息
    * @Param:
    * @Date: 2021/5/24 04:45:40
    */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult insertFilm(Film film){
        filmService.insertFilm(film);
        return CommonResult.success();
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<FilmVo>> getAllFilms(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize){

        return CommonResult.success(CommonPage.restPage(filmService.getFilmList(pageNum,pageSize)));
    }

    @RequestMapping(value = "/broadcast",method = RequestMethod.POST)
    public CommonResult setFilmBroadcast(@RequestParam("poster")MultipartFile poster,
                                         @RequestParam("video")MultipartFile video,
                                         @RequestParam("stage")MultipartFile[] stages,
                                         @RequestParam("filmId")int filmId){
        FilmBroadcast broadcast =  filmService.setCinemaBroadcast(filmId,poster,video,stages);
        if (broadcast != null){
            return CommonResult.success(broadcast);
        }
        return CommonResult.failed();

    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public CommonResult setFilmBroadcast(@RequestParam("filmId")Integer filmId){
        FilmDetailVo filmDetailVo = filmService.getFilmDetail(filmId);

        return CommonResult.success(filmDetailVo);

    }

    @RequestMapping(value = "/hall/seat",method = RequestMethod.GET)
    public CommonResult getHallByScheduleId(@RequestParam("scheduleId")Integer scheduleId){
        Hall hall = filmScheduleService.getHallByScheduleId(scheduleId);
        if (hall != null){
            return CommonResult.success(hall);
        }
        return CommonResult.failed();

    }
    /**
    * @Description: 查询某场次已选座位
    * @Param:
    * @Date: 2021/6/2 10:47:29
    */
//    @RequestMapping(value = "/hall/seat/selected",method = RequestMethod.GET)
//    public CommonResult getHallByScheduleId(@RequestParam("scheduleId")Integer scheduleId){
//
//        return null;
//
//    }


}
