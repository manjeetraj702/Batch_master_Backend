package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.Attendance;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.updaterequest.AttendanceUpdateRequest;
import com.example.batchmaster.repository.AttendanceRepository;
import com.example.batchmaster.service.AttendanceService;
import com.example.batchmaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final BatchService batchService;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, BatchService batchService) {
        this.attendanceRepository = attendanceRepository;
        this.batchService = batchService;
    }

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
