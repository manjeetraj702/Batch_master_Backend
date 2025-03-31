package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.exception.BranchNotFoundException;
import com.example.batchmaster.model.Branch;
import com.example.batchmaster.model.request.BranchCreateRequest;
import com.example.batchmaster.model.updaterequest.BranchUpdateRequest;
import com.example.batchmaster.repository.BranchRepository;
import com.example.batchmaster.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

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
        newBranch.setStartingDate(new Date());
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
        branch.setStartingDate(new Date());
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
