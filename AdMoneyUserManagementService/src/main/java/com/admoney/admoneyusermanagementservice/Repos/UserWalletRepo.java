package com.admoney.admoneyusermanagementservice.Repos;

import com.admoney.admoneyusermanagementservice.DTOs.UserWalletDTO;
import com.admoney.admoneyusermanagementservice.Models.UserWallet;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserWalletRepo extends CassandraRepository<UserWallet,String> {
    @AllowFiltering
    public UserWallet findUserWalletByMobileNum(String mobileNum);
}
