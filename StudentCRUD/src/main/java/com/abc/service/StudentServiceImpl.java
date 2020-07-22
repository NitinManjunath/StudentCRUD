package com.abc.service;

import com.abc.dao.StudentDao;
import com.abc.dto.Student;
import com.abc.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String save(Student student) {

		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.save(student);

		return status;
	}

	@Override
	public Student findById(String sid) {
		return null;
	}

	@Override
	public String deleteById(String sid) {
		return null;
	}

}
