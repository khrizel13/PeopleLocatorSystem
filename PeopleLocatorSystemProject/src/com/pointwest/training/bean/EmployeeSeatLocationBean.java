package com.pointwest.training.bean;

public class EmployeeSeatLocationBean {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String bldgId;
	private String bldgAddress;
	private String floorNumber;
	private String quadrant;
	private String columnNumber;
	private String rowNumber;
	private String localNumber;
	private String shift;
	private String projectAlias;

	public EmployeeSeatLocationBean() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeSeatLocationBean(String employeeId, String firstName, String lastName, String bldgId,
			String bldgAddress, String floorNumber, String quadrant, String columnNumber, String rowNumber,
			String localNumber, String shift, String projectAlias) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bldgId = bldgId;
		this.bldgAddress = bldgAddress;
		this.floorNumber = floorNumber;
		this.quadrant = quadrant;
		this.columnNumber = columnNumber;
		this.rowNumber = rowNumber;
		this.localNumber = localNumber;
		this.shift = shift;
		this.projectAlias = projectAlias;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBldgId() {
		return bldgId;
	}

	public void setBldgId(String bldgId) {
		this.bldgId = bldgId;
	}

	public String getBldgAddress() {
		return bldgAddress;
	}

	public void setBldgAddress(String bldgAddress) {
		this.bldgAddress = bldgAddress;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getQuadrant() {
		return quadrant;
	}

	public void setQuadrant(String quadrant) {
		this.quadrant = quadrant;
	}

	public String getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(String columnNumber) {
		this.columnNumber = columnNumber;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getProjectAlias() {
		return projectAlias;
	}

	public void setProjectAlias(String projectAlias) {
		this.projectAlias = projectAlias;
	}

	@Override
	public String toString() {
		return "EmployeeSeatLocationBean [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", bldgId=" + bldgId + ", bldgAddress=" + bldgAddress + ", floorNumber=" + floorNumber
				+ ", quadrant=" + quadrant + ", columnNumber=" + columnNumber + ", rowNumber=" + rowNumber
				+ ", localNumber=" + localNumber + ", shift=" + shift + ", projectAlias=" + projectAlias + "]";
	}

}
