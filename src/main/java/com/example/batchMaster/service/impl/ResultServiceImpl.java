package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Result;
import com.example.batchMaster.model.request.MarksCreateRequest;
import com.example.batchMaster.model.request.ResultCreateRequest;
import com.example.batchMaster.model.request.StudentMarksRequest;
import com.example.batchMaster.model.updateRequest.ResultUpdateRequest;
import com.example.batchMaster.repository.ResultRepository;
import com.example.batchMaster.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private MarksServiceImpl marksServiceImpl;

    @Override
    public Result createResult(ResultCreateRequest resultCreateRequest) {
        Result newResult = new Result();
        newResult.setBatchId(resultCreateRequest.getBatchId());
        newResult.setDate(resultCreateRequest.getDate());
        newResult.setSubjectId(resultCreateRequest.getSubject());
        newResult.setTopic(resultCreateRequest.getTopic());
        newResult.setStudentAndMarksList(resultCreateRequest.getStudentAndMarksList());
        for (StudentMarksRequest studentMarksRequest : resultCreateRequest.getStudentAndMarksList()) {
            MarksCreateRequest marksCreateRequest = new MarksCreateRequest();
            marksCreateRequest.setBatchId(resultCreateRequest.getBatchId());
            marksCreateRequest.setSubject(resultCreateRequest.getSubject());
            marksCreateRequest.setTopic(resultCreateRequest.getTopic());
            marksCreateRequest.setStudentId(studentMarksRequest.getStudentId());
            marksCreateRequest.setMarksObtained(studentMarksRequest.getStudentMarks());
            marksCreateRequest.setTotalMarks(resultCreateRequest.getTotalMarks());

            marksServiceImpl.createMarks(marksCreateRequest);
        }
        return resultRepository.save(newResult);
    }

    @Override
    public Result updateResult(ResultUpdateRequest resultUpdateRequest) {
        Result existingResult = getResultsByResultId(resultUpdateRequest.getResultId());
        existingResult.setListOfTopperIds(resultUpdateRequest.getListOfTopperIds());
        existingResult.setDate(resultUpdateRequest.getDate());
        existingResult.setSubjectId(resultUpdateRequest.getSubjectId());
        existingResult.setTopic(resultUpdateRequest.getTopic());
        existingResult.setStudentAndMarksList(resultUpdateRequest.getStudentAndMarksList());
        return resultRepository.save(existingResult);
    }

    @Override
    public Result getResultsByResultId(String resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Result not found with ID: " + resultId));
    }


    @Override
    public List<Result> getResultByBatchId(String batchId) {
        return resultRepository.findAllByBatchId(batchId);
    }

    @Override
    public Result getResultByBatchSubjectTopic(String batchId, String subjectId, String topic) {
        return resultRepository.findByBatchIdAndSubjectIdAndTopic(batchId, subjectId, topic);
    }

    @Override
    public List<Result> getResultsByBatchIdAndSubjectId(String batchId, String subjectId) {
        return resultRepository.findByBatchIdAndSubjectId(batchId, subjectId);
    }


}
