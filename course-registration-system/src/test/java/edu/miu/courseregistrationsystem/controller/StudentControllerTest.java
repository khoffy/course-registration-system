package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.service.imp.StudentServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: Rediet
 * @version: 1.0
 * @created: 20-Dec-2022 10:22 PM
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@ContextConfiguration(classes = {StudentController.class})
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @Autowired
    MockMvc mock;
    @MockBean
    private StudentServiceImp studentServiceImp;


    @Test
    void getAllStudents() throws Exception {
        AddressDto address = AddressDto.builder().id(1).street("123").city("123").postalCode("123").stateProvince("123").countryRegion("123").build();
        Mockito.when(studentServiceImp.getStudent(1)).thenReturn(StudentDto.builder().id(1).name("Redi").email("").homeAddress(address).mailingAddress(address).build());
        mock.perform(get("/api/students"))
                .andExpect(status().isOk());

    }

    @Test
    void registerStudent() {

    }

    @Test
    void getStudent() throws Exception {
        AddressDto address = AddressDto.builder().id(1).street("123").city("123").postalCode("123").stateProvince("123").countryRegion("123").build();
        Mockito.when(studentServiceImp.getStudent(1)).thenReturn(StudentDto.builder().id(1).name("Redi").email("").homeAddress(address).mailingAddress(address).build());
        mock.perform(get("/api/students/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Redi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(""))
                .andExpect(MockMvcResultMatchers.jsonPath("$.homeAddress.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mailingAddress.id").value(1));

    }

    @Test
    void updateStudent() {
    }

    @Test
    void dropStudent() {
    }

}