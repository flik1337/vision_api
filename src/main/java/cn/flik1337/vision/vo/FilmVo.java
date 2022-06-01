package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmBroadcast;
import lombok.Data;


public class FilmVo {
    private Film film;
    private FilmBroadcast filmBroadcast;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmBroadcast getFilmBroadcast() {
        return filmBroadcast;
    }

    public void setFilmBroadcast(FilmBroadcast filmBroadcast) {
        this.filmBroadcast = filmBroadcast;
    }
}
