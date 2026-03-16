package com.udemy.Profile.ApiResponse;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private String message;
    private boolean success;
    private T data;
    private LocalDateTime  timeStamp;

    public ApiResponse(String message, boolean success, T data) {
        this.message = message;
        this.success = success;
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
