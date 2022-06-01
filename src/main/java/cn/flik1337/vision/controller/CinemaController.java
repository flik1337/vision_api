package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.dto.CinemaCondition;
import cn.flik1337.vision.service.CinemaService;

import cn.flik1337.vision.vo.CinemaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public CommonResult selectCinemaList(@RequestBody CinemaCondition condition){
        List<CinemaVo> cinemaVos = cinemaService.getCinemasByCondition(condition.getSpecial(),condition.getRank(),condition.getCity(),condition.getLatitude(),condition.getLongitude(),condition.getFilmId());
        return CommonResult.success(cinemaVos);
    }
    @RequestMapping(value = "/spec/list",method = RequestMethod.GET)
    public CommonResult getCinemaSpecList(){

        return CommonResult.success(cinemaService.getCinemaSpecList());
    }
}
