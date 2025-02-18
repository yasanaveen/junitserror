package CrudOps.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import CrudOps.Entity.Courseentity;
import CrudOps.Repository.courseRepository;
import CrudOps.Service.CourseService;

@SpringBootTest
public class CrudopsServiceTest {
	
	@Mock
	private courseRepository courseRepo;
	
	@InjectMocks
	private CourseService courseservice;
	
	
	private Courseentity courseentity;
	
	
	@BeforeEach
	void setup()
	{
		courseentity=new Courseentity("naveen",20000);
	}
	
	@Test
	  void testSavedCourse()
	  {
		  Courseentity savedcourse= new Courseentity("naveen", 20000);
		  
		  savedcourse.setId(1);
		  
		  when(courseRepo.save(courseentity)).thenReturn(savedcourse);
		  
		  Courseentity result=courseservice.addCourse(courseentity);
		  
	        assertNotnull(result);
			

	  }



}

	
	

}
