package com.pointwest.training.main;


import org.apache.log4j.Logger;

import com.pointwest.training.bean.EmployeeBean;
import com.pointwest.training.ui.PeopleLocatorSystemUI;

public class PeopleLocatorSystemMain {
	final static Logger logger = Logger.getLogger(PeopleLocatorSystemMain.class);
	public static void main(String[] args) {
		EmployeeBean employeeBean = new EmployeeBean();
		PeopleLocatorSystemUI peopleLocatorSystemUI = new PeopleLocatorSystemUI();
		boolean checkLogin = true;
		boolean returnMenu = true;
		int selectedSearchMenu = 0;
		int selectedSearchAction = 0;
		boolean checkSearchAgain = true;
		int selectedSeatPlanMenu = 0;
		int selectedViewSeatAction = 0;
		boolean checkViewSeatPlanAgain = true;

		do {
			employeeBean = peopleLocatorSystemUI.login(); //accessing login method
			if (employeeBean.getUsername() == null && employeeBean.getPassword() == null) {
				peopleLocatorSystemUI.displayMessageIncorrectLogin();
				employeeBean = null;
				logger.error("Invalid username/password!");
			} else {
				logger.info("User successfully login! USER :"+ employeeBean.getUsername());
				checkLogin = false;
				returnMenu = true;
				while (returnMenu) {
					checkSearchAgain = true;
					checkViewSeatPlanAgain = true;
					int menuInput = peopleLocatorSystemUI.displayHomePage(employeeBean);
					
					switch (menuInput) {
					case 1:
						while (checkSearchAgain) {
							selectedSearchMenu = peopleLocatorSystemUI.displaySearchMenu();
							peopleLocatorSystemUI.getInputSearch(selectedSearchMenu);
							selectedSearchAction = peopleLocatorSystemUI.displaySeachActions();
							if (selectedSearchAction == 1) {
								checkSearchAgain = true;
							} else if (selectedSearchAction == 2) {
								checkSearchAgain = false;
								break;
							}
						}
						break;
					case 2:
						while (checkViewSeatPlanAgain) {
							selectedSeatPlanMenu = peopleLocatorSystemUI.displayViewSeatPlanMenu();
							peopleLocatorSystemUI.getInputViewSeatPlan(selectedSeatPlanMenu);
							selectedViewSeatAction = peopleLocatorSystemUI.displaySeatPlanActions();
							if (selectedViewSeatAction == 1) {
								checkViewSeatPlanAgain = true;
							} else if (selectedViewSeatAction == 2) {
								checkViewSeatPlanAgain = false;
								break;
							}
						}
						break;
					case 3:
						returnMenu = false;
						checkLogin = true;
						break;
					}
				}
			}

		} while (checkLogin);

	}

}
