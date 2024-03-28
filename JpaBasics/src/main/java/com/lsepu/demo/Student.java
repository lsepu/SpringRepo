package com.lsepu.demo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="T_STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;

    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstName;
    private String lastName;
    private String email;
    private int name;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, String email, int name) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
