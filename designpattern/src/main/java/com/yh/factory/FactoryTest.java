package com.yh.factory;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: yanghua
 * \* @Date: 2019/7/31
 * \* @Description:()
 * \
 */
public class FactoryTest {
    public static void main(String[] args) {
        PainterFactory painterFactory = new TriangleFactory();
        Painter painter = painterFactory.createPainter();
        painter.draw();
    }
}