package com.yh.proxy;

import org.springframework.cglib.proxy.Enhancer;

public class CGLIBProxyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ParkingServiceImpl.class);
        enhancer.setCallback(new CGLIBProxy());
        IParkingService parkingService = (IParkingService) enhancer.create();
        parkingService.add("车场数据");
    }
}
