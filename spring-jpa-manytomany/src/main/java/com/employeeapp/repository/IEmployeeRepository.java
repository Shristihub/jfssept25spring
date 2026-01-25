package com.employeeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Employee;
import com.employeeapp.model.Employee;
import com.employeeapp.model.Mode;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByCity(String city);

	@Query("select e from Employee e join fetch e.courses c where c.courseName=?1")
	List<Employee> findByCourseName(String courseName); // list of emps taking java

	@Query("""
			select e from Employee e join fetch e.courses c where c.courseName=?1
			and c.courseLevel=?2
			""")
	List<Employee> findByCourseNameAndLevel(String courseName, CourseLevel level);// list of emps taking java
																						// beginner level

	@Query(
			"""
				select e from Employee e join fetch e.courses c where c.courseName=?1
				and c.mode=?2
				"""	)
	List<Employee> findByCourseNameAndMode(String courseName,Mode mode); // list of emps taking java online

}
