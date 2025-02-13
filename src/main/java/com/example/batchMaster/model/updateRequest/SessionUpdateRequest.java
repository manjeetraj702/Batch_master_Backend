package com.example.batchMaster.model.updateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionUpdateRequest {
    

    private String sessionId;
    private String subject;
    private String topic;
    private String mentor;
    private String sessionLink;
    private String date;
    private String batchId;
    private String branchId;
    private String day;
    private int onlineStudents;
    private int offlineStudents;
    private int absentStudents;
    private int week;
}
