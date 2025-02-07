package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.repository.BatchRepository;
import com.example.batchMaster.repository.StudentRepository;
import com.example.batchMaster.repository.SubjectRepository;
import com.example.batchMaster.service.BatchService;
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
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public String createBatch(Batch batch) {
        // Check if a batch with the same name already exists
        if (batchRepository.findByBatchName(batch.getBatchName()) != null) {
            return "Batch with the same name already exists";
        }

        // Check if a batch with the same ID already exists
        if (batchRepository.findById(batch.getBatchId()).isPresent()) {
            return "Batch with the same ID already exists";
        }

        // Create a new Batch instance
        Batch newBatch = new Batch();
        newBatch.setBatchId(batch.getBatchId());
        newBatch.setBatchName(batch.getBatchName());
        newBatch.setStartingDate(batch.getStartingDate());
        newBatch.setBatchTime(batch.getBatchTime());
        newBatch.setStudentList(batch.getStudentList());
        newBatch.setSubjectList(batch.getSubjectList());
        newBatch.setCurrentSubject(batch.getCurrentSubject());
        newBatch.setCompletedSubjectList(batch.getCompletedSubjectList());
        newBatch.setOnlineStudentList(batch.getOnlineStudentList());
        newBatch.setOfflineStudentList(batch.getOfflineStudentList());

        // Save the batch to the repository
        batchRepository.save(newBatch);
        return "Batch created successfully with ID: " + newBatch.getBatchId();
    }

    @Override
    public String updateBatch(String batchId, Batch updatedBatch) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {
            Batch batchToUpdate = existingBatch.get();
            batchToUpdate.setBatchName(updatedBatch.getBatchName());
            batchToUpdate.setStartingDate(updatedBatch.getStartingDate());
            batchToUpdate.setBatchTime(updatedBatch.getBatchTime());
            batchToUpdate.setStudentList(updatedBatch.getStudentList());
            batchToUpdate.setSubjectList(updatedBatch.getSubjectList());
            batchToUpdate.setCurrentSubject(updatedBatch.getCurrentSubject());
            batchToUpdate.setCompletedSubjectList(updatedBatch.getCompletedSubjectList());
            batchToUpdate.setOnlineStudentList(updatedBatch.getOnlineStudentList());
            batchToUpdate.setOfflineStudentList(updatedBatch.getOfflineStudentList());
            batchRepository.save(batchToUpdate);
            return "Batch updated successfully";
        } else {
            return "Batch with ID " + batchId + " not found";
        }
    }

    @Override
    public String addStudent(String batchId, String studentId) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {
            Batch batch = existingBatch.get();
            List<String> students = batch.getStudentList();

            if (!students.contains(studentId)) {
                students.add(studentId);
                batch.setStudentList(students);
                batchRepository.save(batch);
                return "Student added successfully to batch " + batchId;
            } else {
                return "Student already exists in batch " + batchId;
            }
        } else {
            return "Batch with ID " + batchId + " not found";
        }
    }

    @Override
    public String removeStudent(String batchId, String studentId) {
        Optional<Batch> existingBatch = batchRepository.findById(batchId);

        if (existingBatch.isPresent()) {
            Batch batch = existingBatch.get();
            List<String> students = batch.getStudentList();

            if (students.contains(studentId)) {
                students.remove(studentId);
                batch.setStudentList(students);
                batchRepository.save(batch);
                return "Student removed successfully from batch " + batchId;
            } else {
                return "Student not found in batch " + batchId;
            }
        } else {
            return "Batch with ID " + batchId + " not found";
        }
    }

    @Override
    public List<Student> getListOfStudents(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch students only from the `studentList` in the batch
        return studentRepository.findAllById(batch.getStudentList());
    }


//Todo: not completed
    @Override
    public List<Subject> getListOfCompletedSubjects(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch completed subjects from the batch
        return subjectRepository.findAllById(batch.getCompletedSubjectList());
    }
//Todo: not completed
    @Override
    public List<Subject> getListOfInCompletedSubjects(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch incomplete subjects from the batch
        return subjectRepository.findAllById(batch.getSubjectList());
    }

//Todo: not completed
    @Override
    public List<Subject> getListOfCurrentSubjects(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch incomplete subjects from the batch
        return subjectRepository.findAllById(batch.getSubjectList());
    }

    @Override
    public List<Student> getListOfOnlineStudents(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch online students from the batch
        return studentRepository.findAllById(batch.getOnlineStudentList());
    }

    @Override
    public List<Student> getListOfOfflineStudents(String batchId) {
        // Fetch the batch by ID or throw an exception if not found
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchNotFoundException("Batch with ID " + batchId + " not found"));

        // Fetch offline students from the batch
        return studentRepository.findAllById(batch.getOfflineStudentList());
    }


//Todo: not completed
    @Override
    public String getListOfTestResults(String batchId) {
        return "";
    }


    @Override
    public String updateBatchStatus(String batchId) {
        // Check if the batch exists
        Optional<Batch> preBatch = batchRepository.findById(batchId);
        if (!preBatch.isPresent()) {
            return "Batch with ID " + batchId + " not found.";
        }

        // Update the batch status
        Batch existingBatch = preBatch.get();
        existingBatch.setStatus(!existingBatch.isStatus());
        batchRepository.save(existingBatch); // Save the updated batch back to the database

        return existingBatch.getBatchName() + " Status Updated Successfully.";

    }
}
