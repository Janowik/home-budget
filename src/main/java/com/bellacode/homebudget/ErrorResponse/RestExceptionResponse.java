package com.bellacode.homebudget.ErrorResponse;

import java.time.LocalDateTime;

class RestExceptionResponse {
    private LocalDateTime dateTime;
    private int httpStatus;
    private String message;

    RestExceptionResponse(LocalDateTime dateTime, int httpStatus, String message) {
        this.dateTime = dateTime;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
