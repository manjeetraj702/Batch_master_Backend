package com.example.batchMaster.model.updateRequest;

import com.example.batchMaster.model.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateRequest {

    @NotBlank(message = "id name is required")
    private String Id;

    private String studentName;
    private String fatherName;
    private String mobileNumber;
    private String parentsPhoneNo;
    private String email;
    private String dob;
    private String imgUrl;
    private String degree;
    private String course;
    private Address address;
    private String branchId;
    private String batchId;
    private String admissionDate;
}
