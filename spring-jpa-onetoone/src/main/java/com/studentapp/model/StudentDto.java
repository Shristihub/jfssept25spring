package com.studentapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
	
	private String studentName;
	private Integer studentId;
	private String department;
	private AddressDto address;
	

}











