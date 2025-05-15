package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.Batch;
import com.example.batchmaster.model.request.BatchCreateRequest;
import com.example.batchmaster.repository.BatchRepository;
import com.example.batchmaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/batches")
@CrossOrigin("*")
public class BatchController {
    @Autowired
    private BatchRepository batchRepository;

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    // Create a new batch
    @PostMapping("/create")
    public ApiResponse<Batch> createBatch(@RequestBody BatchCreateRequest batchCreateRequest) {
        Batch batch = batchService.createBatch(batchCreateRequest);
        return new ApiResponse<>(batch, HttpStatus.CREATED);
    }

    // Update batch details
    @PutMapping("/update")
    public ApiResponse<Batch> updateBatch(@RequestParam String batchId, @RequestBody Batch updatedBatch) {
        Batch batch = batchService.updateBatch(batchId, updatedBatch);
        return new ApiResponse<>(batch, HttpStatus.OK);
    }

    // Update batch status (activate/deactivate)
    @PutMapping("/updateBatchStatus")
    public ApiResponse<Batch> updateBatchStatus(@RequestParam String batchId) {
        Batch batch = batchService.updateBatchStatus(batchId);
        return new ApiResponse<>(batch, HttpStatus.OK);
    }

    // Get batch by ID
    @GetMapping("/getBatchById")
    public ApiResponse<Batch> getBatchById(@RequestParam String batchId) {
        Batch batch = batchService.getBatchById(batchId);
        return new ApiResponse<>(batch, HttpStatus.OK);
    }

    // Get batch by name
    @GetMapping("/getBatchByName")
    public ApiResponse<Batch> getBatchByName(@RequestParam String batchName) {
        Batch batch = batchService.getBatchByName(batchName);
        return new ApiResponse<>(batch, HttpStatus.OK);
    }

    // Get all batches by branch ID
    @GetMapping("/getBatchesByBranchId")
    public ApiResponse<List<Batch>> getBatchesByBranchId(@RequestParam String branchId) {
        List<Batch> batches = batchService.getAllBatchesByBranchId(branchId);
        return new ApiResponse<>(batches, HttpStatus.OK);
    }

    // Get all batches
    @GetMapping("/getAllBatches")
    public ApiResponse<List<Batch>> getAllBatches() {
        List<Batch> batches = batchService.getAllBatches();
        return new ApiResponse<>(batches, HttpStatus.OK);
    }

    @DeleteMapping("/byName")
    public boolean delete(String name) {
        batchRepository.deleteByBatchName(name);
        return true;
    }
}
