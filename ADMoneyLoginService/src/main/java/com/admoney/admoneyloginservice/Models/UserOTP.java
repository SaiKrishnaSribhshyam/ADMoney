package com.admoney.admoneyloginservice.Models;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class UserOTP extends BaseModel{
    @PrimaryKey
    private String mobileNum;
    private String otp;

    public UserOTP(String mobileNum, String otp) {
        this.mobileNum = mobileNum;
        this.otp = otp;
    }
    public UserOTP(){

    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
