package com.example.batchMaster.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentMarksRequest {
    private String studentId;
    private float studentMarks;
    private String studentName;
    private boolean isPresent;
}
