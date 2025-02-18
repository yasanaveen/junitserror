package CrudOps.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CrudOps.Entity.Courseentity;
import CrudOps.Service.CourseService;

@CrossOrigin
@RestController
//@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseservice;

	@PostMapping("/addcourse")
	public ResponseEntity<Courseentity> addCourse(@RequestBody Courseentity coursee) {
		Courseentity ce = courseservice.addCourse(coursee);
		return new ResponseEntity<>(ce, HttpStatus.CREATED);

	}

	@GetMapping("/getcourseid/{id}")
	public Optional<Courseentity> getCourseId(@PathVariable int courseid) {
		return courseservice.getCourseid(courseid);
	}

	@GetMapping("/getcourses")
	public List<Courseentity> getCoursedata() {

		return courseservice.getCourses();
	}

	@PutMapping("/updatecourse/{id}")
	public Courseentity updatecourse(@PathVariable int id, @RequestBody Courseentity course) {
		return courseservice.updatecourseid(id, course);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCourseid(@PathVariable int id) {
		courseservice.deleteId(id);
		return "deleted courseid...!";
	}

}
