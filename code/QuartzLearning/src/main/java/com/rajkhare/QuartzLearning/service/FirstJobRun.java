package com.rajkhare.QuartzLearning.service;

import com.rajkhare.QuartzLearning.commonUtils.CommonUtils;
import com.rajkhare.QuartzLearning.jobs.FirstJob;
import com.rajkhare.QuartzLearning.model.TriggerInfo;
import com.rajkhare.QuartzLearning.scheduler.MainScheduler;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FirstJobRun {

    private final MainScheduler scheduler;
    private final CommonUtils commonUtils;

    @PostConstruct
    public void init() {
        TriggerInfo triggerInfo = commonUtils.getTriggerInfoObj(5,false,1000L,1000L,"info");
        scheduler.scheduleJob(FirstJob.class, triggerInfo);
    }

}
