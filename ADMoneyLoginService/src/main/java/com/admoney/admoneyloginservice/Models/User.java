package com.admoney.admoneyloginservice.Models;

import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@ToString
public class User extends BaseModel{
    @PrimaryKey
    private String mobileNum;
    private Status status;

    public User() {
    }

    public User(String mobileNum){
        this.mobileNum=mobileNum;
        this.status = Status.PENDING;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
