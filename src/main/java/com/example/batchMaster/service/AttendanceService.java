package com.example.batchMaster.service;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;

import java.util.List;


public interface AttendanceService {
    Attendance createAttendance(AttendanceCreateRequest attendanceCreateRequest);

    Attendance updateAttendance(String attendanceId);

     List<Attendance> getAttendanceByStudentId(String studentId);

    List<Attendance> getAttendanceByBatchId(String batchId);

     List<Attendance> getAttendanceByBatchIdAndDate(String batchId,String date);

     List<Attendance> getAttendanceByStudentIdAndDate(String studentId,String date);
}
