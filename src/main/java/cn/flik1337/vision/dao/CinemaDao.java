package cn.flik1337.vision.dao;

import cn.flik1337.vision.mbg.model.Cinema;
import cn.flik1337.vision.mbg.model.CinemaSpec;
import cn.flik1337.vision.vo.CinemaPriceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Mapper
@Transactional
public interface CinemaDao {
    public List<CinemaPriceVo> getCinemaMinPrice(Integer[] ids);
    //public List<HashMap<Integer,Integer>> getCinemaMinPrice(Integer[] ids);
    public List<CinemaSpec> getCinemaSpecList();
    public List<Cinema> getCinemaListWithFilm(@Param("cityName")String cityName,@Param("spec")String spec,@Param("filmId")int filmId);
}
