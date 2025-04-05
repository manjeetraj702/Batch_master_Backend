package com.example.batchmaster.repository;

import com.example.batchmaster.model.Attendance;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {

    // By Student
    List<Attendance> findByStudentId(String studentId, Pageable pageable);

    List<Attendance> findByStudentIdAndDate(String studentId, Instant date);

    List<Attendance> findByStudentIdAndDateGreaterThanEqual(String studentId, Instant fromDate);

    List<Attendance> findByStudentIdAndDateBetween(String studentId, Instant startDate, Instant endDate);

    // By Batch
    List<Attendance> findByBatchId(String batchId, Pageable pageable);

    List<Attendance> findByBatchIdAndDate(String batchId, Instant date);

    List<Attendance> findByBatchIdAndDateGreaterThanEqual(String batchId, Instant fromDate);

    List<Attendance> findByBatchIdAndDateBetween(String batchId, Instant startDate, Instant endDate);

    // By Session
    List<Attendance> findBySessionId(String sessionId, Pageable pageable);

    void deleteAllBySessionId(String sessionId);

    // By Branch
    List<Attendance> findByBranchId(String branchId, Pageable pageable);

    List<Attendance> findByBranchIdAndDate(String branchId, Instant date);

    List<Attendance> findByBranchIdAndDateGreaterThanEqual(String branchId, Instant fromDate);

    List<Attendance> findByBranchIdAndDateBetween(String branchId, Instant startDate, Instant endDate);
}
