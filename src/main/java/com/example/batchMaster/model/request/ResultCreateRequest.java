package com.example.batchMaster.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResultCreateRequest {

    private String batchId;

    private String date;

    private String subject;

    private String topic;

    private float totalMarks;

    private List<StudentMarksRequest> studentAndMarksList;
}
