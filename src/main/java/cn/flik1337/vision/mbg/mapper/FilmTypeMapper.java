package cn.flik1337.vision.mbg.mapper;

import cn.flik1337.vision.mbg.model.FilmType;
import cn.flik1337.vision.mbg.model.FilmTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmTypeMapper {
    long countByExample(FilmTypeExample example);

    int deleteByExample(FilmTypeExample example);

    int deleteByPrimaryKey(Integer filmTypeId);

    int insert(FilmType record);

    int insertSelective(FilmType record);

    List<FilmType> selectByExample(FilmTypeExample example);

    FilmType selectByPrimaryKey(Integer filmTypeId);

    int updateByExampleSelective(@Param("record") FilmType record, @Param("example") FilmTypeExample example);

    int updateByExample(@Param("record") FilmType record, @Param("example") FilmTypeExample example);

    int updateByPrimaryKeySelective(FilmType record);

    int updateByPrimaryKey(FilmType record);
}