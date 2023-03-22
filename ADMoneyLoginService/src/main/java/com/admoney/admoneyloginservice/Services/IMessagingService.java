package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.Models.User;
import com.google.gson.JsonObject;

public  interface IMessagingService {
    public JsonObject sendMessage(User user, String otp);
}
