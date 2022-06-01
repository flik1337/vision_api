package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.Cinema;
import lombok.Data;


public class CinemaVo {
    Cinema cinema;
    Double distance;
    Integer price;

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CinemaVo{" +
                "cinema=" + cinema +
                ", distance=" + distance +
                ", price=" + price +
                '}';
    }
}
