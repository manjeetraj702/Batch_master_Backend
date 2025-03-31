package com.example.batchmaster.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
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


