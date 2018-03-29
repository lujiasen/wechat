package com.ljs.pojo;

import com.ljs.util.Code;

public class Message<T> {
    private String code = Code.SUCCESS.getValue();
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
