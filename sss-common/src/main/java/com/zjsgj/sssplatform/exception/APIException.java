package com.zjsgj.sssplatform.exception;

import com.zjsgj.sssplatform.result.ResultCode;

/**
 * @author sheng
 * @date 2020/12/12
 * @description: 自定义异常
 */
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    public APIException() {
        this(ResultCode.FAILED);
    }

    public APIException(ResultCode failed) {
        this.code=failed.getCode();
        this.msg=failed.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
