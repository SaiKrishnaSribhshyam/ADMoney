package com.admoney.admoneyadmanagementservice.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    public int responseCode;
    public String message;
    public String description;
}
