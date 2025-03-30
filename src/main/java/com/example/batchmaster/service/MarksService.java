package com.example.batchmaster.service;


import com.example.batchmaster.model.Marks;
import com.example.batchmaster.model.request.MarksCreateRequest;

import java.util.List;

public interface MarksService {

    Marks createMarks(MarksCreateRequest marks);

    Marks updateMarks(String marksId, Marks updatedMarks);

    List<Marks> getMarksByStudentId(String studentId);

    List<Marks> getMarksBySubjectTopicAndBatchId(String subject, String topic, String batchId);

    void deleteMarksByResultId(String resultId);

    List<Marks> getMarksByResultId(String resultId);
}
