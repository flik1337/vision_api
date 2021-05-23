package cn.flik1337.vision.mbg.model;

import java.io.Serializable;

public class Cinema implements Serializable {
    private Integer cinemaId;

    private String cinemaName;

    private String cinemaAddress;

    private Double praise;

    private String cinemaTel;

    private String lat;

    private String lng;

    private static final long serialVersionUID = 1L;

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public Double getPraise() {
        return praise;
    }

    public void setPraise(Double praise) {
        this.praise = praise;
    }

    public String getCinemaTel() {
        return cinemaTel;
    }

    public void setCinemaTel(String cinemaTel) {
        this.cinemaTel = cinemaTel;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cinemaId=").append(cinemaId);
        sb.append(", cinemaName=").append(cinemaName);
        sb.append(", cinemaAddress=").append(cinemaAddress);
        sb.append(", praise=").append(praise);
        sb.append(", cinemaTel=").append(cinemaTel);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}