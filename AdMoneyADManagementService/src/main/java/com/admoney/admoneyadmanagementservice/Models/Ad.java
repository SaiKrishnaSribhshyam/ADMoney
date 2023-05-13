package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table
public class Ad extends BaseModel{
    private String name;
    private String company;
    private LocalDateTime listedDate;
    private String s3URL;
    private String s3Key;
    @Enumerated(EnumType.STRING)
    private AdStatus adStatus;
}
