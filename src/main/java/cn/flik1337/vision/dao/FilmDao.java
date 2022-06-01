package cn.flik1337.vision.dao;

import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmType;
import cn.flik1337.vision.vo.CommentVo;
import cn.flik1337.vision.vo.FilmDetailVo;
import cn.flik1337.vision.vo.FilmVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FilmDao {
    List<FilmVo> getCinemaFilmList(@Param("cinemaId")int cinemaId);

    List<FilmVo> getFilmVoById(@Param("filmId")int filmId);

    List<FilmVo> getAllFilmList();

    List<FilmType> getAllFilmTypes();

    FilmDetailVo getFilmDetail(@Param("filmId")int filmId);

    List<CommentVo> getCommentVoList(@Param("filmId") int filmId);


    Integer countFilmComments(@Param("filmId") int filmId);
}
