package com.studentapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
	
	private String studentName;
	@Id
	@GeneratedValue(generator = "student_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_gen",sequenceName = "stud_seq",initialValue = 1,allocationSize = 1)
	private Integer studentId;
	private String department;

	// when the student is saved the address object is also saved
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id") // give a different column name
	private Address address;
	

}











