package com.bellacode.homebudget.ErrorResponse;

import java.time.LocalDateTime;

public class RestExceptionResponse {
    public LocalDateTime dateTime;
    public int httpStatus;
    public String message;

    public RestExceptionResponse(LocalDateTime dateTime, int httpStatus, String message) {
        this.dateTime = dateTime;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
