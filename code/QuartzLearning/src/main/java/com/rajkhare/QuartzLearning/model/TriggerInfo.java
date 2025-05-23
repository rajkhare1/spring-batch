package com.rajkhare.QuartzLearning.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TriggerInfo {

    private int triggerCount;
    private boolean isRunForever;
    private Long timeInterval;
    private Long initialOffSet;
    private String info;

}
