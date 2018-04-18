package com.maxrocky.controller;

import com.maxrocky.dto.User;
import com.maxrocky.repository.UserMapper;
import com.maxrocky.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yado
 * @create 2018-04-16 14:59
 * @desc
 **/
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    /**
     * 设置str
     * @param key
     * @param val
     * @return
     */
    @GetMapping(value = "/set/str/{key}/{val}")
    public String setStr(@PathVariable(value = "key") String key,
                         @PathVariable(value = "val") String val){
        redisService.setStr(key, val);
        return "SUCCESS";
    }

    /**
     * 获取str
     * @param key
     * @return
     */
    @GetMapping(value = "/get/str/{key}")
    public String getStr(@PathVariable(value = "key") String key){
        String str = redisService.getStr(key);
        return str;
    }

    /**
     * 删除str
     * @param key
     * @return
     */
    @GetMapping(value = "/delete/str/{key}")
    public String deleteStr(@PathVariable(value = "key") String key){
        redisService.deleteStr(key);
        return "SUCCESS";
    }

    /**
     * 设置obj
     * @return
     */
    @GetMapping(value = "/set/obj")
    public String setObj(){
        User user = new User(1, "rocky", 20);
        redisService.setObj("max", user);
        return "SUCCESS";
    }

    /**
     * 获取obj
     * @param key
     * @return
     */
    @GetMapping(value = "/get/obj/{key}")
    public Object getObj(@PathVariable(value = "key") Object key){
        Object obj = redisService.getObj(key);
        return obj;
    }

    /**
     * 删除obj
     * @param key
     * @return
     */
    @GetMapping(value = "/delete/obj/{key}")
    public String deleteObj(@PathVariable(value = "key") Object key){
        redisService.deleteObj(key);
        return "SUCCESS";
    }

}