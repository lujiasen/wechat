package com.ljs.controller;

import com.ljs.pojo.User;
import com.ljs.service.WechatService;
import com.ljs.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("weChat")
public class WechatController {
    private static Logger log = Logger.getLogger(WechatController.class);

    @Autowired
    private WechatService weChatService;

    @RequestMapping(value = "/callback", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String callback(HttpServletRequest request) {
        String resultStr = null;
        ////微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        //随机字符串
        String echostr = request.getParameter("echostr");
        if (echostr != null) {
            resultStr = echostr;
        } else {
            String signature = request.getParameter("signature");
            //时间戳
            String timestamp = request.getParameter("timestamp");
            //随机数
            String nonce = request.getParameter("nonce");

            log.info("signature----" + signature);
            log.info("timestamp----" + timestamp);
            log.info("nonce----" + nonce);
            log.info("echostr----" + echostr);
            String token = "lujiasen"; //此处指令牌
            String getSignatureStr = SignUtil.getSignature(timestamp, nonce, token);
            log.info("getSignatureStr----" + getSignatureStr);

            try {
                Map<String, String> map = MessageUtil.parseXml(request);
                //根据company_id查询微信端欢迎语
                resultStr = weChatService.callback(map, token);
                log.info(resultStr);
            } catch (Exception e) {
                // TODO: handle exception
                log.error("callback.json--出错--", e.fillInStackTrace());
            }
        }
        return resultStr;
    }

    /**
     * @Author lujiasen
     * @Description: 微信网页授权回调
     * @Date 下午5:15 2018/3/30
     */
    @RequestMapping(value = "/redirectUrl", produces = "application/json;charset=utf-8")
    public String redirectUrl(HttpServletRequest request) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String param = request.getParameter("param"); //请求参数
        JSONObject json = WechatUtil.get_code_token(WeChatParam.APPID.getValue(), WeChatParam.APPSERCET.getValue(), code);
        log.info("redirectUrl==" + json.toString());
        log.info("param=" + request.getParameter("param"));
        log.info("state=" + state);
        try {
            String openId = json.getString("openid");
            User user = weChatService.getUser(openId);
            log.info("user=" + JSONObject.fromObject(user));
            //解析参数
            if (param != null) {
                String[] params = param.split(",");
                param = "";
                for (String args : params) {
                    param += args + "&";
                }
            }
            String[] params = param != null ? param.split(",") : null;
            if (("express_information").equals(state)) {
                String URL = WeChatURL.EXPRESS_INFORMATION.getUrl() + "?" + param;
                log.info(URL);
                return "redirect:" + URL;
            } else if (("express_list").equals(state)) {
                int userId = 0;
                if (user != null) {
                    userId = user.getId();
                }
                String URL = WeChatURL.EXPRESS_LIST.getUrl() + "?userId=" + userId;
                log.info(URL);
                return "redirect:" + URL;
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }


    }
}
