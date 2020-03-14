package com.example.restDemo.appException.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommonException extends Exception {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CommonException(String msg) {
        this.msg = msg;
    }

    public CommonException() {
    }
}
