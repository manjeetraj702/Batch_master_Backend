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
        // Check if the email already exists in the database
        Optional<Student> existingStudent = studentRepository.findByEmail(studentCreateRequest.getEmail());
        if (existingStudent.isPresent()) {
            throw new IllegalArgumentException("A student with this email already exists.");
        }

        // Create a new student if email does not exist
        Student student = new Student();
        student.setStudentName(studentCreateRequest.getStudentName());
        student.setFatherName(studentCreateRequest.getFatherName());
        student.setMobileNumber(studentCreateRequest.getMobileNumber());
        student.setEmail(studentCreateRequest.getEmail());
        student.setDob(studentCreateRequest.getDob());
        student.setDegree(studentCreateRequest.getDegree());
        student.setCourse(studentCreateRequest.getCourse());
        student.setAddress(studentCreateRequest.getAddress());
        student.setBranchId(studentCreateRequest.getBranchId());
        student.setAdmissionDate(studentCreateRequest.getAdmissionDate());

        return studentRepository.save(student);
    }


    @Override
    public Student getStudentDetails(String studentId) {
        return getStudentById(studentId);

    }

    @Override
    @Override
    public Student updateStudent(StudentUpdateRequest studentUpdateRequest) {
        Student existingStudent = getStudentById(studentUpdateRequest.getId()); // Fetch existing student

        // Update only if new values are provided (avoid overwriting with null)
        if (studentUpdateRequest.getStudentName() != null) {
            existingStudent.setStudentName(studentUpdateRequest.getStudentName());
        }
        if (studentUpdateRequest.getAddress() != null) {
            existingStudent.setAddress(studentUpdateRequest.getAddress());
        }
        if (studentUpdateRequest.getCourse() != null) {
            existingStudent.setCourse(studentUpdateRequest.getCourse());
        }
        if (studentUpdateRequest.getEmail() != null) {
            existingStudent.setEmail(studentUpdateRequest.getEmail());
        }
        if (studentUpdateRequest.getDob() != null) {
            existingStudent.setDob(studentUpdateRequest.getDob());
        }
        if (studentUpdateRequest.getAdmissionDate() != null) {
            existingStudent.setAdmissionDate(studentUpdateRequest.getAdmissionDate());
        }
        if (studentUpdateRequest.getDegree() != null) {
            existingStudent.setDegree(studentUpdateRequest.getDegree());
        }

        return studentRepository.save(existingStudent); // Save updated student
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
    public Student updateStudentBatchId(String studentId, String batchId) {
        Student student = getStudentById(studentId);
        student.setBatchId(batchId);
        return studentRepository.save(student);
    }

    @Override
    public Student removeStudentFromBatch(String studentId) {
        Student student = getStudentById(studentId);
        student.setBatchId("Cage-00");
        return studentRepository.save(student);
    }


    @Override
    public List<Student> getStudentsByBatchId(String batchId) {
        return studentRepository.findAllByBatchId(batchId);
    }

    @Override
    public List<Student> getOnlineStudents(String batchId) {
        return studentRepository.findAllByBatchIdAndModeFalse(batchId);
    }

    @Override
    public List<Student> getOfflineStudents(String batchId) {
        return studentRepository.findAllByBatchIdAndModeTrue(batchId);
    }
}