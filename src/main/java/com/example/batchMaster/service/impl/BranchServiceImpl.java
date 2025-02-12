package com.example.batchMaster.service.impl;

import com.example.batchMaster.exception.BatchMasterException;
import com.example.batchMaster.exception.BranchNotFoundException;
import com.example.batchMaster.model.Branch;
import com.example.batchMaster.model.updateRequest.BranchUpdateRequest;
import com.example.batchMaster.repository.BranchRepository;
import com.example.batchMaster.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository branchRepository;

    @Override
    public Branch createBranch(Branch branch) {

        // Check if a branch with the same name or ID already exists
        if (branchRepository.findByBranchName(branch.getBranchName()).equals(branch.getBranchName())) {
        throw new BatchMasterException("Branch with name '" + branch.getBranchName() + "' already exists");
        }

//
        Branch newBranch=new Branch();
        newBranch.setBranchId(branch.getBranchId());
        newBranch.setBranchName(branch.getBranchName());
        newBranch.setStartingDate(branch.getBranchId());


       return branchRepository.save(branch);

    }

    @Override
    public Branch updateBranch(BranchUpdateRequest branchUpdateRequest) {
        Optional<Branch> preBranch=branchRepository.findByBranchId(branchUpdateRequest.getBranchId());
if (preBranch.isPresent())
{
    Branch branch=preBranch.get();
    branch.setBranchName(branchUpdateRequest.getBranchName());
    branch.setStartingDate(branchUpdateRequest.getStartingDate());
    branch.setAddress(branchUpdateRequest.getAddress());
    return branchRepository.save(branch);
}
throw new BatchMasterException("Branch with ID '" + branchUpdateRequest.getBranchId() + "' not found");
    }

    @Override
    public Branch getBranchByName(String branchName) {
        return branchRepository.findByBranchName(branchName).orElseThrow(() -> new BranchNotFoundException("Branch with name '" + branchName + "' not found"));
    }

    @Override
    public List<Branch> getAllBranch(){
        return branchRepository.findAll();
    }

    @Override
    public Branch updateBranchStatus(String branchId) {

        // Check if the branch exists
        Optional<Branch> preBranch = branchRepository.findById(branchId);
        if (!preBranch.isPresent()) {
            throw new BranchNotFoundException("Branch with ID '" + branchId + "' not found");
        }

        // Update the branch status
        Branch newBranch = preBranch.get();
        newBranch.setBranchStatus(!newBranch.isBranchStatus());
        branchRepository.save(newBranch); // Save the updated branch back to the database

        return newBranch;
    }



}
