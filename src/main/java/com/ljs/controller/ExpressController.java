package com.ljs.controller;

import com.ljs.pojo.Express;
import com.ljs.pojo.Message;
import com.ljs.pojo.UserExpress;
import com.ljs.service.ExpressService;
import com.ljs.util.Code;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/express")
public class ExpressController {
    private Logger logger = Logger.getLogger(ExpressController.class);

    @Autowired
    private ExpressService expressService;

    /**
     * @Author lujiasen
     * @Description: 绑定单号
     * @Date 下午2:46 2018/3/29
     */
    @RequestMapping( value = "updateUserExpress", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message updateUserExpress(UserExpress userExpress){
        Message m = new Message();
        try {
            m = expressService.updateUserExpress(userExpress);
        }catch (Exception e){
            logger.info("updateUserExpress===>"+e.fillInStackTrace());
            m.setCode(Code.ERROR.getValue());
            m.setData(Code.ERROR.getDemo());
        }
        return m;
    }


    @CrossOrigin
    @RequestMapping(value = "getExpressState", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message getExpressState(UserExpress userExpress){
        Message m = new Message();
        try{
            m = expressService.getExpressState(userExpress);
        }catch (Exception e){
            logger.info("getExpressState===>"+e.fillInStackTrace());
            m.setCode(Code.ERROR.getValue());
            m.setData(Code.ERROR.getDemo());
        }
        return m;
    }
}
