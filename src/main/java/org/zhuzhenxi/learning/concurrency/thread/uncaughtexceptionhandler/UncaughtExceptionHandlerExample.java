package org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler;

import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.service.AsynLogger;

/**
 * 测试功能主类
 * @author zhuzh
 * @date 2019.10.17
 */
public class UncaughtExceptionHandlerExample {

    public static void main(String[] args){
        AsynLogger.startLogging();
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕，备用数据源有"+LoginLogBeanFactory.getInstance().getBackupDatasourceSize()+"条数据");
    }
}
