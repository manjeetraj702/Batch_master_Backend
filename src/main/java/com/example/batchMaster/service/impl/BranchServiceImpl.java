package com.example.batchMaster.service.impl;

import com.example.batchMaster.customException.BranchNotFoundException;
import com.example.batchMaster.model.Branch;
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
    public String createBranch(Branch branch) {

        // Check if a branch with the same name or ID already exists
        if (branchRepository.findByBranchName(branch.getBranchName()) != null) {
            return "Branch with the same name already exists";
        }

        if (branchRepository.findByBranchId(branch.getBranchId()).isPresent()) {
            return "Branch with the same ID already exists";
        }
       // Branch Create
        Branch newBranch=new Branch();
        newBranch.setBranchId(branch.getBranchId());
        newBranch.setBranchName(branch.getBranchName());
        newBranch.setStartingDate(branch.getBranchId());
        newBranch.setBatchIdList(branch.getBatchIdList());

        branchRepository.save(branch);
        return "Branch created successfully";
    }

    @Override
    public String updateBranch(String branchId, String branchName, String startingDate, List<String> batchIdList) {
        Optional<Branch> preBranch=branchRepository.findByBranchId(branchId);

        if(preBranch.isPresent()) {
            Branch newBranch=preBranch.get();
            newBranch.setBranchName(branchName);
            newBranch.setStartingDate(startingDate);
            newBranch.setBatchIdList(batchIdList);
            branchRepository.save(newBranch);
            return "Branch Updated Successfully";
        }
        else{
            return "Branch Not found.";
        }

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
    public String updateBranchStatus(String branchId) {

        // Check if the branch exists
        Optional<Branch> preBranch = branchRepository.findById(branchId);
        if (!preBranch.isPresent()) {
            return "Branch with ID " + branchId + " not found.";
        }

        // Update the branch status
        Branch newBranch = preBranch.get();
        newBranch.setBranchStatus(!newBranch.isBranchStatus());
        branchRepository.save(newBranch); // Save the updated branch back to the database

        return newBranch.getBranchName() + " Status Updated Successfully.";
    }



}
