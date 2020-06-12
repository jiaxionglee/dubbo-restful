package com.ljx.dubbo.restful.util;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiaxiong
 * @date 2020/6/12 2:15 下午
 */
public class ZkUtil {

    private static final Logger logger = LoggerFactory.getLogger(ZkUtil.class);

    private static final RetryPolicy RETRY_POLICY = new ExponentialBackoffRetry(1000, 3);

    private static CuratorFramework createClient(String zk) {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(zk)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(RETRY_POLICY)
                .build();
        client.start();
        return client;
    }

    public static Object getDubboData(String zk, String path) {
        CuratorFramework client = createClient(zk);
        List<String> result = new ArrayList<>();
        try {
            List<String> strings = client.getChildren().forPath(path);
            for (String str : strings) {
                result.add(URLDecoder.decode(str, "UTF-8"));
            }
        } catch (Exception e) {
            logger.error("get path error", e);
        } finally {
            client.close();
        }
        return result;
    }
}
