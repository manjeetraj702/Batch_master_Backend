package com.example.batchMaster.service;

import com.example.batchMaster.model.Branch;

import java.util.List;

public interface BranchService {


    String createBranch(Branch branch);

    String updateBranch(String branchId,String branchName, String startingDate, List<String> batchIdList);

    Branch getBranchByName(String branchName);

    List<Branch> getAllBranch();

    String updateBranchStatus(String branchId);


}
