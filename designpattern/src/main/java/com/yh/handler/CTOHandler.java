package com.yh.handler;

public class CTOHandler extends Handler {
    @Override
    public void handlerRequest(Integer days) {
        if ( 3<= days && days < 7) {
            System.out.println("CTO 已经批准休假！");
        } else {
            nextNode.handlerRequest(days);
        }
    }
}
