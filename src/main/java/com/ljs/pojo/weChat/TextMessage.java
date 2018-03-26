package com.ljs.pojo.weChat;

public class TextMessage extends BaseMessage{
    private String Content;

    public TextMessage() {
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
}
