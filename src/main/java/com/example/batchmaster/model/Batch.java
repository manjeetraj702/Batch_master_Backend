package com.example.batchmaster.model;


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
@Document(collection = "batch")
public class Batch {

    @Id
    private String batchId;
    private String branchId;
    private String batchName;
    private Date startingDate;
    private String batchTime;
    private boolean status = true;
}
