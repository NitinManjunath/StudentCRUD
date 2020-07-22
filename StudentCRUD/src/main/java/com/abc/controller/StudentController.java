package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dto.Student;
import com.abc.factory.StudentServiceFactory;
import com.abc.service.StudentService;

/**
 * SERVLET implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Took the data from the client
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String saddress = request.getParameter("saddress");

		// Create a student object use DTO pattern to transfer the data
		Student student = new Student();
		student.setSid(sid);
		student.setSage(sage);
		student.setSname(sname);
		student.setSaddress(saddress);

		//Use Factory Design patter to the StudentService object
		StudentService studentService = StudentServiceFactory.getStudentService();
		
		String status = studentService.save(student);

		RequestDispatcher requestDispatcher = null;
		if (status.equals("success")) {
			requestDispatcher = request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);
		}
		if (status.equals("failure")) {
			requestDispatcher = request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);
		}
		if (status.equals("alreadyExisted")) {
			requestDispatcher = request.getRequestDispatcher("existed.html");
			requestDispatcher.forward(request, response);
		}

	}

}
