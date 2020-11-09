package com.learning.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.jpa.entities.Student;

@Repository
public interface StudentJPQLRepository extends PagingAndSortingRepository<Student, Long>{

	@Query("select s from Student s")
	List<Student> findAllStudents();
	
	@Query("select firstName,lastName from Student s")
	List<Object[]> findAllStudentsData();
	
	@Query("select s from Student s where firstName=:fName")
	List<Student> findAllStudentsByName(@Param("fName") String name);
	
	@Query("select s from Student s where score > :minMarks and score < :maxMarks")
	List<Student> findAllStudentsByMarksRange(@Param("minMarks") int min, @Param("maxMarks") int max);
	
	//pagination support
	
	@Query("select s from Student s")
	List<Student> findAllStudents(Pageable pageable);
	
	@Query("select s from Student s where firstName=:fName")
	List<Student> findAllStudentsByName(@Param("fName") String name, Pageable pageable);
}
