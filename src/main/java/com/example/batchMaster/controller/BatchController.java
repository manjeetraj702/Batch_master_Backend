package com.example.batchMaster.controller;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batches")
@CrossOrigin(origins = "*")
public class BatchController {

    @Autowired
    BatchService batchService;

    @PostMapping("/createBatch")
    public Batch createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    @PutMapping("/updateBatch")
    public Batch updateBatch(@RequestParam String batchId, @RequestBody Batch updatedBatch) {
        return batchService.updateBatch(batchId, updatedBatch);
    }
    @PutMapping("/updateBatchStatus")
    public Batch updateBatchStatus(@RequestParam String batchId) {
        return batchService.updateBatchStatus(batchId);
    }


}
