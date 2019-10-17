package org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.service;

import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.LoginLoggingUncaughtExceptionHandler;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.po.LoginLogPO;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.thread.LoginLoggerThread;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.thread.LoginLoggingTask;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 一个登陆日志异步处理类
 * @author zhuzh
 * @date 2019.10.17
 */
public class AsynLogger {
    private static final ArrayBlockingQueue<Runnable> TASKS = new ArrayBlockingQueue<>(50);

    /**
     * 初始化300个用户登录日志
     */
    static {
        for (int i = 0; i < 300; i++) {
            TASKS.offer(new LoginLoggingTask(new LoginLogPO(i,"用户"+i,"2019-10-1"+i)));
        }
    }
    public static void log(Runnable loggingTask){
        TASKS.offer(loggingTask);
    }

    public static void startLogging(){
        while (!TASKS.isEmpty()){
            Runnable task = TASKS.poll();
            LoginLoggerThread thread = new LoginLoggerThread(task);
            thread.setUncaughtExceptionHandler(new LoginLoggingUncaughtExceptionHandler());
            thread.start();
        }
    }

}
