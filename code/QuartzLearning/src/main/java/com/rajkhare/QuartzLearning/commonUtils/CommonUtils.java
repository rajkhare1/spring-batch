package com.rajkhare.QuartzLearning.commonUtils;

import com.rajkhare.QuartzLearning.model.TriggerInfo;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommonUtils {

    public JobDetail getJobDetail(Class className, TriggerInfo info) {
        JobDataMap jobData = new JobDataMap();
        jobData.put(className.getSimpleName(), info);
        return JobBuilder.newJob(className)
                .withIdentity(className.getSimpleName(), "grp1")
                .setJobData(jobData)
                .build();
    }

    public JobDetail getJobDetail(Class className) {

        return JobBuilder.newJob(className)
                .withIdentity(className.getSimpleName(), "grp1")
                .build();
    }

    public Trigger getTriggerByCronExpression(Class className, String cronExpression) {

        return TriggerBuilder.newTrigger()
                .withIdentity(className.getSimpleName())
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }


    public Trigger getTriggerInfoOfJob(Class className, TriggerInfo info) {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.
                simpleSchedule()
                .withIntervalInMilliseconds(info.getTimeInterval());

        if(info.isRunForever()) {
            scheduleBuilder.repeatForever();
        } else {
            scheduleBuilder.withRepeatCount(info.getTriggerCount());
        }

        return TriggerBuilder.newTrigger()
                .startAt(new Date(System.currentTimeMillis()+ info.getInitialOffSet()))
                .withSchedule(scheduleBuilder)
                .build();
    }

    public TriggerInfo getTriggerInfoObj(int triggerCount, boolean isRunForever,
                                         Long timeInterval, Long initialOffSet, String info) {

        return TriggerInfo.builder()
                .triggerCount(triggerCount)
                .isRunForever(isRunForever)
                .timeInterval(timeInterval)
                .initialOffSet(initialOffSet)
                .info(info)
                .build();
    }

}
