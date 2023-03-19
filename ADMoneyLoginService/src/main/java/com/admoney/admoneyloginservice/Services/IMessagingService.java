package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.models.Status;
import com.admoney.admoneyloginservice.models.User;

public  interface IMessagingService {
    public Status sendMessage(User user, String otp);
}
