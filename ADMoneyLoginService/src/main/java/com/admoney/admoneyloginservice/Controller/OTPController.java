package com.admoney.admoneyloginservice.Controller;

import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class OTPController {

    @GetMapping("/getOTP")
    public LoginServiceResponseDTOObject getOTP(@RequestParam(name="mobilenum") String mobileNum){
        System.out.println("123456");
        return null;
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
