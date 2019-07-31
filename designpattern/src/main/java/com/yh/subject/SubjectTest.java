package com.yh.subject;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/31
 * \* @Description:()
 * \
 */
public class SubjectTest {
    public static void main(String[] args) {
        WeatherSubject subject = new WeatherSystemSubject();
        UserObserver userA = new UserA();
        UserObserver userB = new UserB();
        subject.register(userA);
        subject.register(userB);
        subject.notifyObserver();
    }
}