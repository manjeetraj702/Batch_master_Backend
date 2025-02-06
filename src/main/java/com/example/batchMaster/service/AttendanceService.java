package com.example.batchMaster.service;

import com.example.batchMaster.model.Attendance;

import java.util.List;


public interface AttendanceService {
    Attendance createAttendance(String studentId, String status,String batchId);

    Attendance updateAttendance(String status,String attendanceId);

    public List<Attendance> getAttendanceByStudentId(String studentId);

    public List<Attendance> getAttendanceByBatchId(String batchId);
}
