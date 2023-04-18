package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AcademicBlockStudentDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventStudentDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupStudentDto;
import edu.miu.courseregistrationsystem.entity.*;
import edu.miu.courseregistrationsystem.enumeration.RegistrationRequestStatus;
import edu.miu.courseregistrationsystem.mapper.RegistrationEventMapper;
import edu.miu.courseregistrationsystem.repository.*;
import edu.miu.courseregistrationsystem.service.RegistrationEventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;


import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistrationEventServiceImp implements RegistrationEventService {
    @Autowired
    RegistrationEventRepository registrationEventRepository;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private RegistrationEventMapper registrationEventMapper;
    @Autowired
    private RegistrationGroupServiceImp registrationGroupServiceImp;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;


    @Override
    public RegistrationEventDto addRegistrationEvent(RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent = registrationEventMapper.registrationEventFromRegistrationEventDto(registrationEventDto);
        RegistrationEventDto registrationEventStudentDto = registrationEventMapper
                .registrationEventDtoFromRegistrationEvent(registrationEventRepository.save(registrationEvent));
        jmsTemplate.convertAndSend("registrationEventQueue", "registrationEvent");
        System.out.println("message sent");
        return registrationEventDto;
    }

    @Override
    public RegistrationEventDto updateRegistrationEvent(long id, RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventMapper.registrationEventFromRegistrationEventDto(registrationEventDto);
        registrationEventRepository.save(registrationEvent);
        return registrationEventDto;
    }

    @Override
    public void deleteRegistrationEvent(long id) {
        registrationEventRepository.deleteById(id);
    }

    @Override
    public RegistrationEventDto getRegistrationEvent(long id) {
        RegistrationEvent registrationEvent = registrationEventRepository.findById(id).get();
        RegistrationEventDto registrationEventDto = registrationEventMapper.registrationEventDtoFromRegistrationEvent(registrationEvent);
        return registrationEventDto;
    }

    @Override
    public List<RegistrationEventDto> getAllRegistrationEvents() {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        List<RegistrationEventDto> registrationEventDtos = registrationEventMapper.registrationEventDtosFromRegistrationEvents(registrationEvents);
        return registrationEventDtos;
    }

    @Override
    public List<RegistrationEventDto> getLatestRegistrationEvent() {
         List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
         List<RegistrationEvent> latestRegistrationEventTwo = new ArrayList<>();
    for(RegistrationEvent registrationEvent: registrationEvents){
        if(registrationEvent.getStartDate().isBefore(LocalDateTime.now()) && registrationEvent.getEndDate().isAfter(LocalDateTime.now())){
            latestRegistrationEventTwo.add(registrationEvent);
        }
    }
            return registrationEventMapper.registrationEventDtosFromRegistrationEvents(latestRegistrationEventTwo);
    }
    /**
     * @author REDIET
     * @param registrationEventId
     * @param registrationGroupId
     * admin can add registration group to registration event
     * admin will get existing registration group to existing registration event
     */
    @Override
    public void addRegistrationGroupToRegistrationEvent(long registrationEventId, long registrationGroupId) {
        RegistrationEvent registrationEvent = registrationEventRepository.findById(registrationEventId).get();
        registrationEvent.getRegistrationGroups().add(registrationGroupServiceImp.getRegistrationGroupById(registrationGroupId));
    }
    /**
     * @author REDIET
     * student can see the list of registration events
     * student will get existing registration event to existing student
     */

    @Override
    public List<RegistrationEventStudentDto>  getRegistrationEventByStudentId(long studentId) {
        List<RegistrationEvent> registrationEvents =  registrationEventRepository.findByRegistrationGroupsStudentsId(studentId);
        /*List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        List<RegistrationEvent> registrationEventsForStudent = new ArrayList<>();
        for(RegistrationEvent registrationEvent: registrationEvents){
            for (RegistrationGroup registrationGroup: registrationEvent.getRegistrationGroups()){
                for (Student student: registrationGroup.getStudents()){
                    if(student.getId() == studentId){
                        registrationEventsForStudent.add(registrationEvent);
                    }
                }
            }
        }*/
        List<RegistrationEventStudentDto> registrationEventStudentDtos = new ArrayList<>();
        for (RegistrationEvent registrationEvent: registrationEvents){
            RegistrationEventStudentDto registrationEventStudentDto = new RegistrationEventStudentDto();
           RegistrationEventStudentDto registrationEventStudentDto1 = modelMapper.map(registrationEvent, RegistrationEventStudentDto.class);
            registrationEventStudentDtos.add(registrationEventStudentDto1);
        }

        return registrationEventStudentDtos;
    }
    //convert registrationGroupdto to registrationGroupStudentDto
    public List<RegistrationGroupStudentDto> convertRegistrationGroupDtoToRegistrationGroupStudentDto(List<RegistrationGroup> registrationGroups){
        List<RegistrationGroupStudentDto> registrationGroupStudentDtos = new ArrayList<>();
        for(RegistrationGroup registrationGroup: registrationGroups){
            RegistrationGroupStudentDto registrationGroupStudentDto = new RegistrationGroupStudentDto();
            registrationGroupStudentDto.setId(registrationGroup.getId());
        List<AcademicBlock> academicBlocks = registrationGroup.getAcademicBlocks();
        List<AcademicBlockStudentDto> academicBlockStudentDtos = new ArrayList<>();
        for (AcademicBlock academicBlock: academicBlocks){
            AcademicBlockStudentDto academicBlockStudentDto = new AcademicBlockStudentDto();
            academicBlockStudentDto.setId(academicBlock.getId());
            academicBlockStudentDto.setStartDate(academicBlock.getStartDate());
            academicBlockStudentDto.setEndDate(academicBlock.getEndDate());

            academicBlockStudentDtos.add(academicBlockStudentDto);
        }
            registrationGroupStudentDtos.add(registrationGroupStudentDto);
        }
        return registrationGroupStudentDtos;
    }

    /**
     * @author REDIET
     * send an email to student 8 and 4 hours before the registration event ends
     */
    /*@Override
    public void sendEmailReminder() {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        for(RegistrationEvent registrationEvent: registrationEvents){
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(registrationEvent.getEndDate(), now);
            if(duration.toHours() == 4 || duration.toHours() == 8) {

                jmsTemplate.convertAndSend("OpenRegistrationEventQueue",
                        "Registration will be closed after" + duration.toHours() + " hours");

            }
        }
    }*/
    /**
     * dmin should be able to process registration event
     */
    @Override
    public void processRegistrationEvent(long registrationEventId) {

        RegistrationEvent registrationEvent = registrationEventRepository.findById(registrationEventId).get();
//        if(registrationEvent.getStatus().equals("Closed")) {

            List<Student> students = registrationEvent.getRegistrationGroups().stream()
                    .flatMap(registrationGroup -> registrationGroup.getStudents().stream())
                    .collect(Collectors.toList());
            for (Student student : students) {
                System.out.println("student" + student);
                List<RegistrationRequest> registrationRequests = student.getRequests();
                for (RegistrationRequest registrationRequest : registrationRequests) {
                    Registration registration = convertRegistrationRequestToRegistration(registrationRequest, student.getId());
                    System.out.println("registration" + registration);
//                System.out.println(registration);
                    registrationRepository.save(registration);
                }

            }
//        }
    }
    public Registration convertRegistrationRequestToRegistration(RegistrationRequest registrationRequest, long studentId) {
     if(registrationRequest.getPriority() == 1) {
         if(checkAvailableSeats(registrationRequest.getCourseOffering()) && checkPrerequisites(registrationRequest.getCourseOffering(), studentId)) {
                Registration registration = new Registration();
             registration.setCourseOfferings(registrationRequest.getCourseOffering());
             registration.setStudent(studentRepository.findById(studentId).get());
             registrationRequest.setStatus(RegistrationRequestStatus.ACCEPTED);
             registrationRequestRepository.save(registrationRequest);
             System.out.println("registrationRequest" + registrationRequest);
             /**
              * update available seats
              */
                CourseOffering courseOffering = registrationRequest.getCourseOffering();
                courseOffering.setAvailableSeats(courseOffering.getAvailableSeats() - 1);
                courseOfferingRepository.save(courseOffering);
             return registration;
            }
         }
        else {
         registrationRequest.setStatus(RegistrationRequestStatus.ACCEPTED);
        }
        return null;
     }


    /**
     *
     *check if the courseOffering have available seats
     */
    public boolean checkAvailableSeats(CourseOffering courseOffering){
        if(courseOffering.getAvailableSeats() > 0){
            System.out.println("available seats");
            return true;
        }
        return false;
    }
    public boolean checkPrerequisites(CourseOffering courseOffering, long studentId){
        Course course = courseOffering.getCourse();
        List<Course> coursePrerequisites = new ArrayList<>();
        coursePrerequisites = courseRepository.findById(course.getId()).get().getPreRequisite();
        // if the course has no prerequisites it is possible to register
        if(coursePrerequisites.size() == 0) {
            return true;
        }
        /**
         * if the course has prerequisites, we need to check if the student has taken the prerequisites
         * get the list of prerequisites of the course form courseRepository
         * get the list of registrations of the student form registrationRepository
         * and check if the student already has taken the prerequisites
         */
        List<Course> prerequisites = courseOffering.getCourse().getPreRequisite();
        List<Registration> registrations = registrationRepository.findAllByStudentId(studentId);
        List<Course> courseTakenByStudent = new ArrayList<>();
        for(Registration registration: registrations){
            courseTakenByStudent.add(registration.getCourseOfferings().getCourse());
        }
        for(Course course1: prerequisites){
            System.out.println("course1" + course1);
            if(!courseTakenByStudent.contains(course1)){
                return false;
            }
        }
        return true;
    }

}
