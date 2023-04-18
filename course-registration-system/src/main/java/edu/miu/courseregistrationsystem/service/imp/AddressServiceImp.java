package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.repository.AddressRepository;
import edu.miu.courseregistrationsystem.mapper.AddressMapper;
import edu.miu.courseregistrationsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 */
@Service
@Transactional
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto getAddressById(long id) {
        Address address = addressRepository.findById(id).get();
        AddressDto addressDto = addressMapper.getAddressDtoFromAddress(address);
        return addressDto;
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = addressMapper.getAddressFromAddressDto(addressDto);
        addressRepository.save(address);
        return addressDto;
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        Address address = addressMapper.getAddressFromAddressDto(addressDto);
        addressRepository.save(address);
        return addressDto;
    }

    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }

}
