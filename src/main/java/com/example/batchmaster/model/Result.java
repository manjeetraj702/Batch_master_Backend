package com.example.batchmaster.model;

import com.example.batchmaster.model.request.StudentMarksRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "results")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {

    @Id
    private String resultId;

    @Indexed
    private String batchId;

    @Indexed
    private Date date;

    @Indexed
    private String subject;

    @Indexed
    private String topic;

    private List<String> listOfTopperName;
    private float totalMarks;
    private List<StudentMarksRequest> studentAndMarksList;
}
