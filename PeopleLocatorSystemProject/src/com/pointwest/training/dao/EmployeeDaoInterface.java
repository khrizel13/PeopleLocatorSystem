package com.pointwest.training.dao;

import java.util.List;

import com.pointwest.training.bean.EmployeeBean;
import com.pointwest.training.bean.EmployeeSeatLocationBean;

public interface EmployeeDaoInterface {

	EmployeeBean login(String username, String password);

	List<EmployeeSeatLocationBean> getAllEmployeeSeatLocation();
	
	List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeId(String employeeId);

	List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeName(String employeeName);

	List<EmployeeSeatLocationBean> searchSeatLocationByEmployeeProject(String employeeProject);

	List<EmployeeSeatLocationBean> displaySeatPlanByLocation(String location, String floor);
	
	List<EmployeeSeatLocationBean> displaySeatPlanByQuadrant(String quadrant);
}
