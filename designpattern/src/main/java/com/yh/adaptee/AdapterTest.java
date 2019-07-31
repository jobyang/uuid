package com.yh.adaptee;

public class AdapterTest {
    public static void main(String[] args) {
        // 方法适配
        // 对象适配
        Adapter adapter = new Adapter();
        adapter.request();
        // 类适配
        AdapterClz adapterClz = new AdapterClz();
        adapterClz.request();
    }
}
