package cn.flik1337.vision.mbg.mapper;

import cn.flik1337.vision.mbg.model.CinemaSpec;
import cn.flik1337.vision.mbg.model.CinemaSpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CinemaSpecMapper {
    long countByExample(CinemaSpecExample example);

    int deleteByExample(CinemaSpecExample example);

    int deleteByPrimaryKey(Integer cinemaSpecId);

    int insert(CinemaSpec record);

    int insertSelective(CinemaSpec record);

    List<CinemaSpec> selectByExample(CinemaSpecExample example);

    CinemaSpec selectByPrimaryKey(Integer cinemaSpecId);

    int updateByExampleSelective(@Param("record") CinemaSpec record, @Param("example") CinemaSpecExample example);

    int updateByExample(@Param("record") CinemaSpec record, @Param("example") CinemaSpecExample example);

    int updateByPrimaryKeySelective(CinemaSpec record);

    int updateByPrimaryKey(CinemaSpec record);
}