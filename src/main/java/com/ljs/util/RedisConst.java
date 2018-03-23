package com.ljs.util;

public enum RedisConst {

    EXPRESS_LIST("express_list", "快递列表");
    private String name;
    private String demo;

    RedisConst(String name, String demo) {
        this.name = name;
        this.demo = demo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
