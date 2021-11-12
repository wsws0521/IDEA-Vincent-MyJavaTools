package cn.vincent.husky.controller;

import cn.vincent.husky.constant.ResultCode;

public class BaseResult<T> {
    private String code;

    private String msg;

    private T data;

    public BaseResult() {}

    public BaseResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String toString() {
        return "BaseResult{code='" + this.code + '\'' + ", msg='" + this.msg + '\'' + ", data=" + this.data + '}';
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static cn.vincent.husky.controller.BaseResult getFailResult(ResultCode resultCode) {
        return new cn.vincent.husky.controller.BaseResult(resultCode.getCode(), resultCode.getDesc(), null);
    }

    public static <T> cn.vincent.husky.controller.BaseResult<T> getSuccessResult(T data) {
        return new cn.vincent.husky.controller.BaseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), data);
    }
}

