package com.admoney.admoneyloginservice.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPGeneratorService {
    private int OTPLength;
    public OTPGeneratorService(@Value("${admoney.otp.length}") int OTPLength){
        this.OTPLength=OTPLength;
    }

    public String generateOTP(){
        StringBuffer otp=new StringBuffer();
        Random rand=new Random();
        for(int i=0;i<OTPLength;i++){
            otp.append(rand.nextInt(10-1)+1);
        }
        return otp.toString();
    }
}
