package com.lsepu.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    //which service we want to test
    @InjectMocks
    private StudentService studentService;
    //declare dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_succesfully_save_a_student(){
        StudentDto studentDto = new StudentDto(
                "John",
                "Doe",
                "johndoe@gmail.com",
                "1");

        Student student = new Student(
                "John",
                "Doe",
                "johndoe@gmail.com",
                10);

        //Mock the calls that are made in the dependency
        Mockito.when(studentMapper.toStudent(studentDto)).thenReturn(student);
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Mockito.when(studentMapper.toStudentResponseDto(student)).thenReturn(
                new StudentResponseDto("John","Doe",
                        "johndoe@gmail.com")
        );

        StudentResponseDto  studentResponseDto = studentService.saveStudent(studentDto);

        assertEquals(studentDto.firstName(),studentResponseDto.firstName());
    }

    @Test
    public void should_return_all_students(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "John",
                "Doe",
                "johndoe@gmail.com",
                10));

        //mocks
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "johndoe@gmail.com"));

        List<StudentResponseDto> studentsResponseDto = studentService.getAllStudents();
        assertEquals(students.size(),studentsResponseDto.size());
    }

}