package com.admoney.admoneyloginservice.Controller;

import com.admoney.admoneyloginservice.DTOs.LoginServiceRequestDTOObject;
import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.DataStaxAstraProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class OTPController {
    @Autowired
    DataStaxAstraProperties astraProperties;

    @GetMapping("/getOTP")
    public LoginServiceResponseDTOObject getOTP(@RequestBody LoginServiceRequestDTOObject loginServiceRequestDTOObject){
        LoginServiceResponseDTOObject responseDTOObject=new LoginServiceResponseDTOObject();
        responseDTOObject.setMessage(loginServiceRequestDTOObject.getMobileNum());
        responseDTOObject.setStatus("Success");
        responseDTOObject.setStatusCode(200);
        return responseDTOObject;
    }

    @RequestMapping(method = RequestMethod.POST,name="/validateOTP")
    public LoginServiceResponseDTOObject validateOTP(@RequestParam(name="otp") String otp){
        return null;
    }

    @RequestMapping(method=RequestMethod.GET, value="/validateUser")
    public LoginServiceResponseDTOObject validateUser(@RequestParam(name="mobilenum") String mobileNum){
        return null;
    }
}
