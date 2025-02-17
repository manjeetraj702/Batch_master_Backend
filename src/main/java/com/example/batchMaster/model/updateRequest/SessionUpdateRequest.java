package com.example.batchMaster.model.updateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String type;
    private List<String> onlineStudentsIds;
    private List<String> offlineStudentsIds;
    private List<String> absentStudentsIds;
    private int week;
}
