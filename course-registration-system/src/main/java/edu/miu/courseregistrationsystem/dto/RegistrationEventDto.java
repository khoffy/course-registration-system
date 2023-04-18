package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import lombok.*;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class RegistrationEventDto {
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private
    List<RegistrationGroupDto> registrationGroups;
}
