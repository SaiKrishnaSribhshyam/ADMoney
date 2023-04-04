package com.admoney.admoneyloginservice.Repos;

import com.admoney.admoneyloginservice.Models.UserOTP;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

public interface UserOTPRepository extends CrudRepository<UserOTP,String> {

    @AllowFiltering
    UserOTP findUserOTPByMobileNum(String mobileNum);
}
