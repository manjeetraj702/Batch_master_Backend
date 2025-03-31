package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.Marks;
import com.example.batchmaster.model.request.MarksCreateRequest;
import com.example.batchmaster.repository.MarksRepository;
import com.example.batchmaster.service.MarksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MarksServiceImpl implements MarksService {

    private final MarksRepository marksRepository;

    @Autowired
    public MarksServiceImpl(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }

    @Override
    public Marks createMarks(MarksCreateRequest marksCreateRequest) {
        Marks marks = new Marks();
        marks.setBatchId(marksCreateRequest.getBatchId());
        marks.setStudentId(marksCreateRequest.getStudentId());
        marks.setSubject(marksCreateRequest.getSubject());
        marks.setTopic(marksCreateRequest.getTopic());
        marks.setResultId(marks.getResultId());
        marks.setTotalMarks(marksCreateRequest.getTotalMarks());
        marks.setMarksObtained(marksCreateRequest.getMarksObtained());
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
        throw new BatchMasterException("Marks record not found with ID: " + marksId);
    }

    @Override
    public List<Marks> getMarksByStudentId(String studentId) {
        return marksRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<Marks> getMarksBySubjectTopicAndBatchId(String subject, String topic, String batchId) {
        List<Marks> marks = marksRepository.findAllBySubjectAndTopicAndBatchId(subject, topic, batchId);
        log.info("Marks: " + marks);
        return marks;
    }

    @Override
    public void deleteMarksByResultId(String resultId) {
        marksRepository.deleteAllByResultId(resultId);
    }

    @Override
    public List<Marks> getMarksByResultId(String resultId) {

        return marksRepository.findAllByResultId(resultId);
    }


}
