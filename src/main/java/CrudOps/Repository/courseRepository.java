package CrudOps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CrudOps.Entity.Courseentity;

@Repository
public interface courseRepository extends JpaRepository<Courseentity, Integer>{

}
