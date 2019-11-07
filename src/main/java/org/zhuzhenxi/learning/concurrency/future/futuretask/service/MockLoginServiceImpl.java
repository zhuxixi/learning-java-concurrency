package org.zhuzhenxi.learning.concurrency.future.futuretask.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MockLoginServiceImpl implements LoginService {

    /**
     * 模拟的服务器列表，应该是通过服务注册发现动态刷新列表，这里省略
     */
    public static final List<String> SERVER_LIST = new ArrayList<>(28);
    static {
        refreshServerList();
    }
    private static final Map<String, Integer> SERVER_INVOKE_COUNT = new ConcurrentHashMap<>(28);




    @Override
    public int queryInvokeCount(String url) {
        return 0;
    }

    /**
     * 模拟真实ip地址，同一个网段
     * ip地址不能相同，所以每次随机都要判断是否重复
     */
    public static void refreshServerList(){
        String baseIp = "110.119.120.1";
        int basePort = 6000;
        String url = "";
        int count = 28;
        //创建一个
        List<Integer> seed = new ArrayList<>(40);
        while (count>0){
            int ipTail = new Random().nextInt(99);
            //随机数如果小于10，补一个0，凑三位，因为我喜欢三位数
            if (ipTail<10){
                url = baseIp+"0"+ipTail+":"+(basePort+ipTail);
            }else {
                url = baseIp+ipTail+":"+(basePort+ipTail);
            }

            count-=1;
            SERVER_LIST.add(url);
        }
    }

    public static void main(String[] args){

        System.out.println(SERVER_LIST);
    }
}
