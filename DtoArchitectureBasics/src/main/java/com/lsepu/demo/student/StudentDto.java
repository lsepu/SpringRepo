package com.lsepu.demo.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(

        @NotEmpty(message = "FirstName should not be empty")
        String firstName,
        @NotEmpty(message = "lastName should not be empty")
        String lastName,
        String email,
        String schoolId
) {
}
