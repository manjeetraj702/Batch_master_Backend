package com.example.batchMaster.service.impl;

import com.example.batchMaster.customException.BranchNotFoundException;
import com.example.batchMaster.exception.BatchMasterException;
import com.example.batchMaster.model.Branch;
import com.example.batchMaster.model.request.BranchCreateRequest;
import com.example.batchMaster.model.updateRequest.BranchUpdateRequest;
import com.example.batchMaster.repository.BranchRepository;
import com.example.batchMaster.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository branchRepository;

    @Override
    public Branch createBranch(BranchCreateRequest branchCreateRequest) {
        if (branchCreateRequest == null) {
            throw new IllegalArgumentException("BranchCreateRequest cannot be null");
        }

        if (branchRepository.findByBranchName(branchCreateRequest.getBranchName()).isPresent()) {
            throw new BatchMasterException("Branch with name '" + branchCreateRequest.getBranchName() + "' already exists");
        }

        Branch newBranch = new Branch();
        newBranch.setBranchName(branchCreateRequest.getBranchName());
        newBranch.setAddress(branchCreateRequest.getAddress());
        newBranch.setStartingDate(branchCreateRequest.getStartingDate());
        newBranch.setBranchStatus(branchCreateRequest.isBranchStatus());

        return branchRepository.save(newBranch);
    }

    @Override
    public Branch updateBranch(BranchUpdateRequest branchUpdateRequest) {
        if (branchUpdateRequest == null) {
            throw new IllegalArgumentException("BranchUpdateRequest cannot be null");
        }

        Branch branch = branchRepository.findByBranchId(branchUpdateRequest.getBranchId())
                .orElseThrow(() -> new BatchMasterException("Branch with ID '" + branchUpdateRequest.getBranchId() + "' not found"));

        branch.setBranchName(branchUpdateRequest.getBranchName());
        branch.setStartingDate(branchUpdateRequest.getStartingDate());
        branch.setAddress(branchUpdateRequest.getAddress());

        return branchRepository.save(branch);
    }

    @Override
    public Branch getBranchByName(String branchName) {
        return branchRepository.findByBranchName(branchName).orElseThrow(() -> new BranchNotFoundException("Branch with name '" + branchName + "' not found"));
    }

    @Override
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    public Branch updateBranchStatus(String branchId) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new BranchNotFoundException("Branch with ID '" + branchId + "' not found"));

        branch.setBranchStatus(!branch.isBranchStatus());

        return branchRepository.save(branch);
    }

    @Override
    public Branch getBranchById(String branchId) {
        return branchRepository.findById(branchId).orElseThrow(() -> new BranchNotFoundException("Branch with ID '" + branchId + "' not found"));
    }


}
