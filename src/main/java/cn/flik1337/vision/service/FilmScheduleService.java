package cn.flik1337.vision.service;

import cn.flik1337.vision.mbg.model.FilmSchedule;
import cn.flik1337.vision.mbg.model.Hall;
import cn.flik1337.vision.vo.FilmScheduleVo;

import java.util.HashMap;
import java.util.List;

public interface FilmScheduleService {
    public Hall getHallByScheduleId(int shceduleId);

    public List<FilmScheduleVo> getAvailableSchedules(int cinemaId, int filmId);
    public void setSchedule(FilmSchedule filmSchedule);

    public void setScheduleExpired(Integer id);

    public HashMap<String,Object> selectCinemaSchedule(int cinemaId, int certainFilmId);
}
