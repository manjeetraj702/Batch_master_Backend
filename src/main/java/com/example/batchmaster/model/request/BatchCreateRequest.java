package com.example.batchmaster.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BatchCreateRequest {

    private String branchId;
    private String batchName;
    private Instant batchTime;
    private boolean status = true;
}
