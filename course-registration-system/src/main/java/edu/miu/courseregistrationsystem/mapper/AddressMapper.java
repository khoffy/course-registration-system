package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    public Address getAddressFromAddressDto(AddressDto addressDto);

    public AddressDto getAddressDtoFromAddress(Address address);

}
