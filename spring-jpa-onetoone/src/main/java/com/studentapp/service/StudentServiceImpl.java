package com.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;
import com.studentapp.util.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

	

	private final IStudentRepository repository;
	private final StudentMapper mapper;

    @Override
	public void addStudent(StudentDto studentDto) {
		Student student = mapper.convertToEntity(studentDto);
		repository.save(student);
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		Student student = mapper.convertToEntity(studentDto);
		repository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		repository.deleteById(studentId);
	}

	@Override
	public List<StudentDto> getAll() {
		return repository.findAll()
						 .stream()
						 .map(student -> mapper.convertToDto(student)).toList();
	}

	@Override
	public StudentDto getById(int studentId) throws StudentNotFoundException {
		Optional<Student> optstudent = repository.findById(studentId);
		if(optstudent.isPresent()) {
			Student student  = optstudent.get();
		    return mapper.convertToDto(student);
		}
		throw new StudentNotFoundException("invalid id");
	}

	@Override
	public List<StudentDto> getByDepartment(String department) {
		List<Student> students = repository.findByDepartment(department);
		return students.stream()
		 .map(student -> mapper.convertToDto(student)).toList();
		
	}

	@Override
	public List<StudentDto> getByCity(String city) {
		List<Student> students = repository.findByCity(city);
		return students.stream()
		 .map(student -> mapper.convertToDto(student)).toList();
	}

	@Override
	public List<StudentDto> getByDeptAndCity(String department, String city) {
		List<Student> students = repository.findByDeptCity(department,city);
		return students.stream()
		 .map(student -> mapper.convertToDto(student)).toList();
	}
}
