package com.example.batchmaster.repository;

import com.example.batchmaster.model.Attendance;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends MongoRepository<Attendance, String> {

    // Get attendance by studentId with pagination
    List<Attendance> findByStudentId(String studentId, Pageable pageable);

    // Get attendance by studentId and exact date
    List<Attendance> findByStudentIdAndDate(String studentId, Date date);

    // Get attendance by studentId from a specific date onward
    List<Attendance> findByStudentIdAndDateGreaterThanEqual(String studentId, Date fromDate);

    // Get attendance by studentId between two dates
    List<Attendance> findByStudentIdAndDateBetween(String studentId, Date startDate, Date endDate);

    // Get attendance by batchId with pagination
    List<Attendance> findByBatchId(String batchId, Pageable pageable);

    // Get attendance by batchId and exact date
    List<Attendance> findByBatchIdAndDate(String batchId, Date date);

    // Get attendance by batchId from a specific date onward
    List<Attendance> findByBatchIdAndDateGreaterThanEqual(String batchId, Date fromDate);

    // Get attendance by batchId between two dates
    List<Attendance> findByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate);

    // Get attendance by sessionId with pagination
    List<Attendance> findBySessionId(String sessionId, Pageable pageable);

    // Delete attendance by sessionId
// Delete attendance by sessionId
    void deleteAllBySessionId(String sessionId);

    // Get attendance by branchId with pagination
    List<Attendance> findByBranchId(String branchId, Pageable pageable);

    // Get attendance by branchId and exact date
    List<Attendance> findByBranchIdAndDate(String branchId, Date date);

    // Get attendance by branchId from a specific date onward
    List<Attendance> findByBranchIdAndDateGreaterThanEqual(String branchId, Date fromDate);

    // Get attendance by branchId between two dates
    List<Attendance> findByBranchIdAndDateBetween(String branchId, Date startDate, Date endDate);
}
