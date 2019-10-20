package org.zhuzhenxi.learning.concurrency.thread.stacksize;

/**
 * 指定Stack size改变线程数量
 * @author zhuzh
 * @date 2019.10.20
 */
public class ThreadCountExample {
    public static void main(String[] args){
        int i = 0;
        while (true){
            i++;
            System.out.println(i);
            Thread thread = new StackSizeExampleThread(null,new WaitTask(),i+"",1000*1000*1000);
            thread.start();
        }
    }
}
