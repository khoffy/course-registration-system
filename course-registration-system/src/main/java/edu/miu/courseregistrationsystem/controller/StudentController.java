package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.mapper.StudentMapper;
import edu.miu.courseregistrationsystem.service.StudentService;
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
@RequestMapping("/api/students")
public class StudentController {

    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;

    @GetMapping("test")
    public String test() {
        return "test";
    }
    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        Students students = new Students();
        List<StudentDto> students2 = studentService.getAllStudents();
        students.setStudents(students2);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody StudentDto studentDto) {
        StudentDto responseDto = studentService.registerStudent(studentDto);
        //return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
        return new ResponseEntity<StudentDto>(responseDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id) {
        StudentDto studentDto = studentService.getStudent(id);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> dropStudent(@PathVariable long id) {
        studentService.dropStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * admin can add student
     * @param "studentDto"
     */
    // TODO: fix list of students
   // @PostMapping
    public ResponseEntity<?> addStudents(@RequestBody List<StudentDto> studentDtos) {
        studentService.addStudents(studentDtos);
        System.out.println(studentDtos);
        return new ResponseEntity<Students>(HttpStatus.OK);
    }
    /**
     * student can creat registration request
     */
    @PostMapping("{id}/registration")
    public ResponseEntity<?> createRegistrationRequest(@PathVariable long id, @RequestBody RegistrationRequestDto registrationRequestDto) {
        studentService.addRegistrationRequest(id, registrationRequestDto);
        return new ResponseEntity<RegistrationRequestDto>(HttpStatus.OK);
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
}
