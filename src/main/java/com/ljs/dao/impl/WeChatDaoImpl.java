package com.ljs.dao.impl;

import com.ljs.dao.WeChatDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


public class WeChatDaoImpl extends SqlSessionDaoSupport implements WeChatDao {


    @Override
    @Resource(name = "sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory footballSqlSessionFactory) {
        super.setSqlSessionFactory(footballSqlSessionFactory);
    }

    public  String getSqlMapper(){
        return "";
    }


    public int delete(String sqlmapper, Object obj) {
        return this.getSqlSession().delete(sqlmapper, obj);
    }

    public int insert(String sqlmapper, Object obj) {
        return this.getSqlSession().insert(sqlmapper, obj);
    }

    public List<?> query(String sqlmapper, Object obj) {
        return this.getSqlSession().selectList(sqlmapper, obj);
    }

    public int update(String sqlmapper, Object obj) {
        return this.getSqlSession().update(sqlmapper, obj);
    }

    public Object queryOne(String sqlmapper, Object obj) {
        return this.getSqlSession().selectOne(sqlmapper, obj);
    }

    public List<?> query(String sqlmapper) {
        return this.getSqlSession().selectList(sqlmapper);
    }

    public Integer queryTotal(String sqlmapper, Object obj) {
        return  this.getSqlSession().selectOne(sqlmapper, obj);
    }

    public Integer queryTotal(String sqlmapper) {
        return (Integer) this.getSqlSession().selectOne(sqlmapper);
    }

    public HashMap<?, ?> query(String sqlmapper, Object obj, String key) {
        return (HashMap<?, ?>) this.getSqlSession().selectMap(sqlmapper, obj, key);
    }
}
