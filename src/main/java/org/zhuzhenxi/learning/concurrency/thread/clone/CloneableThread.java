package org.zhuzhenxi.learning.concurrency.thread.clone;

public class CloneableThread extends Thread {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
