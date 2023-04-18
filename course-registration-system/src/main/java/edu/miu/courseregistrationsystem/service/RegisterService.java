package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.dto.RegistrationDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.Registration;

import java.util.List;
/**
 * @author feven
 * @version 1.0
 *@created 18-Dec-2022 5:10PM
 */
public interface RegisterService{

    public List<CourseOffering> findAll();
    public CourseOffering findOne(Long id);
    public CourseOffering update(CourseOfferingDto courseOfferingDto);
    public void delete(Long id);
    public CourseOffering add(CourseOffering t);
    public  List<RegistrationDto> getAllRegistrations();
    public Registration addRegistration(RegistrationDto registrationDto);
}
