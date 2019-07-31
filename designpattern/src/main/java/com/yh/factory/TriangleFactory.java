package com.yh.factory;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/31
 * \* @Description:()
 * \
 */
public class TriangleFactory implements PainterFactory {
    @Override
    public Painter createPainter() {
        return new Triangle();
    }
}