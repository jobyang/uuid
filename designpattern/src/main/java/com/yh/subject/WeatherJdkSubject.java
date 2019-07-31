package com.yh.subject;

import java.util.Observable;

public class WeatherJdkSubject extends Observable {
    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}
