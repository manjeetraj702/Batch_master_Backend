package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchNotFoundException;
import com.example.batchmaster.model.Batch;
import com.example.batchmaster.model.request.BatchCreateRequest;
import com.example.batchmaster.repository.BatchRepository;
import com.example.batchmaster.service.BatchService;
import com.example.batchmaster.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;
    private final BranchService branchService;

    @Autowired
    public BatchServiceImpl(BatchRepository batchRepository, BranchService branchService) {
        this.batchRepository = batchRepository;
        this.branchService = branchService;
    }

    static final String NOT_FOUND = "not found";

    // BATCH
    @Override
    public Batch createBatch(BatchCreateRequest batchCreateRequest) {
        // Check if a batch with the same name already exists
        if (batchRepository.findByBatchName(batchCreateRequest.getBatchName()).isPresent()) {
            throw new RuntimeException("Batch with name '" + batchCreateRequest.getBatchName() + "' already exists");
        }
        // Create a new Batch instance
        Batch newBatch = new Batch();
        newBatch.setBranchId(batchCreateRequest.getBranchId());
        newBatch.setStartingDate(new Date());
        newBatch.setBatchTime(batchCreateRequest.getBatchTime());
        newBatch.setBatchName(batchCreateRequest.getBatchName());

        return batchRepository.save(newBatch);

    }

    @Override
    public Batch updateBatch(String batchId, Batch updatedBatch) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {
            Batch batchToUpdate = existingBatch.get();
            batchToUpdate.setBatchName(updatedBatch.getBatchName());
            batchToUpdate.setBatchTime(updatedBatch.getBatchTime());
            batchRepository.save(batchToUpdate);
            return updatedBatch;
        } else {
            throw new BatchNotFoundException("Batch with ID " + batchId + NOT_FOUND);
        }
    }

    @Override
    public Batch updateBatchStatus(String batchId) {
        // Check if the batch exists
        Optional<Batch> preBatch = batchRepository.findById(batchId);
        if (preBatch.isEmpty()) {
            throw new BatchNotFoundException("Batch with ID " + batchId + NOT_FOUND);
        }

        // Update the batch status
        Batch existingBatch = preBatch.get();
        existingBatch.setStatus(!existingBatch.isStatus());
        return batchRepository.save(existingBatch); // Save the updated batch back to the database


    }

    @Override
    public Batch getBatchById(String batchId) {
        return batchRepository.findById(batchId).orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + NOT_FOUND));

    }

    @Override
    public Batch getBatchByName(String batchName) {
        return batchRepository.findByBatchName(batchName).orElseThrow(() -> new BatchNotFoundException("Batch with name '" + batchName + NOT_FOUND));
    }

    @Override
    public List<Batch> getAllBatchesByBranchId(String branchId) {

        return batchRepository.findAllByBranchId(branchId);
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }
}