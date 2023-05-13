package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Getter
@Setter
public class Key extends BaseModel{
    @OneToOne
    private Question question;
    private String key;
}
