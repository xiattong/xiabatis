package com.xiattong.batis.session;

import com.xiattong.batis.executor.XiaExecutor;

/**
 * 参考org.apache.ibatis.session.defaults.DefaultSqlSession
 */
public class XiaSqlSession {

    XiaConfiguration configuration;
    XiaExecutor executor;

    public XiaSqlSession(XiaConfiguration configuration, XiaExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public<T> T selectOne(String statementId, Object... parameter){
        String sql = XiaConfiguration.sqlMappings.getString(statementId);;
        return executor.query(sql,parameter);
    }

    /**
     * 获取代理对象
     * @param type
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

}
