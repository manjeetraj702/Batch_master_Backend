package com.example.batchMaster.model.request;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarksCreateRequest {

    private String batchId;
    private String studentId;
    private String subject;
    private String topic;
    private float totalMarks;
    private float marksObtained;
}
