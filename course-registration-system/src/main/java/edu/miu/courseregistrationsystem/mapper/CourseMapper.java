package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * @author Feven
 * @version 1.0
 * @created 20-Dec-2022 12:31AM
 */

@Mapper(componentModel = "spring")
public interface CourseMapper {
    public Course courseFromCourseDto(CourseDto courseDto);
    public CourseDto courseDtoFromCourse(Course course);
    public List<Course> courseFromCourseDto(List<CourseDto> courseDto);
    public List<CourseDto> courseDtoFromCourse(List<Course> course);
}
