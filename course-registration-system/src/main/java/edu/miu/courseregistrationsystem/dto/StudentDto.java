package edu.miu.courseregistrationsystem.dto;


import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StudentDto {
    private long id;
    private String name;
    private String email;
    private AddressDto mailingAddress;
    private AddressDto homeAddress;

    private List<RegistrationRequestDto> requests;
//    @Data
//    public static class Address {
//        private long id;
//        private String street;
//        private String city;
//        private String postalCode;
//        private String stateProvince;
//        private String countryRegion;
//    }
}
