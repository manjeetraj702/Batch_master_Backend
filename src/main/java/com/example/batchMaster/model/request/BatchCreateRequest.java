package com.example.batchMaster.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BatchCreateRequest {

    private String branchId;
    private String batchName;
    private String batchTime;
    private boolean status = true;
}
