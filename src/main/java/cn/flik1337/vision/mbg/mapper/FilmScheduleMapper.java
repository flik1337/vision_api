package cn.flik1337.vision.mbg.mapper;

import cn.flik1337.vision.mbg.model.FilmSchedule;
import cn.flik1337.vision.mbg.model.FilmScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmScheduleMapper {
    long countByExample(FilmScheduleExample example);

    int deleteByExample(FilmScheduleExample example);

    int deleteByPrimaryKey(Integer filmScheduleId);

    int insert(FilmSchedule record);

    int insertSelective(FilmSchedule record);

    List<FilmSchedule> selectByExample(FilmScheduleExample example);

    FilmSchedule selectByPrimaryKey(Integer filmScheduleId);

    int updateByExampleSelective(@Param("record") FilmSchedule record, @Param("example") FilmScheduleExample example);

    int updateByExample(@Param("record") FilmSchedule record, @Param("example") FilmScheduleExample example);

    int updateByPrimaryKeySelective(FilmSchedule record);

    int updateByPrimaryKey(FilmSchedule record);
}