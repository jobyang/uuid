package com.yh.factory;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/31
 * \* @Description:()
 * \
 */
public class Square implements Painter {
    @Override
    public void draw() {
        System.out.println("画方形");
    }
}