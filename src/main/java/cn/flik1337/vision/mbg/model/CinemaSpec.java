package cn.flik1337.vision.mbg.model;

import java.io.Serializable;

public class CinemaSpec implements Serializable {
    private Integer cinemaSpecId;

    private String cinemaSpecName;

    private static final long serialVersionUID = 1L;

    public Integer getCinemaSpecId() {
        return cinemaSpecId;
    }

    public void setCinemaSpecId(Integer cinemaSpecId) {
        this.cinemaSpecId = cinemaSpecId;
    }

    public String getCinemaSpecName() {
        return cinemaSpecName;
    }

    public void setCinemaSpecName(String cinemaSpecName) {
        this.cinemaSpecName = cinemaSpecName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cinemaSpecId=").append(cinemaSpecId);
        sb.append(", cinemaSpecName=").append(cinemaSpecName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}