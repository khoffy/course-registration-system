package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Feven
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDto {

    private long id;
    private CourseOffering courseOffering;
    private Student student;
}
