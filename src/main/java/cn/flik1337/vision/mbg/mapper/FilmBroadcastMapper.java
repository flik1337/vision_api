package cn.flik1337.vision.mbg.mapper;

import cn.flik1337.vision.mbg.model.FilmBroadcast;
import cn.flik1337.vision.mbg.model.FilmBroadcastExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmBroadcastMapper {
    long countByExample(FilmBroadcastExample example);

    int deleteByExample(FilmBroadcastExample example);

    int deleteByPrimaryKey(Integer filmBroadcastId);

    int insert(FilmBroadcast record);

    int insertSelective(FilmBroadcast record);

    List<FilmBroadcast> selectByExample(FilmBroadcastExample example);

    FilmBroadcast selectByPrimaryKey(Integer filmBroadcastId);

    int updateByExampleSelective(@Param("record") FilmBroadcast record, @Param("example") FilmBroadcastExample example);

    int updateByExample(@Param("record") FilmBroadcast record, @Param("example") FilmBroadcastExample example);

    int updateByPrimaryKeySelective(FilmBroadcast record);

    int updateByPrimaryKey(FilmBroadcast record);
}