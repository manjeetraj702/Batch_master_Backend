package com.example.batchMaster.model.request;

import com.example.batchMaster.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreateRequest {

    private String studentName;
    private String fatherName;
    private String mobileNumber;
    private String email;
    private String dob;
    private String degree;
    private String course;
    private Address address;
    private String branchId;
    private String admissionDate;
    private boolean studyMode;

}
