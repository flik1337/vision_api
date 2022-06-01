package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.Film;
import cn.flik1337.vision.mbg.model.FilmBroadcast;
import lombok.Data;

import java.util.List;

@Data
public class FilmDetailVo {
    private Film film;
    private FilmBroadcast filmBroadcast;
    private List<CommentVo> commentVoList;
    private Integer commentCount;

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

    public List<CommentVo> getCommentVoList() {
        return commentVoList;
    }

    public void setCommentVoList(List<CommentVo> commentVoList) {
        this.commentVoList = commentVoList;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "FilmDetailVo{" +
                "film=" + film +
                ", filmBroadcast=" + filmBroadcast +
                ", commentVoList=" + commentVoList +
                '}';
    }
}
