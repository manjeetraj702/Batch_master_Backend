package com.example.batchmaster.service.impl;

import com.example.batchmaster.model.Result;
import com.example.batchmaster.model.request.MarksCreateRequest;
import com.example.batchmaster.model.request.ResultCreateRequest;
import com.example.batchmaster.model.request.StudentMarksRequest;
import com.example.batchmaster.model.updaterequest.ResultUpdateRequest;
import com.example.batchmaster.repository.ResultRepository;
import com.example.batchmaster.service.ResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final MarksServiceImpl marksServiceImpl;

    public ResultServiceImpl(ResultRepository resultRepository, MarksServiceImpl marksServiceImpl) {
        this.resultRepository = resultRepository;
        this.marksServiceImpl = marksServiceImpl;
    }

    @Override
    @Transactional
    public Result createResult(ResultCreateRequest resultCreateRequest) {
        Result newResult = new Result();
        newResult.setBatchId(resultCreateRequest.getBatchId());
        newResult.setDate(Instant.now());
        newResult.setSubject(resultCreateRequest.getSubject());
        newResult.setTopic(resultCreateRequest.getTopic());
        newResult.setTotalMarks(resultCreateRequest.getTotalMarks());
        newResult.setStudentAndMarksList(resultCreateRequest.getStudentAndMarksList());
        Result result = resultRepository.save(newResult);
        float topperMarks = 0;
        List<String> topperList = new ArrayList<>();
        for (StudentMarksRequest studentMarksRequest : resultCreateRequest.getStudentAndMarksList()) {
            MarksCreateRequest marksCreateRequest = new MarksCreateRequest();
            marksCreateRequest.setResultId(result.getResultId());
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
        Result existingResult = getResultByResultId(resultUpdateRequest.getResultId());

        Result newResult = existingResult;
        newResult.setBatchId(resultUpdateRequest.getBatchId());
        newResult.setDate(resultUpdateRequest.getDate());
        newResult.setSubject(resultUpdateRequest.getSubject());
        newResult.setTopic(resultUpdateRequest.getTopic());
        newResult.setTotalMarks(resultUpdateRequest.getTotalMarks());

        newResult.setStudentAndMarksList(resultUpdateRequest.getStudentAndMarksList());
        marksServiceImpl.deleteMarksByResultId(newResult.getResultId());
        float topperMarks = 0;
        List<String> topperList = new ArrayList<>();
        for (StudentMarksRequest studentMarksRequest : resultUpdateRequest.getStudentAndMarksList()) {
            MarksCreateRequest marksCreateRequest = new MarksCreateRequest();
            marksCreateRequest.setResultId(resultUpdateRequest.getResultId());
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
    public List<Result> getResultsByBatchIdAndDate(String batchId, Date date) {
        return resultRepository.findByBatchIdAndDate(batchId, date);
    }

    @Override
    public List<Result> getResultsByBatchIdBetweenDates(String batchId, Date startDate, Date endDate) {
        return resultRepository.findByBatchIdAndDateBetween(batchId, startDate, endDate);
    }

    @Override
    public List<Result> getResultsBySubject(String subject) {
        return resultRepository.findBySubject(subject);
    }

    @Override
    public List<Result> getResultsByTopic(String topic) {
        return resultRepository.findByTopic(topic);
    }

    @Override
    public Result getResultByResultId(String resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Result not found with ID: " + resultId));
    }

    @Override
    public List<Result> getResultsByBatchId(String batchId) {
        return resultRepository.findAllByBatchId(batchId);
    }

    @Override
    public Result getResultByBatchSubjectTopic(String batchId, String subject, String topic) {
        return resultRepository.findByBatchIdAndSubjectAndTopic(batchId, subject, topic);
    }

    @Override
    public List<Result> getResultsByBatchIdAndSubject(String batchId, String subject) {
        return resultRepository.findByBatchIdAndSubject(batchId, subject);
    }

}
