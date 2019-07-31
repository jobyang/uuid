package com.yh.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/30
 * \* @Description:(静态内部类)
 * \
 */
public class SingletonD {
    private SingletonD(){}

    private static class InnerSingletonD {
        private final static SingletonD SINGLETON_D = new SingletonD();
    }

    public static SingletonD getInstance() {
        return InnerSingletonD.SINGLETON_D;
    }

    public static void main(String[] args) {
    }
}