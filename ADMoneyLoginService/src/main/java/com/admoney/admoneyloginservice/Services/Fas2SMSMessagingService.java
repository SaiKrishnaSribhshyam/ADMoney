package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.models.Status;
import com.admoney.admoneyloginservice.models.User;
import org.springframework.web.client.RestTemplate;

public class Fas2SMSMessagingService implements IMessagingService{

    @Override
    public Status sendMessage(User user, String otp){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.patchForObject(url,);
        return null;
    }
}
