package com.example.batchMaster.service;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;

import java.util.List;


public interface AttendanceService {
    Attendance createAttendance(AttendanceCreateRequest attendanceCreateRequest);

    Attendance updateAttendance(String status,String attendanceId);

    public List<Attendance> getAttendanceByStudentId(String studentId);

    public List<Attendance> getAttendanceByBatchId(String batchId);

    public List<Attendance> getAttendanceByBatchIdAndDate(String batchId,String date);

    public List<Attendance> getAttendanceByStudentIdAndDate(String studentId,String date);
}
