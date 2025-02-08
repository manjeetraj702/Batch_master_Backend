package com.example.batchMaster.service.impl;
import com.example.batchMaster.exception.BranchNotFoundException;
import com.example.batchMaster.model.Address;
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
    public Branch createBranch(Branch branch) {

        // Check if a branch with the same name or ID already exists
        if (branchRepository.findByBranchName(branch.getBranchName()) != null) {
            throw new BranchNotFoundException("Branch with ID " + branch.getBranchName() + " not found.");
        }

        if (branchRepository.findByBranchId(branch.getBranchId()).isPresent()) {
            throw new BranchNotFoundException("Branch with ID " + branch.getBranchId() + " not found.");
        }
       // Branch Create
        Branch newBranch=new Branch();
        newBranch.setBranchId(branch.getBranchId());
        newBranch.setBranchName(branch.getBranchName());
        newBranch.setStartingDate(branch.getBranchId());
        newBranch.setBatchIdList(branch.getBatchIdList());
        // Set Address
        Address address = new Address(
                branch.getAddress().getStreet(),
                branch.getAddress().getCity(),
                branch.getAddress().getDistrict(),
                branch.getAddress().getState(),
                branch.getAddress().getPostalCode()
        );
        newBranch.setAddress(address);
        return  branchRepository.save(newBranch);

    }

    @Override
    public Branch updateBranch(String branchId, String branchName, String startingDate, Address address, List<String> batchIdList) {
        Optional<Branch> preBranch=branchRepository.findByBranchId(branchId);

        if (preBranch.isPresent()) {
            Branch existingBranch = preBranch.get();

            // Update the branch details
            existingBranch.setBranchName(branchName);
            existingBranch.setStartingDate(startingDate);
            existingBranch.setBatchIdList(batchIdList);

            // Update the address if provided
            if (address != null) {
                Address updatedAddress = new Address(
                        address.getStreet(),
                        address.getCity(),
                        address.getDistrict(),
                        address.getState(),
                        address.getPostalCode()
                );
                existingBranch.setAddress(updatedAddress);
            }

            // Save the updated branch
            branchRepository.save(existingBranch);
            return existingBranch; // Return the updated branch
        } else {
            throw new BranchNotFoundException("Branch with ID " + branchId + " not found.");
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
