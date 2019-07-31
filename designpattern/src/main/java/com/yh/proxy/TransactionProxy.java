package com.yh.proxy;

public class TransactionProxy implements IParkingService {
    private ParkingServiceImpl parkingService;

    public TransactionProxy() {
        if (parkingService == null) {
            this.parkingService = new ParkingServiceImpl();
        }
    }

    @Override
    public void add(String data) {
        System.out.println("open transaction.");
        parkingService.add(data);
        System.out.println("commit transaction.");
    }
}
