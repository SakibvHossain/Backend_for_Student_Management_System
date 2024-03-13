package com.example.studentmanagementproject.service.implementation;

import com.example.studentmanagementproject.dto.StudentDTO;
import com.example.studentmanagementproject.entity.Student;
import com.example.studentmanagementproject.exception.StudentAlreadyExistException;
import com.example.studentmanagementproject.exception.StudentNotFoundByIdException;
import com.example.studentmanagementproject.exception.StudentNotFoundByNameException;
import com.example.studentmanagementproject.repository.StudentRepository;
import com.example.studentmanagementproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;
    private ModelMapper mapper;
    @Override
    public StudentDTO createStudent(StudentDTO dto) {
        Student student = mapper.map(dto, Student.class);
        if (repository.findByName(student.getName())!=null){
            throw new StudentAlreadyExistException(student.getName()+" Already exist");
        }
        Student saveStudent = repository.save(student);
        return mapper.map(saveStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO findStudentByName(String name) {
        Student student = repository.findByName(name);
        if (student == null) {
            throw new StudentNotFoundByNameException("Student Not Found By Name "+name);
        }
        return mapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> allStudents(){
        List<Student> students = repository.findAll();
        return students.stream().map((student) -> mapper.map(student, StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        Student student = repository.findById(id).orElseThrow(
                () -> new StudentNotFoundByIdException("Student", id)
        );
        return mapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudent(Long id) {
        Student findingStudentID = repository.findById(id).orElseThrow(
                () -> new StudentNotFoundByIdException("Student",id)
        );
        repository.deleteById(id);
    }
}
