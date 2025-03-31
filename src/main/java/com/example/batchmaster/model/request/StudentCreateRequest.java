package com.example.batchmaster.model.request;

import com.example.batchmaster.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreateRequest {

    private String studentName;
    private String fatherName;
    private String parentsPhoneNo;
    private String mobileNumber;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    private String dob;
    private String imgUrl;
    private String degree;
    private String course;
    private Address address;
    private String batchId;
    private String branchId;
    private String admissionDate;
    private boolean studyMode;

}
