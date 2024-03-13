package com.example.studentmanagementproject.service;

import com.example.studentmanagementproject.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    //Create student
    StudentDTO createStudent(StudentDTO dto);
    StudentDTO findStudentByName(String name);
    StudentDTO findStudentById(Long id);
    void deleteStudent(Long id);
    List<StudentDTO> allStudents();
}
