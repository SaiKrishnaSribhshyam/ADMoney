package com.admoney.admoneyadmanagementservice.Services;

import com.admoney.admoneyadmanagementservice.Models.S3Object;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Service
public class S3StorageService {
    private AmazonS3 s3Client;
    @Value("${admanager.s3.bucket}")
    private String bucket;

    @Autowired
    public S3StorageService(  @Qualifier("adMoneyS3Client") AmazonS3 s3Client){
        this.s3Client=s3Client;
    }

    public String uploadObject(S3Object s3Object) throws IOException {
        ObjectMetadata s3Metadate=new ObjectMetadata();
        PutObjectResult result=s3Client.putObject(bucket,s3Object.getKey(),s3Object.getMultipartFile().getInputStream(),new ObjectMetadata());
        return s3Client.getUrl(bucket,s3Object.getKey()).toString();
    }
}
