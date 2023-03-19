package com.admoney.admoneyloginservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OTPController {

    @GetMapping("/getOTP")
    public String getOTP(@RequestParam(name="mobilenum") String mobileNum){
        System.out.println("123456");
        return mobileNum;
    }
}
