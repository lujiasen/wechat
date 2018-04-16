package com.ljs.service;

import com.ljs.pojo.User;

import java.util.Map;

public interface WechatService {
    public String callback(Map<String,String> map, String type);
    public User getUser(String openId);
}
