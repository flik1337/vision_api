package cn.flik1337.vision.service;

import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmBroadcast;
import cn.flik1337.vision.vo.FilmDetailVo;
import cn.flik1337.vision.vo.FilmVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilmService {
    public void insertFilm(Film film);
    public boolean checkParams(Film film);
    public List<FilmVo> getCinemaFilmList(int cinemaId);
    public List<FilmVo> getAllFilms();
    public List<FilmVo> getFilmList(int pageNum,int pageSize);
    public FilmBroadcast setCinemaBroadcast(int filmId, MultipartFile poster, MultipartFile video, MultipartFile[] stages);
    public FilmDetailVo getFilmDetail(int filmId);
}
