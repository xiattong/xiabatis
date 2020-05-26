package com.xiattong.batis.binding;

import com.xiattong.batis.session.XiaSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 参考org.apache.ibatis.binding.MapperProxy
 */
public class XiaMapperProxy implements InvocationHandler {

    private XiaSqlSession xiaSqlSession;
    public XiaMapperProxy(XiaSqlSession xiaSqlSession){
        this.xiaSqlSession = xiaSqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return method.invoke(proxy, method, args, xiaSqlSession);
        }*/
        // 获取Mapper接口名

        String mapperInterface = method.getDeclaringClass().getName();
        System.out.println(proxy.getClass().getName() +"  -----   "+mapperInterface);
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        Object result = xiaSqlSession.selectOne(statementId,args);
        return result;
    }
}
