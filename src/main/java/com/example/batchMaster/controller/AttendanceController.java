package com.example.batchMaster.controller;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
import com.example.batchMaster.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @PostMapping ("/createAttendance")
    public Attendance createAttendance(@RequestBody AttendanceCreateRequest attendanceCreateRequest){
        return attendanceService.createAttendance(attendanceCreateRequest);
    }
    @PutMapping("/updateAttendance")
    public Attendance updateAttendance(@RequestParam String attendanceId){
        return attendanceService.updateAttendance(attendanceId);
    }
     @GetMapping("/getAttendanceByStudentId/studentId")
    public List<Attendance> getAttendanceByStudentId(@RequestParam String studentId){
        return attendanceService.getAttendanceByStudentId(studentId);
     }
     @GetMapping("/getAttendanceByBatchId/batchId")
     public List<Attendance> getAttendanceByBatchId(@RequestParam String batchId){
        return attendanceService.getAttendanceByBatchId(batchId);
     }

     @GetMapping("/getAttendanceByBatchId&Date/{batchId}/date")
    public List<Attendance> getAttendanceByBatchIdAndDate(@RequestParam String batchId,@RequestParam String date){
        return attendanceService.getAttendanceByBatchIdAndDate(batchId,date);
     }

     @GetMapping("/getAttendanceByStudentId&Date/studentId/date")
    public List<Attendance> getAttendanceByStudentIdAndDate(@RequestParam String studentId,@RequestParam String date){
        return attendanceService.getAttendanceByStudentIdAndDate(studentId,date);
     }

     @PostMapping("/createAttendanceForBatch")
    boolean createAttendanceForBatch(List<String> absentStudentIds, List<String> presentStudentIds, String batchId, String date)
    {
        return attendanceService.createAttendanceForBatch(absentStudentIds,presentStudentIds,batchId,date);

    }


}
