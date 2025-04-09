package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.Attendance;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.updaterequest.AttendanceUpdateRequest;
import com.example.batchmaster.repository.AttendanceRepository;
import com.example.batchmaster.service.AttendanceService;
import com.example.batchmaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
        attendance.setBranchId(attendanceCreateRequest.getBranchId());
        attendance.setBatchId(attendanceCreateRequest.getBatchId());
        attendance.setDate(attendanceCreateRequest.getDate());
        attendance.setSubject(attendanceCreateRequest.getSubject());
        return attendanceRepository.save(attendance);
    }

    @Override
    public Optional<Attendance> getByAttendanceId(String attendanceId) {
        return attendanceRepository.findById(attendanceId);
    }

    @Transactional
    @Override
    public Attendance updateAttendance(AttendanceUpdateRequest attendanceUpdateRequest) {
        Attendance attendance = getByAttendanceId(attendanceUpdateRequest.getAttendanceId())
                .orElseThrow(() -> new BatchMasterException("Attendance not present with this id."));
        attendance.setDate(attendanceUpdateRequest.getDate());
        attendance.setStudentId(attendanceUpdateRequest.getStudentId());
        attendance.setStatus(attendanceUpdateRequest.isStatus());
        attendance.setMode(attendanceUpdateRequest.getMode());
        attendance.setBatchId(attendanceUpdateRequest.getBatchId());
        attendance.setSubject(attendanceUpdateRequest.getSubject());
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByStudentId(String studentId, int page, int size) {
        return attendanceRepository.findByStudentId(studentId, PageRequest.of(page, size));
    }

    @Override
    public List<Attendance> getAttendanceByStudentIdAndDate(String studentId, Instant date) {
        return attendanceRepository.findByStudentIdAndDate(studentId, date);
    }

    @Override
    public List<Attendance> getAttendanceByStudentIdFromDate(String studentId, Instant fromDate) {
        return attendanceRepository.findByStudentIdAndDateGreaterThanEqual(studentId, fromDate);
    }

    @Override
    public List<Attendance> getAttendanceByStudentIdBetweenDates(String studentId, Instant startDate, Instant endDate) {
        return attendanceRepository.findByStudentIdAndDateBetween(studentId, startDate, endDate);
    }

    @Override
    public List<Attendance> getAttendanceByBatchId(String batchId, int page, int size) {
        return attendanceRepository.findByBatchId(batchId, PageRequest.of(page, size));
    }

    @Override
    public List<Attendance> getAttendanceByBatchIdAndDate(String batchId, Instant date) {
        return attendanceRepository.findByBatchIdAndDate(batchId, date);
    }

    @Override
    public List<Attendance> getAttendanceByBatchIdFromDate(String batchId, Instant fromDate) {
        return attendanceRepository.findByBatchIdAndDateGreaterThanEqual(batchId, fromDate);
    }

    @Override
    public List<Attendance> getAttendanceByBatchIdBetweenDates(String batchId, Instant startDate, Instant endDate) {
        return attendanceRepository.findByBatchIdAndDateBetween(batchId, startDate, endDate);
    }

    @Override
    public List<Attendance> getAttendanceBySessionId(String sessionId, int page, int size) {
        return attendanceRepository.findBySessionId(sessionId, PageRequest.of(page, size));
    }

    @Override
    @Transactional
    public void deleteAttendanceBySessionId(String sessionId) {
        attendanceRepository.deleteAllBySessionId(sessionId);
    }

    // For Branch

    @Override
    public List<Attendance> getAttendanceByBranchId(String branchId, int page, int size) {
        return attendanceRepository.findByBranchId(branchId, PageRequest.of(page, size));
    }

    @Override
    public List<Attendance> getAttendanceByBranchIdAndDate(String branchId, Instant date) {
        return attendanceRepository.findByBranchIdAndDate(branchId, date);
    }

    @Override
    public List<Attendance> getAttendanceByBranchIdFromDate(String branchId, Instant fromDate) {
        return attendanceRepository.findByBranchIdAndDateGreaterThanEqual(branchId, fromDate);
    }

    @Override
    public List<Attendance> getAttendanceByBranchIdBetweenDates(String branchId, Instant startDate, Instant endDate) {
        return attendanceRepository.findByBranchIdAndDateBetween(branchId, startDate, endDate);
    }
}
