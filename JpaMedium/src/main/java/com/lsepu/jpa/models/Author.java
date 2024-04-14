package com.lsepu.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(
        name = "Author.findByNamedQuery",
        query = "select a from Author a where a.age >= :age"
)
public class Author extends BaseEntity {

    /*@Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    private Integer id;*/
    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;

    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @Column(
            insertable = false,
            nullable = false
    )
    private LocalDateTime lastModified;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
