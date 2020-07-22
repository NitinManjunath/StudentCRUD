package com.abc.service;

import com.abc.dto.Student;

public interface StudentService {

	public String save(Student student);

	public Student findById(String sid);

	public String deleteById(String sid);

}
