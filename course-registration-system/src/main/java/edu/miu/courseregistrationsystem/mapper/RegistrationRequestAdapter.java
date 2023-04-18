package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.dto.FacultyDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.Faculty;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RegistrationRequest
 */

//@Component
//public class RegistrationRequestAdapter {
//
//    private static CourseMapper courseMapper;
//
//    public static RegistrationRequest registrationRequestDtoToRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
//        RegistrationRequest request = new RegistrationRequest();
//        List<Course> listOfCourse = new ArrayList<>();
//        if(Objects.nonNull(registrationRequestDto.getStatus())) {
//            request.setStatus(registrationRequestDto.getStatus());
//        }
//        request.setPriority(registrationRequestDto.getPriority());
//
//        CourseOffering courseOffering = new CourseOffering();
//        courseOffering.setCode(registrationRequestDto.getCourseOffering().getCode());
//        courseOffering.setCapacity(registrationRequestDto.getCourseOffering().getCapacity());
//        courseOffering.setAvailableSeats(registrationRequestDto.getCourseOffering().getAvailableSeats());
//        courseOffering.setInitials(registrationRequestDto.getCourseOffering().getInitials());
//
//        Faculty faculty = new Faculty();
//        faculty.setId(registrationRequestDto.getCourseOffering().getFaculty().getId());
//        faculty.setTitle(registrationRequestDto.getCourseOffering().getFaculty().getTitle());
//        faculty.setName(registrationRequestDto.getCourseOffering().getFaculty().getName());
//        faculty.setEmail(registrationRequestDto.getCourseOffering().getFaculty().getEmail());
//
//        courseOffering.setFaculty(faculty);
//        //courseOffering.initial();
//        Course course = new Course();
//        course.setCode(registrationRequestDto.getCourseOffering().getCourse().getCode());
//        course.setName(registrationRequestDto.getCourseOffering().getCourse().getName());
//        course.setDescription(registrationRequestDto.getCourseOffering().getCourse().getDescription());
//        for(CourseDto courseDto: registrationRequestDto.getCourseOffering().getCourse().getPreRequisite()) {
//            Course preRequesitecourse = courseMapper.courseFromCourseDto(courseDto);
//            listOfCourse.add(preRequesitecourse);
//        }
//
//        course.setPreRequisite(listOfCourse);
//
//        courseOffering.setCourse(course);
//
//        request.setCourseOffering(courseOffering);
//
//        return request;
//    }
//
//    public static RegistrationRequestDto registrationRequestToRegistrationRequestDto(RegistrationRequest registrationRequest) {
//        RegistrationRequestDto requestDto = new RegistrationRequestDto();
//        List<CourseDto> listOfCourseDtos = new ArrayList<>();
//        requestDto.setId(registrationRequest.getId());
//        requestDto.setStatus(registrationRequest.getStatus());
//        requestDto.setPriority(registrationRequest.getPriority());
//
//        CourseOfferingDto courseOfferingDto = new CourseOfferingDto();
//        courseOfferingDto.setId(registrationRequest.getCourseOffering().getId());
//        courseOfferingDto.setCode(registrationRequest.getCourseOffering().getCode());
//        courseOfferingDto.setCapacity(registrationRequest.getCourseOffering().getCapacity());
//        courseOfferingDto.setAvailableSeats(registrationRequest.getCourseOffering().getAvailableSeats());
//        courseOfferingDto.setInitials(registrationRequest.getCourseOffering().getInitials());
//
//        FacultyDto facultyDto = new FacultyDto();
//        facultyDto.setId(registrationRequest.getCourseOffering().getFaculty().getId());
//        facultyDto.setTitle(registrationRequest.getCourseOffering().getFaculty().getTitle());
//        facultyDto.setName(registrationRequest.getCourseOffering().getFaculty().getName());
//        facultyDto.setEmail(registrationRequest.getCourseOffering().getFaculty().getEmail());
//
//        courseOfferingDto.setFaculty(facultyDto);
//        CourseDto course = new CourseDto();
//        course.setId(registrationRequest.getCourseOffering().getCourse().getId());
//        course.setCode(registrationRequest.getCourseOffering().getCourse().getCode());
//        course.setName(registrationRequest.getCourseOffering().getCourse().getName());
//        course.setDescription(registrationRequest.getCourseOffering().getCourse().getDescription());
//        for(Course courseAdapted: registrationRequest.getCourseOffering().getCourse().getPreRequisite()) {
//            CourseDto preRequesitecourse = courseMapper.courseDtoFromCourse(courseAdapted);
//            preRequesitecourse.setId(courseAdapted.getId());
//            listOfCourseDtos.add(preRequesitecourse);
//        }
//        course.setPreRequisite(listOfCourseDtos);
//
//        courseOfferingDto.setCourse(course);
//
//        requestDto.setCourseOffering(courseOfferingDto);
//
//        return requestDto;
//    }
//
//    public static List<RegistrationRequestDto> registrationRequestsToRegistrationRequestDtos(List<RegistrationRequest> lists) {
//        List<RegistrationRequestDto> listToReturn = new ArrayList<>();
//
//        for (RegistrationRequest request: lists) {
//            RegistrationRequestDto requestDto =
//                    RegistrationRequestAdapter.registrationRequestToRegistrationRequestDto(request);
//            listToReturn.add(requestDto);
//        }
//
//        return listToReturn;
//    }
//
//    @Autowired
//    public void setCourseMapper(CourseMapper courseMapper) {
//        this.courseMapper = courseMapper;
//    }
//}
