package com.example.batchmaster.model.updaterequest;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BatchUpdateBranch {

    private String batchId;
    private String branchId;
    private String batchName;
    private Instant batchTime;
    private boolean status = true;
}
