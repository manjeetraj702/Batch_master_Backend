package com.example.batchmaster.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BatchAttendanceRequest {
    private List<String> absentStudentIds;
    private List<String> presentStudentIds;
    private String batchId;
}
