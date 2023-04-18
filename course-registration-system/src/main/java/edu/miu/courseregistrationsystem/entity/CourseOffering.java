package edu.miu.courseregistrationsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data @Setter @Getter
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private Long capacity;
    private Long availableSeats;
    private String initials;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL})
    private Course course;
    @ManyToOne(cascade = CascadeType.ALL)
    private Faculty faculty;


    public void initial(){
        String[] initial = new String[2];
        initial = faculty.getName().split(" ");

        char firstName = initial[0].charAt(0);
        char secondName = initial[1].charAt(0);

        this.initials = "" + firstName + secondName;
        this.code += "-" + this.initials;
    }
}
