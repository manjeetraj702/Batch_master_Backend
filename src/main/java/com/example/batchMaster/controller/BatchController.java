package com.example.batchMaster.controller;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    @Autowired
    BatchService batchService;

//    Batch
    // 1. Create a new batch
    @PostMapping("/createBatch")
    public Batch createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    // 2. Update an existing batch
    @PutMapping("/updateBatch")
    public Batch updateBatch(@RequestParam String batchId, @RequestBody Batch updatedBatch) {
        return batchService.updateBatch(batchId, updatedBatch);
    }
    // 3. Switch a batch status (e.g., active/inactive)
    @PutMapping("/updateBatchStatus")
    public Batch updateBatchStatus(@RequestParam String batchId) {
        return batchService.updateBatchStatus(batchId);
    }




}
