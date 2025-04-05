package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.Attendance;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.updaterequest.AttendanceUpdateRequest;
import com.example.batchmaster.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    // Get attendance by ID
    @GetMapping("/{attendanceId}")
    public ApiResponse<Optional<Attendance>> getByAttendanceId(@PathVariable String attendanceId) {
        Optional<Attendance> attendance = attendanceService.getByAttendanceId(attendanceId);
        return new ApiResponse<>(attendance, HttpStatus.OK);
    }

    // Get attendance records by student ID with pagination
    @GetMapping("/student/{studentId}")
    public ApiResponse<List<Attendance>> getAttendanceByStudentIdWithPagination(
            @PathVariable String studentId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudentId(studentId, page, size);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance records by batch ID with pagination
    @GetMapping("/batch/{batchId}")
    public ApiResponse<List<Attendance>> getAttendanceByBatchIdWithPagination(
            @PathVariable String batchId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBatchId(batchId, page, size);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by student ID between dates
    @GetMapping("/student/{studentId}/between")
    public ApiResponse<List<Attendance>> getAttendanceByStudentIdBetweenDates(
            @PathVariable String studentId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudentIdBetweenDates(studentId, startDate, endDate);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by batch ID between dates
    @GetMapping("/batch/{batchId}/between")
    public ApiResponse<List<Attendance>> getAttendanceByBatchIdBetweenDates(
            @PathVariable String batchId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBatchIdBetweenDates(batchId, startDate, endDate);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Delete attendance by session ID
    @DeleteMapping("/session/{sessionId}")
    public ApiResponse<Void> deleteAttendanceBySessionId(@PathVariable String sessionId) {
        attendanceService.deleteAttendanceBySessionId(sessionId);
        return new ApiResponse<>(null, HttpStatus.NO_CONTENT);
    }

    // Get attendance by student ID and date
    @GetMapping("/student/{studentId}/date")
    public ApiResponse<List<Attendance>> getAttendanceByStudentIdAndDate(
            @PathVariable String studentId,
            @RequestParam Date date) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudentIdAndDate(studentId, date);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by student ID from date
    @GetMapping("/student/{studentId}/from")
    public ApiResponse<List<Attendance>> getAttendanceByStudentIdFromDate(
            @PathVariable String studentId,
            @RequestParam Date fromDate) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudentIdFromDate(studentId, fromDate);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by batch ID and date
    @GetMapping("/batch/{batchId}/date")
    public ApiResponse<List<Attendance>> getAttendanceByBatchIdAndDate(
            @PathVariable String batchId,
            @RequestParam Date date) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBatchIdAndDate(batchId, date);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by batch ID from date
    @GetMapping("/batch/{batchId}/from")
    public ApiResponse<List<Attendance>> getAttendanceByBatchIdFromDate(
            @PathVariable String batchId,
            @RequestParam Date fromDate) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBatchIdFromDate(batchId, fromDate);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by session ID with pagination
    @GetMapping("/session/{sessionId}")
    public ApiResponse<List<Attendance>> getAttendanceBySessionIdWithPagination(
            @PathVariable String sessionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Attendance> attendanceList = attendanceService.getAttendanceBySessionId(sessionId, page, size);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by branch ID with pagination
    @GetMapping("/branch/{branchId}")
    public ApiResponse<List<Attendance>> getAttendanceByBranchIdWithPagination(
            @PathVariable String branchId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBranchId(branchId, page, size);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by branch ID and date
    @GetMapping("/branch/{branchId}/date")
    public ApiResponse<List<Attendance>> getAttendanceByBranchIdAndDate(
            @PathVariable String branchId,
            @RequestParam Date date) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBranchIdAndDate(branchId, date);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by branch ID from date
    @GetMapping("/branch/{branchId}/from")
    public ApiResponse<List<Attendance>> getAttendanceByBranchIdFromDate(
            @PathVariable String branchId,
            @RequestParam Date fromDate) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBranchIdFromDate(branchId, fromDate);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }

    // Get attendance by branch ID between dates
    @GetMapping("/branch/{branchId}/between")
    public ApiResponse<List<Attendance>> getAttendanceByBranchIdBetweenDates(
            @PathVariable String branchId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByBranchIdBetweenDates(branchId, startDate, endDate);
        return new ApiResponse<>(attendanceList, HttpStatus.OK);
    }
}
