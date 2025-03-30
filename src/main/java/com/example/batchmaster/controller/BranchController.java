package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.Branch;
import com.example.batchmaster.model.request.BranchCreateRequest;
import com.example.batchmaster.model.updaterequest.BranchUpdateRequest;
import com.example.batchmaster.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branch")
@CrossOrigin("*")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    // Create a new branch
    @PostMapping("/create")
    public ApiResponse<Branch> createBranch(@RequestBody BranchCreateRequest branchCreateRequest) {
        Branch branch = branchService.createBranch(branchCreateRequest);
        return new ApiResponse<>(branch, HttpStatus.CREATED);
    }


    // Update an existing branch
    @PutMapping("/update")
    public ApiResponse<Branch> updateBranch(@RequestBody BranchUpdateRequest branchUpdateRequest) {
        Branch branch = branchService.updateBranch(branchUpdateRequest);
        return new ApiResponse<>(branch, HttpStatus.OK);
    }

    // Get branch by name
    @GetMapping("/getBranchByName")
    public ApiResponse<Branch> getBranchByName(@RequestParam(name = "branchName") String branchName) {
        Branch branch = branchService.getBranchByName(branchName);
        return new ApiResponse<>(branch, HttpStatus.OK);
    }

    // Get all branches
    @GetMapping("/getAllBranches")
    public ApiResponse<List<Branch>> getAllBranches() {
        List<Branch> branches = branchService.getAllBranch();
        return new ApiResponse<>(branches, HttpStatus.OK);
    }

    // Update branch status (active/inactive)
    @PatchMapping("/updateBranchStatus")
    public ApiResponse<Branch> updateBranchStatus(@RequestParam(name = "branchId") String branchId) {
        Branch branch = branchService.updateBranchStatus(branchId);
        return new ApiResponse<>(branch, HttpStatus.OK);
    }

    // Get Branch By BranchId
    @GetMapping("/getBranchById")
    public ApiResponse<Branch> getBranchById(@RequestParam(name = "branchId") String branchId) {
        Branch branch = branchService.getBranchById(branchId);
        return new ApiResponse<>(branch, HttpStatus.OK);
    }


}
