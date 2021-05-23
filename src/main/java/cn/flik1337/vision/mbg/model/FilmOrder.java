package cn.flik1337.vision.mbg.model;

import java.io.Serializable;

public class FilmOrder implements Serializable {
    private String filmOrderId;

    private Integer userId;

    private Integer actualMoney;

    private Integer filmScheduleId;

    private static final long serialVersionUID = 1L;

    public String getFilmOrderId() {
        return filmOrderId;
    }

    public void setFilmOrderId(String filmOrderId) {
        this.filmOrderId = filmOrderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Integer actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Integer getFilmScheduleId() {
        return filmScheduleId;
    }

    public void setFilmScheduleId(Integer filmScheduleId) {
        this.filmScheduleId = filmScheduleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", filmOrderId=").append(filmOrderId);
        sb.append(", userId=").append(userId);
        sb.append(", actualMoney=").append(actualMoney);
        sb.append(", filmScheduleId=").append(filmScheduleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}