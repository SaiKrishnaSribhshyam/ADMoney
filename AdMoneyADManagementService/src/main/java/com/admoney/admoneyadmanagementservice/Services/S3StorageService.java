package com.admoney.admoneyadmanagementservice.Services;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

@Service
public class S3StorageService {
    private AmazonS3 s3Client;

    @Autowired
    public S3StorageService(AmazonS3 s3Client){
        this.s3Client=s3Client;
    }

    public String uploadObject(ByteArrayInputStream byteArrayInputStream,){

    }
}
