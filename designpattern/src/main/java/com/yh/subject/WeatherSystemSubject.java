package com.yh.subject;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/31
 * \* @Description:()
 * \
 */
public class WeatherSystemSubject extends WeatherSubject {
    @Override
    void notifyObserver() {
        for (UserObserver userObserver : userObservers) {
            userObserver.update("台风天气，注意暴雨！");
        }
    }
}