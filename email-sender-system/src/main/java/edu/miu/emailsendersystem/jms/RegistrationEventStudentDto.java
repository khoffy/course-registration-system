package edu.miu.emailsendersystem.jms;



import java.time.LocalDate;
import java.util.List;


public class RegistrationEventStudentDto {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    List<RegistrationGroupStudentDto> registrationGroups;

    public RegistrationEventStudentDto(long id, LocalDate startDate, LocalDate endDate, List<RegistrationGroupStudentDto> registrationGroups) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationGroups = registrationGroups;
    }

    public RegistrationEventStudentDto() {
    }

    public long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<RegistrationGroupStudentDto> getRegistrationGroups() {
        return registrationGroups;
    }
}
