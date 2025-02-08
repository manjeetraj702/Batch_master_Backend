package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.repository.AttendanceRepository;
import com.example.batchMaster.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
        @Autowired
    AttendanceRepository attendanceRepository;
    @Override
    public Attendance createAttendance(String studentId, String status,String batchId) {
        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId);
        attendance.setStatus(status);
        attendance.setBatchId(batchId);
        attendance.setDate(LocalDate.now().toString());
        return attendanceRepository.save(attendance);
    }


    @Override
    public Attendance updateAttendance(String status,String attendanceID) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findById(attendanceID);
        if (attendanceOptional.isPresent()) {
            Attendance attendance = attendanceOptional.get();
            attendance.setStatus(status);
            return attendanceRepository.save(attendance);
        } else {
            return null;
        }
    }
    @Override
    public List<Attendance> getAttendanceByStudentId(String studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    @Override
    public List<Attendance> getAttendanceByBatchId(String batchId) {
        return attendanceRepository.findByBatchId(batchId);
    }
}
