package cn.flik1337.vision.vo;

import lombok.Data;

@Data
public class CinemaPriceVo {
    int cinemaId;
    int price;

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
