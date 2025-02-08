package com.example.batchMaster.service.impl;

import com.example.batchMaster.exception.BatchMasterException;
import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;
import com.example.batchMaster.repository.MarksRepository;
import com.example.batchMaster.repository.StudentRepository;
import com.example.batchMaster.service.AttendanceService;
import com.example.batchMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MarksRepository marksRepository;

    @Autowired
    AttendanceService attendanceService;


    @Override
    public Student createStudent(StudentCreateRequest studentCreateRequest) {


        Student student = new Student();
        student.setStudentName(studentCreateRequest.getName());
        student.setCourse(studentCreateRequest.getCourse());
        student.setEmail(studentCreateRequest.getEmail());
        student.setDob(studentCreateRequest.getDob());
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentDetails(String studentId) {
        return getStudentById(studentId);

    }

    @Override
    public Student updateStudent(StudentUpdateRequest studentUpdateRequest) {
      getStudentById(studentUpdateRequest.getId());
            Student student = new Student();
            student.setStudentId(studentUpdateRequest.getId());
            student.setStudentName(studentUpdateRequest.getName());
            student.setCourse(studentUpdateRequest.getCourse());
            student.setEmail(studentUpdateRequest.getEmail());
            student.setDob(studentUpdateRequest.getDob());
            return studentRepository.save(student);

    }



    @Override
    public Student changeStudentStatus(String studentId) {
        Student student = getStudentById(studentId);
        student.setStatus(!student.isStatus());
        return student;
    }

    @Override
    public List<Marks> getListOfMarks(String studentId) {
        return marksRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<Attendance> getListOfAttendance(String studentId) {
        return attendanceService.getAttendanceByStudentId(studentId);
    }

    @Override
    public Student getStudentById(String studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent())
        {
            return student.get();
        }

        throw  new BatchMasterException("Student is not present");
    }

    @Override
    public List<Student> getStudentsByBatchId(String batchId) {
        return studentRepository.findAllByBatchId(batchId);
    }
}