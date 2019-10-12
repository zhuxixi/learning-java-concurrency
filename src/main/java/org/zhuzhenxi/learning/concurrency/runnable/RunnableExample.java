package org.zhuzhenxi.learning.concurrency.runnable;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhuzh
 * @date 2019.10.12
 */
public class RunnableExample {

    public static void main(String[] args){
        Runnable runner = () -> System.out.println(Thread.currentThread().getName());
        runner.run();
    }
}
