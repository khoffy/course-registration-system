package edu.miu.courseregistrationsystem.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEventStudentDto {
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    List<RegistrationGroupStudentDto> registrationGroups;
}
