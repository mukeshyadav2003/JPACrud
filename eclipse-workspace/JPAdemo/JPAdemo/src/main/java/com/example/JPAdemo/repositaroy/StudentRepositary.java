package com.example.JPAdemo.repositaroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.JPAdemo.module.Student;

@Repository
public interface StudentRepositary extends JpaRepository<Student,Integer>{

	List<Student>findByTechnology(String technology);
	
	
	@Query(nativeQuery=true,value="SELECT * FROM student WHERE gender =:gender AND technology =:technology")
	List<Student>findByGenderAndTechnology(@Param("gender") String Gender,@Param("technology") String Technology);
	
}
