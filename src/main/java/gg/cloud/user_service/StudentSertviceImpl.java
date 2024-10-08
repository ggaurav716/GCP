package gg.cloud.user_service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentSertviceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Transactional
	@Override
	public Optional<Student> getStudentById(Integer id) {

		Optional<Student> st = repo.findById(id);

		return st;
	}

	@Transactional
	@Override
	public Student registerStudent(Student student) {
		return repo.save(student);

	}

	@Transactional
	@Override
	public void deleteStudent(Student student) {
		repo.delete(student);

	}

	@Transactional
	@Override
	public void updateStudent(Student s) {

		repo.save(s);

	}

}
