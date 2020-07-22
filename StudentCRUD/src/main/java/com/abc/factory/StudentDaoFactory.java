package com.abc.factory;

import com.abc.dao.StudentDao;
import com.abc.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static StudentDao stduentDao;

	static {
		stduentDao = new StudentDaoImpl();
	}

	public static StudentDao getStudentDao() {
		return stduentDao;
	}

}
