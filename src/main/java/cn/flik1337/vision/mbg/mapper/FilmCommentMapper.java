package cn.flik1337.vision.mbg.mapper;

import cn.flik1337.vision.mbg.model.FilmComment;
import cn.flik1337.vision.mbg.model.FilmCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmCommentMapper {
    long countByExample(FilmCommentExample example);

    int deleteByExample(FilmCommentExample example);

    int deleteByPrimaryKey(Integer filmCommentId);

    int insert(FilmComment record);

    int insertSelective(FilmComment record);

    List<FilmComment> selectByExample(FilmCommentExample example);

    FilmComment selectByPrimaryKey(Integer filmCommentId);

    int updateByExampleSelective(@Param("record") FilmComment record, @Param("example") FilmCommentExample example);

    int updateByExample(@Param("record") FilmComment record, @Param("example") FilmCommentExample example);

    int updateByPrimaryKeySelective(FilmComment record);

    int updateByPrimaryKey(FilmComment record);
}