package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.Models.Status;
import com.admoney.admoneyloginservice.Models.User;
import com.admoney.admoneyloginservice.Models.UserOTP;
import com.admoney.admoneyloginservice.Repos.UserOTPRepository;
import com.admoney.admoneyloginservice.Repos.UserRepository;
import com.admoney.admoneyloginservice.Utils.TimeStampFormatter;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPValidationService {
    private UserRepository userRepository;
    private UserOTPRepository userOTPRepository;

    @Autowired
    public OTPValidationService(UserRepository userRepository,UserOTPRepository userOTPRepository){
        this.userRepository=userRepository;
        this.userOTPRepository=userOTPRepository;
    }

    public JsonObject validateOTP(UserOTP userOTP){
        UserOTP messagedUserOTP=userOTPRepository.findUserOTPByMobileNum(userOTP.getMobileNum());
        User user=userRepository.findUserByMobileNum(userOTP.getMobileNum());
        JsonObject responseJson=new JsonObject();

        if(user==null){
            responseJson.addProperty("response","Invalid User");
        } else if(user.getStatus()==Status.SUCCESS){
            responseJson.addProperty("response","Invalid request");
        } else if(!isLatestOTP(messagedUserOTP)) {
            responseJson.addProperty("response","Invalid OTP");
        }  else if(userOTP.getOtp().equals(messagedUserOTP.getOtp())){
            user.setStatus(Status.SUCCESS);
            userRepository.save(user);
            responseJson.addProperty("response","Validation Success");
        } else{
            responseJson.addProperty("response","Incorrect OTP");
        }
        return responseJson;
    }

    public boolean isLatestOTP(UserOTP messagedUserOTP){
        long currentTimeInMillis= TimeStampFormatter.getTimeStampinMillis(TimeStampFormatter.getCurrentTimeStamp());
        long otpGeneratedtimeInMillis= TimeStampFormatter.getTimeStampinMillis(messagedUserOTP.getTimeStamp());
        int minutesInDifference=(int)(currentTimeInMillis-otpGeneratedtimeInMillis)/(1000*60);
        return (minutesInDifference<=10)?true:false;
    }
}
