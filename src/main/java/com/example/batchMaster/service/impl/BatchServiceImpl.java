package com.example.batchMaster.service.impl;

import com.example.batchMaster.customException.BatchNotFoundException;
import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.request.BatchCreateRequest;
import com.example.batchMaster.repository.BatchRepository;
import com.example.batchMaster.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    // BATCH
    @Override
    public Batch createBatch(BatchCreateRequest batchCreateRequest) {
        // Check if a batch with the same name already exists
        if (batchRepository.findByBatchName(batchCreateRequest.getBatchName()).isPresent()) {
            throw  new RuntimeException("Batch with name '" + batchCreateRequest.getBatchName() + "' already exists");
        }

        // Create a new Batch instance
        Batch newBatch = new Batch();
        newBatch.setBranchId(batchCreateRequest.getBranchId());
        newBatch.setStartingDate(batchCreateRequest.getStartingDate());
        newBatch.setBatchTime(batchCreateRequest.getBatchTime());
        // Save the batch to the repository
       return batchRepository.save(newBatch);

    }

    @Override
    public Batch updateBatch(String batchId, Batch updatedBatch) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {
            Batch batchToUpdate = existingBatch.get();
            batchToUpdate.setBatchName(updatedBatch.getBatchName());
            batchToUpdate.setStartingDate(updatedBatch.getStartingDate());
            batchToUpdate.setBatchTime(updatedBatch.getBatchTime());
            batchRepository.save(batchToUpdate);
            return updatedBatch;
        } else {
            throw new BatchNotFoundException("Batch with ID " + batchId + " not found");
        }
    }

    @Override
    public Batch updateBatchStatus(String batchId) {
        // Check if the batch exists
        Optional<Batch> preBatch = batchRepository.findById(batchId);
        if (preBatch.isEmpty()) {
            throw new BatchNotFoundException("Batch with ID " + batchId + " not found");
        }

        // Update the batch status
        Batch existingBatch = preBatch.get();
        existingBatch.setStatus(!existingBatch.isStatus());
       return batchRepository.save(existingBatch); // Save the updated batch back to the database



    }

    @Override
    public Batch getBatchById(String batchId) {
        Optional<Batch> preBatch = batchRepository.findById(batchId);
        if (preBatch.isEmpty()) {
            throw new BatchNotFoundException("Batch with ID " + batchId + " not found");
        }
        return preBatch.get();
    }

    @Override
    public Batch getBatchByName(String batchName) {
        return batchRepository.findByBatchName(batchName).orElseThrow(() -> new BatchNotFoundException("Batch with name '" + batchName + "' not found"));
    }

    @Override
    public List<Batch> getAllBatchesByBranchId(String branchId) {
        return batchRepository.findAllByBranchId(branchId);
    }
}