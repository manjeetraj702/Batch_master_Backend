package com.example.batchMaster.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreateRequest {

    @NotBlank(message = "Student name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Age is required")
    private Integer age;

    @NotBlank(message = "Course is required")
    private String course;
}
