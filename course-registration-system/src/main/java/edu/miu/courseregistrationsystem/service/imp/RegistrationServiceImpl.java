package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.dto.RegistrationDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.Registration;
import edu.miu.courseregistrationsystem.mapper.CourseOfferingMapper;
import edu.miu.courseregistrationsystem.mapper.RegistrationMapper;
import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationRepository;
import edu.miu.courseregistrationsystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feven
 * @version 1.0
 *@created 19-Dec-2022 6:00 PM
 */


@Service
@Transactional
public class RegistrationServiceImpl implements RegisterService {
    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    private CourseOfferingMapper courseOfferingMapper;
    private RegistrationMapper registrationMapper;

    @Override
    public List<CourseOffering> findAll() {
        return courseOfferingRepository.findAll();
    }

    @Override
    public CourseOffering findOne(Long id) {
        return courseOfferingRepository.findById(id).orElse(null);
    }

    @Override
    public CourseOffering update(CourseOfferingDto courseOfferingdto) {
        CourseOffering courseOffering = courseOfferingMapper.courseOfferingFromCourseOfferingDto(courseOfferingdto);
       return courseOfferingRepository.save(courseOffering);
    }

    @Override
    public void delete(Long id) {
        courseOfferingRepository.deleteById(id);
    }

    @Override
    public CourseOffering add(CourseOffering t) {
        return courseOfferingRepository.save(t);
    }

    @Override
    public List<RegistrationDto> getAllRegistrations() {
        List<RegistrationDto> r= registrationRepository.findAll().stream().
                map(x->registrationMapper.registrationDtoFromRegistration(x)).collect(Collectors.toList());
        return  r;
    }

    @Override
    public Registration addRegistration(RegistrationDto registrationDto) {
       Registration registration= registrationMapper.getRegistrationFromRegistrationDto(registrationDto);
        return registrationRepository.save(registration);
    }

    @Autowired
    public void setCourseOfferingMapper(CourseOfferingMapper courseOfferingMapper) {
        this.courseOfferingMapper = courseOfferingMapper;
    }
    @Autowired
    public void setRegistrationMapper(RegistrationMapper registrationMapper) {
        this.registrationMapper = registrationMapper;
    }
}
