package com.example.batchMaster.service.impl;

import com.example.batchMaster.customException.BatchNotFoundException;
import com.example.batchMaster.model.Batch;
import com.example.batchMaster.repository.BatchRepository;
import com.example.batchMaster.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    // BATCH
    @Override
    public Batch createBatch(Batch batch) {
        // Check if a batch with the same name already exists
        if (batchRepository.findByBatchName(batch.getBatchName()).equals(batch.getBatchName())) {
            return batch;
        }
        // Check if a batch with the same ID already exists
        if (batchRepository.findById(batch.getBatchId()).equals(batch.getBatchId())) {
            return batch;
        }
        // Create a new Batch instance
        Batch newBatch = new Batch();
        newBatch.setBatchId(batch.getBatchId());
        newBatch.setBatchName(batch.getBatchName());
        newBatch.setStartingDate(batch.getStartingDate());
        newBatch.setBatchTime(batch.getBatchTime());
        batchRepository.save(newBatch);
        return newBatch;
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
        batchRepository.save(existingBatch); // Save the updated batch back to the database

        return existingBatch;

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
    public Batch getBatchByBranchId(String branchId) {
        Optional<Batch> preBatch = batchRepository.findByBranchId(branchId);
        if (preBatch.isEmpty()) {
            throw new BatchNotFoundException("Batch with ID " + branchId + " not found");
        }
        return preBatch.get();
    }
}