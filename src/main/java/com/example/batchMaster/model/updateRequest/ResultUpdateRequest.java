package com.example.batchMaster.model.updateRequest;

import com.example.batchMaster.model.request.StudentMarksRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResultUpdateRequest {

    private String resultId;

    private String batchId;

//    private List<String> listOfTopperIds;

    private String date;

    private String subjectId;

    private String topic;

    private float totalMarks;
    private List<StudentMarksRequest> studentAndMarksList;
}
