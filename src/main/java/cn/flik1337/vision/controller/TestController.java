package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.common.utils.JwtTokenUtil;
import cn.flik1337.vision.common.utils.OrderNoUtil;
import cn.flik1337.vision.common.utils.QrCodeUtil;
import cn.flik1337.vision.dao.FilmDao;
import cn.flik1337.vision.mbg.mapper.HallMapper;
import cn.flik1337.vision.mbg.model.*;
import cn.flik1337.vision.service.FilmScheduleService;
import cn.flik1337.vision.service.UserService;
import cn.flik1337.vision.vo.FilmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private HallMapper hallMapper;
    @Autowired
    private FilmScheduleService filmScheduleService;

    @Autowired
    private OrderNoUtil orderNoUtil;

    @Autowired
    private QrCodeUtil qrCodeUtil;
    @GetMapping("test")
    public CommonResult test(HttpServletResponse response){

        try {
            // 传入图像链接，还能够生成带logo的二维码
            String imgBase64 =  QrCodeUtil.encodeToBase64("hello");
            return CommonResult.success(imgBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();


    }
    @GetMapping("run")
    public void run() throws ParseException {
//        String[] date ={"2021-06-08 09:01:01",
//                        "2021-06-08 11:20:01",
//                        "2021-06-08 13:30:01",
//                        "2021-06-08 16:40:01",
//                        "2021-06-08 18:50:01",
//                        "2021-06-08 21:05:01",
//                        "2021-06-09 09:01:01",
//                        "2021-06-09 11:20:01",
//                        "2021-06-09 13:30:01",
//                        "2021-06-09 16:40:01",
//                        "2021-06-09 18:50:01",
//                        "2021-06-09 21:05:01",
//                        "2021-06-10 09:01:01",
//                        "2021-06-10 11:20:01",
//                        "2021-06-10 13:30:01",
//                        "2021-06-10 16:40:01",
//                        "2021-06-10 18:50:01",
//                        "2021-06-10 21:05:01"};
        String[] date = {"2021-06-18 21:05:01", "2021-06-19 16:40:01","2021-06-20 18:50:01",};
        int[] price = new int[2];
        price[0] = 1990;
        price[1] = 3990;

        List<FilmVo> filmList = filmDao.getAllFilmList();
        HallExample hallExample = new HallExample();
        HallExample.Criteria criteria = hallExample.createCriteria();

        //criteria.andCinemaIdEqualTo(11);
        criteria.andHallIdIsNotNull();
        List<Hall> hallList = hallMapper.selectByExample(hallExample);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        for (int i = 0;i < hallList.size();i++){

                for (int k = 0; k < date.length; k++) {
                    FilmVo filmVo = filmList.get(i % filmList.size());
                    Hall hall = hallList.get(i);
                    FilmSchedule filmSchedule = new FilmSchedule();
                    filmSchedule.setFilmId(filmVo.getFilm().getFilmId());
                    filmSchedule.setCinemaId(hall.getCinemaId());
                    filmSchedule.setFilmScheduleStatus(0);
                    filmSchedule.setHallId(hall.getHallId());
                    filmSchedule.setScheduleType("华语2D");
                    filmSchedule.setPrice(price[i%2]);
                    filmSchedule.setScheduleTime(filmVo.getFilm().getFilmLength());
                    filmSchedule.setScheduleDate(formatter.parse(date[(i+k)%3]));
                    filmScheduleService.setSchedule(filmSchedule);
                }



        }


    }


}
