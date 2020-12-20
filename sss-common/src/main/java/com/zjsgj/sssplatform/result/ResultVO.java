package com.zjsgj.sssplatform.result;

public class ResultVO<T>  {
    private Integer code;
    private String msg;
    private T data;
    private Integer pageNo;
    private Integer totalCount;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
        this.pageNo=1;
        this.totalCount=20;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
}
