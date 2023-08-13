package com.admoney.admoneyloginservice.Controller;

import com.admoney.admoneyloginservice.DTOs.LoginServiceRequestDTOObject;
import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.DataStaxAstraProperties;
import com.admoney.admoneyloginservice.Models.User;
import com.admoney.admoneyloginservice.Models.UserOTP;
import com.admoney.admoneyloginservice.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class OTPController {
    private IMessagingService messagingService;
    private OTPGeneratorService otpGeneratorService;
    private OTPValidationService otpValidationService;
    private UserValidationService userValidationService;
    private JWTService jwtService;

    public OTPController(){

    }
    @Autowired
    public OTPController(IMessagingService messagingService,OTPGeneratorService otpGeneratorService,OTPValidationService otpValidationService,UserValidationService userValidationService,JWTService jwtService){
        this.messagingService=messagingService;
        this.otpGeneratorService=otpGeneratorService;
        this.otpValidationService=otpValidationService;
        this.userValidationService=userValidationService;
        this.jwtService=jwtService;
    }

    @GetMapping("/getOTP")
    public LoginServiceResponseDTOObject getOTP(@RequestBody LoginServiceRequestDTOObject loginServiceRequestDTOObject){
        UserOTP userOTP=new UserOTP(loginServiceRequestDTOObject.getMobileNum(), otpGeneratorService.generateOTP());
        LoginServiceResponseDTOObject responseDTOObject=messagingService.sendMessage(userOTP);
        return responseDTOObject;
    }

    @RequestMapping(method=RequestMethod.POST,value="/validateOTP")
    public LoginServiceResponseDTOObject validateOTP(@RequestBody LoginServiceRequestDTOObject loginServiceRequestDTOObject, HttpServletResponse response){
        UserOTP userOTP=new UserOTP(loginServiceRequestDTOObject.getMobileNum(), loginServiceRequestDTOObject.getOtp());
        LoginServiceResponseDTOObject loginServiceResponseDTOObject=otpValidationService.validateOTP(userOTP);
        if(loginServiceResponseDTOObject.getStatusCode()==200){
            Cookie cookie=new Cookie("token", jwtService.createJWTToken(new User(loginServiceRequestDTOObject.getMobileNum())));
            cookie.setComment("Authntication token");
            cookie.setMaxAge(15);
            response.addCookie(cookie);
        }
        return loginServiceResponseDTOObject;
    }


    @RequestMapping(method=RequestMethod.GET, value="/validateUser")
    public LoginServiceResponseDTOObject validateUser(@RequestBody LoginServiceRequestDTOObject loginServiceRequestDTOObject){
        LoginServiceResponseDTOObject responseDTOObject=userValidationService.validateUser(loginServiceRequestDTOObject.getMobileNum());
        return responseDTOObject;
    }
}
