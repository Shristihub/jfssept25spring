package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentapp.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

	// derived queries
	List<Student> findByDepartment(String department);

	List<Student> findByAddressCity(String city);

	// select * from student s inner join address a on s.address_id=a.address_id
	// where a.city='Bengaluru'
	@Query("select s from Student s join s.address a where a.city= ?1")
	List<Student> findByCity(String city);

	@Query("""
			select s from Student s join s.address a where s.department=?1
			and a.city=?2
			""")
	List<Student> findByDeptCity(String dept, String city);

}
