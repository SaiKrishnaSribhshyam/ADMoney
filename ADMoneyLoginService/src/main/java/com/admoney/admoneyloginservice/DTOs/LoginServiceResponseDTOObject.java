package com.admoney.admoneyloginservice.DTOs;

public class LoginServiceResponseDTOObject {
    private String status;
    private String message;
    private int statusCode;

    public LoginServiceResponseDTOObject() {
    }

    public LoginServiceResponseDTOObject(String status, int statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public LoginServiceResponseDTOObject(String status, String message, int statusCode) {
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
