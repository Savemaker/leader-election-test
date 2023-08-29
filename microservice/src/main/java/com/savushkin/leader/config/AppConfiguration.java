package com.savushkin.leader.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfiguration {

    public static final String ZOOKEEPER_CONNECTION = "localhost:2181";
    public static final String ZOOKEEPER_LEADER_PATH = "/business";

    @Bean
    CuratorFramework curatorFramework() {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZOOKEEPER_CONNECTION,
                new ExponentialBackoffRetry(1000, 3));
        client.start();
        return client;
    }

    @Bean
    LeaderSelector leaderSelector(CuratorFramework curatorClient) {
        LeaderSelector leaderSelector = new LeaderSelector(curatorClient, ZOOKEEPER_LEADER_PATH, new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework client) {
                log.info("Obtained leadership");
                while (true) {

                }
            }
        });
        leaderSelector.start();
        return leaderSelector;
    }
}
