package com.ljs.util;

public enum WeChatParam {

    APPID("appid","wx5179c821a45f7352"),

    APPSERCET("AppSercet","8fa6756e456c39f05c4115603be352d9");

    private String name;
    private String value;

    private WeChatParam(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
