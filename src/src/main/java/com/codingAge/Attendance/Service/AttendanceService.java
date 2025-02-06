package com.codingAge.Attendance.Service;

import com.codingAge.Attendance.Model.Attendance;

import java.util.List;


public interface AttendanceService {
    Attendance createAttendance(String studentId, String status,String batchId);

    Attendance updateAttendance(String status,String attendanceId);

    public List<Attendance> getAttendanceByStudentId(String studentId);

    public List<Attendance> getAttendanceByBatchId(String batchId);
}
