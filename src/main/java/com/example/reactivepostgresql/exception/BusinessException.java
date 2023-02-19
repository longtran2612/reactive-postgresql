package com.example.reactivepostgresql.exception;

import com.example.reactivepostgresql.base.BaseException;

/**
 * 9:38 AM 15-Sep-22
 * Long Tran
 */

public class BusinessException extends BaseException {
    public BusinessException(String errorCode, Object... args) {
        super(errorCode, args);
    }

    public static BaseException build(String errorCode, String msgDetail) {
        BusinessException exp = new BusinessException(errorCode);
        exp.setMessage(msgDetail);
        return exp;
    }
}
