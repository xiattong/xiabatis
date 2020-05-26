package com.xiattong.batis.session;

import com.xiattong.batis.binding.XiaMapperProxy;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 参考org.apache.ibatis.session.Configuration
 */
public class XiaConfiguration {

    public static final ResourceBundle sqlMappings;
    static{
        //读取 sql.properties
        sqlMappings = ResourceBundle.getBundle("sql");
    }

    public <T> T getMapper(Class<T> type, XiaSqlSession xiaSqlSession) {
        // return mapperRegistry.getMapper(type, sqlSession);
        // ...
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[] { type }, new XiaMapperProxy(xiaSqlSession));
    }
}
