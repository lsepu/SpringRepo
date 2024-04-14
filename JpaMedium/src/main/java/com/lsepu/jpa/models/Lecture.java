package com.lsepu.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lecture extends BaseEntity{

    private String name;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

}
