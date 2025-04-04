package com.example.batchmaster.service;

import com.example.batchmaster.model.Marks;
import com.example.batchmaster.model.request.MarksCreateRequest;

import java.util.Date;
import java.util.List;

public interface MarksService {

    Marks createMarks(MarksCreateRequest marks);

    Marks updateMarks(String marksId, Marks updatedMarks);

    List<Marks> getMarksByStudentId(String studentId);

    List<Marks> getMarksBySubjectTopicAndBatchId(String subject, String topic, String batchId);

    void deleteMarksByResultId(String resultId);

    List<Marks> getMarksByResultId(String resultId);

    // New Optimized Methods
    List<Marks> getMarksByBatchId(String batchId);

    List<Marks> getMarksByBatchIdAndSubject(String batchId, String subject);

    List<Marks> getMarksByBatchIdAndTopic(String batchId, String topic);

    List<Marks> getMarksByBatchIdAndDate(String batchId, Date date);

    List<Marks> getMarksByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate);

    List<Marks> getMarksByBatchIdAndSubjectAndDate(String batchId, String subject, Date date);

    public List<Marks> getMarksByBatchIdAndSubjectAndTopicAndDate(String batchId, String subject, String topic, Date date);

}
