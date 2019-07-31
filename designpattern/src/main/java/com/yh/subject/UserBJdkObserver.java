package com.yh.subject;

import java.util.Observable;
import java.util.Observer;

public class UserBJdkObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UserB" + arg);
    }
}
