package com.litbo.hospital.result;

import lombok.Data;

@Data
public class Result<T> {
    private String msg;
    private int code;
    private T data;
    //成功的时候调用此方法
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    //失败的时候调用此方法
    public static<T>  Result<T> error(CodeMsg cm){
        return new Result<>(cm);
    }
    private Result(CodeMsg cm){
        if(cm==null){
            return;
        }
        this.msg = cm.getMsg();
        this.code = cm.getCode();
    }
    private Result(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

}
