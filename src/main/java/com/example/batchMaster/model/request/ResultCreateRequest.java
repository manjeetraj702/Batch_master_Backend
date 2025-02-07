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

    private String subjectId;

    private String topic;

    private List<StudentMarksRequest> studentAndMarksList;
}
