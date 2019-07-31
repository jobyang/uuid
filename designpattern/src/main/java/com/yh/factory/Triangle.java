package com.yh.factory;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/31
 * \* @Description:()
 * \
 */
public class Triangle implements Painter {
    @Override
    public void draw() {
        System.out.println("画三角形");
    }
}