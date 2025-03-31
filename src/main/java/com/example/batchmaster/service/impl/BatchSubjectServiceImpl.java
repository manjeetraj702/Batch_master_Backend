package com.example.batchmaster.service.impl;


import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.BatchSubject;
import com.example.batchmaster.model.request.SubjectCreateRequest;
import com.example.batchmaster.model.updaterequest.BatchSubjectUpdateRequest;
import com.example.batchmaster.repository.BatchSubjectRepository;
import com.example.batchmaster.service.BatchSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchSubjectServiceImpl implements BatchSubjectService {
    private final BatchSubjectRepository batchSubjectRepository;

    @Autowired
    public BatchSubjectServiceImpl(BatchSubjectRepository batchSubjectRepository) {
        this.batchSubjectRepository = batchSubjectRepository;
    }

    @Override
    public BatchSubject createCourse(SubjectCreateRequest subjectCreateRequest) {
        BatchSubject batchSubject = new BatchSubject();
        batchSubject.setSubjectName(subjectCreateRequest.getSubjectName());
        batchSubject.setBatchId(subjectCreateRequest.getBatchId());
        batchSubject.setStatus(subjectCreateRequest.isStatus());
        batchSubject.setListOfTopics(subjectCreateRequest.getListOfTopics());
        return batchSubjectRepository.save(batchSubject);
    }

    @Override
    public BatchSubject updateSubject(BatchSubjectUpdateRequest subjectUpdateRequest) {
        getSubjectById(subjectUpdateRequest.getSubjectId());
        BatchSubject batchSubject = new BatchSubject();
        batchSubject.setSubjectId(subjectUpdateRequest.getSubjectId());
        batchSubject.setSubjectName(subjectUpdateRequest.getSubjectName());
        batchSubject.setBatchId(subjectUpdateRequest.getBatchId());
        batchSubject.setListOfTopics(subjectUpdateRequest.getListOfTopics());
        batchSubject.setStatus(subjectUpdateRequest.isStatus());
        return batchSubjectRepository.save(batchSubject);
    }

    @Override
    public BatchSubject getSubjectById(String subjectId) {
        return batchSubjectRepository.findById(subjectId).orElseThrow(() -> new BatchMasterException("Subject is not present"));
    }


    @Override
    public BatchSubject changeSubjectStatus(String subjectId) {
        BatchSubject batchSubject = getSubjectById(subjectId);
        batchSubject.setStatus(!batchSubject.isStatus());

        return batchSubjectRepository.save(batchSubject);
    }


    @Override
    public List<BatchSubject> getAllSubject() {
        return batchSubjectRepository.findAll();
    }

    @Override
    public List<BatchSubject> getSubjectByBatchId(String batchId) {
        return batchSubjectRepository.findAllByBatchId(batchId);
    }

    @Override
    public BatchSubject getBySubjectNameAndBatchId(String subjectName, String batchId) {
        return batchSubjectRepository.findBySubjectNameAndBatchId(subjectName, batchId);
    }

    @Override
    public List<BatchSubject> getCompleteSubject(String batchId) {
        return batchSubjectRepository.findAllByBatchIdAndStatusTrue(batchId);
    }

    @Override
    public List<BatchSubject> getIncompleteSubject(String batchId) {
        return batchSubjectRepository.findAllByBatchIdAndStatusFalse(batchId);
    }

    @Override
    public BatchSubject addTopic(String subjectId, String topic) {
        Optional<BatchSubject> optionalSubject = batchSubjectRepository.findById(subjectId);

        if (optionalSubject.isPresent()) {
            BatchSubject batchSubject = optionalSubject.get();

            if (!batchSubject.getListOfTopics().contains(topic)) {
                batchSubject.getListOfTopics().add(topic);
                return batchSubjectRepository.save(batchSubject); // Save updated subject
            }
            throw new BatchMasterException("Topic already exists in the subject");
        }

        throw new BatchMasterException("Subject not found");
    }

    @Override
    public BatchSubject removeTopic(String subjectId, String topic) {
        Optional<BatchSubject> optionalSubject = batchSubjectRepository.findById(subjectId);

        if (optionalSubject.isPresent()) {
            BatchSubject batchSubject = optionalSubject.get();

            if (batchSubject.getListOfTopics().contains(topic)) {
                batchSubject.getListOfTopics().remove(topic);
                return batchSubjectRepository.save(batchSubject); // Save updated subject
            }
            throw new BatchMasterException("Topic not found in the subject");
        }

        throw new BatchMasterException("Subject not found");
    }


}
