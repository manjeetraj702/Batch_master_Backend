package com.example.batchmaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "marks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@CompoundIndex(name = "batchId_subject_topic_idx", def = "{'batchId': 1, 'subject': 1, 'topic': 1}")
public class Marks {

    @Id
    private String marksId;

    @Indexed
    private String batchId;

    @Indexed
    private String studentId;

    @Indexed
    private String resultId;

    @Indexed
    private String subject;

    @Indexed
    private String topic;

    private double totalMarks;
    private double marksObtained;

    @Indexed
    private Date date;  // Keeping Date type as requested
}
