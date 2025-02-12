package com.example.batchMaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    private List<String> onlineStudents;
    private List<String> offlineStudents;
    private List<String> presentStudentsId;
    private List<String> absentStudentsId;

}
