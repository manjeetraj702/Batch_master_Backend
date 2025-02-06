package com.codingAge.Attendance.Controller;

import com.codingAge.Attendance.Model.Attendance;
import com.codingAge.Attendance.Service.ServiceImpl.AttendanceServiceImpl;
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
    public Attendance createAttendance(@RequestParam String studentId,@RequestParam String status,@RequestParam String batchId){
        return attendanceServiceImpl.createAttendance(studentId,status,batchId);
    }
    @PutMapping("/updateAttendance")
    public Attendance updateAttendance(@RequestParam String status,@RequestParam String attendanceId){
        return attendanceServiceImpl.updateAttendance(status,attendanceId);
    }
     @GetMapping("/getAttendanceByStudentId/{studentId}")
    public List<Attendance> getAttendanceByStudentId(@RequestParam String studentId){
        return attendanceServiceImpl.getAttendanceByStudentId(studentId);
     }
     @GetMapping("/getAttendanceByBatchId/{batchId}")
     public List<Attendance> getAttendanceByBatchId(@RequestParam String batchId){
        return attendanceServiceImpl.getAttendanceByBatchId(batchId);
     }

}
