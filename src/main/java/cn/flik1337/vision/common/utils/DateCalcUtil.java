package cn.flik1337.vision.common.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateCalcUtil {
    public static Long getDay(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long seconds = null;
        try {
            Date currentTime = dateFormat.parse(dateFormat.format(new Date()));//现在系统当前时间
            System.out.println(currentTime.toString());
            long diff = date.getTime() -  currentTime.getTime();
            if (diff<0){
                return 0l;
            }
            //seconds = diff / (1000 * 60 * 60 * 24);
            seconds = diff / (1000 ); //seconds
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return seconds;
    }
}
