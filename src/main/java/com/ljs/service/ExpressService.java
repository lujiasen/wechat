package com.ljs.service;

import com.ljs.pojo.Express;
import com.ljs.pojo.Message;
import com.ljs.pojo.User;
import com.ljs.pojo.UserExpress;

import java.util.List;

public interface ExpressService {
    public String getExpress();
    public Message updateUserExpress(UserExpress user);
    public Message getExpressState(UserExpress user);
    public Message getExpressList(User user);
}
