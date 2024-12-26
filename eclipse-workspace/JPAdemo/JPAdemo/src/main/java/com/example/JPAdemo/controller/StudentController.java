package com.example.JPAdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAdemo.module.Student;
import com.example.JPAdemo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		
		return studentService.getAllStudent();
		
	}
	
	@GetMapping("/student/{rno}")
	public Student getStudent(@PathVariable("rno")int RollNo ) {
		
		return studentService.getStudent(RollNo);
		
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {
		
		studentService.addStudents(student);
		return "add succefully";
	}
	
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student student) {
		
				studentService.updateStudent(student);
		return "updated succefully";
		
	}
	
	@DeleteMapping("/students/{rno}")
	public String DeleteStudent(@PathVariable("rno") int rollno) {
		
		studentService.deleteStudent(rollno);
		
		return "Deleted Succefully";
		
	}
	
	@GetMapping("/students/technology/{tech}")
	public List<Student> getStudentByTechnology(@PathVariable("tech") String technology){
		
		return studentService.getTechnology(technology);
		
	}
	
	
	@PostMapping("/students/filter")
	public List<Student> getStudentGenderandTechnology(@Param("gender")String Gender ,@Param("technology")String Technology){
		
		return studentService.getStudentGenderandTechnology(Gender,Technology);
		
	}
}
