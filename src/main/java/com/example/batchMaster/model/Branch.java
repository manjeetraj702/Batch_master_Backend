package com.example.batchMaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
