package com.ljs.util;

public enum Code {

    EXPRESS_NO_ERROR("0", "暂无轨迹信息"),

    SUCCESS("0000", "成功"),

    ERROR("-1", "网络异常");

    private String value;
    private String demo;
    private  Code(String value, String demo) {
        this.value = value;
        this.demo = demo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
