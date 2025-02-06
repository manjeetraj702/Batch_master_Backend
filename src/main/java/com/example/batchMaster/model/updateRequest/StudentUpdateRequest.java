package com.example.batchMaster.model.updateRequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateRequest {

    @NotBlank(message = "id name is required")
    private String Id;

    @NotBlank(message = "Student name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;


    @NotBlank(message = "dob is required")
    private String dob;

    @NotBlank(message = "Course is required")
    private String course;
}
