package com.example.batchMaster.model;

import com.example.batchMaster.model.request.StudentMarksRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "results")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {

    @Id
    private String resultId;
    private String batchId;
    private List<String> listOfTopperIds;
    private String date;
    private String subjectId;
    private String topic;
    private List<StudentMarksRequest> studentAndMarksList;
}
