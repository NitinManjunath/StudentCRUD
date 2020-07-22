package com.abc.dao;

import com.abc.dto.Student;

public interface StudentDao {

	public String save(Student student);

	public Student findById(String sid);

	public String deleteById(String sid);
}
