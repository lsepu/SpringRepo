package com.lsepu.jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance
//@PrimaryKeyJoinColumn(name = "video_id") -- only with JOIN Strategy
//@DiscriminatorValue("V") -- only with single table
public class Video extends Resource {

    private int length;
}
