package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.Marks;
import com.example.batchmaster.model.request.MarksCreateRequest;
import com.example.batchmaster.repository.MarksRepository;
import com.example.batchmaster.service.MarksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        marks.setResultId(marksCreateRequest.getResultId());
        marks.setTotalMarks(marksCreateRequest.getTotalMarks());
        marks.setMarksObtained(marksCreateRequest.getMarksObtained());
        marks.setDate(marksCreateRequest.getDate());
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
            marks.setDate(updatedMarks.getDate());  // Update date if modified
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

    // New Optimized Methods
    @Override
    public List<Marks> getMarksByBatchId(String batchId) {
        return marksRepository.findAllByBatchId(batchId);
    }

    @Override
    public List<Marks> getMarksByBatchIdAndSubject(String batchId, String subject) {
        return marksRepository.findAllByBatchIdAndSubject(batchId, subject);
    }

    @Override
    public List<Marks> getMarksByBatchIdAndTopic(String batchId, String topic) {
        return marksRepository.findAllByBatchIdAndTopic(batchId, topic);
    }


    @Override
    public List<Marks> getMarksByBatchIdAndDate(String batchId, Date date) {
        return marksRepository.findAllByBatchIdAndDate(batchId, date);
    }

    @Override
    public List<Marks> getMarksByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate) {
        return marksRepository.findAllByBatchIdAndDateBetween(batchId, startDate, endDate);
    }

    @Override
    public List<Marks> getMarksByBatchIdAndSubjectAndDate(String batchId, String subject, Date date) {
        return marksRepository.findAllByBatchIdAndSubjectAndDate(batchId, subject, date);
    }

    @Override
    public List<Marks> getMarksByBatchIdAndSubjectAndTopicAndDate(String batchId, String subject, String topic, Date date) {
        return marksRepository.findAllByBatchIdAndSubjectAndTopicAndDate(batchId, subject, topic, date);
    }


}
