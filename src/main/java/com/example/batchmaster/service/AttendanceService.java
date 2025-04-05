package com.example.batchmaster.service;

import com.example.batchmaster.model.Attendance;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.updaterequest.AttendanceUpdateRequest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface AttendanceService {

    Attendance createAttendance(AttendanceCreateRequest attendanceCreateRequest);

    Optional<Attendance> getByAttendanceId(String attendanceId);

    Attendance updateAttendance(AttendanceUpdateRequest attendanceUpdateRequest);

    // For Student
    List<Attendance> getAttendanceByStudentId(String studentId, int page, int size);

    List<Attendance> getAttendanceByStudentIdAndDate(String studentId, Instant date);

    List<Attendance> getAttendanceByStudentIdFromDate(String studentId, Instant fromDate);

    List<Attendance> getAttendanceByStudentIdBetweenDates(String studentId, Instant startDate, Instant endDate);

    // For Batch
    List<Attendance> getAttendanceByBatchId(String batchId, int page, int size);

    List<Attendance> getAttendanceByBatchIdAndDate(String batchId, Instant date);

    List<Attendance> getAttendanceByBatchIdFromDate(String batchId, Instant fromDate);

    List<Attendance> getAttendanceByBatchIdBetweenDates(String batchId, Instant startDate, Instant endDate);

    // For Session
    List<Attendance> getAttendanceBySessionId(String sessionId, int page, int size);

    // Deletion
    void deleteAttendanceBySessionId(String sessionId);

    // For Branch
    List<Attendance> getAttendanceByBranchId(String branchId, int page, int size);

    List<Attendance> getAttendanceByBranchIdAndDate(String branchId, Instant date);

    List<Attendance> getAttendanceByBranchIdFromDate(String branchId, Instant fromDate);

    List<Attendance> getAttendanceByBranchIdBetweenDates(String branchId, Instant startDate, Instant endDate);
}
