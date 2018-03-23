package com.ljs.util;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 */
@Service
public class Cache {
    private final static Logger logger = LoggerFactory.getLogger(Cache.class);
    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 缓存字符串
     *
     * @param key
     * @param value
     * @param milliseconds
     */
    public void set(String key, String value, long milliseconds) {
        stringRedisTemplate.opsForValue().set(key, value, milliseconds, TimeUnit.MILLISECONDS);
    }

    /**
     * 不超时
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setDay(String key, String value, int day) {
        stringRedisTemplate.opsForValue().set(key, value, TimeoutUtils.toSeconds(day, TimeUnit.DAYS));
    }

    /**
     * 根据key 获取对应的字符
     *
     * @param key
     * @return
     */
    public String get(String key) {
        try {
            return stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error("获取缓存异常，key={},异常信息={}", key, e);
            return null;
        }
    }

    /**
     * 根据key 获取过期时间 毫秒
     *
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return stringRedisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
    }

    /**
     * 判断是否存在此key
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 存入list
     */
    public void setList(String key, String object) {
        stringRedisTemplate.opsForList().rightPush(key, object);
    }

    /**
     * 获取list
     */
    public List<String> getList(String key, int start, int end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

}
