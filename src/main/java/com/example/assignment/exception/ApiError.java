package com.example.assignment.exception;


import org.springframework.http.HttpStatus;


public class ApiError extends RuntimeException {
    private final HttpStatus status;
    private final String message;


    public ApiError(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }


    public HttpStatus getStatus() { return status; }


    @Override
    public String getMessage() { return message; }
}
