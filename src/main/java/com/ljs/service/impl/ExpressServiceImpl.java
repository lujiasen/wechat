package com.ljs.service.impl;

import com.ljs.dao.WeChatDao;
import com.ljs.pojo.Express;
import com.ljs.service.ExpressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {
    @Resource
    private WeChatDao weChatDao;

    public List<Express> getExpress() {
        List<Express> list = (List<Express>)weChatDao.query("Express.getExpress",null);
        return list;
    }
}
