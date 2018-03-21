package com.ljs.controller;

import com.ljs.util.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("login")
public class loginController {
    @Autowired
    private  Cache cahce;
    @RequestMapping(value = "toLogin")
    public String toLogin(){
       return "index";
    }
    @ResponseBody
    @RequestMapping("/sss")
    public String ss() {
        cahce.set("sss","sdfafasfasfd",10000);

        return cahce.get("sss");
    }
}
