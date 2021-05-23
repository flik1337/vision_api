package cn.flik1337.vision.mbg.model;

import java.io.Serializable;

public class FilmBroadcast implements Serializable {
    private Integer filmBroadcastId;

    private Integer filmId;

    private String filmPoster;

    private String filmVideo;

    private Integer remian;

    private static final long serialVersionUID = 1L;

    public Integer getFilmBroadcastId() {
        return filmBroadcastId;
    }

    public void setFilmBroadcastId(Integer filmBroadcastId) {
        this.filmBroadcastId = filmBroadcastId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmPoster() {
        return filmPoster;
    }

    public void setFilmPoster(String filmPoster) {
        this.filmPoster = filmPoster;
    }

    public String getFilmVideo() {
        return filmVideo;
    }

    public void setFilmVideo(String filmVideo) {
        this.filmVideo = filmVideo;
    }

    public Integer getRemian() {
        return remian;
    }

    public void setRemian(Integer remian) {
        this.remian = remian;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", filmBroadcastId=").append(filmBroadcastId);
        sb.append(", filmId=").append(filmId);
        sb.append(", filmPoster=").append(filmPoster);
        sb.append(", filmVideo=").append(filmVideo);
        sb.append(", remian=").append(remian);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}