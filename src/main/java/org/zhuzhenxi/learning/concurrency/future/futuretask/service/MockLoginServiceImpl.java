package org.zhuzhenxi.learning.concurrency.future.futuretask.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MockLoginServiceImpl implements LoginService {


    private static final Map<String, Integer> SERVER_INVOKE_COUNT = new ConcurrentHashMap<>(28);




    @Override
    public int queryInvokeCount(String url) {
        return 0;
    }


}
