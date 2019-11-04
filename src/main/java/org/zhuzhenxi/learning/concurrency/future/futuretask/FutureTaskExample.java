package org.zhuzhenxi.learning.concurrency.future.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args){
        CallableChecker<String> checker = new CallableChecker<>();
        FutureTask<String> test = new FutureTask<String>(checker);
        try {
            Thread a = new Thread(test);
            a.start();
            Thread.sleep(1000);
            while (test.isDone()){
                System.out.println(test.get());
            }
        }catch (ExecutionException|InterruptedException e){
            e.printStackTrace();
        }
    }
}
