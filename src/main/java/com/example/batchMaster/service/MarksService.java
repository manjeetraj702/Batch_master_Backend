package com.example.batchMaster.service;


import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.request.MarksCreateRequest;

import java.util.List;

public interface MarksService {

    Marks createMarks(MarksCreateRequest marks);

    Marks updateMarks(String marksId, Marks updatedMarks);

    List<Marks> getMarksByStudentId(String studentId);

    List<Marks> getMarksBySubjectTopicAndBatchId(String subject, String topic, String batchId);

    void deleteMarksByResultId(String resultId);

    List<Marks> getMarksByResultId(String resultId);
}
