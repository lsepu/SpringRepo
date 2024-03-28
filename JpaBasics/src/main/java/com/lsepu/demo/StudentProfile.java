package com.lsepu.demo;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private String id;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    private String bio;

    public StudentProfile() {
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
