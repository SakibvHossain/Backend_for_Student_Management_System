package com.example.studentmanagementproject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String department;
    @NotEmpty
    private String batch;
}
