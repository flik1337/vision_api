package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.FilmComment;
import cn.flik1337.vision.mbg.model.User;

public class CommentVo {
    FilmComment filmComment;
    User user;


    public FilmComment getFilmComment() {
        return filmComment;
    }

    public void setFilmComment(FilmComment filmComment) {
        this.filmComment = filmComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
