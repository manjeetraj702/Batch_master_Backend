package com.example.batchMaster.controller;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.request.BatchCreateRequest;
import com.example.batchMaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
@CrossOrigin("*")
public class BatchController {

    @Autowired
    BatchService batchService;

    @PostMapping("/createBatch")
    public Batch createBatch(@RequestBody BatchCreateRequest batchCreateRequest) {
        return batchService.createBatch(batchCreateRequest);
    }

    @PutMapping("/updateBatch")
    public Batch updateBatch(@RequestParam String batchId, @RequestBody Batch updatedBatch) {
        return batchService.updateBatch(batchId, updatedBatch);
    }
    @PutMapping("/updateBatchStatus")
    public Batch updateBatchStatus(@RequestParam String batchId) {
        return batchService.updateBatchStatus(batchId);
    }

    @GetMapping("/getBatchById")
    public Batch getBatchById(@RequestParam String batchId) {
        return batchService.getBatchById(batchId);
    }

    @GetMapping("/getBatchByName")
    public Batch getBatchByName(@RequestParam String batchName) {
        return batchService.getBatchByName(batchName);
    }



    @GetMapping("/getAllBatchesByBranchId")
    public List<Batch> getBatchesByBranchId(@RequestParam String branchId) {
        return batchService.getAllBatchesByBranchId(branchId);
    }

    @GetMapping("/getAllBatches")
    public List<Batch> getAllBatches()
    {
        return batchService.getAllBatches();
    }

}
