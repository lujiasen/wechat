package com.ljs.service.impl;

import com.ljs.dao.WeChatDao;
import com.ljs.pojo.Express;
import com.ljs.service.ExpressService;
import com.ljs.util.Cache;
import com.ljs.util.RedisConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {
    @Resource
    private WeChatDao weChatDao;
    @Autowired
    private Cache cache;
    public List<Express> getExpress() {
        List<Express> list = (List<Express>)weChatDao.query("Express.getExpress",null);
        list.forEach((Express express) -> {
            cache.setList(RedisConst.EXPRESS_LIST.getName(),express.toString());
        });
        List<String> list2= cache.getList(RedisConst.EXPRESS_LIST.getName(), 0 , -1);
        System.out.println(list2);
        return list;
    }
}
