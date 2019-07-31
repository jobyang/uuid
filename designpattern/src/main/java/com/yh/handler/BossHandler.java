package com.yh.handler;

public class BossHandler extends Handler {
    @Override
    public void handlerRequest(Integer days) {
        if (days >= 7 && days < 15) {
            System.out.println("Boss 已经批准！");
        } else {
            System.out.println("Boss 不批准！");
        }
    }
}
