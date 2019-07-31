package com.yh.subject;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/31
 * \* @Description:(抽象目标)
 * \
 */
public abstract class WeatherSubject {
    protected List<UserObserver> userObservers = new ArrayList<>();
    public void register(UserObserver observer) {
        userObservers.add(observer);
    }
    public void unregister(UserObserver observer) {
        userObservers.remove(observer);
    }
    abstract void notifyObserver();
}
