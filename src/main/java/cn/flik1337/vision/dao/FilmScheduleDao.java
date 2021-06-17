package cn.flik1337.vision.dao;

import cn.flik1337.vision.mbg.model.FilmSchedule;
import cn.flik1337.vision.mbg.model.Hall;
import cn.flik1337.vision.mbg.model.Ticket;
import cn.flik1337.vision.vo.FilmScheduleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FilmScheduleDao {

     List<FilmScheduleVo> queryScheduleByCinemaAndFilm(@Param("filmId")int filmId,
                                                       @Param("cinemaId")int cinemaId);

     List<Hall> getHallByScheduleId(@Param("scheduleId")int scheduleId);

     Integer getSchedulePrice(@Param("scheduleId")int scheduleId);

     List<FilmScheduleVo> queryScheduleByIds(@Param("ids")List<Integer> ids);

     void updateScheduleStatus(@Param("scheduleId")int scheduleId);

     FilmScheduleVo getFilmScheduleById(@Param("filmScheduleId")int filmScheduleId);
}
