package com.rajkhare.batchprocessing.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SampleJob {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Job firstJob() {
        return new JobBuilder("First Job", jobRepository).start(firstStep()).build();
    }

    private Step firstStep() {
        return new StepBuilder("First Step", jobRepository).tasklet(firstTask(), transactionManager).build();
    }

    private Tasklet firstTask() {
        return (contribution, chunkContext) -> {
            System.out.println("This is first tasklet step");
            return RepeatStatus.FINISHED;
        };
    }

}
