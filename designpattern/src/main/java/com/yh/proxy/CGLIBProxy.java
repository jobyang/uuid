package com.yh.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("open transaction.");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("commit transaction.");
        return invoke;
    }
}
