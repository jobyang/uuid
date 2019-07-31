package com.yh.adaptee;

/**
 * 目标对象实现类
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget 目标方法");
    }
}
