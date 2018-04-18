package com.maxrocky.task;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CleanRedisTask {

    /**
     * 每半小时执行一次
     */
    @Scheduled(fixedRate = 1000*30)
    @CacheEvict(value = {"users", "users#20#5"}, allEntries = true)
    public void cleanRedis(){
        System.out.print("定时任务---------清理redis缓存------");
    }
}
