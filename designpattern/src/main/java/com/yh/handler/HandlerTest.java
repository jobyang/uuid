package com.yh.handler;

public class HandlerTest {
    public static void main(String[] args) {
        Handler leaderHandler = new LeaderHandler();
        Handler bossHandler = new BossHandler();
        Handler ctoHandler = new CTOHandler();

        leaderHandler.setNextNode(ctoHandler);
        ctoHandler.setNextNode(bossHandler);

        leaderHandler.handlerRequest(16);
    }
}
