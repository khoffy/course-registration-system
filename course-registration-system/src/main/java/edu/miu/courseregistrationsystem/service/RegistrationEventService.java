package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventStudentDto;

import java.util.List;
/**
 * @author REDIET
 * @version 1.0
 *@created 16-Dec-2022 2:00:00 AM
 */
public interface RegistrationEventService {
    public RegistrationEventDto addRegistrationEvent(RegistrationEventDto registrationEventDto);
    public RegistrationEventDto updateRegistrationEvent(long id,  RegistrationEventDto registrationEventDto);
    public void deleteRegistrationEvent(long id);
    public RegistrationEventDto getRegistrationEvent(long id);
    public List<RegistrationEventDto> getAllRegistrationEvents();

    public List<RegistrationEventDto>  getLatestRegistrationEvent();

    /**
     * @author REDIET
     * @param registrationEventId
     * @param registrationGroupId
     * admin can add registration group to registration event
     */
    public void addRegistrationGroupToRegistrationEvent(long registrationEventId, long registrationGroupId);

    /**
     * @author REDIET
        * student can see the list of registration events
     *
     */
    public  List<RegistrationEventStudentDto>  getRegistrationEventByStudentId(long studentId);

//    public void sendEmailReminder();

    /**
     * dmin should be able to process registration event
     */
    public void processRegistrationEvent(long registrationEventId);

}
