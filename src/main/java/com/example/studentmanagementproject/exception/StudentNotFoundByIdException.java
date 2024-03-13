package com.example.studentmanagementproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentNotFoundByIdException extends RuntimeException{
   private String message;
   private Long id;
   public StudentNotFoundByIdException(String message, Long id){
       super(String.format("%s Not Found of ID: '%s'",message,id));
       this.message = message;
       this.id = id;
   }
}
