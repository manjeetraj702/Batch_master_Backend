package com.example.batchMaster.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchSubject {
    @Id
    private String subjectId;
    private String subjectName;
    private String batchId;
    private boolean status;
    private List<String> listOfTopics;
}
