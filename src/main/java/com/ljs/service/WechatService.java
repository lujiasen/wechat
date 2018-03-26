package com.ljs.service;

import java.util.Map;

public interface WechatService {
    public String callback(Map<String,String> map, String type);
}
