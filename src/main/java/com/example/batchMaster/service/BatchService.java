package com.example.batchMaster.service;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.request.BatchCreateRequest;

import java.util.List;

public interface BatchService {
    Batch createBatch(BatchCreateRequest batchCreateRequest);

    Batch updateBatch(String batchId, Batch updatedBatch);

    Batch updateBatchStatus(String batchId);

    Batch getBatchById(String batchId);
    Batch getBatchByName(String batchName);
    List<Batch> getAllBatchesByBranchId(String branchId);
    List<Batch> getAllBatches();
}
