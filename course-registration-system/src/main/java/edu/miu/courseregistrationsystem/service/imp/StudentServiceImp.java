package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestMapper;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import edu.miu.courseregistrationsystem.mapper.StudentMapper;
import edu.miu.courseregistrationsystem.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RegistrationRequestMapper registrationRequestMapper;

    @Override
    public StudentDto registerStudent(StudentDto studentDto) {
        Student student = studentMapper.studentFromStudentDto(studentDto);
        Student new_student = studentRepository.save(student);
        return studentMapper.studentDtoFromStudent(new_student);
    }

    @Override
    public void dropStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = studentMapper.studentFromStudentDto(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    @Override
    public StudentDto getStudent(long id) {
        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = studentMapper.studentDtoFromStudent(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = studentMapper.studentDtosFromStudents(students);
        return studentDtos;
    }

    /**
     * @param students admin can add students
     * @return
     * @author Rediet
     */
    @Override
    public List<Student> addStudents(List<StudentDto> students) {
        return studentRepository.saveAll(studentMapper.studentsFromStudentDtos(students));
    }

    /**
     * @return
     * @author Feven
     * students that registers
     */
    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDto = studentMapper.studentDtosFromStudents(students);
        return studentDto;
    }

    @Override
    public StudentDto findOne(Long id) {
        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = studentMapper.studentDtoFromStudent(student);
        return studentDto;
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = studentMapper.studentFromStudentDto(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        Student student = studentMapper.studentFromStudentDto(studentDto);
        Student response = studentRepository.save(student);
        StudentDto responseDto = studentMapper.studentDtoFromStudent(response);
        return responseDto;
    }

    @Override
    public void addRegistrationRequest(long studentId,RegistrationRequestDto registrationRequestDto) {
        Student student = studentRepository.findById(studentId).get();
        List<RegistrationRequest> registrationRequestDtos = student.getRequests();
        RegistrationRequest registrationRequest = registrationRequestMapper.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
        registrationRequestDtos.add(registrationRequest);
        student.setRequests(registrationRequestDtos);
    }
}
