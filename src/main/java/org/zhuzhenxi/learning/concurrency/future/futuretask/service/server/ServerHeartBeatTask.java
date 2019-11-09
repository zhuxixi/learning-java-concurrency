package org.zhuzhenxi.learning.concurrency.future.futuretask.service.server;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhuzhenxi
 * @date 2019.11.09
 */
@AllArgsConstructor
public class ServerHeartBeatTask implements Runnable {

    private CountDownLatch latch;




    @Override
    public void run() {
        MockServerListGenerator.heartBeat();
        latch.countDown();
    }
}
