package com.rajkhare.QuartzLearning.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SecondJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext)  {
        System.out.println("Executing forever");
    }

}
