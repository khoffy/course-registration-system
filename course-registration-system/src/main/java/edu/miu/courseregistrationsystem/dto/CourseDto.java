package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDto {

    private long id;
    private String code;
    private String name;
    private String description;
    //TODO: Course and prerequisite are many to many
    private List<CourseDto> preRequisite;

}
