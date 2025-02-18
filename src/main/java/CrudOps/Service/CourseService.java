package CrudOps.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CrudOps.Entity.Courseentity;
import CrudOps.Repository.courseRepository;

@Service
public class CourseService {

	@Autowired
	courseRepository crudrepo;

	public Courseentity addCourse(Courseentity course) {
		return crudrepo.save(course);
	}

	public Optional<Courseentity> getCourseid(int courseid) {

		return crudrepo.findById(courseid);
	}

	public List<Courseentity> getCourses() {

		return crudrepo.findAll();
	}

	public Courseentity updatecourseid(int id, Courseentity course) {
		Optional<Courseentity> existing = crudrepo.findById(id);

		if (existing != null) {
			course.setId(id);
			crudrepo.save(course);
			return course;

//			Courseentity updatedCourse = existing.get();
//			updatedCourse.setName(course.getName());
//			updatedCourse.setDos(course.getDos());
//			updatedCourse.setAmount(course.getAmount());
//			updatedCourse.setCerticateavailable(course.isCerticateavailable());
//			return crudrepo.save(updatedCourse);
		}
		return null;

	}

	public void deleteId(int id) {

		crudrepo.deleteById(id);
	}

}
