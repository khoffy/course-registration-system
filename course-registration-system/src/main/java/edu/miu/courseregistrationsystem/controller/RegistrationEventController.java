package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventStudentDto;
import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.mapper.RegistrationEventMapper;
import edu.miu.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @version 1.0
 * @created 12-Sep-2020 10:00:00 AM
 */

@RestController
@RequestMapping("api/registration-events")
public class  RegistrationEventController {
    @Autowired
    private RegistrationEventService registrationEventService;
    @Autowired
    private RegistrationEventMapper registrationEventMapper;

    @GetMapping
    public ResponseEntity<?> getAllRegistrationEvents() {
        RegistrationEvents registrationEvents = new RegistrationEvents();
        List<RegistrationEventDto> registrationEvents2 = registrationEventService.getAllRegistrationEvents();
        registrationEvents.setRegistrationEvents(registrationEvents2);
        return new ResponseEntity<>(registrationEvents, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        registrationEventService.addRegistrationEvent(registrationEventDto);
        return new ResponseEntity<RegistrationEventDto>(registrationEventDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistrationEvent(@PathVariable long id) {
        RegistrationEventDto registrationEventDto = registrationEventService.getRegistrationEvent(id);
        return new ResponseEntity<RegistrationEventDto>(registrationEventDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegistrationEvent(@PathVariable long id, @RequestBody RegistrationEventDto registrationEventDto) {
        registrationEventService.updateRegistrationEvent(id, registrationEventDto);
        return new ResponseEntity<RegistrationEventDto>(registrationEventDto, HttpStatus.OK);
    }

    /**
     * @author REDIET
     * @param id
     * @param registrationGroupId
     * admin can add registration group to registration event
     */
    @PutMapping("/{id}/registration-groups")
    public ResponseEntity<?> getRegistrationEventService(@PathVariable long id, @RequestBody long registrationGroupId) {
        registrationEventService.addRegistrationGroupToRegistrationEvent(id, registrationGroupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegistrationEvent(@PathVariable long id) {
        registrationEventService.deleteRegistrationEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestRegistrationEvent() {
        List<RegistrationEventDto> registrationEventDto = registrationEventService.getLatestRegistrationEvent();
        return new ResponseEntity<List<RegistrationEventDto>>(registrationEventDto, HttpStatus.OK);
    }
    /**
     * admin can add student
     * REST API for admin to add registration event
     * admin can call this API
     * need to use FeignClient to call student service to get all students
     */
//    @PostMapping("/student)")
//    public ResponseEntity<?> addNewStudents(List<StudentDto> studentDtos) {
////        studentService.addNewStudents(studentDtos);
//        return new ResponseEntity<List<StudentDto>>(studentDtos, HttpStatus.OK);
//    }

    /**
     * student can register to registration event that the student is a member of
     */
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getRegistrationEventByStudentId(@PathVariable long id) {
        List<RegistrationEventStudentDto> registrationEventDtos = registrationEventService.getRegistrationEventByStudentId(id);
        return new ResponseEntity<List<RegistrationEventStudentDto>>(registrationEventDtos, HttpStatus.OK);
    }
    /** admin should be able to process registration event
     *
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> processRegistrationEvent(@PathVariable long id, @RequestParam boolean processed) {
        if(processed) {
            registrationEventService.processRegistrationEvent(id);
        } else {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
