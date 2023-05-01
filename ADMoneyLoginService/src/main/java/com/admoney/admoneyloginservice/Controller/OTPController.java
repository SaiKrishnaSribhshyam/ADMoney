package com.admoney.admoneyloginservice.Controller;

import com.admoney.admoneyloginservice.DTOs.LoginServiceRequestDTOObject;
import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.DataStaxAstraProperties;
import com.admoney.admoneyloginservice.Models.UserOTP;
import com.admoney.admoneyloginservice.Services.IMessagingService;
import com.admoney.admoneyloginservice.Services.OTPGeneratorService;
import com.admoney.admoneyloginservice.Services.OTPValidationService;
import com.admoney.admoneyloginservice.Services.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class OTPController {
    private IMessagingService messagingService;
    private OTPGeneratorService otpGeneratorService;
    private OTPValidationService otpValidationService;
    private UserValidationService userValidationService;

    public OTPController(){

    }
    @Autowired
    public OTPController(IMessagingService messagingService,OTPGeneratorService otpGeneratorService,OTPValidationService otpValidationService,UserValidationService userValidationService){
        this.messagingService=messagingService;
        this.otpGeneratorService=otpGeneratorService;
        this.otpValidationService=otpValidationService;
        this.userValidationService=userValidationService;
    }

    @GetMapping("/getOTP")
    public LoginServiceResponseDTOObject getOTP(@RequestBody LoginServiceRequestDTOObject loginServiceRequestDTOObject){
        UserOTP userOTP=new UserOTP(loginServiceRequestDTOObject.getMobileNum(), otpGeneratorService.generateOTP());
        LoginServiceResponseDTOObject responseDTOObject=messagingService.sendMessage(userOTP);
        return responseDTOObject;
    }

    @RequestMapping(method=RequestMethod.POST,value="/validateOTP")
    public LoginServiceResponseDTOObject validateOTP(@RequestBody LoginServiceRequestDTOObject loginServiceRequestDTOObject){
        UserOTP userOTP=new UserOTP(loginServiceRequestDTOObject.getMobileNum(), loginServiceRequestDTOObject.getOtp());
        return otpValidationService.validateOTP(userOTP);
    }


    @RequestMapping(method=RequestMethod.GET, value="/validateUser")
    public LoginServiceResponseDTOObject validateUser(@RequestBody LoginServiceRequestDTOObject loginServiceRequestDTOObject){
        LoginServiceResponseDTOObject responseDTOObject=userValidationService.validateUser(loginServiceRequestDTOObject.getMobileNum());return responseDTOObject;
    }
}
