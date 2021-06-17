package cn.flik1337.vision;

import cn.flik1337.vision.common.utils.DateCalcUtil;
import cn.flik1337.vision.common.utils.SeatUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class VisionApplicationTests {


    @Test
    void a() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2021-06-03 22:57:01");
        Long seconds = DateCalcUtil.getDay(date);
        System.out.println(seconds);
    }
    @Test
    void testSeatUtil(){

    }

}
