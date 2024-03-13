package com.example.studentmanagementproject.exception.global;

import com.example.studentmanagementproject.exception.ErrorDetails;
import com.example.studentmanagementproject.exception.StudentAlreadyExistException;
import com.example.studentmanagementproject.exception.StudentNotFoundByIdException;
import com.example.studentmanagementproject.exception.StudentNotFoundByNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundByNameException.class)
    public ResponseEntity<ErrorDetails> handleStudentNotFoundByNameException(StudentNotFoundByNameException exception, WebRequest request){
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "Student_Not_Found"
        );
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentNotFoundByIdException.class)
    public  ResponseEntity<ErrorDetails> handleStudentNotFoundByIdException(StudentNotFoundByIdException exception, WebRequest request){
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "Student_Not_Found"
        );
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleStudentAlreadyExist(StudentAlreadyExistException exception, WebRequest request){
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "Student_Found_Exception"
        );
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest request){
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "Internal Server Error"
        );
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

}
