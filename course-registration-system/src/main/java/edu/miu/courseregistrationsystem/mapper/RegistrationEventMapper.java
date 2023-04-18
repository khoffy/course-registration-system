package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventStudentDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:11 AM
 */

@Mapper(componentModel = "spring")
public interface RegistrationEventMapper {

    public RegistrationEvent registrationEventFromRegistrationEventDto(RegistrationEventDto registrationEventDto);

    public RegistrationEventDto registrationEventDtoFromRegistrationEvent(RegistrationEvent registrationEvent);
    public List<RegistrationEventDto> registrationEventDtosFromRegistrationEvents(List<RegistrationEvent> registrationEvents);
    public List<RegistrationEvent> registrationEventsFromRegistrationEventDtos(List<RegistrationEventDto> registrationEventDtos);

}
