package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.AddressDto;

public interface AddressService {
    public AddressDto getAddressById(long id);
    public AddressDto createAddress(AddressDto addressDto);
    public AddressDto updateAddress(AddressDto addressDto);
    public void deleteAddress(long id);
}
