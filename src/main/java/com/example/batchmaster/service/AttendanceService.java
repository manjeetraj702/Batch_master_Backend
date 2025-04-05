package com.example.batchmaster.service;

import com.example.batchmaster.model.Attendance;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.updaterequest.AttendanceUpdateRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AttendanceService {

    Attendance createAttendance(AttendanceCreateRequest attendanceCreateRequest);

    Optional<Attendance> getByAttendanceId(String attendanceId);

    Attendance updateAttendance(AttendanceUpdateRequest attendanceUpdateRequest);

    // For Student
    List<Attendance> getAttendanceByStudentId(String studentId, int page, int size);

    List<Attendance> getAttendanceByStudentIdAndDate(String studentId, Date date);

    List<Attendance> getAttendanceByStudentIdFromDate(String studentId, Date fromDate);

    List<Attendance> getAttendanceByStudentIdBetweenDates(String studentId, Date startDate, Date endDate);

    // For Batch
    List<Attendance> getAttendanceByBatchId(String batchId, int page, int size);

    List<Attendance> getAttendanceByBatchIdAndDate(String batchId, Date date);

    List<Attendance> getAttendanceByBatchIdFromDate(String batchId, Date fromDate);

    List<Attendance> getAttendanceByBatchIdBetweenDates(String batchId, Date startDate, Date endDate);

    // For Session
    List<Attendance> getAttendanceBySessionId(String sessionId, int page, int size);

    // Deletion
    void deleteAttendanceBySessionId(String sessionId);

    // For Branch
    List<Attendance> getAttendanceByBranchId(String branchId, int page, int size);

    List<Attendance> getAttendanceByBranchIdAndDate(String branchId, Date date);

    List<Attendance> getAttendanceByBranchIdFromDate(String branchId, Date fromDate);

    List<Attendance> getAttendanceByBranchIdBetweenDates(String branchId, Date startDate, Date endDate);
}}
