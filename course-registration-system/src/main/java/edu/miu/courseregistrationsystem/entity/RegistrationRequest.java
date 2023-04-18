package edu.miu.courseregistrationsystem.entity;

import edu.miu.courseregistrationsystem.enumeration.RegistrationRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RegistrationRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer priority;

    @Enumerated(EnumType.STRING)
    private RegistrationRequestStatus status = RegistrationRequestStatus.NEW;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private CourseOffering courseOffering;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id")
    private Student student;

}
