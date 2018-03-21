package com.ljs.dao;

import java.util.HashMap;
import java.util.List;


public interface WeChatDao {

    /**
     * 按照条件查询多行
     * @param sqlmapper
     * @param map
     * @return
     */
    public List<?> query(String sqlmapper, Object map);
    /**
     * 按照条件查询一行数据
     * @param sqlmapper
     * @param obj
     * @return
     */
    public Object queryOne(String sqlmapper, Object obj);
    /**
     * 无条件查询
     * @param sqlmapper
     * @return
     */
    public List<?> query(String sqlmapper);
    /**
     * 无条件查询总数
     * @param sqlmapper
     * @return
     */
    public Integer queryTotal(String sqlmapper);
    /**
     * 有条件查询总数
     * @param sqlmapper
     * @param obj
     * @return
     */
    public Integer queryTotal(String sqlmapper, Object obj);
    /**
     * 添加数据
     * @param sqlmapper
     * @param obj
     * @return
     */
    public int insert(String sqlmapper, Object obj);
    /**
     * 更新数据
     * @param sqlmapper
     * @param obj
     * @return
     */
    public int update(String sqlmapper, Object obj);
    /**
     * 删除数据
     * @param sqlmapper
     * @param obj
     * @return
     */
    public int delete(String sqlmapper, Object obj);

    /**
     * 查询数据结果集是HashMap集合
     * @param sqlmapper
     * @param obj
     * @param key
     * @return
     */
    public HashMap<?, ?> query(String sqlmapper, Object obj, String key);
}
