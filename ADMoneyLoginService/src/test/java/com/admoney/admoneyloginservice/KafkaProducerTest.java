package com.admoney.admoneyloginservice;


import com.admoney.admoneyloginservice.Config.KafkaProducer;
import com.admoney.admoneyloginservice.Models.Status;
import com.admoney.admoneyloginservice.Models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerTest {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void sendMessageTest(){
        User user=new User();
        user.setMobileNum("9951499411");
        user.setStatus(Status.SUCCESS);
        kafkaProducer.sendMessage(user);
    }
}
