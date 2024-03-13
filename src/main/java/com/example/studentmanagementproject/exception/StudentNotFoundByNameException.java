package com.example.studentmanagementproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundByNameException extends RuntimeException{
    private String message;
    public StudentNotFoundByNameException(String message){
        super(message);
        this.message = message;
    }
}
