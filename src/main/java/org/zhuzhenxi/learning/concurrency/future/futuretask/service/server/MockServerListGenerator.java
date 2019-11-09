package org.zhuzhenxi.learning.concurrency.future.futuretask.service.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zhuzhenxi.learning.concurrency.future.futuretask.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 服务器列表生成器
 * 一套微服务系统中一定有服务注册发现的组件
 * 一个比较常用的方案是基于zookeeper的watcher机制，每个微服务节点去zookeeper
 * 创建一个临时节点，并保持心跳，如果服务挂了，3秒左右临时节点会被zookeeper移除。
 * 一个微服务集群中一般都会有一类管控节点，去监听这些临时节点，如果节点被移除，说明某个节点down了
 * 但是监听不是可靠的，可能会因为一些原因例如网络原因或资源不足导致事件发生了但是监听没有生效
 * 这个是时候我们还需要心跳线程去主动拉取服务器列表
 *
 * 这个类用于模拟服务器列表的生成，为了简化处理，我们使用一个String url = 110.119.120.178:6078表示一个节点
 * @author zhuzh
 * @date 2019.11.08
 */
public class MockServerListGenerator {
    /**
     * 模拟的服务器列表，当前最新读取的服务列表
     */
    private static final List<String> CURRENT_SERVER_LIST = new ArrayList<>(28);

    /**
     * 读取的服务列表，放入历史MAP中
     */
    private static final Map<String, ServerSnapShot> SERVER_HISTORY= new LinkedHashMap<>();
    private static final Random RANDOM = new Random();

    private static final AtomicInteger HEART_BEAT_COUNTER = new AtomicInteger();

    /**
     * 先初始化一组服务列表
     */
    static {
        initialMockServerList();
        recordHistory();
    }

    /**
     * 每次读取后将服务器列表存入历史记录
     */
    private static void recordHistory() {
        if (!CURRENT_SERVER_LIST.isEmpty()){
            String time = DateUtil.getCurrentTime();
            ServerSnapShot serverSnapShot  = new ServerSnapShot(CURRENT_SERVER_LIST,time);
            SERVER_HISTORY.put(time,serverSnapShot);
        }
    }



    /**
     * 获取当前的服务器列表
     */
    public static List<String> loadServerList(){
        return CURRENT_SERVER_LIST;
    }

    /**
     * 初始化节点列表，模拟第一次获取节点列表的结果
     */
    public static void initialMockServerList(){
        //IP地址前缀
        String baseIp = "110.119.120.1";
        //端口号前缀
        int basePort = 6000;
        String url = "";

        //28个节点
        int count = 28;
        /**
         * 使用随机数，因为随机数生成可能会有重复，需要一个列表保存
         * 已生成过得随机数，如果出现重复，重新生成
         */
        List<Integer> seed = new ArrayList<>(40);
        while (count>0){
            int ipTail = 0;
            //自旋的生成随机数，直到不重复位置
            while (true){
                ipTail = RANDOM.nextInt(99);
                if (!seed.contains(ipTail)){
                    seed.add(ipTail);
                    break;
                }
            }

            //随机数如果小于10，补一个0，凑三位，因为我喜欢三位数
            if (ipTail<10){
                url = baseIp+"0"+ipTail+":"+(basePort+ipTail);
            }else {
                url = baseIp+ipTail+":"+(basePort+ipTail);
            }

            count-=1;
            CURRENT_SERVER_LIST.add(url);
        }
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ServerSnapShot{
        private List<String> serverList;
        private String time;
    }

    /**
     * 模拟心跳，3秒钟读取一次zk的服务列表
     */
    public static void heartBeat(){
        for (;;){
            /**
             * 检查随机数是否命中
             * 如果命中，重新生成一组ip，模拟集群重启的情况
             * 重启的原因有很多，可能是大半夜升级
             */
            boolean nodeAllReboot = RANDOM.nextInt(6) ==5;
            if (nodeAllReboot){
                System.out.println(HEART_BEAT_COUNTER.incrementAndGet()+".服务列表Watcher:节点列表发生变化，可能集群重启了");
                initialMockServerList();
            }else {
                System.out.println(HEART_BEAT_COUNTER.incrementAndGet()+".服务列表Watcher:节点列表无变化，一切正常");
            }
            recordHistory();
            try {
                Thread.sleep(2950);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
