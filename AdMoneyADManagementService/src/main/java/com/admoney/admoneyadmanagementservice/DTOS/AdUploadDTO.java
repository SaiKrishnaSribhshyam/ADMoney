package com.admoney.admoneyadmanagementservice.DTOS;

import com.admoney.admoneyadmanagementservice.Models.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AdUploadDTO {
    private MultipartFile adVideo;
    private MultipartFile thumbNailImage;
    private String company;
    private String adName;
    private double campaignAmount;
    private double userAmountPerView;
    private PaymentStatus paymentStatus;
    private int questionsCount;
}
