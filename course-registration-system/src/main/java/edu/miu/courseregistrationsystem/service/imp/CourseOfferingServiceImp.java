package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.mapper.CourseOfferingMapper;
import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
import edu.miu.courseregistrationsystem.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseOfferingServiceImp implements CourseOfferingService {
    @Autowired
    CourseOfferingRepository courseOfferingRepository;
    @Autowired
    CourseOfferingMapper courseOfferingMapper;

    @Override
    public CourseOfferingDto addCourseOffering(CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = courseOfferingMapper.courseOfferingFromCourseOfferingDto(courseOfferingDto);
        System.out.println(courseOffering);
        courseOfferingRepository.save(courseOffering);
        return courseOfferingDto;
    }

    @Override
    public CourseOfferingDto getCourseOffering(long id) {
        CourseOffering courseOffering = courseOfferingRepository.findById(id).get();
        return courseOfferingMapper.courseOfferingDtoFromCourseOffering(courseOffering);
    }

    @Override
    public CourseOfferingDto updateCourseOffering(long id, CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = courseOfferingMapper.courseOfferingFromCourseOfferingDto(courseOfferingDto);
        return courseOfferingMapper.courseOfferingDtoFromCourseOffering(courseOfferingRepository.save(courseOffering));
    }

    @Override
    public void deleteCourseOffering(long id) {
        courseOfferingRepository.deleteById(id);
    }

    @Override
    public List<CourseOfferingDto> getAllCourseOfferings() {
        List<CourseOffering> courseOfferings = courseOfferingRepository.findAll();
        return courseOfferingMapper.courseOfferingDtosFromCourseOfferings(courseOfferings);
    }

    /**
     * @author Rediet
     * studnet can get all the course offerings which he/she register
     */
    @Override
    public List<CourseOfferingDto> getCourseOfferingsByStudent(long academicBlockId) {
//        List<CourseOffering> courseOfferings = courseOfferingRepository.findByStudentsId(academicBlockId);
//        return courseOfferingMapper.courseOfferingDtosFromCourseOfferings(courseOfferings);
        return null;
    }
}
