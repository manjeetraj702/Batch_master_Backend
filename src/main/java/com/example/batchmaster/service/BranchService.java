package com.example.batchmaster.service;

import com.example.batchmaster.model.Branch;
import com.example.batchmaster.model.request.BranchCreateRequest;
import com.example.batchmaster.model.updaterequest.BranchUpdateRequest;

import java.util.List;

public interface BranchService {


    Branch createBranch(BranchCreateRequest branchCreateRequest);

    Branch updateBranch(BranchUpdateRequest branchUpdateRequest);

    Branch getBranchByName(String branchName);

    List<Branch> getAllBranch();

    Branch updateBranchStatus(String branchId);

    Branch getBranchById(String branchId);
}
