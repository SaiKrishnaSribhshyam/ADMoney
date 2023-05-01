package com.admoney.admoneyusermanagementservice.DTOs;

import com.admoney.admoneyusermanagementservice.Models.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private Status status;
    private String message;
}
