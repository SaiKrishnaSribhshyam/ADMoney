package com.admoney.admoneyloginservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginServiceRequestDTOObject {
    private String mobileNum;
    private String otp;
}
