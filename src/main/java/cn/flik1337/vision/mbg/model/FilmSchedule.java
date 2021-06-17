package cn.flik1337.vision.mbg.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class FilmSchedule implements Serializable {
    private Integer filmScheduleId;

    private Integer filmId;

    private Integer hallId;

    private Integer cinemaId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scheduleDate;

    private Integer scheduleTime;

    private Integer price;

    private String scheduleType;

    private Integer filmScheduleStatus;

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

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Integer scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public Integer getFilmScheduleStatus() {
        return filmScheduleStatus;
    }

    public void setFilmScheduleStatus(Integer filmScheduleStatus) {
        this.filmScheduleStatus = filmScheduleStatus;
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
        sb.append(", cinemaId=").append(cinemaId);
        sb.append(", scheduleDate=").append(scheduleDate);
        sb.append(", scheduleTime=").append(scheduleTime);
        sb.append(", price=").append(price);
        sb.append(", scheduleType=").append(scheduleType);
        sb.append(", filmScheduleStatus=").append(filmScheduleStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}