package com.lsepu.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository repository;

    public SchoolController(SchoolRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/school")
    public School createSchool(
            @RequestBody School school
    ) {
        return repository.save(school);
    }

    @GetMapping("/schools")
    public List<School> getAllSchools(){
        return repository.findAll();
    }
}
