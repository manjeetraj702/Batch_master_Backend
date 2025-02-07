package com.example.batchMaster.controller;

import com.example.batchMaster.model.Branch;
import com.example.batchMaster.service.BranchService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping("/createBranch")
    public String createBranch(Branch branch){
        return branchService.createBranch(branch);
    }

    @PutMapping("/updateBranchById")
    public String updateBranch(@RequestParam String branchId,@RequestParam String branchName,@RequestParam String startingDate,@RequestParam List<String> batchIdList){
        return  branchService.updateBranch(branchId,branchName,startingDate,batchIdList);
    }

    @GetMapping("/GetBranchByName")
    public Branch getBranchByName(@RequestParam String branchName){
        return branchService.getBranchByName(branchName);
    }

    @GetMapping("/getAllBranch")
    public List<Branch> getAllBranch(){
        return branchService.getAllBranch();
    }

    @PutMapping("/updateBranchStatus")
    public String updateBranchStatus(String branchId, boolean Status){
        return branchService.updateBranchStatus(branchId);

    }



}
