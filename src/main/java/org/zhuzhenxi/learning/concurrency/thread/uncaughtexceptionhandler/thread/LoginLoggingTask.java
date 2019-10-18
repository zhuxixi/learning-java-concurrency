package org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.thread;

import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.LoginLogBeanFactory;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.dao.LoginLoggingDAO;
import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.po.LoginLogPO;

/**
 * 记录登录日志的执行任务
 * @author zhuzh
 * @date 2019.10.17
 */
public class LoginLoggingTask implements Runnable {

    private LoginLogPO po;
    public LoginLoggingTask(LoginLogPO po1){
        po = po1;
    }

    @Override
    public void run() {
        LoginLoggingDAO dao = LoginLogBeanFactory.getInstance();
        dao.log(po);
    }

    @Override
    public String toString() {
        return "LoginLoggingTask{" +
                "po=" + po +
                '}';
    }
}
