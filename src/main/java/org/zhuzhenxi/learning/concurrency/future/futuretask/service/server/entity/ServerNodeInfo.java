package org.zhuzhenxi.learning.concurrency.future.futuretask.service.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务节点信息
 * 记录服务节点的url和这个节点自启动以来记录的请求次数
 * @author zhuzhenxi
 * @date 2019.11.09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerNodeInfo {
    private String url;
    private int invokeCount;
}
