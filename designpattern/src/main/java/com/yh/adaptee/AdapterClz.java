package com.yh.adaptee;

public class AdapterClz extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
