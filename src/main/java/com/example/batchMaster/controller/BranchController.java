package com.example.batchMaster.controller;

import com.example.batchMaster.model.Branch;
import com.example.batchMaster.model.updateRequest.BranchUpdateRequest;
import com.example.batchMaster.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
@CrossOrigin("*")

public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/createBranch")
    public Branch createBranch(@RequestBody Branch branch) {
        return branchService.createBranch(branch);
    }

    @PutMapping("/updateBranchById")
    public Branch updateBranch(@RequestBody BranchUpdateRequest branchUpdateRequest) {
return branchService.updateBranch(branchUpdateRequest);
    }

    @GetMapping("/GetBranchByName")
    public Branch getBranchByName(@RequestParam String branchName) {
        return branchService.getBranchByName(branchName);
    }

    @GetMapping("/getAllBranch")
    public List<Branch> getAllBranch() {
        return branchService.getAllBranch();
    }

    @PutMapping("/updateBranchStatus")
    public Branch updateBranchStatus(@RequestParam String branchId) {
        return branchService.updateBranchStatus(branchId);
    }
}
