package CrudOps.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import CrudOps.Entity.Courseentity;
import CrudOps.Repository.courseRepository;
import CrudOps.Service.CourseService;
import jakarta.validation.constraints.AssertTrue;

@SpringBootTest
public class CrudopsServiceTest {

	@Mock
	private courseRepository courseRepo;

	@InjectMocks
	private CourseService courseservice;

	private Courseentity courseentity;

	@BeforeEach
	void setup() {
		courseentity = new Courseentity("naveen", 20000);
	}

	@Test
	void testSavedCourse() {
		
		Courseentity savedcourse = new Courseentity("naveen", 20000);

		savedcourse.setId(1);
		when(courseRepo.save(courseentity)).thenReturn(savedcourse);
		Courseentity result = courseservice.addCourse(courseentity);
		//assertThat(result).isNotNull();
		assertNotNull(result);
		assertThat(result.getId()).isEqualTo(1);
		assertThat(result.getName()).isEqualTo("naveen");
		assertThat(result.getAmount()).isEqualTo(20000);
		//assertEquals(20000, result.getAmount());
	}
	
	
	@Test
	 void testCourseByid() {
		
		when(courseRepo.findById(1)).thenReturn(Optional.of(courseentity));
		
		Optional<Courseentity> foundcourse=courseservice.getCourseid(1);
		
		assertTrue(foundcourse.isPresent());
		assertEquals("naveen",foundcourse.get().getName());
		
	}

}
