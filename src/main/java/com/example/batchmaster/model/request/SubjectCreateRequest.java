package com.example.batchmaster.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateRequest {

    private String subjectName;
    private String batchId;
    private boolean status;
    private Set<String> listOfTopics;
}
