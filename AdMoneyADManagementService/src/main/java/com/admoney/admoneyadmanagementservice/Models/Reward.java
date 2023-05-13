package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Table
@Getter
@Setter
public class Reward extends BaseModel{
    private Ad ad;
    private User user;
    private double rewardAmount;
    private PaymentStatus paymentStatus;
    private String transactionId;
}
