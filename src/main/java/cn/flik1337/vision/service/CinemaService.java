package cn.flik1337.vision.service;


import cn.flik1337.vision.mbg.model.CinemaSpec;
import cn.flik1337.vision.vo.CinemaVo;

import java.util.List;
import java.util.Map;

public interface CinemaService {
    public Map<String,Object> selectFilmScheduleByFilmAndCinema(int cinemaId, boolean first, boolean fromCinema, int certainFilmId);
    public List<CinemaVo> getCinemasByCondition(String spec, int rank, String cityName,double latitude,double longitude,int certainFilmId);
    public List<CinemaSpec> getCinemaSpecList();
}
