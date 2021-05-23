package cn.flik1337.vision.mbg.mapper;

import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmMapper {
    long countByExample(FilmExample example);

    int deleteByExample(FilmExample example);

    int deleteByPrimaryKey(Integer filmId);

    int insert(Film record);

    int insertSelective(Film record);

    List<Film> selectByExample(FilmExample example);

    Film selectByPrimaryKey(Integer filmId);

    int updateByExampleSelective(@Param("record") Film record, @Param("example") FilmExample example);

    int updateByExample(@Param("record") Film record, @Param("example") FilmExample example);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKey(Film record);
}