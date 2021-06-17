package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.mbg.model.FilmType;
import cn.flik1337.vision.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmType")
public class FilmTypeController {
    @Autowired
    private FilmTypeService filmTypeService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public CommonResult getAll(){
        List<FilmType> list = filmTypeService.getFilmTypeList();
        if (list != null) {
            return CommonResult.success(list);
        }
        return CommonResult.failed();
    }

}
