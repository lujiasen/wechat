package com.ljs.task;

import com.ljs.util.Cache;
import com.ljs.util.RedisConst;
import com.ljs.util.WeChatParam;
import com.ljs.util.WechatUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class TaskJob {
    private static Logger logger = Logger.getLogger(TaskJob.class);
    @Autowired
    private Cache cache;
    @Scheduled(cron = "0 0 0/2 * * ?")
    public void updateTokenJob() {
        logger.info("微信token更新开始");
        String token = WechatUtil.get_access_token(WeChatParam.APPID.getValue(), WeChatParam.APPSERCET.getValue());
        cache.set(RedisConst.TOKEN.getName()+WeChatParam.APPID.getValue(), token);
        logger.info("微信token更新成功");
    }
}

