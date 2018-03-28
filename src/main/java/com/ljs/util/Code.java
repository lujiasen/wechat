package com.ljs.util;

public enum Code {

    EXPRESS_NO_ERROR("0001", "快递单号不存在");

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
