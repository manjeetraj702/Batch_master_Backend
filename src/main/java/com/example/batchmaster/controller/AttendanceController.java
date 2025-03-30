package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.Attendance;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.updaterequest.AttendanceUpdateRequest;
import com.example.batchmaster.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // Create attendance for a student
    @PostMapping("/create")
    public ApiResponse<Attendance> createAttendance(@RequestBody AttendanceCreateRequest attendanceCreateRequest) {
        Attendance attendance = attendanceService.createAttendance(attendanceCreateRequest);
        return new ApiResponse<>(attendance, HttpStatus.CREATED);
    }

    // Update an attendance record
    @PutMapping("/update")
    public ApiResponse<Attendance> updateAttendance(@RequestBody AttendanceUpdateRequest attendanceUpdateRequest) {
        Attendance attendance = attendanceService.updateAttendance(attendanceUpdateRequest);
        return new ApiResponse<>(attendance, HttpStatus.OK);
    }

    // Get attendance records by student ID
    @GetMapping("/getAttendanceByStudentId")
    public ApiResponse<List<Attendance>> getAttendanceByStudentId(@RequestParam String studentId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudentId(studentId);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance records by batch ID
    @GetMapping("/getAttendanceByBatchId")
    public ApiResponse<List<Attendance>> getAttendanceByBatchId(@RequestParam String batchId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBatchId(batchId);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by batch ID and date
    @GetMapping("/getAttendanceByBatchIdAndDate")
    public ApiResponse<List<Attendance>> getAttendanceByBatchIdAndDate(
            @RequestParam String batchId, @RequestParam String date) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBatchIdAndDate(batchId, date);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by student ID and date
    @GetMapping("/getAttendanceByStudentIdAndDate")
    public ApiResponse<List<Attendance>> getAttendanceByStudentIdAndDate(
            @RequestParam String studentId, @RequestParam String date) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudentIdAndDate(studentId, date);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    //Get attendance by session Id
    @GetMapping("/getAttendanceBySessionId")
    public ApiResponse<List<Attendance>> getAttendanceBySessionId(@RequestParam String sessionId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceBySessionId(sessionId);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }
}
