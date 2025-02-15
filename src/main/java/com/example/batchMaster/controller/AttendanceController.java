package com.example.batchMaster.controller;

import com.example.batchMaster.base.ApiResponse;
import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
import com.example.batchMaster.model.request.BatchAttendanceRequest;
import com.example.batchMaster.service.AttendanceService;
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
    public ApiResponse<Attendance> updateAttendance(@RequestParam String attendanceId) {
        Attendance attendance = attendanceService.updateAttendance(attendanceId);
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

    // Create attendance records for an entire batch
    @PostMapping("/createAttendanceForBatch")
    public ApiResponse<List<Attendance>> createAttendanceForBatch(@RequestBody BatchAttendanceRequest request) {
        List<Attendance> attendanceList = attendanceService.createAttendanceForBatch(
                request.getAbsentStudentIds(),
                request.getPresentStudentIds(),
                request.getBatchId(),
                request.getDate()
        );
        return new ApiResponse<>(attendanceList, HttpStatus.CREATED);
    }
}
