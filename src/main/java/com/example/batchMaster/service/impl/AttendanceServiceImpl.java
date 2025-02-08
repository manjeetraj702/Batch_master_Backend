package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
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
    public Attendance createAttendance(AttendanceCreateRequest attendanceCreateRequest) {
        Attendance attendance = new Attendance();
        attendance.setStudentId(attendanceCreateRequest.getStudentId());
        attendance.setStatus(attendanceCreateRequest.getStatus());
        attendance.setBatchId(attendanceCreateRequest.getBatchId());
        attendance.setDate(attendanceCreateRequest.getDate());
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

    @Override
    public List<Attendance> getAttendanceByBatchIdAndDate(String batchId, String date) {
        return attendanceRepository.findByBatchIdAndDate(batchId,date);
    }

    @Override
    public List<Attendance> getAttendanceByStudentIdAndDate(String studentId, String date) {
        return attendanceRepository.findByStudentIdAndDate(studentId,date);
    }
}
