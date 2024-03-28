package com.lsepu.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;
    @BeforeEach
    void setUp(){
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDto studentDto = new StudentDto(
                "John",
                "Doe",
                "johndoe@gmail.com",
                "1");

        Student student = mapper.toStudent(studentDto);
        assertEquals(studentDto.firstName(),student.getFirstName());
        assertEquals(studentDto.lastName(),student.getLastName());
        assertEquals(studentDto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(studentDto.schoolId(), student.getSchool().getId());

    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){
        //Given
        Student student = new Student(
                "Jane",
                "Smith",
                "jane@email.com",
                20);

        //When
        StudentResponseDto studentResponseDto = mapper.toStudentResponseDto(student);

        //Then
        assertEquals(student.getFirstName(), studentResponseDto.firstName());

    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
    }

}