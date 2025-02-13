package com.example.batchMaster.repository;

import com.example.batchMaster.model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByBatchId(String batchId);

    List<Attendance> findByStudentId(String studentId);

    List<Attendance> findByBatchIdAndDate(String batchId, String date);

    List<Attendance> findByStudentIdAndDate(String studentId, String date);

}
