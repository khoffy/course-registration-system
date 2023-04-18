package edu.miu.courseregistrationsystem.dto;

import lombok.*;

/**
 * @author Rediet
 * @version 1.0
 * @created 09/12/2020 10:00 PM
 */


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class AddressDto {

    private long id;
    private String street;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryRegion;

}
