package com.example.batchMaster.service;

import com.example.batchMaster.model.Batch;

public interface BatchService {
    Batch createBatch(Batch batch);

    Batch updateBatch(String batchId, Batch updatedBatch);

    Batch updateBatchStatus(String batchId);

    Batch getBatchById(String batchId);
    Batch getBatchByName(String batchName);
    Batch getBatchByBranchId(String branchId);
}
