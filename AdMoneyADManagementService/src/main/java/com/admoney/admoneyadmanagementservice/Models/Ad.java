package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Ad{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String name;
    private String company;
    private LocalDateTime listedDate;
    private String s3URL;
    private String s3Key;
    @Enumerated(EnumType.STRING)
    private AdStatus adStatus;
}
