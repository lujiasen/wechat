package com.ljs.controller;

import com.ljs.service.WechatService;
import com.ljs.util.MessageUtil;
import com.ljs.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("weChat")
public class WechatController {
    private Logger log = Logger.getLogger(WechatController.class);

    @Autowired
    private WechatService weChatService;

    @RequestMapping(value = "/callback")
    public String callback(HttpServletRequest request) {
        String resultStr=null;
        ////微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        //随机字符串
        String echostr = request.getParameter("echostr");
        if(echostr!=null){
            resultStr=echostr;
        }else{
            String signature = request.getParameter("signature");
            //时间戳
            String timestamp = request.getParameter("timestamp");
            //随机数
            String nonce = request.getParameter("nonce");

            log.info("signature----"+signature);
            log.info("timestamp----"+timestamp);
            log.info("nonce----"+nonce);
            log.info("echostr----"+echostr);

            String getSignatureStr = SignUtil.getSignature(timestamp, nonce, "somur2017");
            log.info("getSignatureStr----"+getSignatureStr);

            try {
                Map<String, String> map = MessageUtil.parseXml(request);
                //根据company_id查询微信端欢迎语
                resultStr = weChatService.callback(map);
                log.info(resultStr);
            } catch (Exception e) {
                // TODO: handle exception
                log.error("smccjweChatCallback.json--出错--",e.fillInStackTrace());
            }
        }

        return resultStr;

    }
}
