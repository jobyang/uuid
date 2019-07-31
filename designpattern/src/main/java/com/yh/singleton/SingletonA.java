package com.yh.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/30
 * \* @Description:(饿汉式)
 * \
 */
public class SingletonA {
    private static SingletonA singleton = new SingletonA();
    private SingletonA(){}

    public static SingletonA getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        SingletonA instance = SingletonA.getInstance();
        SingletonA instance1 = SingletonA.getInstance();
        System.out.println(instance == instance1);
    }
}