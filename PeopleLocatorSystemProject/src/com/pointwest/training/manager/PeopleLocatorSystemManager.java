package com.pointwest.training.manager;

import java.util.List;

import com.pointwest.training.bean.EmployeeBean;
import com.pointwest.training.bean.EmployeeSeatLocationBean;
import com.pointwest.training.dao.EmployeeDao;

public class PeopleLocatorSystemManager {
	EmployeeDao employeeDao = new EmployeeDao();

	public EmployeeBean login(String username, String password) {
		return employeeDao.login(username, password);
	}

	public List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeId(String employeeId) {
		return employeeDao.searchSeatLocationByEmployeeId(employeeId);
	}

	public List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeName(String employeeName) {
		return employeeDao.searchSeatLocationByEmployeeName(employeeName);
	}

	public List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeProject(String employeeProject) {
		return employeeDao.searchSeatLocationByEmployeeProject(employeeProject);
	}

	public List<EmployeeSeatLocationBean> displaySeatPlanByLocation(String location, String floor) {
		return employeeDao.displaySeatPlanByLocation(location, floor);
	}
	
	public List<EmployeeSeatLocationBean> displaySeatPlanByQuadrant(String quadrant) {
		return employeeDao.displaySeatPlanByQuadrant(quadrant);
	}
	
	public List<EmployeeSeatLocationBean> getAllEmployeeSeatLocation() {
		return employeeDao.getAllEmployeeSeatLocation();
	}
}
