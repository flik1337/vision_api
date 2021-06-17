package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.Cinema;
import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmBroadcast;
import cn.flik1337.vision.mbg.model.FilmSchedule;
import lombok.Data;

import java.util.List;

@Data
public class CinemaFilmScheduleVo {
    private FilmVo filmVo;
    private List<FilmScheduleVo> filmScheduleVoList;

    public FilmVo getFilmVo() {
        return filmVo;
    }

    public void setFilmVo(FilmVo filmVo) {
        this.filmVo = filmVo;
    }

    public List<FilmScheduleVo> getFilmScheduleVoList() {
        return filmScheduleVoList;
    }

    public void setFilmScheduleVoList(List<FilmScheduleVo> filmScheduleVoList) {
        this.filmScheduleVoList = filmScheduleVoList;
    }
}
