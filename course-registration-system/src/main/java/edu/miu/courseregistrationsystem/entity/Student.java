package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author REDIET
 * @version 1.0
 *@created 16-Dec-2022 10:00:00 AM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Student extends User {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_address_id")
    private Address homeAddress;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "student_id")
    List<RegistrationRequest> requests;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    List<RegistrationGroup> registrationGroups;

    public void addRegistrationRequest(RegistrationRequest registrationRequest) {
        if (requests == null) {
            requests = new ArrayList<>();
        }
        requests.add(registrationRequest);
    }



}
