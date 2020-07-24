package com.api.crew.aso.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crew_incident_details")
public class CrewIncidentDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="incident_id")
	private Integer incidentId;
	@Column(name="crew_pass_id")
	private Long crewPassId;
	@Column(name="crew_pass_name")
	private String crewPassName;
	@Column(name="crew_pass_type")
	private String crewPassType;
	@Column(name="ticket_no")	
	private String ticketNo;
	@Column(name="seat_number")
	private String seatNumber;
	@Column(name="pnr")
	private String pnr;
	@Column(name="email_id")
	private String emailId;
	@Column(name="ph_no")
	private Long phoneNumber;
	@Column(name="emergency_contact_no")
	private Long emergencyContactNumber;
	@Column(name="address_to_contact")
	private String addressToContact;
	@Column(name="body_temperature")
	private String bodyTemperature;
	@Column(name="incident_status")
	private String incidentStatus;
	@Column(name="symptom_fever")
	private String symptomFever;
	@Column(name="symptom_cold")
	private String symptomCold;
	@Column(name="symptom_cough")
	private String symptomCough;
	@Column(name="symptom_breath")
	private String symptomBreath;
	@Column(name="wearing_mask")
	private String wearingMask;
	@Column(name="isolation_required")
	private String isolationRequired;
	@Column(name="arrival_station_code")
	private String arrivalStationCode;
	@Column(name="departure_station_code")
	private String departureStationCode;
	@Column(name="comments")
	private String comments;
	@Column(name="flight_number")
	private String flightNumber;
	@Column(name="flight_origin_date")
	private String flightOriginDate;
	@Column(name="replaced_crew_id")
	private Long replacedCrewId;
	@Column(name="replaced_crew_name")
	private String replacedCrewName;
	@Column(name="creation_date")
	private Timestamp creationDate;
	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;
	
	
	public Integer getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(Integer incidentId) {
		this.incidentId = incidentId;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	public void setEmergencyContactNumber(Long emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	public String getBodyTemperature() {
		return bodyTemperature;
	}
	public void setBodyTemperature(String bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
	
	public String getArrivalStationCode() {
		return arrivalStationCode;
	}
	public void setArrivalStationCode(String arrivalStationCode) {
		this.arrivalStationCode = arrivalStationCode;
	}
	public String getDepartureStationCode() {
		return departureStationCode;
	}
	public void setDepartureStationCode(String departureStationCode) {
		this.departureStationCode = departureStationCode;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightOriginDate() {
		return flightOriginDate;
	}
	public void setFlightOriginDate(String flightOriginDate) {
		this.flightOriginDate = flightOriginDate;
	}
	public String getIncidentStatus() {
		return incidentStatus;
	}
	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}
	public String getSymptomFever() {
		return symptomFever;
	}
	public void setSymptomFever(String symptomFever) {
		this.symptomFever = symptomFever;
	}
	public String getSymptomCold() {
		return symptomCold;
	}
	public void setSymptomCold(String symptomCold) {
		this.symptomCold = symptomCold;
	}
	public String getSymptomCough() {
		return symptomCough;
	}
	public void setSymptomCough(String symptomCough) {
		this.symptomCough = symptomCough;
	}
	public String getSymptomBreath() {
		return symptomBreath;
	}
	public void setSymptomBreath(String symptomBreath) {
		this.symptomBreath = symptomBreath;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getAddressToContact() {
		return addressToContact;
	}
	public void setAddressToContact(String addressToContact) {
		this.addressToContact = addressToContact;
	}
	public Long getReplacedCrewId() {
		return replacedCrewId;
	}
	public void setReplacedCrewId(Long replacedCrewId) {
		this.replacedCrewId = replacedCrewId;
	}
	public String getReplacedCrewName() {
		return replacedCrewName;
	}
	public void setReplacedCrewName(String replacedCrewName) {
		this.replacedCrewName = replacedCrewName;
	}
	public Long getCrewPassId() {
		return crewPassId;
	}
	public void setCrewPassId(Long crewPassId) {
		this.crewPassId = crewPassId;
	}
	public String getCrewPassName() {
		return crewPassName;
	}
	public void setCrewPassName(String crewPassName) {
		this.crewPassName = crewPassName;
	}
	public String getCrewPassType() {
		return crewPassType;
	}
	public void setCrewPassType(String crewPassType) {
		this.crewPassType = crewPassType;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getWearingMask() {
		return wearingMask;
	}
	public void setWearingMask(String wearingMask) {
		this.wearingMask = wearingMask;
	}
	public String getIsolationRequired() {
		return isolationRequired;
	}
	public void setIsolationRequired(String isolationRequired) {
		this.isolationRequired = isolationRequired;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}
