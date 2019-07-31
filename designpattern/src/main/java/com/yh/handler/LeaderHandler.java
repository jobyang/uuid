package com.yh.handler;

public class LeaderHandler extends Handler {
    @Override
    public void handlerRequest(Integer days) {
        if (days < 3) {
            System.out.println("leader 已经批准休假！");
        } else {
            nextNode.handlerRequest(days);
        }
    }
}
