package com.example.batchmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // Enables scheduling support
public class BatchMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchMasterApplication.class, args);
    }

}
