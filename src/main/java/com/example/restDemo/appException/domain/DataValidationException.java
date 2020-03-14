package com.example.restDemo.appException.domain;

import org.springframework.stereotype.Component;

@Component
public class DataValidationException extends RuntimeException{
    String errorMsg;
    String errorCode;
    String fieldName;

    public DataValidationException(Exception e) {
        this.errorMsg = e.getMessage();
    }

    public DataValidationException() {
    }

    public DataValidationException(String errorMsg, String errorCode, String fieldName){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.fieldName = fieldName;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
