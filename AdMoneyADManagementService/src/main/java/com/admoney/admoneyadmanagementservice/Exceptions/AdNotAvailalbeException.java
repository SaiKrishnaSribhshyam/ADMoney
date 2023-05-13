package com.admoney.admoneyadmanagementservice.Exceptions;

import org.hibernate.jdbc.Expectation;

public class AdNotAvailalbeException extends Exception {
    public AdNotAvailalbeException(String message){
        super(message);
    }
}
