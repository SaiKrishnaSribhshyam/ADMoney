package com.admoney.admoneyusermanagementservice.DTOs;

import com.admoney.admoneyusermanagementservice.Models.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String mobileNum;
    private Status status;
}
