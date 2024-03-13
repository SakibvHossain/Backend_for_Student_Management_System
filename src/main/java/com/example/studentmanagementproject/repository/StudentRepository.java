package com.example.studentmanagementproject.repository;

import com.example.studentmanagementproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);

}
