package com.yh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        IParkingService parkingServiceImpl = new ParkingServiceImpl();
        InvocationHandler handle = new DynamicProxy(parkingServiceImpl);
        IParkingService proxyInstance = (IParkingService) Proxy.newProxyInstance(
                parkingServiceImpl.getClass().getClassLoader(),
                parkingServiceImpl.getClass().getInterfaces(),
                handle
        );
        proxyInstance.add("车场数据");
    }

}
