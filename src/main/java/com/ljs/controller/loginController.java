package com.ljs.controller;

import com.ljs.dao.WeChatDao;
import com.ljs.pojo.Express;
import com.ljs.service.ExpressService;
import com.ljs.util.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("login")
public class loginController {
    @Autowired
    private  Cache cahce;

    @Autowired
    private ExpressService expressService;
    @ResponseBody
    @RequestMapping("/sss")
    public List<Express> ss() {
//        cahce.set("sss","sdfafasfasfd",10000);

        return expressService.getExpress();
    }
}
