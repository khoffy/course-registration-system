package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.mapper.CourseMapper;
import edu.miu.courseregistrationsystem.service.imp.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feven
 * @version 1.0
 * @created 20-Dec-2022 01:00AM
 */
@RestController
@RequestMapping("/Course")
public class CourseController {

    private CourseMapper courseMapper;

    private CourseService courseService;

    @GetMapping
    public ResponseEntity<?> findAllCourses() {
        List<Course> course= courseService.findAll();
        //student.setStudents(students2);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCourse(@PathVariable long id) {
        Course course = courseService.findOne(id);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable long id, @RequestBody CourseDto courseDto) {
        courseService.update(courseDto);
        return new ResponseEntity<CourseDto>(courseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable long id){
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        courseService.add(course);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @Autowired
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
