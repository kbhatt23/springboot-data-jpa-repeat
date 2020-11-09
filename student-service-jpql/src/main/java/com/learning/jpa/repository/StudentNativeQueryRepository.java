package com.learning.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.jpa.entities.Student;

//this supports native sql query
@Repository
public interface StudentNativeQueryRepository extends PagingAndSortingRepository<Student, Long>{
	//need to use table and columns here
	@Query(nativeQuery = true,value = "select * from student")
	List<Student> findAllStudents();
	
	@Query(nativeQuery = true, value = "select fname,lname from student")
	List<Object[]> findAllStudentsData();
	
	@Query(nativeQuery = true, value = "select * from student where fname=:fName")
	List<Student> findAllStudentsByName(@Param("fName") String name);
	
	@Query(nativeQuery = true, value = "select * from student s where score > :minMarks and score < :maxMarks")
	List<Student> findAllStudentsByMarksRange(@Param("minMarks") int min, @Param("maxMarks") int max);
	
	//pagination support
	
	@Query(/* nativeQuery = true, */value = "select s from Student s")
	List<Student> findAllStudents(Pageable pageable);
	
	@Query(/* nativeQuery = true, */value = "select s from Student s where firstName=:fName")
	List<Student> findAllStudentsByName(@Param("fName") String name, Pageable pageable);
}
