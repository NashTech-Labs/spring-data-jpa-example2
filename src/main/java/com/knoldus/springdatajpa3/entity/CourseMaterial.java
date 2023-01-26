package com.knoldus.springdatajpa3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    private  Long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(
            name = "course_Id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
