package com.example.restDemo.appException.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DataValidationException.class)
    public ResponseEntity<ErrorVO> handleDVE(DataValidationException dve){
        return new ResponseEntity<>(new ErrorVO(dve.errorMsg, "400",null,null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<CommonException> handleDVE(String msg){
        return new ResponseEntity<>(new CommonException(msg), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorVO> handleDNF(DataNotFoundException dnf){
        return new ResponseEntity<>(new ErrorVO(DataNotFoundException.msg,"404",dnf.getFielName(), dnf.getFieldIdentifier()), HttpStatus.NOT_FOUND);
    }


}
