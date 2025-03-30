package com.example.batchmaster.model.request;

import com.example.batchmaster.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BranchCreateRequest {
    private String branchName;
    private Address address;
    private boolean branchStatus = true;


}
