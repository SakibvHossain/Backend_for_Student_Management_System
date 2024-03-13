package com.example.studentmanagementproject.controller;

import com.example.studentmanagementproject.dto.StudentDTO;
import com.example.studentmanagementproject.exception.ErrorDetails;
import com.example.studentmanagementproject.exception.StudentAlreadyExistException;
import com.example.studentmanagementproject.exception.StudentNotFoundByIdException;
import com.example.studentmanagementproject.exception.StudentNotFoundByNameException;
import com.example.studentmanagementproject.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentController {
    private StudentService service;

    @PostMapping("create")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO dto) {
        return new ResponseEntity<>(service.createStudent(dto), HttpStatus.CREATED);
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable Long id) {
        return new ResponseEntity<>(service.findStudentById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("byName/{name}")
    public ResponseEntity<StudentDTO> getStudentByName(@PathVariable("name") String studentName) {
        return new ResponseEntity<>(service.findStudentByName(studentName), HttpStatus.ACCEPTED);
    }

    @GetMapping("allStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return new ResponseEntity<>(service.allStudents(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable Long id) {
        service.deleteStudent(id);
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}