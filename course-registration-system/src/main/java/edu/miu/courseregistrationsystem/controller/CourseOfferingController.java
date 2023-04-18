package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rediet
 * @version 1.0
 * @created 19/12/2020 11:07 PM
 */
@RestController
@RequestMapping("/courseOfferings")
public class CourseOfferingController {

    @Autowired
    private CourseOfferingService courseOfferingService;

    @GetMapping
    public ResponseEntity<?> getAllCourseOfferings() {
        return new ResponseEntity<>(courseOfferingService.getAllCourseOfferings(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addCourseOffering(@RequestBody CourseOfferingDto courseOfferingDto) {
        CourseOfferingDto courseOfferingDto1 =  courseOfferingService.addCourseOffering(courseOfferingDto);
        return new ResponseEntity<CourseOfferingDto>(courseOfferingDto1, HttpStatus.OK);
    }
    /**
     * @author  REDIET
     * @param id
     * student can get course offerings in which he/she is registered
     */
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getCourseOfferingsByStudent(@PathVariable long id) {
        return new ResponseEntity<>(courseOfferingService.getCourseOfferingsByStudent(id), HttpStatus.OK);
    }
}
