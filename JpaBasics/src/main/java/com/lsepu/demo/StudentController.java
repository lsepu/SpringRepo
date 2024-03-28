package com.lsepu.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student postStudent(
            @RequestBody Student student
    ){
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student getStudentById(
            @PathVariable(name = "student-id") Integer studentId
    ){
        return repository.findById(studentId)
                .orElse(new Student());
    }

    //usa nuevo metodo creado en StudentRepository
    @GetMapping("/students/{student-name}")
    public List<Student> getStudentByName(
            @PathVariable(name = "student-name") String studentName
    ){
        return repository.findAllByFirstNameContaining(studentName);
    }



}
