package org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.dao;

import org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.po.LoginLogPO;

/**
 * 登录日志持久层
 * @author zhuzh
 * @date 2019.10.17
 */
public interface LoginLoggingDAO {
    /**
     * 记录登录日志到数据库
     * @param po
     * @return
     */
    boolean log(LoginLogPO po);

    /**
     * 记录日志失败
     * @return
     */
    void logFailed();
}
