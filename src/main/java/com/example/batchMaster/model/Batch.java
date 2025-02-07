package com.example.batchMaster.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "batch")
public class Batch {

    @Id
    private String batchId;
    private String branchId;
    private String batchName;
    private String startingDate;
    private String batchTime;
    private List<String> studentList;
    private List<String> subjectList;
    private String currentSubject;
    private List<String> completedSubjectList;
    private List<String> onlineStudentList;
    private List<String> offlineStudentList;
    private  boolean status=true;
}
