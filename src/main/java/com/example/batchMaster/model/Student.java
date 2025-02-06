package com.example.batchMaster.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "students")
public class Student {

    @Id
    private String studentId;
    private String studentName;
    private String fatherName;
    private String mobileNumber;
    private String address;
    private String degree;
    private String course;
    private String batchId;
    private String branchId;
    private String startingDate;
    private List<Marks> resultList;
    private List<Attendance> attendanceList;
    private boolean status;
}

class Marks {
    private String subject;
    private int score;
}

class Attendance {
    private String date;
    private boolean present;
}
