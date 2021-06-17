package cn.flik1337.vision.component;


import cn.flik1337.vision.service.FilmScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

public class KeyExpiredListener extends KeyExpirationEventMessageListener {
    @Resource
    private FilmScheduleService filmScheduleService;

    private static final String SPLIT = "_";
    private static final String SCHEDULE_IDENTITY = "schedule";
    public KeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
    @Override
    public void onMessage(Message message, byte[] pattern) {
        //String channel = new String(message.getChannel(),StandardCharsets.UTF_8);
        //过期的key
        String key = new String(message.getBody(), StandardCharsets.UTF_8);
        //schedule_f_11_c_11_id_25
        // 判断是否是schedule类型的key
        if (!key.contains(SCHEDULE_IDENTITY)){
            return;
        }
        String[] keySplits = key.split(SPLIT);
        Integer scheduleId = Integer.parseInt(keySplits[keySplits.length-1]);
        System.out.println(scheduleId);
        if (scheduleId > 1){
            filmScheduleService.setScheduleExpired(scheduleId);

        }

    }
}
