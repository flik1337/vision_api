package cn.flik1337.vision.mbg.model;

import java.io.Serializable;

public class FilmType implements Serializable {
    private Integer filmTypeId;

    private String filmTypeName;

    private static final long serialVersionUID = 1L;

    public Integer getFilmTypeId() {
        return filmTypeId;
    }

    public void setFilmTypeId(Integer filmTypeId) {
        this.filmTypeId = filmTypeId;
    }

    public String getFilmTypeName() {
        return filmTypeName;
    }

    public void setFilmTypeName(String filmTypeName) {
        this.filmTypeName = filmTypeName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", filmTypeId=").append(filmTypeId);
        sb.append(", filmTypeName=").append(filmTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}