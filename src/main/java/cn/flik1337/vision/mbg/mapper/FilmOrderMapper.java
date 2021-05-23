package cn.flik1337.vision.mbg.mapper;

import cn.flik1337.vision.mbg.model.FilmOrder;
import cn.flik1337.vision.mbg.model.FilmOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmOrderMapper {
    long countByExample(FilmOrderExample example);

    int deleteByExample(FilmOrderExample example);

    int deleteByPrimaryKey(String filmOrderId);

    int insert(FilmOrder record);

    int insertSelective(FilmOrder record);

    List<FilmOrder> selectByExample(FilmOrderExample example);

    FilmOrder selectByPrimaryKey(String filmOrderId);

    int updateByExampleSelective(@Param("record") FilmOrder record, @Param("example") FilmOrderExample example);

    int updateByExample(@Param("record") FilmOrder record, @Param("example") FilmOrderExample example);

    int updateByPrimaryKeySelective(FilmOrder record);

    int updateByPrimaryKey(FilmOrder record);
}