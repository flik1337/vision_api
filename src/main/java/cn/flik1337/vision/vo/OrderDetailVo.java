package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.Cinema;
import cn.flik1337.vision.mbg.model.FilmBroadcast;
import cn.flik1337.vision.mbg.model.FilmOrder;
import cn.flik1337.vision.mbg.model.Ticket;

import java.util.List;

public class OrderDetailVo {
    FilmOrder filmOrder;
    List<Ticket> ticketList;
    FilmVo filmVo;
    FilmScheduleVo filmScheduleVo;
    Cinema cinema;

    public FilmOrder getFilmOrder() {
        return filmOrder;
    }

    public void setFilmOrder(FilmOrder filmOrder) {
        this.filmOrder = filmOrder;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public FilmVo getFilmVo() {
        return filmVo;
    }

    public void setFilmVo(FilmVo filmVo) {
        this.filmVo = filmVo;
    }

    public FilmScheduleVo getFilmScheduleVo() {
        return filmScheduleVo;
    }

    public void setFilmScheduleVo(FilmScheduleVo filmScheduleVo) {
        this.filmScheduleVo = filmScheduleVo;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
