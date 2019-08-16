package com.vigoss.wechat.official.config;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author:czq
 * @Description:
 * @Date: 10:22 2019/4/30
 * @Modified By:
 */
@Component
public class TimeBean {

    @Autowired
    private RedissonClient redissonClient;

    private Timer timer = new Timer();

    public void run(Date date, Integer threadNum, Long messageCreateTime) {
        timer.schedule(new Task(threadNum, messageCreateTime, redissonClient), date);
    }

    private static class Task extends TimerTask {

        private Integer threadNum;

        private Long messageCreateTime;

        private RedissonClient redisson;

        public Task(Integer threadNum, Long messageCreateTime, RedissonClient redisson) {
            this.threadNum = threadNum;
            this.messageCreateTime = messageCreateTime;
            this.redisson = redisson;
        }

        @Override
        public void run() {
            System.out.println("execute .....");
            String day = DateFormatUtils.ISO_DATE_FORMAT.format(messageCreateTime);
            String sceneId = "";
            Thread[] threads = new Thread[threadNum];
            for (int i = 0; i < threadNum; i++) {
                String finalSceneId = sceneId;
                threads[i] = new Thread(() -> redisson.getMap("MOTHERSDAY").addAndGet("MOTHERSDAY:SUBSCRIBE:" + day + ":" + (StringUtils.isEmpty(finalSceneId) ? finalSceneId : "DOCTORWORK"), 1));
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].start();
            }
            System.out.println("done .....");
        }
    }

}
