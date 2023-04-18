package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.entity.Course;

import java.util.List;

/**
 * @author Feven
 * @version 1.0
 * @created 20-Dec-2022 12:10AM
 */

public interface CourseService {
    public List<Course> findAll();
    public Course findOne(Long id);
    public Course update(CourseDto courseDto);
    public void delete(Long id);
    public Course add(Course course);
}
