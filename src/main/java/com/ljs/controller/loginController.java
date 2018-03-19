package com.ljs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("login")
public class loginController {
    @RequestMapping(value = "toLogin")
    public String toLogin(){
       return "index";
    }
    @ResponseBody
    @RequestMapping("/sss")
    public String ss(){
        return "ss";
    }
}
