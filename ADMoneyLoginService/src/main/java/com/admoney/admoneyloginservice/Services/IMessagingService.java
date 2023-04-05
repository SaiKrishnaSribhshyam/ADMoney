package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.UserOTP;

public  interface IMessagingService {
    public LoginServiceResponseDTOObject sendMessage(UserOTP userOTP);
}
