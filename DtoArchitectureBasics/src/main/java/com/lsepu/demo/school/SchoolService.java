package com.lsepu.demo.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final SchoolRepository repository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository repository) {
        this.schoolMapper = schoolMapper;
        this.repository = repository;
    }

    public SchoolDto createSchool(
              SchoolDto dto
    ) {
        var school = schoolMapper.toSchool(dto);
        repository.save(school);
        return dto;
    }


    public List<SchoolDto> getAllSchools(){
        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }


}
