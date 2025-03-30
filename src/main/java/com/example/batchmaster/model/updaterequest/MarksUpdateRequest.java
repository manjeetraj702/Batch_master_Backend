package com.example.batchmaster.model.updaterequest;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarksUpdateRequest {
    private String id;
    private String batchId;
    private String studentId;
    private String subject;
    private String resultId;
    private String topic;
    private float totalMarks;
    private float marksObtained;
}
