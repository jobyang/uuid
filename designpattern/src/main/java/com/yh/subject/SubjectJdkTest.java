package com.yh.subject;

import java.util.Observer;

public class SubjectJdkTest {

    public static void main(String[] args) {
        WeatherJdkSubject weatherJdkSubject = new WeatherJdkSubject();
        Observer userAJdkObserver = new UserAJdkObserver();
        weatherJdkSubject.addObserver(userAJdkObserver);
        Observer userBJdkObserver = new UserBJdkObserver();
        weatherJdkSubject.addObserver(userBJdkObserver);
        weatherJdkSubject.notifyObservers("天气变凉，注意保暖！");
    }
}
