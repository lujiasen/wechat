package com.ljs.service.impl;

import com.ljs.service.WechatService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class WechatServiceImpl implements WechatService {

    private Logger log = Logger.getLogger(WechatServiceImpl.class);

    /**
     * 微信回调函数处理
     */

    public String callback(Map<String, String> map,String type) {

        //获取二维码Ticket
        String openid=map.get("FromUserName");
        log.info("openid--"+openid);
        String Ticket = map.get("Ticket");
        log.info("Ticket--"+Ticket);
        String paramEWM="-1";
        //获取二维码参数
        if(Ticket!=null){
            String EventKey = map.get("EventKey");
            if(EventKey.indexOf("qrscene_")!=-1){
                String[] temparr = EventKey.split("_");
                paramEWM = temparr[1];
                log.info("EventKey--"+EventKey);
                log.info("paramEWM--"+paramEWM);

            }

        }

        String resultxXml = WeiXinServerMenu.replyMessage(map,"",type,paramEWM);
        return resultxXml;
    }
}
