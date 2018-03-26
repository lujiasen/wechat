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


    /**
     * 处理微信回复消息
     * @param map
     * @param welcomeContent 欢迎与
     * @param type key
     * @param paramEWM 二维码参数
     * @return
     */
    public static String replyMessage(Map<String,String> map,String welcomeContent,String type,String paramEWM){

        //信息类型
        String msgType = map.get("MsgType");

        String resultXml=null;
        //事件推送
        if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
            String event = map.get("Event");
            //订阅
            if(event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
                resultXml =WeChatResultMessage.getEvent(map,welcomeContent,type,paramEWM);
            }else if(event.equals(MessageUtil.SCAN) && type.equals("shuimuadmin")){
                resultXml =WeChatResultMessage.getEvent(map,welcomeContent,type,MessageUtil.SCAN);
            }
        }
        //文本信息回復
        else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
            resultXml =WeChatResultMessage.getSearchMessage(map,welcomeContent,type,paramEWM);
        }

        return resultXml;
    }
}
