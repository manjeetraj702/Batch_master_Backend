package com.example.batchmaster.service;

import com.example.batchmaster.model.Result;
import com.example.batchmaster.model.request.ResultCreateRequest;
import com.example.batchmaster.model.updaterequest.ResultUpdateRequest;

import java.util.Date;
import java.util.List;

public interface ResultService {

    Result createResult(ResultCreateRequest resultCreateRequest);

    Result updateResult(ResultUpdateRequest resultUpdateRequest);

    List<Result> getResultsByBatchIdAndSubject(String batchId, String subject);

    Result getResultByResultId(String resultId);

    List<Result> getResultsByBatchId(String batchId);

    Result getResultByBatchSubjectTopic(String batchId, String subject, String topic);

    // New Methods
    List<Result> getResultsByBatchIdAndDate(String batchId, Date date);

    List<Result> getResultsByBatchIdBetweenDates(String batchId, Date startDate, Date endDate);

    List<Result> getResultsBySubject(String subject);

    List<Result> getResultsByTopic(String topic);
}
