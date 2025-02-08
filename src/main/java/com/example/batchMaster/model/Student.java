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
    private String email;
    private String dob;
    private String degree;
    private String course;
    private Address address;
    private String batchId = "Cage-00";
    private String branchId;
    private String admissionDate;
    private List<Marks> marksList;
    private List<Attendance> attendanceList;
    private boolean status;
    private boolean mode;
}


