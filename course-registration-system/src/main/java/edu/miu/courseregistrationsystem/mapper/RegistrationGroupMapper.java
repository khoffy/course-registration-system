package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationEventStudentDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:04 AM
 */
@Mapper(componentModel = "spring")
public interface RegistrationGroupMapper {

    public RegistrationGroup registrationGroupFromRegistrationGroupDto(RegistrationGroupDto registrationGroupDto);
    public RegistrationGroupDto registrationGroupDtoFromRegistrationGroup(RegistrationGroup registrationGroup);
    public List<RegistrationGroupDto> registrationGroupDtosFromRegistrationGroups(List<RegistrationGroup> registrationGroups);
    public List<RegistrationGroup> registrationGroupsFromRegistrationGroupDtos(List<RegistrationGroupDto> registrationGroupDtos);
}
