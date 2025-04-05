package com.example.batchmaster.model.updaterequest;

import com.example.batchmaster.model.request.StudentMarksRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResultUpdateRequest {

    private String resultId;

    private String batchId;


    private Instant date;

    private String subject;

    private String topic;

    private float totalMarks;
    private List<StudentMarksRequest> studentAndMarksList;
}
