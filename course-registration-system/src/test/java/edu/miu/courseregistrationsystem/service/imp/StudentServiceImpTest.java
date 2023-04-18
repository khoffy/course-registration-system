package edu.miu.courseregistrationsystem.service.imp;


import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import edu.miu.courseregistrationsystem.service.StudentService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author: Rediet
 * @version: 1.0
 * @created: 20-Dec-2022 10:00 PM
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentServiceImpTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentServiceImp;


    @Before
    public void setUp() {
        long id = 201;
        Address address = new Address("123", "123", "123", "123", "123");

        Student student = Student.builder().id(1L).name("Redi").email("Redi@gmail.com")
                .homeAddress(address).mailingAddress(address).build();
        Optional<Student> suraOptional = Optional.of(student);
        when(studentRepository.findById(Mockito.any())).thenReturn(suraOptional);
    }

    @Test
    void registerStudent() {
        Address address = new Address("123", "123", "123", "123", "123");
        Student student = Student.builder().name("Redi").email("Redi@gmail.com")
                .homeAddress(address).mailingAddress(address).build();
        Student student1 = studentRepository.save(student);
        Student student2 = studentRepository.findById(student1.getId()).orElseThrow(() -> new RuntimeException("Student not found"));
        assertThat(student1.getEmail()).isEqualTo(student2.getEmail());
        assertThat(student1.getName()).isEqualTo(student2.getName());
        studentRepository.deleteById(student1.getId());
    }

    @Test
    void dropStudent() {
        Address address = new Address("123", "123", "123", "123", "123");
        Student student = Student.builder().name("Redi").email("Redi@gmail.com")
                .homeAddress(address).mailingAddress(address).build();
        Student student1 = studentRepository.save(student);
        studentRepository.deleteById(student1.getId());
        assertThat(studentRepository.findById(student1.getId())).isEmpty();

    }

    @Test
    void updateStudent() {
        Address address = new Address("123", "123", "123", "123", "123");
        Student student = Student.builder().name("Redi").email("Redi@gmail.com")
                .homeAddress(address).mailingAddress(address).build();
        Student student1 = studentRepository.save(student);
        student1.setName("Rediet");
        studentRepository.save(student1);
        Student student2 = studentRepository.findById(student1.getId()).orElseThrow(() -> new RuntimeException("Student not found"));
        assertThat(student1.getName()).isEqualTo(student2.getName());
        studentRepository.deleteById(student1.getId());
    }

    @Test
    void getStudent() {
        Address address = new Address("123", "123", "123", "123", "123");
        Student student = Student.builder().name("Redi").email("Redi@gmail.com")
                .homeAddress(address).mailingAddress(address).build();
        Student student1 = studentRepository.save(student);
        Student student2 = studentRepository.findById(student1.getId()).orElseThrow(() -> new RuntimeException("Student not found"));
        assertThat(student1.getEmail()).isEqualTo(student2.getEmail());
        assertThat(student1.getName()).isEqualTo(student2.getName());
        studentRepository.deleteById(student1.getId());
    }

    @Test
    void getAllStudents() {
        Address address = new Address("123", "123", "123", "123", "123");
        Address address2 = new Address("123", "123", "123", "123", "123");
        Student student = Student.builder().name("Redi").email("Redi@gmail.com")
                .homeAddress(address).mailingAddress(address).build();
        Student student1 = Student.builder().name("Luis").email("Luis@gmail.com")
                .homeAddress(address2).mailingAddress(address2).build();
        studentRepository.save(student);
        studentRepository.save(student1);
        assertThat(studentRepository.findAll().isEmpty()).isFalse();
        studentRepository.deleteById(student.getId());
        studentRepository.deleteById(student1.getId());
    }

}