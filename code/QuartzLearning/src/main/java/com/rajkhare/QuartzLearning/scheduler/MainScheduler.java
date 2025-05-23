package com.rajkhare.QuartzLearning.scheduler;

import com.rajkhare.QuartzLearning.commonUtils.CommonUtils;
import com.rajkhare.QuartzLearning.model.TriggerInfo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MainScheduler {

    private final Scheduler scheduler;
    private final CommonUtils commonUtils;

    @PostConstruct
    public void startScheduler() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }


    public void scheduleJob(Class className, TriggerInfo info) {

        try {
            JobDetail jobDetail = commonUtils.getJobDetail(className, info);
            Trigger trigger = commonUtils.getTriggerInfoOfJob(className, info);
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void closeScheduler() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

}
