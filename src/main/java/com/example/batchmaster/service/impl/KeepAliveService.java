package com.example.batchmaster.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class KeepAliveService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${app.url}")
    private String appUrl;

    @Scheduled(fixedRate = 240000)
    public void pingApplication() {
        try {
            String url = appUrl + "/ping"; // Your backend's health-check endpoint
            restTemplate.getForObject(url, String.class);
            log.info("Pinged application successfully at: " + url);
        } catch (Exception e) {
            log.info("Failed to ping application: " + e.getMessage());
        }
    }
}
