package com.abc.factory;

import com.abc.service.StudentService;
import com.abc.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static StudentService studentService;

	static {
		studentService = new StudentServiceImpl();
	}

	public static StudentService getStudentService() {
		return studentService;
	}

}
