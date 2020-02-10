package com.biye.hxpj.exception;

/**
 * @program: hxpj
 * @description:
 * @author: LiLei
 **/

public class BusinessException extends BasicException{
    private static final long serialVersionUID = 1L;

    public BusinessException(String errMsg) {

        super(errMsg);
    }

    public BusinessException(String errMsg, Throwable cause) {

        super(errMsg, cause);
    }

    public BusinessException(String code, String errMsg) {

        super(code, errMsg);
    }

    public BusinessException(String code, String errMsg, Throwable cause) {

        super(code, errMsg, cause);
    }
}
