package com.admoney.admoneyloginservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginServiceRequestDTOObject {
    private String mobileNum;
    private String otp;
}
