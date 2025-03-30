package com.example.batchmaster.model.updaterequest;

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
public class AttendanceUpdateRequest {
    private String attendanceId;
    private String batchId;
    private String studentId;
    private String sessionId;
    private String subject;
    private String mode;
    private boolean status;
}
