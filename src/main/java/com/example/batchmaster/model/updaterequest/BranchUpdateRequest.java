package com.example.batchmaster.model.updaterequest;

import com.example.batchmaster.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BranchUpdateRequest {


    private String branchId;
    private String branchName;
    private Address address;

}
