package com.ljs.util;

public enum WeChatURL {
    //    8fa6756e456c39f05c4115603be352d9
//    wx5179c821a45f7352
    ACCESS_TOKEN("获取token,示例:https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET",
            "https://api.weixin.qq.com/cgi-bin/token"),

    USER_INFORMATION("获取用户资料,:示例:https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN",
            "https://api.weixin.qq.com/cgi-bin/user/info");


    private String name;
    private String url;

    private WeChatURL(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    }
