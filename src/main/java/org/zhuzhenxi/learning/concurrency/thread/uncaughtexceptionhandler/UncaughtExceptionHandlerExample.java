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
    }
}
