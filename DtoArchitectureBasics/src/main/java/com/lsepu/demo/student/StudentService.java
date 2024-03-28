package com.lsepu.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentDto studentDto
    ) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto getStudentById(
            Integer studentId
    ){
        return repository.findById(studentId)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    //usa nuevo metodo creado en StudentRepository
    public List<StudentResponseDto> getStudentByName(
            String studentName
    ){
        return repository.findAllByFirstNameContaining(studentName)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

}
