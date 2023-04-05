package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.DTOs.LoginServiceResponseDTOObject;
import com.admoney.admoneyloginservice.Models.Status;
import com.admoney.admoneyloginservice.Models.User;
import com.admoney.admoneyloginservice.Repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
    private UserRepository userRepository;

    public UserValidationService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public LoginServiceResponseDTOObject validateUser(String mobileNum){
        User user=userRepository.findUserByMobileNum(mobileNum);
        LoginServiceResponseDTOObject responseDTOObject=new LoginServiceResponseDTOObject();
        if(user==null) {
            responseDTOObject.setMessage("Invalid User");
            responseDTOObject.setStatus("Failed");
            responseDTOObject.setStatusCode(100);
        }

        else if(user.getStatus()==Status.SUCCESS){
            responseDTOObject.setMessage("User Authorized");
            responseDTOObject.setStatus("Success");
            responseDTOObject.setStatusCode(200);
        }
        else{
            responseDTOObject.setMessage("User not verified");
            responseDTOObject.setStatus("Failed");
            responseDTOObject.setStatusCode(110);
        }

        return responseDTOObject;
    }
}
