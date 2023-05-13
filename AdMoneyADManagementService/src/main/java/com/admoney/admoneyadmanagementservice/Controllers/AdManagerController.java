package com.admoney.admoneyadmanagementservice.Controllers;

import com.admoney.admoneyadmanagementservice.DTOS.*;
import com.admoney.admoneyadmanagementservice.Exceptions.AdNotAvailalbeException;
import com.admoney.admoneyadmanagementservice.Models.S3Object;
import com.admoney.admoneyadmanagementservice.Models.S3ObjectType;
import com.admoney.admoneyadmanagementservice.Services.S3StorageService;
import com.amazonaws.services.ec2.model.RequestSpotFleetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AdManagerController {
    private S3StorageService s3StorageService;

    @Autowired
    public AdManagerController(S3StorageService s3StorageService){
        this.s3StorageService=s3StorageService;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/uploadAd")
    public ResponseDTO uploadFile(@ModelAttribute AdUploadDTO adUploadDTO) throws IOException {
        S3Object adVideoS3Object=new S3Object();
        adVideoS3Object.setMultipartFile(adUploadDTO.getAdVideo());
        adVideoS3Object.setObjectType(S3ObjectType.AD);
        adVideoS3Object.setKey("ADVIDEO_1");
        adVideoS3Object.setId(1);
        String url=s3StorageService.uploadObject(adVideoS3Object);

        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setResponseCode(200);
        responseDTO.setDescription("Ad Uploaded Successfully to - "+url);
        responseDTO.setMessage("Ap Uploaded to S3");
        return responseDTO;
    }

    @RequestMapping(method=RequestMethod.GET,value="/getThumbNails")
    public ThumbNailsResponseDTO getThumbNails(){
        return null;
    }

    @RequestMapping(method=RequestMethod.GET, value = "/getAdStreamingURL")
    public CDNObjectDTO getAdStreamingURL(@RequestBody int adId){
        return null;
    }

    @RequestMapping(method=RequestMethod.GET,value="/getQuestionnaire")
    public QuestionnaireResponceDTO getQuestionnaire(@RequestBody int adId){
        return null;
    }

    @RequestMapping(method=RequestMethod.GET,value="/getKeys")
    public KeysResponseDTO getKeys(@RequestBody int adId){
        return null;
    }

    @RequestMapping(method=RequestMethod.POST, value="/updateQuestionnaire")
    public ResponseDTO updateQuestionnaire(@RequestBody PostQuestionDTO postQuestionDTO){
        return null;
    }

    @ExceptionHandler({IOException.class, AdNotAvailalbeException.class})
    public ResponseDTO adManagerControllerExceptionHandler(){
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setResponseCode(300);
        responseDTO.setDescription("Exception occured while saving/retrieving Ad");
        responseDTO.setMessage("Please check your inputs and try again");
        return responseDTO;
    }
}
