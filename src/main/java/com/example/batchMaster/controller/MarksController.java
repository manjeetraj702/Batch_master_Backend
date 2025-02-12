package com.example.batchMaster.controller;


import com.example.batchMaster.model.Marks;
import com.example.batchMaster.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "*")

public class MarksController {

    @Autowired
    private MarksService marksService;

    // Create Marks
    @PostMapping
    public Marks createMarks(@RequestBody Marks marks) {
        return marksService.createMarks(marks);
    }

    // Update Marks by ID
    @PutMapping("/marksId")
    public Marks updateMarks(@RequestParam String marksId, @RequestBody Marks updatedMarks) {
        return marksService.updateMarks(marksId, updatedMarks);
    }

    // Get Marks by Student ID
    @GetMapping("/student/{studentId}")
    public List<Marks> getMarksByStudentId(@RequestParam String studentId) {
        return marksService.getMarksByStudentId(studentId);
    }

    // Get Marks by Topic ID and Batch ID
    @GetMapping("/topic/topicId/batch/batchId")
    public List<Marks> getMarksByTopicIdAndBatchId(@RequestParam String subject, @RequestParam String topic, @RequestParam String batch) {
        return marksService.getMarksBySubjectTopicAndBatchId(subject, topic,batch);
    }
}
