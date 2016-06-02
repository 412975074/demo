package com.springapp.mvc.handler;

import com.springapp.mvc.exception.AppException;
import com.springapp.mvc.exception.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wangjie on 16-1-6.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultResponse handleException(AppException exception) {

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(exception.getCode());
        resultResponse.setMessage(exception.getMessage());

        return resultResponse;
    }



}
