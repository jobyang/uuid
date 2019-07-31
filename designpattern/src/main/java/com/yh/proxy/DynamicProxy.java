package com.yh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private Object realObj;

    public DynamicProxy(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("open transaction.");
        method.invoke(realObj, args);
        System.out.println("commit transaction.");
        return null;
    }
}
