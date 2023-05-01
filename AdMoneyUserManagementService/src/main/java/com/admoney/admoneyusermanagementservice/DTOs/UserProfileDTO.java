package com.admoney.admoneyusermanagementservice.DTOs;

import com.admoney.admoneyusermanagementservice.Models.Status;
import com.admoney.admoneyusermanagementservice.Models.UserProfile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDTO {
    private UserProfile userProfile;
    private Status status;
}
