package org.zhuzhenxi.learning.concurrency.future.futuretask.callable;

import java.util.concurrent.Callable;

public class CallableChecker<String> implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("当前线程"+Thread.currentThread().getName());
        throw new RuntimeException("故意的");
    }
}
