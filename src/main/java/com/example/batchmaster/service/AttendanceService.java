package com.example.batchmaster.service;

import com.example.batchmaster.model.Attendance;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.updaterequest.AttendanceUpdateRequest;

import java.util.List;


public interface AttendanceService {
    Attendance createAttendance(AttendanceCreateRequest attendanceCreateRequest);

    Attendance getByAttendanceId(String attendenceId);

    Attendance updateAttendance(AttendanceUpdateRequest attendanceUpdateRequest);

    List<Attendance> getAttendanceByStudentId(String studentId);

    List<Attendance> getAttendanceByBatchId(String batchId);

    List<Attendance> getAttendanceByBatchIdAndDate(String batchId, String date);

    List<Attendance> getAttendanceByStudentIdAndDate(String studentId, String date);

    void deleteAttendanceBySessionId(String sessionId);

    List<Attendance> getAttendanceBySessionId(String sessionId);
}
