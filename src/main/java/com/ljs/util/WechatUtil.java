package com.ljs.util;

import java.util.HashMap;
import java.util.Map;

public class WechatUtil {

    //获取access_token
    public static String get_access_token(String appId, String secret) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("grant_type", "client_credential");
        map.put("appid", appId);
        map.put("secret", secret);
        String return_data = HttpClientHelper.sendGet(WeChatURL.ACCESS_TOKEN.getUrl(), map, "UTF-8");
        return return_data;
    }


    //获取用户信息
    public static String get_user_information(String openId, String access_token){
        String information = "";
        Map map = new HashMap();
        map.put("access_token",access_token);
        map.put("openid",openId);
        map.put("lang","zh_CN");
        information = HttpClientHelper.sendGet(WeChatURL.USER_INFORMATION.getUrl(), map, "UTF-8");
        return information;
    }
    public static void main(String[] args) {
        System.out.println(WeChatURL.a);
        System.out.println(WeChatURL.USER_INFORMATION.getUrl());
    }
}
