package com.admoney.admoneyloginservice;

import com.admoney.admoneyloginservice.Models.User;
import com.admoney.admoneyloginservice.Services.Fast2SMSMessagingService;
import com.admoney.admoneyloginservice.Services.IMessagingService;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SMSServiceTest {
    private IMessagingService messagingService=new Fast2SMSMessagingService("https://www.fast2sms.com/dev/bulkV2","xQEajh5DsAJrqbwoeyLC8kNfl13RvUP4FHtWVO692Tc7ZGI0SdzyUaY8FJ304KCmAeMknhPwRq9EOTiV");
    private User user=new User("9951499411");
    private Logger logger= LoggerFactory.getLogger(SMSServiceTest.class);

    @Test
    public void testMessageService(){
        JsonObject response=messagingService.sendMessage(user,"3456");
        logger.info(response.toString());
        org.junit.Assert.assertEquals("\"OK\"",response.get("response").toString());
    }
}