package cn.flik1337.vision.mbg.model;

import java.io.Serializable;

public class Ticket implements Serializable {
    private Integer ticketId;

    private String filmOrderId;

    private String qrCode;

    private Integer posX;

    private Integer posY;

    private static final long serialVersionUID = 1L;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getFilmOrderId() {
        return filmOrderId;
    }

    public void setFilmOrderId(String filmOrderId) {
        this.filmOrderId = filmOrderId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ticketId=").append(ticketId);
        sb.append(", filmOrderId=").append(filmOrderId);
        sb.append(", qrCode=").append(qrCode);
        sb.append(", posX=").append(posX);
        sb.append(", posY=").append(posY);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}