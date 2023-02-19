package com.example.reactivepostgresql.base;

import com.example.reactivepostgresql.utils.MessageSourceUtils;
import lombok.Getter;
import lombok.Setter;


/**
 * 9:38 AM 15-Sep-22
 * Long Tran
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    protected String errorCode;

    protected String message;

    public BaseException() {
    }

    protected BaseException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.message = MessageSourceUtils.getMessage(errorCode, args);
    }
}
