package com.example.JPAdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAdemo.module.Student;
import com.example.JPAdemo.repositaroy.StudentRepositary;

@Service
public class StudentService {

     @Autowired
	StudentRepositary studentRepo;
	
	public List<Student> getAllStudent() {
				
		return studentRepo.findAll();
	}

	public void addStudents(Student student) {
		
		studentRepo.save(student);
		
	}

	public Student getStudent(int rollNo) {
		
		
		return studentRepo.findById(rollNo).orElse(new Student());
	}

	public void updateStudent(Student student) {
		
		studentRepo.save(student);
		
	}

	public void deleteStudent(int rollno) {
	
		studentRepo.deleteById(rollno);
		
	}

	public List<Student> getTechnology(String technology) {
		
		return studentRepo.findByTechnology(technology);
	}

	public List<Student> getStudentGenderandTechnology(String Gender, String Technology) {
		
		return studentRepo.findByGenderAndTechnology(Gender,Technology);
	}

	

	
}
