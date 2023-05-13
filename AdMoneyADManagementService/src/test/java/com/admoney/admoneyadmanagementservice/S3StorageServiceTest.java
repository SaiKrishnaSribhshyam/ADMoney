package com.admoney.admoneyadmanagementservice;

import com.admoney.admoneyadmanagementservice.Services.S3StorageService;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

@SpringBootTest
public class S3StorageServiceTest {
    @Autowired
    private S3StorageService s3StorageService;
    @Autowired
    @Qualifier("adMoneyS3Client")
    private AmazonS3 amazonS3;
    @Value("${admanager.s3.bucket}")
    private String bucket;

    Logger logger= LoggerFactory.getLogger(S3StorageServiceTest.class);

    @Test
    public void testcase1() {
        File file=new File("E:\\ami\\SFQK7710.MP4");
        try {
            //amazonS3.setRegion(Region.getRegion(Regions.EU_WEST_2));
            FileInputStream fileInputStream = new FileInputStream(file);
            String key="AmiMakingCar2019";
            PutObjectResult putObjectResult=amazonS3.putObject(bucket,"AmiMakingCar2019",file);
            URL url=amazonS3.getUrl(bucket,key);
            logger.info(url.toString());
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
