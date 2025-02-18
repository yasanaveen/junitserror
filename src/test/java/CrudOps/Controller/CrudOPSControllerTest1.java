package CrudOps.Controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import CrudOps.Entity.Courseentity;
import CrudOps.Service.CourseService;

@WebMvcTest(CrudOPSControllerTest1.class)
public class CrudOPSControllerTest1 {

	private MockMvc mockMvc;

	@Mock
	private CourseService courseservice;

	@InjectMocks
	private CourseController coursecontroller; 

	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(coursecontroller).build();
	}

	@Test
	@Order(1)
	void testCreateCourse() throws Exception {

		Courseentity ce = new Courseentity("naveen", 20000);

		when(courseservice.addCourse(ce)).thenReturn(ce);

		mockMvc.perform(post("/addcourse").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"naveen\",\"amount\":\"20000\"}"))
		         .andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value("naveen"))
				.andExpect(jsonPath("$.amount").value(20000));

		verify(courseservice).addCourse(ce);
	}

//	@Test
//	void testCreateCourse() throws Exception {
//	    Courseentity ce = new Courseentity("naveen", 20000);
//
//	    when(courseservice.addCourse(ce)).thenReturn(ce);
//
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    String courseJson = objectMapper.writeValueAsString(ce);
//
//	    mockMvc.perform(post("/addcourse")
//	            .contentType(MediaType.APPLICATION_JSON)
//	            .content(courseJson))
//	            .andExpect(status().isCreated())
//	            .andExpect(jsonPath("$.name").value("naveen"))
//	            .andExpect(jsonPath("$.amount").value(20000));
//
//	    verify(courseservice).addCourse(ce);
//	}
	
	
	
	@Test @Order(2)
	void testGetallcourses() throws Exception
	{
		Courseentity ce1= new Courseentity("naveen",20000);
		
		when(courseservice.getCourses()).thenReturn(Collections.singletonList(ce1));
		
		
		mockMvc.perform(get("/getcourses"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].name").value("naveen"));
		
		verify(courseservice).getCourses();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
