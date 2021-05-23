package cn.flik1337.vision.mbg.model;

import java.io.Serializable;

public class Hall implements Serializable {
    private Integer hallId;

    private String hallName;

    private Integer cinemaId;

    private String seatInfo;

    private static final long serialVersionUID = 1L;

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getSeatInfo() {
        return seatInfo;
    }

    public void setSeatInfo(String seatInfo) {
        this.seatInfo = seatInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hallId=").append(hallId);
        sb.append(", hallName=").append(hallName);
        sb.append(", cinemaId=").append(cinemaId);
        sb.append(", seatInfo=").append(seatInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}