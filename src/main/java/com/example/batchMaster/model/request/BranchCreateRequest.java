package com.example.batchMaster.model.request;

import com.example.batchMaster.model.Address;
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
    private Address address;
    private boolean branchStatus=true;
    private List<String> batchIdList;


}
