package com.pointwest.training.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pointwest.training.bean.EmployeeBean;
import com.pointwest.training.bean.EmployeeSeatLocationBean;
import com.pointwest.training.manager.PeopleLocatorSystemManager;

public class PeopleLocatorSystemUI {
	Scanner scanner = new Scanner(System.in);
	
	// -----------EMployeeLogin Page
	public EmployeeBean login() {
		EmployeeBean employeeBean = new EmployeeBean();
		PeopleLocatorSystemManager peopleLocatorSystemManager = new PeopleLocatorSystemManager();
		System.out.println("-----------------------------------");
		System.out.println("           **LOGIN**");
		System.out.println("-----------------------------------");
		System.out.println("Username:");
		employeeBean.setUsername(scanner.nextLine());
		
		System.out.println("Password:");
		employeeBean.setPassword(scanner.nextLine());

		return peopleLocatorSystemManager.login(employeeBean.getUsername(), employeeBean.getPassword());

	}

	// -----------will display the error message for the incorrect user name /pass
	public void displayMessageIncorrectLogin() {
		System.out.println("");
		System.out.println("Incorrect Username/Password. Please try again.");
	}

	// -----------will display Home page
	public int displayHomePage(EmployeeBean employeeBean) {
		int selectedHomeMenu = 0;
		System.out.println("## HOME ##");
		System.out.println("-----------------------------------");
		System.out.println("Welcome " + employeeBean.getFirstName() + " " + employeeBean.getLastName() + " ["
				+ employeeBean.getRole() + "]!");
		System.out.println("-----------------------------------");
		System.out.println("MENU:");
		System.out.println("[1]Search");
		System.out.println("[2]View Seatplan");
		System.out.println("[3]Logout");
		selectedHomeMenu =inputNumberValidation();
		

		
		return selectedHomeMenu;
	}

	// -----------will display search menu page
	public int displaySearchMenu() {
		int selectedSearchMenu;
		System.out.println("## SEARCH ##");
		System.out.println("MENU:");
		System.out.println("[1]By Employee Id");
		System.out.println("[2]By Name");
		System.out.println("[3]By Project");
		selectedSearchMenu = inputNumberValidation();
		return selectedSearchMenu;
	}

	// -----------Search selection for employee ID/Name/Project
	public List<EmployeeSeatLocationBean> getInputSearch(int searchMenuInput) {
		PeopleLocatorSystemManager peopleLocatorSystemManager = new PeopleLocatorSystemManager();
		List<EmployeeSeatLocationBean> employeeSeatLocationBeans = new ArrayList<>();
		switch (searchMenuInput) {
		case 1:
			System.out.println("Enter Employee ID :");
			String employeeId = scanner.next();
			employeeSeatLocationBeans = displaySearchResult(
					peopleLocatorSystemManager.searchSeatLocationByEmployeeId(employeeId));
			break;
		case 2:
			System.out.println("Enter Employee Name :");
			scanner.nextLine();
			String employeeName = scanner.nextLine();
			employeeSeatLocationBeans = displaySearchResult(
					peopleLocatorSystemManager.searchSeatLocationByEmployeeName(employeeName));
			break;
		case 3:
			System.out.println("Enter Employee's Project :");
			scanner.nextLine();
			String employeeProject = scanner.next();
			employeeSeatLocationBeans = displaySearchResult(
					peopleLocatorSystemManager.searchSeatLocationByEmployeeProject(employeeProject));
			break;
		}
		return employeeSeatLocationBeans;
	}

	// -----------display Search result
	public List<EmployeeSeatLocationBean> displaySearchResult(
			List<EmployeeSeatLocationBean> employeeSeatLocationBeans) {
		System.out.println("## SEARCH RESULT – (" + employeeSeatLocationBeans.size() + ") ## ");
		System.out.println("---------------------------------------------------------------");
		System.out.println("EMPLOYEE ID | FIRSTNAME | LASTNAME | SEAT | LOCAL | SHIFT | PROJECT(S)");
		int rowCount = 0;
		for (EmployeeSeatLocationBean employeeSeatLocationBean : employeeSeatLocationBeans) {
			++rowCount;
			System.out.println("[" + rowCount + "] " + employeeSeatLocationBean.getEmployeeId() + " | "
					+ employeeSeatLocationBean.getFirstName() + " | " + employeeSeatLocationBean.getLastName() + " | "
					+ employeeSeatLocationBean.getBldgId() + employeeSeatLocationBean.getFloorNumber() + "F"
					+ employeeSeatLocationBean.getQuadrant() + employeeSeatLocationBean.getColumnNumber() + "-"
					+ employeeSeatLocationBean.getRowNumber() + " | " + employeeSeatLocationBean.getLocalNumber()
					+ " | " + employeeSeatLocationBean.getShift() + " | " + employeeSeatLocationBean.getProjectAlias());
		}
		System.out.println("---------------------- end of result ----------------------------");
		System.out.println("");
		return employeeSeatLocationBeans;
	}

	// -----------will display the search action
	public int displaySeachActions() {
		System.out.println("ACTIONS: [1] Search Again [2] Home");
		int selectedAction = inputNumberValidation();
		return selectedAction;
	}

	// -----------will display the view seat plan page
	public int displayViewSeatPlanMenu() {
		int selectedViewSeatPlanMenu;
		System.out.println("## VIEW SEATPLAN ##");
		System.out.println("MENU:");
		System.out.println("[1] By Location – Floor Level");
		System.out.println("[2] By Quadrant");
		System.out.println("[3] By Employee");
		selectedViewSeatPlanMenu = inputNumberValidation();
		return selectedViewSeatPlanMenu;
	}

	// -----------View seat plan selection if by location/quadrant/Employee #
	public void getInputViewSeatPlan(int inputSeatPlan) {
		PeopleLocatorSystemManager peopleLocatorSystemManager = new PeopleLocatorSystemManager();
		switch (inputSeatPlan) {
		case 1:
			System.out.println("## VIEW SEATPLAN – By Location – Floor Level ##");
			System.out.print("Enter Location : ");
			String location = scanner.next();
			System.out.print("Enter Floor Level : ");
			String floor = scanner.next();
			displaySeatPlan(peopleLocatorSystemManager.displaySeatPlanByLocation(location, floor));
			break;
		case 2:
			System.out.println("## VIEW SEATPLAN – By Quardrant ##");
			System.out.print("Enter Quardrant : ");
			String quadrant = scanner.next();
			displaySeatPlan(peopleLocatorSystemManager.displaySeatPlanByQuadrant(quadrant));
			break;
		case 3:
			System.out.println("## VIEW SEATPLAN – By Employee ##");
			System.out.print("-- You need to search for an employee first. --");
			int selectedEmployeeSearch = displaySearchMenu();
			List<EmployeeSeatLocationBean> seatPlanEmployees = getInputSearch(selectedEmployeeSearch);
			selectEmployeeToBeDisplayed(seatPlanEmployees);
			break;
		}
	}

	// -----------Display the seat plan result
	public void displaySeatPlan(List<EmployeeSeatLocationBean> employeeSeatLocationBeans) {
		System.out.println("## VIEW SEATPLAN ## ");
		System.out.println("LOCATION : " + employeeSeatLocationBeans.get(0).getBldgId() + "["
				+ employeeSeatLocationBeans.get(0).getBldgAddress() + "], FLOOR : "
				+ employeeSeatLocationBeans.get(0).getFloorNumber());
		System.out.println("-------------------------------------------------------");

		for (EmployeeSeatLocationBean employeeSeatLocationBean : employeeSeatLocationBeans) {

			System.out.println(employeeSeatLocationBean.getBldgId() + employeeSeatLocationBean.getFloorNumber() + "F"
					+ employeeSeatLocationBean.getQuadrant() + employeeSeatLocationBean.getColumnNumber() + "-"
					+ employeeSeatLocationBean.getRowNumber() + " | " + employeeSeatLocationBean.getFirstName() + " | "
					+ employeeSeatLocationBean.getLastName() + "\t");

		}

		System.out.println("---------------------- end of seatplan ----------------------------");
		System.out.println("");
	}

	// -----------Display seat plan actions
	public int displaySeatPlanActions() {
		System.out.println("ACTIONS: [1] View seatplan Again [2] Home");
		int selectedAction = inputNumberValidation();
		return selectedAction;
	}

	// -----------will select the employee you want to view
	public void selectEmployeeToBeDisplayed(List<EmployeeSeatLocationBean> employeeSeatLocationBeans) {
		System.out.print("Enter the result no. of the employee you want to view:");
		int selectedEmployee = inputNumberValidation();
		viewSearchEmployeeSeatPlan(employeeSeatLocationBeans, selectedEmployee);

	}

	// -----------will display the employee seat plan
	public void viewSearchEmployeeSeatPlan(List<EmployeeSeatLocationBean> employeeSeatLocationBeans,
			int selectedEmployee) {
		System.out.println("## VIEW SEATPLAN - By Employee ## ");
		int index = 0;
		String employeeId = "";
		List<EmployeeSeatLocationBean> list = new ArrayList<>();
		for (EmployeeSeatLocationBean employeeSeatLocationBean : employeeSeatLocationBeans) {
			++index;
			if (selectedEmployee == index) {
				employeeId = employeeSeatLocationBean.getEmployeeId();
			}
		}
		System.out.println(employeeId);
		PeopleLocatorSystemManager peopleLocatorSystemManager = new PeopleLocatorSystemManager();
		list = peopleLocatorSystemManager.getAllEmployeeSeatLocation();
		for (EmployeeSeatLocationBean employeeSeatLocationBean : list) {
			if (employeeSeatLocationBean.getEmployeeId().equals(employeeId)) {
				System.out.println(employeeSeatLocationBean.getBldgId() + employeeSeatLocationBean.getFloorNumber()
						+ "F" + employeeSeatLocationBean.getQuadrant() + employeeSeatLocationBean.getColumnNumber()
						+ "-" + employeeSeatLocationBean.getRowNumber());
				System.out.println("*" + employeeSeatLocationBean.getFirstName() + ","
						+ employeeSeatLocationBean.getLastName() + "*");
			} else {
				System.out.println(employeeSeatLocationBean.getBldgId() + employeeSeatLocationBean.getFloorNumber()
						+ "F" + employeeSeatLocationBean.getQuadrant() + employeeSeatLocationBean.getColumnNumber()
						+ "-" + employeeSeatLocationBean.getRowNumber());
				System.out.println(
						employeeSeatLocationBean.getFirstName() + "," + employeeSeatLocationBean.getLastName());
				System.out.println("");
			}
			System.out.println("-------------------------- end of seatplan --------------------------------");
		}
	}
	
	// -----------will validate the input for integer
	public int inputNumberValidation() {
		int inputNumber = 0;
		String err = "Invalid Input";
		
				while(!scanner.hasNextInt() || (inputNumber = scanner.nextInt()) <=0) {
					System.err.println(err + ", " + "Please Select Again");
					scanner.next();
				}
		return inputNumber;
	}
}
