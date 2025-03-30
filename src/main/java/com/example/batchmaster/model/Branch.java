package com.example.batchmaster.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "branch")
public class Branch {

    @Id
    private String branchId;
    private String branchName;
    private Date startingDate;
    private Address address;
    private boolean branchStatus = true;

}
