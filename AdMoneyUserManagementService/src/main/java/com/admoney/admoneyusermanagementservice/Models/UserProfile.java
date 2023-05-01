package com.admoney.admoneyusermanagementservice.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Getter
@Setter
public class UserProfile{
    @PrimaryKey
    private String mobileNum;
    private String name;
    private String occupation;
    private String dateOfBirth;
    private String city;
    private String state;
    private String mailId;
}
