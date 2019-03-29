package com.bellacode.homebudget.ErrorResponse;

public class UserEmailExistException extends RuntimeException {
    public UserEmailExistException() {
    }

    public UserEmailExistException(String message) {
        super(message);
    }
/*
    public UserEmailExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmailExistException(Throwable cause) {
        super(cause);
    }

    public UserEmailExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }*/
}
