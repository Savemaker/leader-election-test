package com.savushkin.leader.app;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class LeaderLogic {
    private LeaderSelector leaderSelector;

    @Scheduled(cron = "*/5 * * * * *")
    public void printLine() {
        if (leaderSelector.hasLeadership()) {
            log.info("Leader stuff");
        }
    }
}
