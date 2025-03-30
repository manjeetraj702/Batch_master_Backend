package com.example.batchmaster.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @Id
    private String studentId;
    private String studentName;
    private String fatherName;
    private String parentsPhoneNo;
    private String mobileNumber;
    private String imgUrl;
    private String email;
    private String dob;
    private String degree;
    private String course;
    private Address address;
    private String batchId = "Cage-00";
    private String branchId;
    private String admissionDate;
    private boolean activeStatus = true;
    private boolean studyMode;
}


