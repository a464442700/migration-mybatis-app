package com.lxf.dao;

import com.lxf.mapper.BFSMapper;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;


import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.executor.statement.StatementHandler;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class SessionInterceptor  implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 调用存储过程
       callProcedure(invocation);
        // 执行原来的操作
        return invocation.proceed();
    }
    private void callProcedure(Invocation invocation) {

 //暂时不知道如何获取sqlsession
    }
}
