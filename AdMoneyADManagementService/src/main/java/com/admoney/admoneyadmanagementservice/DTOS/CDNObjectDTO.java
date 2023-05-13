package com.admoney.admoneyadmanagementservice.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CDNObjectDTO {
    private String cdnUrl;
    private String name;
    private String company;
    private double amountPerSuccessfulView;
    private int responseCode;
    private int adId;
}
