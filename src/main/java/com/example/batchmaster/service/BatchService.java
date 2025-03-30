package com.example.batchmaster.service;

import com.example.batchmaster.model.Batch;
import com.example.batchmaster.model.request.BatchCreateRequest;

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
