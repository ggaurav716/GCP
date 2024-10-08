package gg.cloud.user_service;


import java.util.Optional;

public interface StudentService {

	public Optional<Student> getStudentById(Integer id);

	public Student registerStudent(Student student);

	public void deleteStudent(Student student);

	public void updateStudent(Student s);

}
