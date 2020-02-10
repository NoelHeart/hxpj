package com.biye.hxpj.exception;

/**
 * @program: hxpj
 * @description:
 * @author: LiLei
 **/

public class BasicException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String errMsg;

    private String code;

    public BasicException(String errMsg) {

        super(errMsg);

        setErrMsg(errMsg);
    }

    public BasicException(String errMsg, Throwable cause) {

        super(errMsg, cause);

        setErrMsg(errMsg);
    }

    public BasicException(String code, String errMsg) {

        super(errMsg);

        setErrMsg(errMsg);
        setCode(code);
    }

    public BasicException(String code, String errMsg, Throwable cause) {

        super(errMsg, cause);

        setErrMsg(errMsg);
        setCode(code);
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}