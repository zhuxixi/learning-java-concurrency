package org.zhuzhenxi.learning.concurrency.future.futuretask.service.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerSnapShot {
    private List<String> serverList;
    private String time;
    private int heartBeatCount;
}
