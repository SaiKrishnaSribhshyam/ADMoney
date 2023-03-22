package com.admoney.admoneyloginservice;

import com.admoney.admoneyloginservice.Services.OTPGeneratorService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class OTPGenerationServiceTest {
    private int length=4;
    private OTPGeneratorService otpGeneratorService=new OTPGeneratorService(length);
    private Logger logger= LoggerFactory.getLogger(OTPGenerationServiceTest.class);

    @Test
    public void testOTPService(){
        String otp=otpGeneratorService.generateOTP();
        int intOTP=Integer.valueOf(otp);
        logger.info(otp);
        assertTrue(1000<intOTP && intOTP<10000);
    }
}
