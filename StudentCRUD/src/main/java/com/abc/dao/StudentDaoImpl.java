package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.dto.Student;
import com.abc.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String save(Student student) {
		String status = "";
		try {
			Connection connection = ConnectionFactory.getConnectionToDb();
			String sqlSelectQuery = "select * from `student` where `sid`=?";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sqlSelectQuery);
			preparedStatement.setString(1, student.getSid());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next() == true) {
				status = "alreadyExisted";

			} else {

				String sqlInsertQuery = "insert into `student`(`sid`,`sname`,`sage`,`saddress`)values(?,?,?,?)";
				preparedStatement = connection.prepareStatement(sqlInsertQuery);
				preparedStatement.setString(1, student.getSid());
				preparedStatement.setString(2, student.getSname());
				preparedStatement.setString(3, student.getSage());
				preparedStatement.setString(4, student.getSaddress());

				int rowCount = preparedStatement.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}

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
