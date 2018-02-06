package com.pointwest.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.training.bean.EmployeeBean;
import com.pointwest.training.bean.EmployeeSeatLocationBean;
import com.pointwest.training.dbconnection.JDBCMySQLConnection;
import com.pointwest.training.main.PeopleLocatorSystemMain;

public class EmployeeDao implements EmployeeDaoInterface {
	ResultSet rs = null;
	Connection connection = null;
	PreparedStatement statement = null;
	final static Logger logger = Logger.getLogger(EmployeeDao.class);
	
	// -------------------------SQL query for login
	@Override
	public EmployeeBean login(String username, String password) {
		logger.info("login - Start");
		EmployeeBean employee = new EmployeeBean();
		String query = "SELECT * FROM employee WHERE username = ? and password = ?";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			rs = statement.executeQuery();
			if (rs.next()) {

				employee.setEmployeeId(rs.getString("emp_id"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setRole(rs.getString("role"));
				employee.setShift(rs.getString("shift"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		}
		logger.info("login - End");
		return employee;
	}
	
	// -------------------------SQL query for Search Seat Location By Employee ID
	@Override
	public List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeId(String employeeId) {
		logger.info("login - Start");
		List<EmployeeSeatLocationBean> employeeSeatLocationBeans = new ArrayList<>();
		String query = "SELECT * FROM v_employeeseatlocation WHERE emp_id like ?";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, employeeId+"%");
			rs = statement.executeQuery();
			while (rs.next()) {
				EmployeeSeatLocationBean employeeSeatLocationBean = new EmployeeSeatLocationBean();
				employeeSeatLocationBean.setEmployeeId(rs.getString("emp_id"));
				employeeSeatLocationBean.setFirstName(rs.getString("first_name"));
				employeeSeatLocationBean.setLastName(rs.getString("last_name"));
				employeeSeatLocationBean.setBldgId(rs.getString("bldg_id"));
				employeeSeatLocationBean.setBldgAddress(rs.getString("bldg_address"));
				employeeSeatLocationBean.setFloorNumber(rs.getString("floor_number"));
				employeeSeatLocationBean.setQuadrant(rs.getString("quadrant"));
				employeeSeatLocationBean.setColumnNumber(rs.getString("column_number"));
				employeeSeatLocationBean.setRowNumber(rs.getString("row_number"));
				employeeSeatLocationBean.setLocalNumber(rs.getString("local_number"));
				employeeSeatLocationBean.setShift(rs.getString("shift"));
				employeeSeatLocationBean.setProjectAlias(rs.getString("proj_alias"));
				employeeSeatLocationBeans.add(employeeSeatLocationBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		}
		logger.info("login - End");
		return employeeSeatLocationBeans;
	}

	// -------------------------SQL query for Search Seat Location By Employee Name
	@Override
	public List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeName(String employeeName) {
		logger.info("login - Start");
		List<EmployeeSeatLocationBean> employeeSeatLocationBeans = new ArrayList<>();
		String query = "SELECT * FROM v_employeeseatlocation WHERE first_name like ? OR last_name like ?";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, employeeName+"%");
			statement.setString(2, employeeName+"%");
			rs = statement.executeQuery();
			while (rs.next()) {
				EmployeeSeatLocationBean employeeSeatLocationBean = new EmployeeSeatLocationBean();
				employeeSeatLocationBean.setEmployeeId(rs.getString("emp_id"));
				employeeSeatLocationBean.setFirstName(rs.getString("first_name"));
				employeeSeatLocationBean.setLastName(rs.getString("last_name"));
				employeeSeatLocationBean.setBldgId(rs.getString("bldg_id"));
				employeeSeatLocationBean.setBldgAddress(rs.getString("bldg_address"));
				employeeSeatLocationBean.setFloorNumber(rs.getString("floor_number"));
				employeeSeatLocationBean.setQuadrant(rs.getString("quadrant"));
				employeeSeatLocationBean.setColumnNumber(rs.getString("column_number"));
				employeeSeatLocationBean.setRowNumber(rs.getString("row_number"));
				employeeSeatLocationBean.setLocalNumber(rs.getString("local_number"));
				employeeSeatLocationBean.setShift(rs.getString("shift"));
				employeeSeatLocationBean.setProjectAlias(rs.getString("proj_alias"));
				employeeSeatLocationBeans.add(employeeSeatLocationBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		}
		logger.info("login - End");
		return employeeSeatLocationBeans;
	}

	// -------------------------SQL query for Search Seat Location By Employee Project
	@Override
	public List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeProject(String employeeProject) {
		logger.info("login - Start");
		List<EmployeeSeatLocationBean> employeeSeatLocationBeans = new ArrayList<>();
		String query = "SELECT * FROM v_employeeseatlocation WHERE proj_alias like ?";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, employeeProject+"%");
			rs = statement.executeQuery();
			while (rs.next()) {
				EmployeeSeatLocationBean employeeSeatLocationBean = new EmployeeSeatLocationBean();
				employeeSeatLocationBean.setEmployeeId(rs.getString("emp_id"));
				employeeSeatLocationBean.setFirstName(rs.getString("first_name"));
				employeeSeatLocationBean.setLastName(rs.getString("last_name"));
				employeeSeatLocationBean.setBldgId(rs.getString("bldg_id"));
				employeeSeatLocationBean.setBldgAddress(rs.getString("bldg_address"));
				employeeSeatLocationBean.setFloorNumber(rs.getString("floor_number"));
				employeeSeatLocationBean.setQuadrant(rs.getString("quadrant"));
				employeeSeatLocationBean.setColumnNumber(rs.getString("column_number"));
				employeeSeatLocationBean.setRowNumber(rs.getString("row_number"));
				employeeSeatLocationBean.setLocalNumber(rs.getString("local_number"));
				employeeSeatLocationBean.setShift(rs.getString("shift"));
				employeeSeatLocationBean.setProjectAlias(rs.getString("proj_alias"));
				employeeSeatLocationBeans.add(employeeSeatLocationBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		}
		logger.info("login - End");
		return employeeSeatLocationBeans;
	}

	// -------------------------SQL query for display seat plan by Location
	@Override
	public List<EmployeeSeatLocationBean> displaySeatPlanByLocation(String location, String floor) {
		logger.info("login - Start");
		List<EmployeeSeatLocationBean> employeeSeatLocationBeans = new ArrayList<>();
		String query = "SELECT * FROM v_employeeseatlocation WHERE bldg_id = ? AND floor_number = ?";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, location);
			statement.setString(2, floor);
			rs = statement.executeQuery();
			while (rs.next()) {
				EmployeeSeatLocationBean employeeSeatLocationBean = new EmployeeSeatLocationBean();
				employeeSeatLocationBean.setEmployeeId(rs.getString("emp_id"));
				employeeSeatLocationBean.setFirstName(rs.getString("first_name"));
				employeeSeatLocationBean.setLastName(rs.getString("last_name"));
				employeeSeatLocationBean.setBldgId(rs.getString("bldg_id"));
				employeeSeatLocationBean.setBldgAddress(rs.getString("bldg_address"));
				employeeSeatLocationBean.setFloorNumber(rs.getString("floor_number"));
				employeeSeatLocationBean.setQuadrant(rs.getString("quadrant"));
				employeeSeatLocationBean.setColumnNumber(rs.getString("column_number"));
				employeeSeatLocationBean.setRowNumber(rs.getString("row_number"));
				employeeSeatLocationBean.setLocalNumber(rs.getString("local_number"));
				employeeSeatLocationBean.setShift(rs.getString("shift"));
				employeeSeatLocationBean.setProjectAlias(rs.getString("proj_alias"));
				employeeSeatLocationBeans.add(employeeSeatLocationBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		}
		logger.info("login - End");
		return employeeSeatLocationBeans;
	}

	// -------------------------SQL query for display seat plan by quadrant
	@Override
	public List<EmployeeSeatLocationBean> displaySeatPlanByQuadrant(String quadrant) {
		logger.info("login - Start");
		List<EmployeeSeatLocationBean> employeeSeatLocationBeans = new ArrayList<>();
		String query = "SELECT * FROM v_employeeseatlocation WHERE quadrant = ?";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, quadrant);
			rs = statement.executeQuery();
			while (rs.next()) {
				EmployeeSeatLocationBean employeeSeatLocationBean = new EmployeeSeatLocationBean();
				employeeSeatLocationBean.setEmployeeId(rs.getString("emp_id"));
				employeeSeatLocationBean.setFirstName(rs.getString("first_name"));
				employeeSeatLocationBean.setLastName(rs.getString("last_name"));
				employeeSeatLocationBean.setBldgId(rs.getString("bldg_id"));
				employeeSeatLocationBean.setBldgAddress(rs.getString("bldg_address"));
				employeeSeatLocationBean.setFloorNumber(rs.getString("floor_number"));
				employeeSeatLocationBean.setQuadrant(rs.getString("quadrant"));
				employeeSeatLocationBean.setColumnNumber(rs.getString("column_number"));
				employeeSeatLocationBean.setRowNumber(rs.getString("row_number"));
				employeeSeatLocationBean.setLocalNumber(rs.getString("local_number"));
				employeeSeatLocationBean.setShift(rs.getString("shift"));
				employeeSeatLocationBean.setProjectAlias(rs.getString("proj_alias"));
				employeeSeatLocationBeans.add(employeeSeatLocationBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		}
		logger.info("login - End");
		return employeeSeatLocationBeans;
	}

	// -------------------------SQL query for getting all employee location
	@Override
	public List<EmployeeSeatLocationBean> getAllEmployeeSeatLocation() {
		logger.info("login - Start");
		List<EmployeeSeatLocationBean> employeeSeatLocationBeans = new ArrayList<>();
		String query = "SELECT * FROM v_employeeseatlocation";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			while (rs.next()) {
				EmployeeSeatLocationBean employeeSeatLocationBean = new EmployeeSeatLocationBean();
				employeeSeatLocationBean.setEmployeeId(rs.getString("emp_id"));
				employeeSeatLocationBean.setFirstName(rs.getString("first_name"));
				employeeSeatLocationBean.setLastName(rs.getString("last_name"));
				employeeSeatLocationBean.setBldgId(rs.getString("bldg_id"));
				employeeSeatLocationBean.setBldgAddress(rs.getString("bldg_address"));
				employeeSeatLocationBean.setFloorNumber(rs.getString("floor_number"));
				employeeSeatLocationBean.setQuadrant(rs.getString("quadrant"));
				employeeSeatLocationBean.setColumnNumber(rs.getString("column_number"));
				employeeSeatLocationBean.setRowNumber(rs.getString("row_number"));
				employeeSeatLocationBean.setLocalNumber(rs.getString("local_number"));
				employeeSeatLocationBean.setShift(rs.getString("shift"));
				employeeSeatLocationBean.setProjectAlias(rs.getString("proj_alias"));
				employeeSeatLocationBeans.add(employeeSeatLocationBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		logger.info("login - End");
		return employeeSeatLocationBeans;
	}

}
