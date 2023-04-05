package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.User;
import com.admoney.admoneyloginservice.Models.UserOTP;
import com.admoney.admoneyloginservice.Repos.UserOTPRepository;
import com.admoney.admoneyloginservice.Repos.UserRepository;
import com.admoney.admoneyloginservice.Utils.TimeStampFormatter;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Fast2SMSMessagingService implements IMessagingService{

    private String fast2smsurl;
    private String authToken;
    private Logger logger= LoggerFactory.getLogger(Fast2SMSMessagingService.class);
    private UserRepository userRepository;
    private UserOTPRepository userOTPRepository;

    @Autowired
    public Fast2SMSMessagingService(@Value("${admoney.fast2sms.url}") String fast2smsurl,@Value("${admoney.fast2sms.token}")String authToken, UserRepository userRepository,UserOTPRepository userOTPRepository){
        this.fast2smsurl=fast2smsurl;
        this.authToken=authToken;
        this.userRepository=userRepository;
        this.userOTPRepository=userOTPRepository;
    }

    @Override
    public LoginServiceResponseDTOObject sendMessage(UserOTP userOTP){
        User user=new User(userOTP.getMobileNum());
        userRepository.save(user);

        //setting headers
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authorization",authToken);

        //POST request body
        JsonObject body=new JsonObject();
        body.addProperty("route","otp");
        body.addProperty("sender_id","ADMoney");
        body.addProperty("variables_values",userOTP.getOtp());
        body.addProperty("flash", 0);
        body.addProperty("numbers",userOTP.getMobileNum());
        //HTTP Request
        HttpEntity<String> request=new HttpEntity<>(body.toString(),headers);

        System.out.println(body.toString());
        logger.info(body.toString());
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<JsonObject> response=restTemplate.postForEntity(fast2smsurl,request, JsonObject.class);
        logger.info(response.getStatusCode().toString());

        LoginServiceResponseDTOObject responseDTOObject=new LoginServiceResponseDTOObject();
        if(response.getStatusCode()== HttpStatus.OK) {
            responseDTOObject.setStatus("Success");
            responseDTOObject.setStatusCode(200);
            responseDTOObject.setMessage("Message sent to User Successfully");
            userOTP.setTimeStamp(TimeStampFormatter.getCurrentTimeStamp());
            userOTPRepository.save(userOTP);
        }
        else {
            responseDTOObject.setStatus("Failed");
            responseDTOObject.setStatusCode(100);
            responseDTOObject.setMessage("Failed to send Message");
        }

        return responseDTOObject;
    }
}
