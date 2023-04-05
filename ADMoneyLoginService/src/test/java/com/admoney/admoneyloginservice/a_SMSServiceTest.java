package com.admoney.admoneyloginservice;

import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.UserOTP;
import com.admoney.admoneyloginservice.Repos.UserOTPRepository;
import com.admoney.admoneyloginservice.Repos.UserRepository;
import com.admoney.admoneyloginservice.Services.Fast2SMSMessagingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class a_SMSServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserOTPRepository userOTPRepository;
    @Autowired
    private Fast2SMSMessagingService messagingService;
    private UserOTP userOTP =new UserOTP("9951499411","8986");
    private Logger logger= LoggerFactory.getLogger(a_SMSServiceTest.class);

    @Test
    public void testMessageService(){
        LoginServiceResponseDTOObject responseDTOObject=messagingService.sendMessage(userOTP);
        logger.info(responseDTOObject.getStatus());
        org.junit.Assert.assertEquals("\"Success\"",responseDTOObject.getStatus());
    }
}
