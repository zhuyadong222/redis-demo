package com.maxrocky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yado
 * @create 2018-04-16 14:49
 * @desc
 **/
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valOpsStr;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOpsObj;

    /**
     * 根据指定key获取String
     * @param key
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String getStr(String key){
        return valOpsStr.get(key);
    }

    /**
     * 设置str缓存
     * @param key
     * @param val
     */
    @Transactional(rollbackFor = Exception.class)
    public void setStr(String key, String val){
        valOpsStr.set(key, val);
    }

    /**
     * 删除指定Key
     * @param key
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteStr(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 设置obj
     * @param o1,o2
     */
    @Transactional(rollbackFor = Exception.class)
    public void setObj(Object o1, Object o2){
        valOpsObj.set(o1, o2);
    }

    /**
     * 获取obj
     * @param o1
     */
    @Transactional(rollbackFor = Exception.class)
    public Object getObj(Object o1){
        return valOpsObj.get(o1);
    }

    /**
     * 删除obj
     * @param o1
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteObj(Object o1){
        redisTemplate.delete(o1);
    }

}