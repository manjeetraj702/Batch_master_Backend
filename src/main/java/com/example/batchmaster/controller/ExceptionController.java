package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.exception.BatchMasterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
// Log the exception for debugging purposes
        Logger logger = LoggerFactory.getLogger(ExceptionController.class);
        logger.error("Unhandled exception occurred: " + e.getMessage(), e);
        e.printStackTrace();
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

