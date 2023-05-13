package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table
public class Question extends BaseModel {
    @ManyToOne
    private Ad ad;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
