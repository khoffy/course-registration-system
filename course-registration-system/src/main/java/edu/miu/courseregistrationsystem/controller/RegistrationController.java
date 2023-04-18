package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.dto.RegistrationDto;
import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.mapper.CourseOfferingMapper;
import edu.miu.courseregistrationsystem.mapper.RegistrationMapper;
import edu.miu.courseregistrationsystem.service.RegisterService;
import edu.miu.courseregistrationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feven
 * @version 1.0
 * @created 12-Sep-2020 10:00:00 AM
 */

@RestController
@RequestMapping("/Registration")
public class RegistrationController {

    private CourseOfferingMapper courseOfferingMapper;
    private RegistrationMapper registrationMapper;

    private StudentService studentService;

    private RegisterService registrationService;

    //list of Registrations
    @GetMapping("/allRegistration")
    public ResponseEntity<?> findAllRegistration() {
        List<RegistrationDto> registrationDto= registrationService.getAllRegistrations();
        return new ResponseEntity<>(registrationDto, HttpStatus.OK);
    }

    @PostMapping("/allRegistration")
    public ResponseEntity<?> addRegistration(@RequestBody RegistrationDto registrationDto){
        registrationService.addRegistration(registrationDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    //Student in registration
    @GetMapping
    public ResponseEntity<?> findAllStudents() {
       List<StudentDto> studentDtos = studentService.findAll();
        //student.setStudents(students2);

        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneStudent(@PathVariable long id) {
        StudentDto studentDto = studentService.getStudent(id);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        studentService.dropStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
        StudentDto responseDto = studentService.add(studentDto);
        return ResponseEntity.ok(responseDto);
    }
    //CourseOffering in Registration

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getOneCourseOffering(@PathVariable long id){
        registrationService.findOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/courses/{id}")
    public ResponseEntity<?> updateCourseOffering(@PathVariable long id, @RequestBody CourseOfferingDto coursesOfferingDto){
        registrationService.update(coursesOfferingDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourseOffering(@PathVariable long id){
        registrationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    public void setCourseOfferingMapper(CourseOfferingMapper courseOfferingMapper) {
        this.courseOfferingMapper = courseOfferingMapper;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setRegistrationService(RegisterService registrationService) {
        this.registrationService = registrationService;
    }
}


