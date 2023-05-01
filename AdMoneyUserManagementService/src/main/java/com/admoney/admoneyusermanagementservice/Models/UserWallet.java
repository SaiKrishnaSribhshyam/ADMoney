package com.admoney.admoneyusermanagementservice.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Getter
@Setter
public class UserWallet{
    @PrimaryKey
    private String mobileNum;
    private String upiId;
}
