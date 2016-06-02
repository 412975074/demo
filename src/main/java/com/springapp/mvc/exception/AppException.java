package com.springapp.mvc.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by wangjie on 16-1-6.
 */
public class AppException extends NestedRuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;


    public AppException(String message) {
        super(message);
    }

    public AppException(Integer code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }


}
