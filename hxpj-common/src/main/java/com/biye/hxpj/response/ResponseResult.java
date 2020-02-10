package com.biye.hxpj.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @program: hxpj
 * @description: 出参模板
 * @author: LiLei
 * @create: 2019-03-25 13:58
 **/

@Getter
@Setter
public class ResponseResult implements Serializable {
    private boolean success = true;
    private Integer code=null;
    private String errMsg=null;
    private Object data=null;
    public ResponseResult(boolean success, Integer code, String errMsg, Object data){
        this.success = success;
        this.code = code;
        this.errMsg = errMsg;
        this.data = data;
    }

    public ResponseResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ResponseResult(boolean success, String errMsg, Object data) {
        this.success = success;
        this.errMsg = errMsg;
        this.data = data;
    }
    public ResponseResult(boolean success) {

        this.success = success;
    }

    public static ResponseResult build(boolean success, String errMsg, Object data) {
        return new ResponseResult(success, errMsg, data);
    }
    public static ResponseResult build(boolean success, Integer code, String errMsg, Object data) {
        return new ResponseResult(success, code, errMsg, data);
    }
    public static ResponseResult build(boolean success, Object data) {

        return new ResponseResult(success, null ,data);
    }
    public static ResponseResult build(boolean success) {

        return new ResponseResult(success);
    }
    public static ResponseResult build(boolean success,Integer code,Object data) {
        return new ResponseResult(success,code,null,data);
    }

    public static ResponseResult buildError(String errMsg) {
        return build(false, errMsg, null);
    }
    public static ResponseResult buildError(Integer code,String errMsg) {
        return build(false, code, errMsg, null);
    }

    public static ResponseResult buildSuccess(Object data) {
        return build(true,data);
    }

    public static ResponseResult buildSuccess(String errMsg,Object data) {

        return build(true,errMsg, data);
    }

    public static ResponseResult buildSuccess() {

        return build(true, null);
    }


}
