package com.example.batchMaster.controller;


import com.example.batchMaster.model.BatchSubject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.model.updateRequest.SubjectUpdateRequest;
import com.example.batchMaster.service.BatchSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/batchSubject")
public class BatchSubjectController {
   @Autowired
   private BatchSubjectService subjectService;
   @PostMapping("/create/batchSubject")
   public BatchSubject createCourse(@RequestBody SubjectCreateRequest subjectCreateRequest)
   {
      return subjectService.createCourse(subjectCreateRequest);
   }

   @PutMapping("/update/batchSubject")
  public BatchSubject updateSubject(@RequestBody  SubjectUpdateRequest subjectUpdateRequest){
     return subjectService.updateSubject(subjectUpdateRequest);
   }
@GetMapping("/get/allBatchSubject")
   public List<BatchSubject> getAllSubject() {
      return subjectService.getAllSubject();
   }

   @PatchMapping("/status/active or not ")
   public BatchSubject changeSubjectStatus(@RequestParam String SubjectId){
       return subjectService.changeSubjectStatus(SubjectId);
   }

   @GetMapping("get/incomplete/batchSubjects/byBatchId")
   public  List<BatchSubject> getIncompleteSubject(@RequestParam String batchId){
       return subjectService.getIncompleteSubject(batchId);
   }

   @GetMapping("get/complete/batchSubjects/byBatchId")
   public  List<BatchSubject> getCompleteSubject(@RequestParam String batchId){
      return subjectService.getCompleteSubject(batchId);
   }


   @GetMapping("/getBy/batch" + "Id")
   public List<BatchSubject> getByBatchId(@RequestParam String batchId){
      return subjectService.getSubjectByBatchId(batchId);
   }


   @GetMapping("/getBy/subjectName/batchId")
   public BatchSubject getBySubjectNameAndBatchId(@RequestParam String subjectName , String batchId){
      return subjectService.getBySubjectNameAndBatchId(subjectName,batchId);
   }


}

