package com.ljs.service.impl;

import com.ljs.dao.WeChatDao;
import com.ljs.pojo.Express;
import com.ljs.pojo.Message;
import com.ljs.pojo.UserExpress;
import com.ljs.service.ExpressService;
import com.ljs.util.Cache;
import com.ljs.util.KdniaoTrackQueryAPI;
import com.ljs.util.RedisConst;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ExpressServiceImpl implements ExpressService {
    private static Logger logger = Logger.getLogger(ExpressServiceImpl.class);
    @Resource
    private WeChatDao weChatDao;
    @Autowired
    private Cache cache;
    public String getExpress() {
        List<Map<String,Object>> list = (List<Map<String,Object>>)weChatDao.query("Express.getExpress",null);
        JSONObject json = new JSONObject();
        list.forEach((Map<String,Object> map) -> {
            json.put(map.get("kuaidi100"),map.get("express_name")+","+map.get("express_no"));
            cache.set(RedisConst.EXPRESS_LIST.getName()+map.get("kuaidi100"), JSONObject.fromObject(map).toString());
        });
        System.out.println(json);
        return "快递列表缓存成功";
    }

    @Override
    public Message updateUserExpress(UserExpress userExpress) {
        UserExpress express = (UserExpress)weChatDao.queryOne("UserExpress.getUserExpress",userExpress);
        Message message = new Message();
        if(express == null ){
            weChatDao.insert("UserExpress.insertUserExpress",userExpress);
        }else{
            weChatDao.update("UserExpress.updateUserExpress",userExpress);
        }
        return message;
    }

    @Override
    public Message getExpressState(UserExpress userExpress) {
        Message message = new Message();
        UserExpress express = (UserExpress)weChatDao.queryOne("UserExpress.getUserExpress",userExpress);
        String resultJson = KdniaoTrackQueryAPI.getOrderTracesByJson(userExpress.getCompanyCode(),userExpress.getExpressNo());
        JSONObject json = JSONObject.fromObject(resultJson);
        json.put("attention",express == null ? 0 : express.getAttention());
        message.setData(json);
        return message;
    }
}
