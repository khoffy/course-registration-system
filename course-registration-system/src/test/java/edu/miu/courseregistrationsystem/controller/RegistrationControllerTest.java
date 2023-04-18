//package edu.miu.courseregistrationsystem.controller;
//
//import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
//import edu.miu.courseregistrationsystem.repository.StudentRepository;
//import edu.miu.courseregistrationsystem.service.StudentService;
//import edu.miu.courseregistrationsystem.service.RegisterService;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(RegistrationController.class)
//public class RegistrationControllerTest {
//
//    @Autowired
//    MockMvc mock;
//
//    @MockBean
//    RegisterService registerService;
//
//    @MockBean
//    StudentService studentService;
//
//    @MockBean
//    CourseOfferingRepository courseOfferingRepository;
//
//    @MockBean
//    StudentRepository studentRepository;

 	//@Test
//	public void GetallStudents() throws Exception {
//        C
//		customers.addCustomer(new Customer(1L, "Frank Brown", "fbrown@gmail.com"));
//		customers.addCustomer(new Customer(2L, "John Doe", "jdoe@gmail.com"));
//		Mockito.when(accountService.getAllCustomers()).thenReturn(customers);
//
//		mock.perform(MockMvcRequestBuilders.get("/customers"))
//		  .andExpect(status().isOk())
//          .andExpect(MockMvcResultMatchers.jsonPath("$.customers").isArray())
//          .andExpect(MockMvcResultMatchers.jsonPath("$.customers", hasSize(2)))
//		  .andExpect(MockMvcResultMatchers.jsonPath("$.customers[0].customerNumber").value(1L))
//		  .andExpect(MockMvcResultMatchers.jsonPath("$.customers[0].name").value("Frank Brown"))
//		  .andExpect(MockMvcResultMatchers.jsonPath("$.customers[0].email").value("fbrown@gmail.com"));
//
//		verify(accountService, times(1)).getAllCustomers();
//	}
//	public void testDeleteCustomerByCustomerNumber() throws Exception {
//		mock.perform(MockMvcRequestBuilders.delete("/customer/{id}",1))
//		  .andExpect(status().isOk());
//
//		verify(accountService, times(1)).removeCustomer("1");
//	}
//
//	@Test
//	public void testAddCustomer() throws Exception {
//		Customer customer = new Customer(1L, "Frank Brown", "fbrown@gmail.com");
//		mock.perform(MockMvcRequestBuilders.post("/customer")
//	      .content(asJsonString(customer))
//	      .contentType(MediaType.APPLICATION_JSON))
//          .andExpect(status().isOk());
//
//		verify(accountService, times(1)).addCustomer(customer);
//	}
//
//	@Test
//	public void testUpdateCustomer() throws Exception {
//		Customer customer = new Customer(1L, "Frank Brown", "fbrown@gmail.com");
//		mock.perform(MockMvcRequestBuilders.put("/customer")
//	      .content(asJsonString(customer))
//	      .contentType(MediaType.APPLICATION_JSON))
//          .andExpect(status().isOk());
//
//		verify(accountService, times(1)).updateCustomer(customer);
//	}
//

//
//	public static String asJsonString(final Object obj) {
//	    try {
//	        return new ObjectMapper().writeValueAsString(obj);
//	    } catch (Exception e) {
//	        throw new RuntimeException(e);
//	    }
//	}

//}
