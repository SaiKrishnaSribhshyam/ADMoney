package com.admoney.admoneyloginservice;

import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.UserOTP;
import com.admoney.admoneyloginservice.Repos.UserOTPRepository;
import com.admoney.admoneyloginservice.Repos.UserRepository;
import com.admoney.admoneyloginservice.Services.OTPValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OTPValidationServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserOTPRepository userOTPRepository;
    @Autowired
    private OTPValidationService otpValidationService;

    @Test
    public void testValidateOTPSuccessCase(){
        UserOTP userOTP=new UserOTP("9951499411","8986");
        LoginServiceResponseDTOObject responseDTOObject=otpValidationService.validateOTP(userOTP);
        org.junit.Assert.assertEquals("\"Validation Success\"",responseDTOObject.getMessage());
    }


}
