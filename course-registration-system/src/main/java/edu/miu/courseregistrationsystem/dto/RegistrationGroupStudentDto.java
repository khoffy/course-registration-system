package edu.miu.courseregistrationsystem.dto;

import lombok.*;

import java.util.List;
/**
 * @author Redie
 * @version 1.0
 * @created 19/12/2020 5:57 PM
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegistrationGroupStudentDto {
    long id;
    private List<AcademicBlockStudentDto> academicBlocks;

}
