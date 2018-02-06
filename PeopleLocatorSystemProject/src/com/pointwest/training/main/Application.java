package com.pointwest.training.main;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pointwest.training.bean.EmployeeBean;
import com.pointwest.training.dbconnection.JDBCMySQLConnection;

public class Application {

	public static void main(String[] args) {
		Application application = new Application();
		List<EmployeeBean> employeeList = application.getEmployeeListByRole("Employee","REG");
		for (EmployeeBean employeeBean : employeeList) {
			employeeBean.toString();
			System.out.println(employeeBean.getEmployeeId()+" : "+ employeeBean.getUsername()+" : "+ employeeBean.getPassword());
		}
	}
	
	public List<EmployeeBean> getEmployeeListByRole(String role, String shift){
		ResultSet rs = null;
        Connection connection = null;
        PreparedStatement  statement = null; 
         
        List<EmployeeBean> employees = new ArrayList<>();
        String query = "SELECT * FROM employee WHERE role = ? and shift = ?";
        try {           
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, role);
            statement.setString(2, shift);
            rs = statement.executeQuery();
             
            while (rs.next()) {
                EmployeeBean employee = new EmployeeBean();
                employee.setEmployeeId(rs.getString("emp_id"));
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setRole(rs.getString("role"));
                employee.setShift(rs.getString("shift"));
                employees.add(employee);
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
        return employees;
	}
}
