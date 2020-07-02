package com.ldd.exceptions;

import com.ldd.common.MyErrorCode;

/**
 * @author xiaoxiya
 * @date 2020/7/2 19:53
 * @describe 自定义异常
 */
public class ApiException extends RuntimeException {
    private MyErrorCode errorCode;

    public ApiException(MyErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyErrorCode getErrorCode() {
        return errorCode;
    }

}
