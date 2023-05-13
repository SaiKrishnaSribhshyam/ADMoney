package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class S3Object extends BaseModel{
    private MultipartFile multipartFile;
    private S3ObjectType objectType;
    private String key;
}
