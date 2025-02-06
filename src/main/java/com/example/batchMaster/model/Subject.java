package com.example.first.model;


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
public class Subject {
    @Id
    private String subjectId;
    private String subjectName;
    private String BatchId;
    private List<String> topicList;
    private boolean status;
}
