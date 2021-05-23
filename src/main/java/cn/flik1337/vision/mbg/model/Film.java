package cn.flik1337.vision.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class Film implements Serializable {
    private Integer filmId;

    private String filmName;

    private Date releaseTime;

    private Date offTime;

    private String director;

    private String actor;

    private Integer filmType;

    private String area;

    private String producer;

    private Integer filmLength;

    private String introduction;

    private Integer filmStatus;

    private Double boxOffice;

    private String commentCount;

    private Double score;

    private static final long serialVersionUID = 1L;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getOffTime() {
        return offTime;
    }

    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getFilmType() {
        return filmType;
    }

    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(Integer filmLength) {
        this.filmLength = filmLength;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Integer filmStatus) {
        this.filmStatus = filmStatus;
    }

    public Double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(Double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", filmId=").append(filmId);
        sb.append(", filmName=").append(filmName);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", offTime=").append(offTime);
        sb.append(", director=").append(director);
        sb.append(", actor=").append(actor);
        sb.append(", filmType=").append(filmType);
        sb.append(", area=").append(area);
        sb.append(", producer=").append(producer);
        sb.append(", filmLength=").append(filmLength);
        sb.append(", introduction=").append(introduction);
        sb.append(", filmStatus=").append(filmStatus);
        sb.append(", boxOffice=").append(boxOffice);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}