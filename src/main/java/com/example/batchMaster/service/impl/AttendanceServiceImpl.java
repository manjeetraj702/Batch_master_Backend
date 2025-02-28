package com.example.batchMaster.service.impl;

import com.example.batchMaster.exception.BatchMasterException;
import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
import com.example.batchMaster.model.updateRequest.AttendanceUpdateRequest;
import com.example.batchMaster.repository.AttendanceRepository;
import com.example.batchMaster.service.AttendanceService;
import com.example.batchMaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    BatchService batchService;

    @Override
    public Attendance createAttendance(AttendanceCreateRequest attendanceCreateRequest) {

        batchService.getBatchById(attendanceCreateRequest.getBatchId());
        Attendance attendance = new Attendance();
        attendance.setStudentId(attendanceCreateRequest.getStudentId());
        attendance.setStatus(attendanceCreateRequest.isStatus());
        attendance.setMode(attendanceCreateRequest.getMode());
        attendance.setSessionId(attendanceCreateRequest.getSessionId());
        attendance.setBatchId(attendanceCreateRequest.getBatchId());
        attendance.setDate(new Date());
        attendance.setSubject(attendanceCreateRequest.getSubject());
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance getByAttendanceId(String attendenceId) {
        return attendanceRepository.findById(attendenceId).orElseThrow(() -> new BatchMasterException("Attendance not present with this id."));

    }


    @Override
    public Attendance updateAttendance(AttendanceUpdateRequest attendanceUpdateRequest) {
        Attendance attendance = getByAttendanceId(attendanceUpdateRequest.getAttendanceId());
        attendance.setStudentId(attendanceUpdateRequest.getStudentId());
        attendance.setStatus(attendanceUpdateRequest.isStatus());
        attendance.setMode(attendanceUpdateRequest.getMode());
        attendance.setBatchId(attendanceUpdateRequest.getBatchId());
        attendance.setSubject(attendanceUpdateRequest.getSubject());
        return attendanceRepository.save(attendance);
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
        return attendanceRepository.findByBatchIdAndDate(batchId, date);
    }

    @Override
    public List<Attendance> getAttendanceByStudentIdAndDate(String studentId, String date) {
        return attendanceRepository.findByStudentIdAndDate(studentId, date);
    }

    @Override
    public List<Attendance> getAttendanceBySessionId(String sessionId) {
        return attendanceRepository.findAllBySessionId(sessionId);
    }

    @Override
    public void deleteAttendanceBySessionId(String sessionId) {
        attendanceRepository.deleteAllBySessionId(sessionId);
    }


}
