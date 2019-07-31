package com.yh.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/30
 * \* @Description:(懒汉式)
 * \
 */
public class SingletonB {
    private static SingletonB singleton;
    private SingletonB(){}

    public static SingletonB getInstance() {
        if (singleton == null) {
            singleton = new SingletonB();
        }
        return singleton;
    }

    public static void main(String[] args) {
        SingletonB instance = SingletonB.getInstance();
        SingletonB instance1 = SingletonB.getInstance();
        System.out.println(instance == instance1);
    }
}