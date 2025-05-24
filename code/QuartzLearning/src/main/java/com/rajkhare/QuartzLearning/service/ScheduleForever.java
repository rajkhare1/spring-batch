package com.rajkhare.QuartzLearning.service;

import com.rajkhare.QuartzLearning.commonUtils.CommonUtils;
import com.rajkhare.QuartzLearning.jobs.SecondJob;
import com.rajkhare.QuartzLearning.model.TriggerInfo;
import com.rajkhare.QuartzLearning.scheduler.MainScheduler;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleForever {

    private final MainScheduler scheduler;
    private final CommonUtils commonUtils;

    @PostConstruct
    public void init() {
//        TriggerInfo triggerInfoDTO = commonUtils.getTriggerInfoObj(1,true,1000L,1000L,"Hello Forever");
        scheduler.scheduleJob(SecondJob.class, "0/2 * * * * ?");
    }

}
