package org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler;

import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.dao.LoginLoggingDAO;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.exception.DatasourceBusyException;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.service.AsynLogger;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.thread.LoginLoggerThread;

/**
 * 一个自定义的线程任务异常处理器
 * @author zhuzh
 * @date 2019.10.17
 */
public class LoginLoggingUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //如果确实是数据源的问题，我们再切换数据源，如果抛出了别的异常，暂不处理
        if (e instanceof DatasourceBusyException){
            LoginLoggingDAO dao = LoginLogBeanFactory.getInstance();
            dao.logFailed();
            LoginLoggerThread thread = (LoginLoggerThread)t;
            Runnable task = thread.getTask();
            AsynLogger.log(task);
        }
    }
}