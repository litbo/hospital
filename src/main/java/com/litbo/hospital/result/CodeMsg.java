package com.litbo.hospital.result;

import lombok.Data;

@Data
public class CodeMsg {
    private int code;
    private String msg;
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");//数据返回成功
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务器端异常");
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
