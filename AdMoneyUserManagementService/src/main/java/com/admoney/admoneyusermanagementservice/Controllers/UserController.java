package com.admoney.admoneyusermanagementservice.Controllers;

import com.admoney.admoneyusermanagementservice.DTOs.ResponseDTO;
import com.admoney.admoneyusermanagementservice.DTOs.UserProfileDTO;
import com.admoney.admoneyusermanagementservice.DTOs.UserDTO;
import com.admoney.admoneyusermanagementservice.DTOs.UserWalletDTO;
import com.admoney.admoneyusermanagementservice.Exceptions.DetailsUnAvailableException;
import com.admoney.admoneyusermanagementservice.Exceptions.InvalidUserException;
import com.admoney.admoneyusermanagementservice.Models.Status;
import com.admoney.admoneyusermanagementservice.Models.UserProfile;
import com.admoney.admoneyusermanagementservice.Models.UserWallet;
import com.admoney.admoneyusermanagementservice.Services.UserProfileService;
import com.admoney.admoneyusermanagementservice.Services.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserProfileService userProfileService;
    private UserWalletService userWalletService;

    @Autowired
    public UserController(UserProfileService userProfileService,UserWalletService userWalletService){
        this.userProfileService=userProfileService;
        this.userWalletService=userWalletService;
    }

    @RequestMapping(method = RequestMethod.POST,value="/user/updateprofile")
    public UserDTO updateUserProfile(@RequestBody UserProfileDTO userProfileDTO) throws InvalidUserException {
        return userProfileService.saveUserProfile(userProfileDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/updatewallet")
    public UserDTO updateWalletDetails(@RequestBody UserWalletDTO userWalletDTO) throws InvalidUserException {
        return userWalletService.saveUserWallet(userWalletDTO);
    }

    @RequestMapping(method=RequestMethod.GET,value="/user/getuserprofile")
    public UserProfileDTO getUserProfile(@RequestBody UserDTO userDTO) throws InvalidUserException, DetailsUnAvailableException {
        UserProfile userProfile= userProfileService.getUserProfile(userDTO);
        UserProfileDTO userProfileDTO=new UserProfileDTO();
        userProfileDTO.setUserProfile(userProfile);
        userProfileDTO.setStatus(Status.SUCCESS);
        return userProfileDTO;
    }

    @RequestMapping(method = RequestMethod.GET,value="/user/getuserwallet")
    public UserWalletDTO getUserWallet(@RequestBody UserDTO userDTO) throws DetailsUnAvailableException, InvalidUserException {
        UserWallet userWallet=userWalletService.getUserWallet(userDTO);
        UserWalletDTO userWalletDTO=new UserWalletDTO();
        userWalletDTO.setUserWallet(userWallet);
        userWalletDTO.setStatus(Status.SUCCESS);
        return userWalletDTO;
    }

    @ExceptionHandler({InvalidUserException.class, DetailsUnAvailableException.class})
    public ResponseDTO exceptionHandling(Exception e){
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setStatus(Status.FAILED);
        responseDTO.setMessage(e.getMessage());
        return responseDTO;
    }
}
