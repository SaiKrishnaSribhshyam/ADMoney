package com.admoney.admoneyusermanagementservice.DTOs;

import com.admoney.admoneyusermanagementservice.Models.Status;
import com.admoney.admoneyusermanagementservice.Models.UserWallet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWalletDTO {
    private UserWallet userWallet;
    private Status status;
}
