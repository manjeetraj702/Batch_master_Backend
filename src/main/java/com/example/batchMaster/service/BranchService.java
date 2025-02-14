package com.example.batchMaster.service;

import com.example.batchMaster.model.Branch;
import com.example.batchMaster.model.request.BranchCreateRequest;
import com.example.batchMaster.model.updateRequest.BranchUpdateRequest;

import java.util.List;

public interface BranchService {


    Branch createBranch(BranchCreateRequest branchCreateRequest);

    Branch updateBranch(BranchUpdateRequest branchUpdateRequest);

    Branch getBranchByName(String branchName);

    List<Branch> getAllBranch();

    Branch updateBranchStatus(String branchId);

    Branch getBranchById(String branchId);
}
