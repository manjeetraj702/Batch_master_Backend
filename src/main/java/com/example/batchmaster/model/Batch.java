package com.example.batchmaster.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

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
    private Instant startingDate;
    private Instant batchTime;
    private boolean status = true;
}
