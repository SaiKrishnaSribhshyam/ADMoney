package com.admoney.admoneyadmanagementservice.Services;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
public class AuthenticationService {

    public boolean isAuthenticated(HttpServletRequest request){
        return request.getSession()
                .getAttribute("Authentication")
                .equals("Completed");
    }
}
