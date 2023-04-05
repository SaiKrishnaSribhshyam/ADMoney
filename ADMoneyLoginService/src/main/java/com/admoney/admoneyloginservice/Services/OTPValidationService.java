package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.Status;
import com.admoney.admoneyloginservice.Models.User;
import com.admoney.admoneyloginservice.Models.UserOTP;
import com.admoney.admoneyloginservice.Repos.UserOTPRepository;
import com.admoney.admoneyloginservice.Repos.UserRepository;
import com.admoney.admoneyloginservice.Utils.TimeStampFormatter;
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

    public LoginServiceResponseDTOObject validateOTP(UserOTP userOTP){
        UserOTP messagedUserOTP=userOTPRepository.findUserOTPByMobileNum(userOTP.getMobileNum());
        User user=userRepository.findUserByMobileNum(userOTP.getMobileNum());
        LoginServiceResponseDTOObject responseDTOObject=new LoginServiceResponseDTOObject();

        if(user==null){
            responseDTOObject.setMessage("Invalid User");
            responseDTOObject.setStatus("Failed");
            responseDTOObject.setStatusCode(100);
        } else if(user.getStatus()==Status.SUCCESS){
            responseDTOObject.setMessage("Invalid request");
            responseDTOObject.setStatus("Failed");
            responseDTOObject.setStatusCode(110);
        } else if(!isLatestOTP(messagedUserOTP)) {
            responseDTOObject.setMessage("Invalid OTP");
            responseDTOObject.setStatus("Failed");
            responseDTOObject.setStatusCode(120);
        }  else if(userOTP.getOtp().equals(messagedUserOTP.getOtp())){
            user.setStatus(Status.SUCCESS);
            userRepository.save(user);
            userOTPRepository.delete(messagedUserOTP);
            responseDTOObject.setMessage("Validation Success");
            responseDTOObject.setStatus("Success");
            responseDTOObject.setStatusCode(200);
        } else{
            responseDTOObject.setMessage("Incorrect OTP");
            responseDTOObject.setStatus("Failed");
            responseDTOObject.setStatusCode(130);
        }
        return responseDTOObject;
    }

    public boolean isLatestOTP(UserOTP messagedUserOTP){
        long currentTimeInMillis= TimeStampFormatter.getTimeStampinMillis(TimeStampFormatter.getCurrentTimeStamp());
        long otpGeneratedtimeInMillis= TimeStampFormatter.getTimeStampinMillis(messagedUserOTP.getTimeStamp());
        int minutesInDifference=(int)(currentTimeInMillis-otpGeneratedtimeInMillis)/(1000*60);
        return (minutesInDifference<=10)?true:false;
    }
}
