package com.example.batchMaster.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SessionCreateRequest {
    

    private String subject;
    private String topic;
    private String mentor;
    private String sessionLink;
    private String date;
    private String batchId;
}
