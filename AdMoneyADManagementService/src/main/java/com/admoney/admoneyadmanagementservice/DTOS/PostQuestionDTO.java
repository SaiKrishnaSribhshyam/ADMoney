package com.admoney.admoneyadmanagementservice.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostQuestionDTO {
    private int adId;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String key;
}
