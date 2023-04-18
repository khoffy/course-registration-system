package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:10 AM
 */
@Mapper(componentModel = "spring")
public interface CourseOfferingMapper {
    public CourseOffering courseOfferingFromCourseOfferingDto(CourseOfferingDto courseOfferingDto);
    public CourseOfferingDto courseOfferingDtoFromCourseOffering(CourseOffering courseOffering);
    public List<CourseOffering> courseOfferingsFromCourseOfferingDtos(List<CourseOfferingDto> courseOfferingDtos);
    public List<CourseOfferingDto> courseOfferingDtosFromCourseOfferings(List<CourseOffering> courseOfferings);

}
