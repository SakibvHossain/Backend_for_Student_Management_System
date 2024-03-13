package com.example.studentmanagementproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentAlreadyExistException extends RuntimeException{
    private String message;
    public StudentAlreadyExistException(String message){
        super(message);
        this.message = message;
    }
}
