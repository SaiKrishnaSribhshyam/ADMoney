package com.admoney.admoneyloginservice.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Getter
@Setter
public class UserOTP extends BaseModel{
    @PrimaryKey
    private String mobileNum;
    private String otp;
    private String timeStamp;


    public UserOTP(String mobileNum, String otp,String timeStamp) {
        this.mobileNum = mobileNum;
        this.otp = otp;
        this.timeStamp = timeStamp;
    }

    public UserOTP(String mobileNum, String otp) {
        this.mobileNum = mobileNum;
        this.otp = otp;
    }

    public UserOTP(){

    }

}
