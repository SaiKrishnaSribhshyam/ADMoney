package com.admoney.admoneyloginservice;

import com.admoney.admoneyloginservice.DTOs.LoginServiceRequestDTOObject;
import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AdMoneyLoginServiceApplicationTests {
    private RestTemplate restTemplate;

    @BeforeEach
    public void contextLoads() {
        restTemplate=new RestTemplate();
    }


@Test
    public void controllerGetOTPTest(){
        LoginServiceRequestDTOObject requestDTOObject=new LoginServiceRequestDTOObject();
        requestDTOObject.setMobileNum("9948962245");
        requestDTOObject.setOtp("NA");

        String url="http://localhost:8081/getOTP";
        Client client=new Client(url);
        String response=client.getWithBody(requestDTOObject);
        System.out.println(response);
        JsonObject responseJson=new Gson().fromJson(response,JsonObject.class);
        Assert.assertEquals("200",responseJson.get("statusCode").toString());
    }

    @SneakyThrows
    @Test
    public void controllerValidateOTPTest(){
        LoginServiceRequestDTOObject requestDTOObject=new LoginServiceRequestDTOObject();
        requestDTOObject.setMobileNum("9951499411");
        requestDTOObject.setOtp("9569");

        String url="http://localhost:8081/validateOTP";
        restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper=new ObjectMapper();

        HttpEntity<String> request=new HttpEntity<>(mapper.writeValueAsString(requestDTOObject),headers);

        LoginServiceResponseDTOObject response=restTemplate.postForObject(url,request,LoginServiceResponseDTOObject.class);
        System.out.println(response);
        //JsonObject responseJson=new Gson().fromJson(response,JsonObject.class);
        Assert.assertEquals(200,response.getStatusCode());
    }


    @SneakyThrows
    @Test
    public void controllerValidateOTP_FailedCaseTest(){
        LoginServiceRequestDTOObject requestDTOObject=new LoginServiceRequestDTOObject();
        requestDTOObject.setMobileNum("9951499411");
        requestDTOObject.setOtp("9569");

        String url="http://localhost:8081/validateOTP";
        restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper=new ObjectMapper();

        HttpEntity<String> request=new HttpEntity<>(mapper.writeValueAsString(requestDTOObject),headers);

        LoginServiceResponseDTOObject response=restTemplate.postForObject(url,request,LoginServiceResponseDTOObject.class);
        System.out.println(response);
        //JsonObject responseJson=new Gson().fromJson(response,JsonObject.class);
        Assert.assertNotEquals(200,response.getStatusCode());
    }



    @SneakyThrows
    @Test
    public void controllerValidateOTP_CheckCooieTest(){
        LoginServiceRequestDTOObject requestDTOObject=new LoginServiceRequestDTOObject();
        requestDTOObject.setMobileNum("9948962245");
        requestDTOObject.setOtp("2229");

        String url="http://localhost:8081/validateOTP";
        restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper=new ObjectMapper();
        HttpEntity<String> request=new HttpEntity<>(mapper.writeValueAsString(requestDTOObject),headers);
        ResponseEntity<LoginServiceResponseDTOObject> response=restTemplate.postForEntity(url,request,LoginServiceResponseDTOObject.class);
        System.out.println(response);
        HttpHeaders responseHeaders=response.getHeaders();
        String cookie=responseHeaders.getFirst(HttpHeaders.SET_COOKIE);
        //JsonObject responseJson=new Gson().fromJson(response,JsonObject.class);
        System.out.println(cookie);
        Assert.assertNotEquals("token",cookie.substring(0,5));
    }


}
