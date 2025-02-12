package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
import com.example.batchMaster.repository.AttendanceRepository;
import com.example.batchMaster.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        attendance.setStatus(attendanceCreateRequest.isStatus());
        attendance.setBatchId(attendanceCreateRequest.getBatchId());
        attendance.setDate(attendanceCreateRequest.getDate());
        return attendanceRepository.save(attendance);
    }


    @Override
    public Attendance updateAttendance(String attendanceID) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findById(attendanceID);
        if (attendanceOptional.isPresent()) {
            Attendance attendance = attendanceOptional.get();
            attendance.setStatus(!attendanceOptional.get().isStatus());
            return attendanceRepository.save(attendance);
        } else {
            throw new RuntimeException("Attendance record not found with ID: " + attendanceID);
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

    @Override
    public void createAttendanceForBatch(List<String> absentStudentIds, List<String> presentStudentIds, String batchId, String date) {
        List<Attendance> attendances = new ArrayList<>();

        // Mark present students
        for (String studentId : presentStudentIds) {

            Attendance attendance = new Attendance();
            attendance.setStudentId(studentId);
            attendance.setStatus(true);
            attendance.setBatchId(batchId);
            attendance.setDate(date);
            attendances.add(attendance);
        }

        // Mark absent students
        for (String studentId : absentStudentIds) {
            Attendance attendance = new Attendance();
            attendance.setStudentId(studentId);
            attendance.setStatus(false);
            attendance.setBatchId(batchId);
            attendance.setDate(date);
            attendances.add(attendance);
        }

        attendanceRepository.saveAll(attendances);
    }

}
