package edu.miu.courseregistrationsystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author REDIET
 * @version 1.0
 *@created 17-Dec-2022 10:00:00 AM
 */
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryRegion;

    public Address(String street, String city, String postalCode, String stateProvince, String countryRegion) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.stateProvince = stateProvince;
        this.countryRegion = countryRegion;
    }

    public Address() {
    }
}

