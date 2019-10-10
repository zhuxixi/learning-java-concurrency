package org.zhuzhenxi.learning.concurrency.copyonwritearraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CopyOnWriteArrayList的一个使用场景就是内存缓存
 * @author zhuzh
 * @date 2019.10.09
 */
public class CopyOnWriteArrayListExample {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10,50,5, TimeUnit.MINUTES,new LinkedBlockingDeque<>(10));

    private static CopyOnWriteArrayList<Dictionary> copyOnWriteArrayList = new CopyOnWriteArrayList<>(testCaseGenerator());

    private static List<Dictionary> testCaseGenerator(){
        List<Dictionary> test = new ArrayList<>(300);
        for (int i = 0; i < 300; i++) {
            Dictionary dictionary = new Dictionary(i);
            test.add(dictionary);
        }
        return test;
    }

    public static void main(String[] args) {
        int aa = 0;
        for (int i = 0; i < 300; i++) {
            aa += i ;
        }
        System.out.println("aa = "+aa);
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                int a = 0;
                for (Iterator it = copyOnWriteArrayList.iterator(); it.hasNext(); ) {
                    Dictionary dictionary = (Dictionary) it.next();
                    a = a + dictionary.getNum();
                }
                System.out.println(Thread.currentThread().getName() + "says num = " + a);
            });
        }
        try {
            Thread.sleep(10000);
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
