package cn.flik1337.vision.vo;

import cn.flik1337.vision.mbg.model.FilmOrder;
import cn.flik1337.vision.mbg.model.Ticket;

import java.util.List;

public class OrderVo {
    FilmOrder filmOrder;
    List<Ticket> ticketList;

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
}

