package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.repository.BatchRepository;
import com.example.batchMaster.repository.StudentRepository;
import com.example.batchMaster.repository.SubjectRepository;
import com.example.batchMaster.service.BatchService;
import com.example.batchMaster.service.ResultService;
import com.example.batchMaster.service.StudentService;
import com.example.batchMaster.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import  com.example.batchMaster.customException.BatchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    ResultService resultService;


    @Override
    public Batch createBatch(Batch batch) {
        // Check if a batch with the same name already exists
        if (batchRepository.findByBatchName(batch.getBatchName()) != null) {
           return  batch;
        }
        // Check if a batch with the same ID already exists
        if (batchRepository.findById(batch.getBatchId()).isPresent()) {
            return batch;
        }
        // Create a new Batch instance
        Batch newBatch = new Batch();
        newBatch.setBatchId(batch.getBatchId());
        newBatch.setBatchName(batch.getBatchName());
        newBatch.setStartingDate(batch.getStartingDate());
        newBatch.setBatchTime(batch.getBatchTime());
        newBatch.setOnlineStudentList(batch.getOnlineStudentList());
        newBatch.setOfflineStudentList(batch.getOfflineStudentList());
        // Save the batch to the repository
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
            batchToUpdate.setOnlineStudentList(updatedBatch.getOnlineStudentList());
            batchToUpdate.setOfflineStudentList(updatedBatch.getOfflineStudentList());
            batchRepository.save(batchToUpdate);
            return updatedBatch;
        } else {
            return null;
        }
    }

    @Override
    public Batch addStudent(String batchId, String studentId) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {
            Batch batch = existingBatch.get();
                studentService.updateStudentBatchId(studentId,batchId);
                return batch;
        }
        else {
            return null;
        }
    }

    @Override
    public Batch removeStudent(String batchId, String studentId) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {
            Batch batch = existingBatch.get();
            studentService.updateStudentBatchId(studentId,batchId);
            return batch;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getListOfStudents(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch students only from the `studentList` in the batch
        return studentService.getStudentsByBatchId(batchId);
    }


//Todo: not completed
    @Override
    public List<Subject> getListOfCompletedSubjects(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch completed subjects from the batch
        return subjectService.getAllSubject();
    }
//Todo: not completed
    @Override
    public List<Subject> getListOfInCompletedSubjects(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch incomplete subjects from the batch
        return subjectService.getAllSubject();
    }

//Todo: not completed
    @Override
    public List<Subject> getListOfCurrentSubjects(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch incomplete subjects from the batch
        return subjectService.getAllSubject();
    }

    @Override
    public List<Student> getListOfOnlineStudents(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch online students from the batch
        return studentService.getOnlineStudents(batchId);
    }

    @Override
    public List<Student> getListOfOfflineStudents(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch offline students from the batch
        return studentService.getOfflineStudents(batchId);
    }


//Todo: not completed
    @Override
    public List<ResultService> getListOfTestResults(String batchId) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {


            return null;
        }
        else {
            return null;
        }

    }


    @Override
    public Batch updateBatchStatus(String batchId) {
        // Check if the batch exists
        Optional<Batch> preBatch = batchRepository.findById(batchId);
        if (!preBatch.isPresent()) {
            return null;
        }

        // Update the batch status
        Batch existingBatch = preBatch.get();
        existingBatch.setStatus(!existingBatch.isStatus());
        batchRepository.save(existingBatch); // Save the updated batch back to the database

        return existingBatch;

    }
}
