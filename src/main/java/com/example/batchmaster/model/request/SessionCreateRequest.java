package com.example.batchmaster.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SessionCreateRequest {


    private String subject;
    private String topic;
    private String mentor;
    private String sessionLink;
    private String batchId;
    private String branchId;
    private String day;
    private String type;
    private Set<String> onlineStudentsIds;
    private Set<String> offlineStudentsIds;
    private Set<String> absentStudentsIds;
    private int week;


}
