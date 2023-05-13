package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Table
@Getter
@Setter
public class ThumbNail extends BaseModel{
    private Ad ad;
    private String s3URL;
    private String s3Key;
}
