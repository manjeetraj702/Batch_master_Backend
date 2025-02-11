package com.example.batchMaster.controller;


import com.example.batchMaster.model.Subject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.model.updateRequest.SubjectUpdateRequest;
import com.example.batchMaster.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class SubjectController {
   @Autowired
   private SubjectService subjectService;
   @PostMapping("/create/subject")
   public Subject createCourse(@RequestBody SubjectCreateRequest subjectCreateRequest)
   {
      return subjectService.createCourse(subjectCreateRequest);
   }

   @PutMapping("/update/subject")
  public Subject updateSubject( @RequestBody  SubjectUpdateRequest subjectUpdateRequest){
     return subjectService.updateSubject(subjectUpdateRequest);
   }
@GetMapping("/get/allSubject")
   public List<Subject> getAllSubject() {
      return subjectService.getAllSubject();
   }

   @PatchMapping("/status/active or not ")
   public Subject changeSubjectStatus(@RequestParam String SubjectId){
       return subjectService.changeSubjectStatus(SubjectId);
   }

   @GetMapping("get/incomplete/subjects/byBatchId")
   public  List<Subject> getIncompleteSubject(@RequestParam String batchId){
       return subjectService.getIncompleteSubject(batchId);
   }

   @GetMapping("get/complete/subjects/byBatchId")
   public  List<Subject> getCompleteSubject(@RequestParam String batchId){
      return subjectService.getCompleteSubject(batchId);
   }


   @GetMapping("/getBy/batchId")
   public List<Subject> getByBatchId(@RequestParam String batchId){
      return subjectService.getSubjectByBatchId(batchId);
   }


   @GetMapping("/getBy/subjectName/batchId")
   public Subject getBySubjectNameAndBatchId(@RequestParam String subjectName ,String batchId){
      return subjectService.getBySubjectNameAndBatchId(subjectName,batchId);
   }


}

