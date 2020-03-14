package com.example.restDemo.appException.domain;

public class ErrorVO {
    String errorMessage;
    String errorCode;
    String fieldName;
    String fieldIdentifier;

    public ErrorVO() {
    }

    public ErrorVO(String errorMessage, String errorCode, String fieldName, String fieldIdentifier) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.fieldIdentifier = fieldIdentifier;
    }

    public String getFieldIdentifier() {
        return fieldIdentifier;
    }

    public void setFieldIdentifier(String fieldIdentifier) {
        this.fieldIdentifier = fieldIdentifier;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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
