package com.example.batchMaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marks {

    @Id
    private String marksId;
    private String batchId;
    private String studentId;
    private String resultId;
    private String subject;
    private String topic;
    private float totalMarks;
    private float marksObtained;
}
