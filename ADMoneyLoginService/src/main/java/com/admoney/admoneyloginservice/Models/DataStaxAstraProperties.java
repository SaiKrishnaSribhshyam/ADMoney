package com.admoney.admoneyloginservice.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@Getter
@Setter
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties  {
    @Value("${datastax.astra.secureConnectBundle}")
    private File seureConnectBundle;
}