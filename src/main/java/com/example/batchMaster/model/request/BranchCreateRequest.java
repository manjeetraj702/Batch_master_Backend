package com.example.batchMaster.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BranchCreateRequest {
    private String branchName;
    private String startingDate;
    private boolean branchStatus=true;
    private List<String> batchIdList;


}
