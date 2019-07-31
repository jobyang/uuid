package com.yh.handler;

public abstract class Handler {
    protected Handler nextNode;

    public void setNextNode(Handler nextNode) {
        this.nextNode = nextNode;
    }

    public abstract void handlerRequest(Integer days);
}
