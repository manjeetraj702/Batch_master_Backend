package com.example.batchMaster.model.updateRequest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter

public class BatchSubjectUpdateRequest {

    @Id
    private String subjectId;
    private String subjectName;
    private String batchId;
    private boolean status;
    private List<String> listOfTopics;

}
