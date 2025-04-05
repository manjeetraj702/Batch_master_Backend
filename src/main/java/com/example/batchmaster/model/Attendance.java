package com.example.batchmaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "attendances")
@CompoundIndex(name = "batch_date_index", def = "{'batchId': 1, 'date': 1}")
@CompoundIndex(name = "student_date_index", def = "{'studentId': 1, 'date': 1}")
@CompoundIndex(name = "session_subject_index", def = "{'sessionId': 1, 'subject': 1}")
@CompoundIndex(name = "branch_batch_student_index", def = "{'branchId': 1, 'batchId': 1, 'studentId': 1}")
@CompoundIndex(name = "branch_batch_student_index", def = "{'branchId': 1, 'batchId': 1, 'studentId': 1}")
@CompoundIndex(name = "branch_date_index", def = "{'branchId': 1, 'date': 1}")
public class Attendance {
    @Id
    private String attendanceId;

    @Indexed
    private String branchId;

    @Indexed
    private String batchId;

    @Indexed
    private String studentId;

    @Indexed
    private String sessionId;


    @Indexed
    private Instant date;

    private String subject;
    private String mode;
    private boolean status;
}
