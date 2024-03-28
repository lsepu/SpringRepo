package com.lsepu.demo.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto postStudent(
            @Valid @RequestBody StudentDto studentDto
    ){
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(
            @PathVariable(name = "student-id") Integer studentId
    ){
        return studentService.getStudentById(studentId);
    }


    @GetMapping("/students/{student-name}")
    public List<StudentResponseDto> getStudentByName(
            @PathVariable(name = "student-name") String studentName
    ){
        return studentService.getStudentByName(studentName);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var fieldMessage = error.getDefaultMessage();
                    errors.put(fieldMessage, fieldMessage);
                } );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }





}
