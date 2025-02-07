package com.example.batchMaster.customException;

public class BatchNotFoundException extends RuntimeException {
    public BatchNotFoundException(String message) {
        super(message);
    }
}
