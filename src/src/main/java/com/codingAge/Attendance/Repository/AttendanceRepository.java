package com.codingAge.Attendance.Repository;

import com.codingAge.Attendance.Model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance,String> {
    List<Attendance> findByBatchId(String batchId);
    List<Attendance> findByStudentId(String studentId);
}
