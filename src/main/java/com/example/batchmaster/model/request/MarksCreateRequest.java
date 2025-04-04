package com.example.batchmaster.model.request;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private String resultId;
    private String topic;
    private float totalMarks;
    private float marksObtained;
    private Date date;
}
