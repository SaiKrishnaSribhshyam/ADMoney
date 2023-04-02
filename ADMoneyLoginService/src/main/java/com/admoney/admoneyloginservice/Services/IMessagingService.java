package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.Models.UserOTP;
import com.google.gson.JsonObject;

public  interface IMessagingService {
    public JsonObject sendMessage(UserOTP userOTP);
}
