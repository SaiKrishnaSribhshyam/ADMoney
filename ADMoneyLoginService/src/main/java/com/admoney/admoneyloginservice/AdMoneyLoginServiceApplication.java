package com.admoney.admoneyloginservice;


import com.admoney.admoneyloginservice.Models.DataStaxAstraProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Path;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class AdMoneyLoginServiceApplication {
    private Logger logger= LoggerFactory.getLogger(AdMoneyLoginServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AdMoneyLoginServiceApplication.class, args);
    }

      @Bean
      @Autowired
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        //logger.info(astraProperties.getSeureConnectBundle().toString());
        File file=new File("secure-connect-admoneydb.zip");
          //Path bundle = file.toPath();
        Path bundle = astraProperties.getSeureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }

}
