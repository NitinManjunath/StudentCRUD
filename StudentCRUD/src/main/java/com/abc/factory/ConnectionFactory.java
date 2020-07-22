package com.abc.factory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {

	private static Connection connection;

	static {

		try {

			// Creating a data source Object
			MysqlDataSource dataSource = new MysqlDataSource();

			// Creating a properties file to store the values from properties file
			Properties properites = new Properties();
			properites.load(new FileInputStream("src/main/resources/com/abc/config/connection.properties"));

			String url = properites.getProperty("mysql.url");
			String userID = properites.getProperty("mysql.user");
			String pass = properites.getProperty("mysql.password");

			// Through setters set url,user,password
			dataSource.setURL(url);
			dataSource.setUser(userID);
			dataSource.setPassword(pass);

			// Get the connection object
			connection = dataSource.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnectionToDb() {
		return connection;
	}

}
