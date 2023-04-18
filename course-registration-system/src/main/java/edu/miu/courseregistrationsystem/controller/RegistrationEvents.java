package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Redeit
 * @version 1.0
 * @created 19-Dec-2022 10:00 PM
 */
@Getter
public class RegistrationEvents {
    List<RegistrationEventDto> registrationEvents;

    public RegistrationEvents() {
    }
    public RegistrationEvents(List<RegistrationEventDto> registrationEvents) {
        this.registrationEvents = registrationEvents;
    }
    public void setRegistrationEvents(List<RegistrationEventDto> registrationEvents) {
        this.registrationEvents = registrationEvents;
    }

}
