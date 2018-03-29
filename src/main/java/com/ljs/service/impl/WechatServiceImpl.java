package com.ljs.service.impl;

import com.ljs.dao.WeChatDao;
import com.ljs.pojo.User;
import com.ljs.service.WechatService;
import com.ljs.util.MessageUtil;
import com.ljs.util.WeiXinServerMenu;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class WechatServiceImpl implements WechatService {

    private Logger log = Logger.getLogger(WechatServiceImpl.class);

    @Resource
    private WeChatDao wechatDao;

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
        String msgType = map.get("MsgType");
        User user = (User)wechatDao.queryOne("User.getUser",openid);
        //获取用户信息
        if(user == null){
            user = new User();
            user.setOpenId(openid);
            wechatDao.insert("User.insertUser",user);
        }
        map.put("userId",String.valueOf(user.getId()));
        String resultxXml = WeiXinServerMenu.replyMessage(map,paramEWM);
        return resultxXml;
    }
}
