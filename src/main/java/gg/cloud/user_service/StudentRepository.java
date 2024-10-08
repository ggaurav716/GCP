package gg.cloud.user_service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query(value = "select * from Student", nativeQuery = true)
	public List<Student> getAllStudents();

	
	
	
}
