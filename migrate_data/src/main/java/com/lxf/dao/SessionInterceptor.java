package com.lxf.dao;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

public class SessionInterceptor  implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 调用存储过程
       callProcedure();
        // 执行原来的操作
        return invocation.proceed();
    }
    private void callProcedure() {
        // 调用存储过程的代码
        System.out.println();
    }
}
