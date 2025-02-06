package com.example.batchMaster.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateRequest {
    private String subjectName;
    private String BatchId;
    private List<String> topicList;
    private Boolean status;

}
