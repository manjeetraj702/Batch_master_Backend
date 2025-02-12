package com.example.batchMaster.controller;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
import com.example.batchMaster.service.impl.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceServiceImpl attendanceServiceImpl;
    @PostMapping ("/createAttendance")
    public Attendance createAttendance(@RequestBody AttendanceCreateRequest attendanceCreateRequest){
        return attendanceServiceImpl.createAttendance(attendanceCreateRequest);
    }
    @PutMapping("/updateAttendance")
    public Attendance updateAttendance(@RequestParam String attendanceId){
        return attendanceServiceImpl.updateAttendance(attendanceId);
    }
     @GetMapping("/getAttendanceByStudentId/studentId")
    public List<Attendance> getAttendanceByStudentId(@RequestParam String studentId){
        return attendanceServiceImpl.getAttendanceByStudentId(studentId);
     }
     @GetMapping("/getAttendanceByBatchId/batchId")
     public List<Attendance> getAttendanceByBatchId(@RequestParam String batchId){
        return attendanceServiceImpl.getAttendanceByBatchId(batchId);
     }

     @GetMapping("/getAttendanceByBatchId&Date/{batchId}/date")
    public List<Attendance> getAttendanceByBatchIdAndDate(@RequestParam String batchId,@RequestParam String date){
        return attendanceServiceImpl.getAttendanceByBatchIdAndDate(batchId,date);
     }

     @GetMapping("/getAttendanceByStudentId&Date/studentId}/date")
    public List<Attendance> getAttendanceByStudentIdAndDate(@RequestParam String studentId,@RequestParam String date){
        return attendanceServiceImpl.getAttendanceByStudentIdAndDate(studentId,date);
     }



}
