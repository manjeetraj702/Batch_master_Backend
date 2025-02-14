package com.example.batchMaster.controller;

import com.example.batchMaster.base.ApiResponse;
import com.example.batchMaster.exception.BatchMasterException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin("*")
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> generalExceptionHandler(Exception e) {
        // Log the exception for debugging purposes
        System.err.println("Unhandled exception occurred: " + e.getMessage());
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);

        response.setErrorMessage(e.getMessage());

        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Object> applicationExceptionHandler(BatchMasterException e) {
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.OK);
        response.setErrorMessage(e.getMessage());
        return response;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse<Object> badRequestExceptionHandler(IllegalArgumentException e) {
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.BAD_REQUEST);
        response.setErrorMessage(e.getMessage());
        return response;
    }
}

