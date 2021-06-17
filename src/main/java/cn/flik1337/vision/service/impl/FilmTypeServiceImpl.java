package cn.flik1337.vision.service.impl;

import cn.flik1337.vision.dao.FilmDao;
import cn.flik1337.vision.mbg.mapper.FilmTypeMapper;
import cn.flik1337.vision.mbg.model.FilmType;
import cn.flik1337.vision.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmTypeServiceImpl implements FilmTypeService {

    @Autowired
    private FilmDao filmDao;

    public List<FilmType> getFilmTypeList(){
        List<FilmType>  filmTypes = filmDao.getAllFilmTypes();
        if (filmTypes != null){
            return filmTypes;
        }
        return null;
    }


}
