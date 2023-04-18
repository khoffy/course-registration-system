package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationDto;
import edu.miu.courseregistrationsystem.entity.Registration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Feven
 * @version 1.0
 * @created 10/12/2020 12:10 AM
 */
@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    public Registration getRegistrationFromRegistrationDto(RegistrationDto registrationDto);
    public RegistrationDto registrationDtoFromRegistration(Registration registration);
    public List<RegistrationDto> registrationDtoFromRegistration(List<Registration> registration);
    public List<Registration> registrationFromRegistrationDto(List<RegistrationDto> registrationDto);
}
