package com.api.crew.aso.model;

public class FlightCrewDetails {
	private String flightNumber;
	private String flightDate;
	private String departureAirport;
	private String arrivalAirport;
	private String carrierCode;
	private String employeeId;
	private String roleCode;
	private String baseCode;
	private String rotationBeginDate;
	
	public FlightCrewDetails(String flightNumber, String flightDate,String departureAirport,String arrivalAirport
			,String carrierCode,String employeeId,String roleCode, String baseCode, String rotationBeginDate  ){
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.carrierCode = carrierCode;
		this.employeeId = employeeId;
		this.roleCode = roleCode;
		this.baseCode = baseCode;
		this.rotationBeginDate = rotationBeginDate;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getBaseCode() {
		return baseCode;
	}
	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}
	public String getRotationBeginDate() {
		return rotationBeginDate;
	}
	public void setRotationBeginDate(String rotationBeginDate) {
		this.rotationBeginDate = rotationBeginDate;
	}
	
	 @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class CrewMemberDetails {\n");
	    sb.append("    flightNumber: ").append(toIndentedString(flightNumber)).append("\n");
	    sb.append("    flightDate: ").append(toIndentedString(flightDate)).append("\n");
	    sb.append("    departureAirport: ").append(toIndentedString(departureAirport)).append("\n");
	    sb.append("    arrivalAirport: ").append(toIndentedString(arrivalAirport)).append("\n");
	    sb.append("    carrierCode: ").append(toIndentedString(carrierCode)).append("\n");
	    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
	    sb.append("    roleCode: ").append(toIndentedString(roleCode)).append("\n");
	    sb.append("    baseCode: ").append(toIndentedString(baseCode)).append("\n");
	    sb.append("    rotationBeginDate: ").append(toIndentedString(rotationBeginDate)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }
	 
	  private String toIndentedString(java.lang.Object o) {
		    if (o == null) {
		      return "null";
		    }
		    return o.toString().replace("\n", "\n    ");
		  }

}
