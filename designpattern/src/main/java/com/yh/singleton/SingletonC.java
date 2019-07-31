package com.yh.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/30
 * \* @Description:(双重锁校验)
 * \
 */
public class SingletonC {
    private static volatile SingletonC singleton;
    private SingletonC(){}

    public static SingletonC getInstance() {
        if (singleton == null) {
            synchronized (SingletonC.class) {
                if (singleton == null) {
                    singleton = new SingletonC();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        SingletonC instance = SingletonC.getInstance();
        SingletonC instance1 = SingletonC.getInstance();
        System.out.println(instance == instance1);
    }
}