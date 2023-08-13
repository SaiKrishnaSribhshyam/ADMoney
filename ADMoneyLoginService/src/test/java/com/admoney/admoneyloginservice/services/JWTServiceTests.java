package com.admoney.admoneyloginservice.services;

import com.admoney.admoneyloginservice.Models.Status;
import com.admoney.admoneyloginservice.Models.User;
import com.admoney.admoneyloginservice.Services.JWTService;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class JWTServiceTests {

    private JWTService jwtService;

    @BeforeEach
    @Test
    public void setup(){
        jwtService=new JWTService();
        System.out.println("Initialised");
        Class serviceClass=jwtService.getClass();
        try {
            Field secretKey=serviceClass.getDeclaredField("secretKey");
            secretKey.setAccessible(true);
            secretKey.set(jwtService,"MY_SECRET_KEY");
            Assertions.assertEquals("MY_SECRET_KEY",(String)secretKey.get(jwtService));

            Field algo=serviceClass.getDeclaredField("algorithm");
            algo.setAccessible(true);
            algo.set(jwtService, Algorithm.HMAC256("MY_SECRET_KEY"));

        } catch (Exception e){
            System.out.println("exception in setting algo");
        }
    }


    @Test
    public void testCreateToken(){
        User user=new User();
        user.setMobileNum("9951499411");
        user.setStatus(Status.SUCCESS);
        String token=jwtService.createJWTToken(user);
        System.out.println(token);
        Assertions.assertEquals("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiOTk1MTQ5OTQxMSIsImlzcyI6ImF1dGgwIn0.ZOur2ZDyUvxfu0dqrXIYI3BGIR9c0A-uu4V1s2rufXo",token);
    }

    @Test
    public void testValidateToken(){
        String payload=jwtService.verifyJWTToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiOTk1MTQ5OTQxMSIsImlzcyI6ImF1dGgwIn0.ZOur2ZDyUvxfu0dqrXIYI3BGIR9c0A-uu4V1s2rufXo");
        Assertions.assertEquals("eyJ1c2VyIjoiOTk1MTQ5OTQxMSIsImlzcyI6ImF1dGgwIn0",payload);
    }
}
