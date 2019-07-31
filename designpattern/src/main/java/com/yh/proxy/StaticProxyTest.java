package com.yh.proxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        IParkingService parkingService = new TransactionProxy();
        parkingService.add("车场数据");
    }
}
