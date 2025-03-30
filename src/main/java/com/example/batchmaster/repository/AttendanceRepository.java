package com.example.batchmaster.repository;

import com.example.batchmaster.model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByBatchId(String batchId);

    List<Attendance> findByStudentId(String studentId);

    List<Attendance> findByBatchIdAndDate(String batchId, String date);

    List<Attendance> findByStudentIdAndDate(String studentId, String date);


    void deleteAllBySessionId(String sessionId);

    List<Attendance> findAllBySessionId(String sessionId);
}
