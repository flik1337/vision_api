package cn.flik1337.vision.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class FilmSchedule implements Serializable {
    private Integer filmScheduleId;

    private Integer filmId;

    private Integer hallId;

    private Date scheduleDate;

    private Date scheduleTime;

    private Integer price;

    private static final long serialVersionUID = 1L;

    public Integer getFilmScheduleId() {
        return filmScheduleId;
    }

    public void setFilmScheduleId(Integer filmScheduleId) {
        this.filmScheduleId = filmScheduleId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", filmScheduleId=").append(filmScheduleId);
        sb.append(", filmId=").append(filmId);
        sb.append(", hallId=").append(hallId);
        sb.append(", scheduleDate=").append(scheduleDate);
        sb.append(", scheduleTime=").append(scheduleTime);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}