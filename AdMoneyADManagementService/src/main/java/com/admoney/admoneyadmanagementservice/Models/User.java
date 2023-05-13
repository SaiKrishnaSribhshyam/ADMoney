package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@Table
public class User extends BaseModel{
    private String mobileNum;
    private UserStatus userStatus;
}
