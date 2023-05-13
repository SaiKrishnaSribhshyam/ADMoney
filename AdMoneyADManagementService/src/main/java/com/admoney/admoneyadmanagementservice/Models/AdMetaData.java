package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table
public class AdMetaData extends BaseModel{
    @OneToOne
    private Ad ad;
    private double userAmountPerSuccessfulView;
    private double totalCampaignAmount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private int expectedImpressions;
    private int questionsCount;
}
