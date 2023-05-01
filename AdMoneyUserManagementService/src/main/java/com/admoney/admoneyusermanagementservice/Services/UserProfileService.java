package com.admoney.admoneyusermanagementservice.Services;

import com.admoney.admoneyusermanagementservice.DTOs.UserDTO;
import com.admoney.admoneyusermanagementservice.DTOs.UserProfileDTO;
import com.admoney.admoneyusermanagementservice.Exceptions.DetailsUnAvailableException;
import com.admoney.admoneyusermanagementservice.Exceptions.InvalidUserException;
import com.admoney.admoneyusermanagementservice.Models.Status;
import com.admoney.admoneyusermanagementservice.Models.User;
import com.admoney.admoneyusermanagementservice.Models.UserProfile;
import com.admoney.admoneyusermanagementservice.Repos.UserProfileRepo;
import com.admoney.admoneyusermanagementservice.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private UserProfileRepo userProfileRepo;
    private UserRepo userRepo;

    @Autowired
    public UserProfileService(UserProfileRepo userProfileRepo,UserRepo userRepo){
        this.userProfileRepo=userProfileRepo;
        this.userRepo=userRepo;
    }

    public void userCheck(String mobileNum) throws InvalidUserException{
        User user=userRepo.findUserByMobileNum(mobileNum);
        if(user==null || user.getStatus()!= Status.VERIFIED)
            throw new InvalidUserException("User not exists or not verified");
    }

    public UserProfile getUserProfile(UserDTO userDTO) throws InvalidUserException, DetailsUnAvailableException {
        userCheck(userDTO.getMobileNum());
        UserProfile userProfile=userProfileRepo.findUserProfileByMobileNum(userDTO.getMobileNum());

        if(userProfile==null)
            throw new DetailsUnAvailableException("User Profile details Not Avaialble");
        return userProfile;
    }

    public UserDTO saveUserProfile(UserProfileDTO userProfileDTO) throws InvalidUserException {
        userCheck(userProfileDTO.getUserProfile().getMobileNum());
        userProfileRepo.save(userProfileDTO.getUserProfile());
        return new UserDTO(userProfileDTO.getUserProfile().getMobileNum(),Status.SUCCESS);
    }


}
