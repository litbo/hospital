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
    public static <T> Result<T> success(){
        return new Result<T>();
    }
    public static <T> Result<T> success(int code , String msg ){
        return new Result<T>(code,msg);
    }


    //失败的时候调用此方法
    public static<T>  Result<T> error(CodeMsg cm){
        return new Result<>(cm);
    }
    public static<T>  Result<T> error(String msg) {
        return new Result<>(msg);
    }
    public static<T>  Result<T> error() {
        return error("error");
    }
    public static<T>  Result<T> error(int code) {
        return new Result<>(code);
    }
    public static<T>  Result<T> error(int code,String msg) {
        return new Result<>(code,msg);
    }


    private Result(CodeMsg cm){
        if(cm==null){
            return;
        }
        this.msg = cm.getMsg();
        this.code = cm.getCode();
    }
    private Result(int code,String msg ){
        this.msg = msg;
        this.code = code;
    }
    private Result(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    private Result(){
        this.code=0;
        this.msg="success";
    }

    private Result(String msg){
        this.code=1;
        this.msg=msg;
    }
    private Result(int code){
        this.code=code;
        this.msg="error";
    }

}
