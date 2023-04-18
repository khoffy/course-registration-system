package edu.miu.courseregistrationsystem.entity;


import edu.miu.courseregistrationsystem.enumeration.RegistrationEventStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 17-Dec-2022 07:48 AM
 */
@Entity
@Data
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private RegistrationEventStatus status = RegistrationEventStatus.NEW;
    //@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany(cascade = {CascadeType.ALL})
    List<RegistrationGroup> registrationGroups;

    public RegistrationEvent() {
    }

    public RegistrationEvent(long id, LocalDateTime startDate, LocalDateTime endDate, List<RegistrationGroup> registrationGroups) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationGroups = registrationGroups;
    }

    public void setStatus() {
        if (startDate.isBefore(LocalDateTime.now()) && endDate.isAfter(LocalDateTime.now())) {
            this.status = RegistrationEventStatus.OPEN;
        } else {
            this.status = RegistrationEventStatus.CLOSED;
        }
        //this.status = status;
    }

    @Override
    public String toString() {
        return "RegistrationEvent{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", registrationGroups=" + registrationGroups +
                '}';
    }
}
