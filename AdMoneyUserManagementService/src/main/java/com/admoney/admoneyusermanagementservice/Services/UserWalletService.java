package com.admoney.admoneyusermanagementservice.Services;

import com.admoney.admoneyusermanagementservice.DTOs.UserDTO;
import com.admoney.admoneyusermanagementservice.DTOs.UserProfileDTO;
import com.admoney.admoneyusermanagementservice.DTOs.UserWalletDTO;
import com.admoney.admoneyusermanagementservice.Exceptions.DetailsUnAvailableException;
import com.admoney.admoneyusermanagementservice.Exceptions.InvalidUserException;
import com.admoney.admoneyusermanagementservice.Models.Status;
import com.admoney.admoneyusermanagementservice.Models.User;
import com.admoney.admoneyusermanagementservice.Models.UserProfile;
import com.admoney.admoneyusermanagementservice.Models.UserWallet;
import com.admoney.admoneyusermanagementservice.Repos.UserProfileRepo;
import com.admoney.admoneyusermanagementservice.Repos.UserRepo;
import com.admoney.admoneyusermanagementservice.Repos.UserWalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletService {
    private UserWalletRepo userWalletRepo;
    private UserRepo userRepo;

    @Autowired
    public UserWalletService(UserWalletRepo userWalletRepo,UserRepo userRepo){
        this.userWalletRepo=userWalletRepo;
        this.userRepo=userRepo;
    }

    public void userCheck(String mobileNum) throws InvalidUserException {
        User user=userRepo.findUserByMobileNum(mobileNum);
        if(user==null || user.getStatus()!= Status.VERIFIED)
            throw new InvalidUserException("User not exists or not verified");
    }

    public UserWallet getUserWallet(UserDTO userDTO) throws InvalidUserException, DetailsUnAvailableException {
        userCheck(userDTO.getMobileNum());
        UserWallet userWallet=userWalletRepo.findUserWalletByMobileNum(userDTO.getMobileNum());

        if(userWallet==null)
            throw new DetailsUnAvailableException("User wallet details Not Avaialble");
        return userWallet;
    }

    public UserDTO saveUserWallet(UserWalletDTO userWalletDTO) throws InvalidUserException {
        userCheck(userWalletDTO.getUserWallet().getMobileNum());
        userWalletRepo.save(userWalletDTO.getUserWallet());
        return new UserDTO(userWalletDTO.getUserWallet().getMobileNum(),Status.SUCCESS);
    }

}
