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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private MarksServiceImpl marksServiceImpl;

    @Override
    @Transactional
    public Result createResult(ResultCreateRequest resultCreateRequest) {
        Result newResult = new Result();
        newResult.setBatchId(resultCreateRequest.getBatchId());
        newResult.setDate(new Date());
        newResult.setSubject(resultCreateRequest.getSubject());
        newResult.setTopic(resultCreateRequest.getTopic());
        newResult.setStudentAndMarksList(resultCreateRequest.getStudentAndMarksList());
        Result result = resultRepository.save(newResult);
        float topperMarks = 0;
        List<String> topperList = new ArrayList<>();
        for (StudentMarksRequest studentMarksRequest : resultCreateRequest.getStudentAndMarksList()) {
            MarksCreateRequest marksCreateRequest = new MarksCreateRequest();
            marksCreateRequest.setBatchId(resultCreateRequest.getBatchId());
            marksCreateRequest.setSubject(resultCreateRequest.getSubject());
            marksCreateRequest.setTopic(resultCreateRequest.getTopic());
            marksCreateRequest.setStudentId(studentMarksRequest.getStudentId());
            marksCreateRequest.setMarksObtained(studentMarksRequest.getStudentMarks());
            marksCreateRequest.setTotalMarks(resultCreateRequest.getTotalMarks());
            marksServiceImpl.createMarks(marksCreateRequest);

            if (studentMarksRequest.getStudentMarks() == topperMarks) {
                topperList.add(studentMarksRequest.getStudentName());
            } else if (topperMarks < studentMarksRequest.getStudentMarks()) {
                topperList = new ArrayList<>();
                topperList.add(studentMarksRequest.getStudentName());
                topperMarks = studentMarksRequest.getStudentMarks();

            }
        }
        result.setListOfTopperName(topperList);

        return resultRepository.save(result);
    }

    @Override
    @Transactional
    public Result updateResult(ResultUpdateRequest resultUpdateRequest) {
        Result existingResult = getResultsByResultId(resultUpdateRequest.getResultId());

        Result newResult = existingResult;
        newResult.setBatchId(resultUpdateRequest.getBatchId());
        newResult.setDate(resultUpdateRequest.getDate());
        newResult.setSubject(resultUpdateRequest.getSubject());
        newResult.setTopic(resultUpdateRequest.getTopic());
        newResult.setStudentAndMarksList(resultUpdateRequest.getStudentAndMarksList());
        marksServiceImpl.deleteMarksByResultId(newResult.getResultId());
        float topperMarks = 0;
        List<String> topperList = new ArrayList<>();
        for (StudentMarksRequest studentMarksRequest : resultUpdateRequest.getStudentAndMarksList()) {
            MarksCreateRequest marksCreateRequest = new MarksCreateRequest();
            marksCreateRequest.setBatchId(resultUpdateRequest.getBatchId());
            marksCreateRequest.setSubject(resultUpdateRequest.getSubject());
            marksCreateRequest.setTopic(resultUpdateRequest.getTopic());
            marksCreateRequest.setStudentId(studentMarksRequest.getStudentId());
            marksCreateRequest.setMarksObtained(studentMarksRequest.getStudentMarks());
            marksCreateRequest.setTotalMarks(resultUpdateRequest.getTotalMarks());
            marksServiceImpl.createMarks(marksCreateRequest);

            if (studentMarksRequest.getStudentMarks() == topperMarks) {
                topperList.add(studentMarksRequest.getStudentName());
            } else if (topperMarks < studentMarksRequest.getStudentMarks()) {
                topperList = new ArrayList<>();
                topperList.add(studentMarksRequest.getStudentName());
                topperMarks = studentMarksRequest.getStudentMarks();

            }

        }
        existingResult.setListOfTopperName(topperList);
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
    public Result getResultByBatchSubjectTopic(String batchId, String subject, String topic) {
        return resultRepository.findByBatchIdAndSubjectAndTopic(batchId, subject, topic);
    }

    @Override
    public List<Result> getResultsByBatchIdAndSubjectId(String batchId, String subjectId) {
        return resultRepository.findByBatchIdAndSubject(batchId, subjectId);
    }

}
