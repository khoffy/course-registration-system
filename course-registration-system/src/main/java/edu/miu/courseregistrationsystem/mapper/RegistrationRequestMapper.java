package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistrationRequestMapper {
    RegistrationRequest registrationRequestDtoToRegistrationRequest(RegistrationRequestDto registrationRequestDto);

    RegistrationRequestDto registrationRequestToRegistrationRequestDto(RegistrationRequest registrationRequest);

    List<RegistrationRequest> registrationRequestDtosToRegistrationRequests(List<RegistrationRequestDto> registrationRequestDtos);

    List<RegistrationRequestDto> registrationRequestsToRegistrationRequestDtos(List<RegistrationRequest> registrationRequests);


}
