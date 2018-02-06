package com.pointwest.training.dbconnection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.pointwest.training.dao.EmployeeDao;

public class JDBCMySQLConnection {

	private static JDBCMySQLConnection instance = new JDBCMySQLConnection();
	public static final String URL = "jdbc:mysql://localhost/plsdb";
	public static final String USER = "root";
	public static final String PASSWORD = "abc123";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	final static Logger logger = Logger.getLogger(JDBCMySQLConnection.class);

	// private constructor
	private JDBCMySQLConnection() {
		try {
			// Step 2: Load MySQL Java driver
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	private Connection createConnection() {

		Connection connection = null;
		try {
			// Step 3: Establish Java MySQL connection
			connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
			logger.error(e);
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
