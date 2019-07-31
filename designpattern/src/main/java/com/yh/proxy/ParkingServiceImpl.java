package com.yh.proxy;

public class ParkingServiceImpl implements IParkingService {
    @Override
    public void add(String data) {
        System.out.println("add " + data + " to DB...");
    }
}
