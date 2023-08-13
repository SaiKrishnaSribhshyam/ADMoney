package com.admoney.admoneyadmanagementservice.Controllers;

import com.admoney.admoneyadmanagementservice.DTOS.ResponseDTO;
import com.admoney.admoneyadmanagementservice.Exceptions.AdNotAvailalbeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity handleAuthExceptions(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Missing Auth cookie");

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
