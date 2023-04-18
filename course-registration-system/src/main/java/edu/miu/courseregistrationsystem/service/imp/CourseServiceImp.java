package edu.miu.courseregistrationsystem.service.imp;


import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.mapper.CourseMapper;
import edu.miu.courseregistrationsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author Feven
 * @version 1.0
 * @created 20-Dec-2022 12:31AM
 */

@Service
@Transactional
public class CourseServiceImp implements CourseService{
    @Autowired
    CourseRepository courseRepository;

    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findOne(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course update(CourseDto courseDto) {
        Course course= courseMapper.courseFromCourseDto(courseDto);
        return courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }
    @Autowired
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }
}
