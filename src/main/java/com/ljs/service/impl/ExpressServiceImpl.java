package com.ljs.service.impl;

import com.ljs.dao.WeChatDao;
import com.ljs.pojo.Express;
import com.ljs.service.ExpressService;
import com.ljs.util.Cache;
import com.ljs.util.RedisConst;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ExpressServiceImpl implements ExpressService {
    @Resource
    private WeChatDao weChatDao;
    @Autowired
    private Cache cache;
    public String getExpress() {
        List<Map<String,Object>> list = (List<Map<String,Object>>)weChatDao.query("Express.getExpress",null);
        JSONArray json = JSONArray.fromObject(list);
        cache.set(RedisConst.EXPRESS_LIST.getName(),json.toString());
        return "快递列表缓存成功";
    }
}
