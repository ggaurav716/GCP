package gg.cloud.user_service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping(value = "/hi")
	public void get() {

		System.out.println("-------------------------hello-----------------------");

	}

	@GetMapping(value = "/get/{id}", produces = {
			/* MediaType.APPLICATION_XML_VALUE, */ MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Studentdto> getStudentbyid(@PathVariable Integer id, HttpStatus status) throws Exception {
		System.out.println("------------------------------------------------------");
		Optional<Student> s = service.getStudentById(id);
		if (!s.isPresent()) {
			throw new Exception("Id " + id + " is not present in database");
		} else {
			Studentdto studentDto = new Studentdto(s.get().getId(), s.get().getName(), s.get().getAddress(),
					s.get().getContact());
			return new ResponseEntity<>(studentDto, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/register"/*
									 * , produces ={ MediaType.APPLICATION_JSON_VALUE,
									 * MediaType.APPLICATION_XML_VALUE }, consumes = {
									 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
									 */)

	public ResponseEntity<String> registerStudentWithValidition(@RequestBody Studentdto dt, BindingResult br) {

		if (br.hasErrors()) {
			String errMsg = new String(br.getFieldError().getDefaultMessage());
			return new ResponseEntity<String>(errMsg, HttpStatus.BAD_REQUEST);
		} else {
			Student st = new Student(dt.getName(), dt.getAddress(), dt.getContact());
			Student s = service.registerStudent(st);
			String message = "Record added Id is " + s.getId();
			return new ResponseEntity<>(message, HttpStatus.CREATED);

		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id, HttpStatus status) {

		Optional<Student> s = service.getStudentById(id);
		Student student = new Student(s.get().getId(), s.get().getName(), s.get().getAddress(), s.get().getAddress());
		service.deleteStudent(student);
		String meaasge = "Record no" + id + "Deleted";
		return new ResponseEntity<>(meaasge, HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student st, HttpStatus status) {

		service.updateStudent(st);
		String message = "Student Updated";
		return new ResponseEntity<>(message, HttpStatus.CREATED);

	}

}
