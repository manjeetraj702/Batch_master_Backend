package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.Marks;
import com.example.batchmaster.model.Student;
import com.example.batchmaster.model.request.StudentCreateRequest;
import com.example.batchmaster.model.updaterequest.StudentUpdateRequest;
import com.example.batchmaster.repository.MarksRepository;
import com.example.batchmaster.repository.StudentRepository;
import com.example.batchmaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final MarksRepository marksRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, MarksRepository marksRepository) {
        this.studentRepository = studentRepository;
        this.marksRepository = marksRepository;
    }

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
        if (studentCreateRequest.getBatchId() != null) {
            student.setBatchId(studentCreateRequest.getBatchId());
        }

        return studentRepository.save(student);
    }


    @Override
    public Student getStudentDetails(String studentId) {
        return getStudentById(studentId);

    }

    @Override
    public Student updateStudent(StudentUpdateRequest studentUpdateRequest) {
        Student existingStudent = getStudentById(studentUpdateRequest.getStudentId());

        if (studentUpdateRequest.getStudentName() != null) {
            existingStudent.setStudentName(studentUpdateRequest.getStudentName());
        }
        if (studentUpdateRequest.getFatherName() != null) {
            existingStudent.setFatherName(studentUpdateRequest.getFatherName());
        }
        if (studentUpdateRequest.getMobileNumber() != null) {
            existingStudent.setMobileNumber(studentUpdateRequest.getMobileNumber());
        }
        if (studentUpdateRequest.getParentsPhoneNo() != null) {
            existingStudent.setParentsPhoneNo(studentUpdateRequest.getParentsPhoneNo());
        }
        Optional<Student> existingStudent2 = studentRepository.findByEmail(studentUpdateRequest.getEmail());
        if (existingStudent2.isPresent() && !existingStudent2.get().getStudentId().equals(studentUpdateRequest.getStudentId())) {
            throw new IllegalArgumentException("A student with this email already exists.");
        }
        if (studentUpdateRequest.getEmail() != null) {
            existingStudent.setEmail(studentUpdateRequest.getEmail());
        }
        if (studentUpdateRequest.getDob() != null) {
            existingStudent.setDob(studentUpdateRequest.getDob());
        }
        if (studentUpdateRequest.getImgUrl() != null) {
            existingStudent.setImgUrl(studentUpdateRequest.getImgUrl());
        }
        if (studentUpdateRequest.getDegree() != null) {
            existingStudent.setDegree(studentUpdateRequest.getDegree());
        }
        if (studentUpdateRequest.getCourse() != null) {
            existingStudent.setCourse(studentUpdateRequest.getCourse());
        }
        if (studentUpdateRequest.getAddress() != null) {
            existingStudent.setAddress(studentUpdateRequest.getAddress());
        }
        if (studentUpdateRequest.getBranchId() != null) {
            existingStudent.setBranchId(studentUpdateRequest.getBranchId());
        }
        if (studentUpdateRequest.getBatchId() != null) {
            existingStudent.setBatchId(studentUpdateRequest.getBatchId());
        }
        if (studentUpdateRequest.getAdmissionDate() != null) {
            existingStudent.setAdmissionDate(studentUpdateRequest.getAdmissionDate());
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

    //for image only

    @Override
    public boolean updateStudentImage(String studentId, String imgUrl) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setImgUrl(imgUrl); // Update only the image URL
            studentRepository.save(student);
            return true;
        }
        return false;
    }
}