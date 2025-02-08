package com.example.batchMaster.service;

import com.example.batchMaster.model.Address;
import com.example.batchMaster.model.Branch;

import java.util.List;

public interface BranchService {


    Branch createBranch(Branch branch);

    Branch updateBranch(String branchId, String branchName, String startingDate, Address address, List<String> batchIdList);

    Branch getBranchByName(String branchName);

    List<Branch> getAllBranch();

    String updateBranchStatus(String branchId);


}
