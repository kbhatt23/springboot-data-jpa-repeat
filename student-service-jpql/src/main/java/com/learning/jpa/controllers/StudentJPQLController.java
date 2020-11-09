package com.learning.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.entities.Student;
import com.learning.jpa.repository.StudentJPQLRepository;

@RestController
@RequestMapping("/jpql/students")
public class StudentJPQLController {
	
	@Autowired
	private StudentJPQLRepository repository;
	
	private static final int pageSize  =2;

	//sort by name first and if names are same sort by marks
	private static final Sort NAME_AND_SCORE_SORT = Sort.by(Sort.Order.asc("firstName"),Sort.Order.desc("score"));

	@GetMapping
	public List<Student> findAllStudents(){
		return repository.findAllStudents();
	}
	
	@GetMapping("/partial")
	public List<Object[]> findAllStudentsPartial(){
		 List<Object[]> findAllStudentsData = repository.findAllStudentsData();
		 int rowCount=1;
		 for (Object[] rowItems : findAllStudentsData) {
			System.out.println("iterating for row count "+rowCount);
			for (Object column : rowItems) {
				System.out.println("column found "+column+" with type "+column.getClass().getSimpleName());
			}
			System.out.println("iterating completed for row count "+rowCount);
			 rowCount++;
		}
		 return findAllStudentsData;
	}
	@GetMapping("/name/{name}")
	public List<Student> findAllStudents(@PathVariable String name){
		return repository.findAllStudentsByName(name);
	}
	@GetMapping("/min/{min}/max/{max}")
	public List<Student> findAllStudents(@PathVariable String min, @PathVariable String max){
		return repository.findAllStudentsByMarksRange(Integer.parseInt(min), Integer.parseInt(max));
	}
	
	//pagiantion supoort
	@GetMapping("/pageNumber/{pageNumber}")
	public List<Student> findAllStudentsPageable(@PathVariable String pageNumber){
		Pageable pageable  =PageRequest.of(Integer.parseInt(pageNumber), pageSize);
		return repository.findAllStudents(pageable);
	}
	
	@GetMapping("/pageNumberSorted/{pageNumber}")
	public List<Student> findAllStudentsPageableSorted(@PathVariable String pageNumber){
		Pageable pageable  =PageRequest.of(Integer.parseInt(pageNumber), pageSize,NAME_AND_SCORE_SORT);
		return repository.findAllStudents(pageable);
	}
	
	@GetMapping("/name/{name}/pageNumber/{pageNumber}")
	public List<Student> findAllStudentsByNamePageable(@PathVariable String name,@PathVariable String pageNumber){
		Pageable pageable  =PageRequest.of(Integer.parseInt(pageNumber), 1,NAME_AND_SCORE_SORT);
		return repository.findAllStudentsByName(name,pageable);
	}
}
