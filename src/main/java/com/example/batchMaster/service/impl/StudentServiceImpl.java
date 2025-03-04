package com.example.batchMaster.service.impl;

import com.example.batchMaster.exception.BatchMasterException;
import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;
import com.example.batchMaster.repository.MarksRepository;
import com.example.batchMaster.repository.StudentRepository;
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
        student.setParentsPhoneNo(studentCreateRequest.getParentsPhoneNo());
        student.setMobileNumber(studentCreateRequest.getMobileNumber());
        student.setEmail(studentCreateRequest.getEmail());
        student.setDob(studentCreateRequest.getDob());
        student.setDegree(studentCreateRequest.getDegree());
        student.setCourse(studentCreateRequest.getCourse());
        student.setAddress(studentCreateRequest.getAddress());
        student.setBranchId(studentCreateRequest.getBranchId());
        student.setAdmissionDate(studentCreateRequest.getAdmissionDate());
        student.setImgUrl(studentCreateRequest.getImgUrl());
        student.setStudyMode(studentCreateRequest.isStudyMode());
        student.setBatchId(studentCreateRequest.getBatchId());

        return studentRepository.save(student);
    }


    @Override
    public Student getStudentDetails(String studentId) {
        return getStudentById(studentId);

    }

    @Override
    public Student updateStudent(StudentUpdateRequest studentUpdateRequest) {
        Student existingStudent = getStudentById(studentUpdateRequest.getId());


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
        student.setActiveStatus(!student.isActiveStatus());
        return student;
    }

    @Override
    public List<Marks> getListOfMarks(String studentId) {
        return marksRepository.findAllByStudentId(studentId);
    }


    @Override
    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new BatchMasterException("Student is not present"));
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
        return studentRepository.findAllByBatchIdAndStudyModeFalse(batchId);
    }

    @Override
    public List<Student> getOfflineStudents(String batchId) {
        return studentRepository.findAllByBatchIdAndStudyModeTrue(batchId);
    }

    @Override
    public List<Student> getStudentsByBranchId(String branchId) {
        return studentRepository.findAllByBranchId(branchId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByEmailId(String emailId) {
        return studentRepository.findByEmail(emailId).orElseThrow(() -> new BatchMasterException("Sudent not found with emailId"));
    }
}