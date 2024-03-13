package com.example.studentmanagementproject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    //I have created this class for custom exception
    private LocalDateTime time;
    private String message;
    private String path;
    private String error;
}
