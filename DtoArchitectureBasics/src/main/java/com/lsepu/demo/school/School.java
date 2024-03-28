package com.lsepu.demo.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lsepu.demo.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference
    private List<Student> students;



    public School(String name) {
        this.name = name;
    }

    public School() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
