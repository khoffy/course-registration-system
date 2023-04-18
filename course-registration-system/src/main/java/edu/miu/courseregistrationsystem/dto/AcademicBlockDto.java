package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicBlockDto {
    private long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<CourseOffering> courseOfferings;


}
