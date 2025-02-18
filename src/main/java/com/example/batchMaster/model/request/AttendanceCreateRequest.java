package com.example.batchMaster.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class AttendanceCreateRequest {
    private String batchId;
    private String date;
    private String studentId;
    private String sessionId;
    private String subject;
    private String mode;
    private boolean status;
}
