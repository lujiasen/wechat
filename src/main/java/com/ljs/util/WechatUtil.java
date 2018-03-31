package com.ljs.util;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WechatUtil {

    //获取access_token
    public static String get_access_token(String appId, String secret) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("grant_type", "client_credential");
        map.put("appid", appId);
        map.put("secret", secret);
        String return_data = HttpClientHelper.sendGet(WeChatURL.ACCESS_TOKEN.getUrl(), map);
        return return_data;
    }


    //获取用户信息
    public static String get_user_information(String openId, String access_token){
        String information = "";
        Map map = new HashMap();
        map.put("access_token",access_token);
        map.put("openid",openId);
        map.put("lang","zh_CN");
        information = HttpClientHelper.sendGet(WeChatURL.USER_INFORMATION.getUrl(), map);
        return information;
    }

    //网页授权回调根据token获取用户id
    public static JSONObject get_code_token(String appId,String secret,String code){
        Map map = new HashMap();
        map.put("appid", appId);
        map.put("secret", secret);
        map.put("grant_type","authorization_code");
        map.put("code",code);
        String result = HttpClientHelper.sendGet(WeChatURL.CODE.getUrl(), map);
        JSONObject json = JSONObject.fromObject(result);
        return json;
    }
}
