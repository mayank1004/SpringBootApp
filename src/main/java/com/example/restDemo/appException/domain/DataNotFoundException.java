package com.example.restDemo.appException.domain;

public class DataNotFoundException extends RuntimeException {
    static String msg = "Record not found";
    String fielName;
    String fieldIdentifier;

    public DataNotFoundException(String fielName, String fieldIdentifier) {
        this.fielName = fielName;
        this.fieldIdentifier = fieldIdentifier;
    }


    public String getFielName() {
        return fielName;
    }

    public void setFielName(String fielName) {
        this.fielName = fielName;
    }

    public String getFieldIdentifier() {
        return fieldIdentifier;
    }

    public void setFieldIdentifier(String fieldIdentifier) {
        this.fieldIdentifier = fieldIdentifier;
    }

    public DataNotFoundException() {
    }

}
