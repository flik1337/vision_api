package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.mbg.model.FilmSchedule;
import cn.flik1337.vision.service.CinemaService;
import cn.flik1337.vision.service.FilmScheduleService;
import cn.flik1337.vision.vo.FilmScheduleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class FilmScheduleController {
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private FilmScheduleService filmScheduleService;
    /**
     * @Description: 获取电影院的电影和对应的排片
     * @Param:
     * @Date: 2021/5/28 08:47:59
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public CommonResult selectFilmScheduleByFilmAndCinema(@RequestParam("cinemaId")int cinemaId,
                                                          @RequestParam("first")boolean first,
                                                          @RequestParam("fromCinema")boolean fromCinema,
                                                          @RequestParam("certainFilmId")int certainFilmId){
        Map<String,Object> results = cinemaService.selectFilmScheduleByFilmAndCinema(cinemaId,first,fromCinema,certainFilmId);

        return CommonResult.success(results);


    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult setFilmSchedule(@RequestBody FilmSchedule filmSchedule){
        filmScheduleService.setSchedule(filmSchedule);
        return CommonResult.success();
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult getFilmScheduleList(@RequestParam("cinemaId")int cinemaId,
                                            @RequestParam("filmId")int filmId){
        List<FilmScheduleVo> list =  filmScheduleService.getAvailableSchedules(cinemaId,filmId);
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public CommonResult selectCinemaSchedule(@RequestParam("cinemaId")int cinemaId,
                                             @RequestParam("certainFilmId")int certainFilmId){
        return CommonResult.success(filmScheduleService.selectCinemaSchedule(cinemaId,certainFilmId));
    }




}
