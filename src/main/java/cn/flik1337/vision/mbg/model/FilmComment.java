package cn.flik1337.vision.mbg.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class FilmComment implements Serializable {
    private Integer filmCommentId;

    private String commentContent;

    private Integer filmId;

    @JsonFormat(pattern="mm-dd hh:mm")
    private Date commentTime;

    private Double commentScore;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getFilmCommentId() {
        return filmCommentId;
    }

    public void setFilmCommentId(Integer filmCommentId) {
        this.filmCommentId = filmCommentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Double getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Double commentScore) {
        this.commentScore = commentScore;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", filmCommentId=").append(filmCommentId);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", filmId=").append(filmId);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", commentScore=").append(commentScore);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}