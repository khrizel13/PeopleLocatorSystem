package com.pointwest.training.bean;

public class SeatBean {
	private int seatId;
	private String bldgId;
	private String floorNumber;
	private String quadrant;
	private String rowNumber;
	private String columnNumber;
	private String localNumber;

	public SeatBean() {
		// TODO Auto-generated constructor stub
	}

	public SeatBean(int seatId, String bldgId, String floorNumber, String quadrant, String rowNumber,
			String columnNumber, String localNumber) {
		super();
		this.seatId = seatId;
		this.bldgId = bldgId;
		this.floorNumber = floorNumber;
		this.quadrant = quadrant;
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.localNumber = localNumber;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getBldgId() {
		return bldgId;
	}

	public void setBldgId(String bldgId) {
		this.bldgId = bldgId;
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

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(String columnNumber) {
		this.columnNumber = columnNumber;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

	@Override
	public String toString() {
		return "SeatBean [seatId=" + seatId + ", bldgId=" + bldgId + ", floorNumber=" + floorNumber + ", quadrant="
				+ quadrant + ", rowNumber=" + rowNumber + ", columnNumber=" + columnNumber + ", localNumber="
				+ localNumber + "]";
	}

}
