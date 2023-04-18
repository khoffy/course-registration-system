package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
/**
 * @author REDIET
 * @version 1.0
 * @created 17-Dec-2022 10:00:00 AM
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * The code for the course offering
     *
     * 2020-09-01D
     */
    private String code;
    /**
     * The name of the academic block
     */
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CourseOffering> courseOfferings;


    public void addCourseOffering(CourseOffering courseOffering){
        this.courseOfferings.add(courseOffering);
    }
}
