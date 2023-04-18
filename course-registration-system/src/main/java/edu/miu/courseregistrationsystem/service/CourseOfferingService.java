package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;

import java.util.List;

public interface CourseOfferingService {

    public CourseOfferingDto addCourseOffering(CourseOfferingDto courseOfferingDto);

    public CourseOfferingDto getCourseOffering(long id);

    public CourseOfferingDto updateCourseOffering(long id, CourseOfferingDto courseOfferingDto);

    public void deleteCourseOffering(long id);

    public List<CourseOfferingDto> getAllCourseOfferings();

    public List<CourseOfferingDto> getCourseOfferingsByStudent(long academicBlockId);
}
