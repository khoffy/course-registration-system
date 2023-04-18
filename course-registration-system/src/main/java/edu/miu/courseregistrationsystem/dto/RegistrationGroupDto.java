package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.Student;
import lombok.*;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationGroupDto {
    long id;
    private List<StudentDto> students;

    private List<AcademicBlockDto> academicBlocks;
}
