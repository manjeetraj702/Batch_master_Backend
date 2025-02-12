package com.example.batchMaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "sessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    private String sessionId;
    private String subject;
    private String topic;
    private String mentor;
    private String sessionLink;
    private String date;
    private String batchId;
    private String branchId;
    private int onlineStudents;
    private int offlineStudents;
    private int absentStudents;
    @CreatedDate
    @Indexed // Index for faster queries
    private Instant createdAt;
}
