package com.example.batchMaster.service;


import com.example.batchMaster.model.Marks;

import java.util.List;

public interface MarksService {
    
    Marks createMarks(Marks marks);
    
    Marks updateMarks(String marksId, Marks updatedMarks);
    
    List<Marks> getMarksByStudentId(String studentId);
    
    List<Marks> getMarksByTopicIdAndBatchId(String topicId, String batchId);
}
