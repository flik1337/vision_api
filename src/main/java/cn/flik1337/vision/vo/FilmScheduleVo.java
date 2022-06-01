package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmSchedule;
import cn.flik1337.vision.mbg.model.Hall;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


@Data
public class FilmScheduleVo {
    private FilmSchedule filmSchedule;
    private Hall hall;

    public FilmSchedule getFilmSchedule() {
        return filmSchedule;
    }

    public void setFilmSchedule(FilmSchedule filmSchedule) {
        this.filmSchedule = filmSchedule;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
