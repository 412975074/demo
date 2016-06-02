package com.springapp.mvc.exception;

/**
 * Created by wangjie on 16-1-6.
 */
public class ResultResponse {

    private String message;
    private Integer code;

    public ResultResponse() {};

    /**
     * Construction Method
     * @param code
     * @param message
     */
    public ResultResponse(Integer code, String message){
        this.message = message;
        this.code = code;
    }

    public static ResultResponse create(Integer code, String message){
        return new ResultResponse(code, message);
    }

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
