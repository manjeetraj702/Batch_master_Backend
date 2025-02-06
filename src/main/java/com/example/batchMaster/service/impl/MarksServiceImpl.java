package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Marks;
import com.example.batchMaster.repository.MarksRepository;
import com.example.batchMaster.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public Marks createMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    @Override
    public Marks updateMarks(String marksId, Marks updatedMarks) {
        Optional<Marks> existingMarks = marksRepository.findById(marksId);
        if (existingMarks.isPresent()) {
            Marks marks = existingMarks.get();
            marks.setBatchId(updatedMarks.getBatchId());
            marks.setStudentId(updatedMarks.getStudentId());
            marks.setSubject(updatedMarks.getSubject());
            marks.setTopic(updatedMarks.getTopic());
            marks.setTotalMarks(updatedMarks.getTotalMarks());
            marks.setMarksObtained(updatedMarks.getMarksObtained());
            return marksRepository.save(marks);
        }
        throw new RuntimeException("Marks record not found with ID: " + marksId);
    }

    @Override
    public List<Marks> getMarksByStudentId(String studentId) {
        return List.of();
    }

    @Override
    public List<Marks> getMarksByTopicIdAndBatchId(String topicId, String batchId) {
        return List.of();
    }
}
