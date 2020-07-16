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
	@Column(name="crew_id")
	private Long crewId;
	@Column(name="crew_name")
	private String crewName;
	@Column(name="crew_type")
	private String crewType;
	@Column(name="crew_email_id")
	private String crewEmailId;
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
	@Column(name="arrival_station_code")
	private String arrivalStationCode;
	@Column(name="carrier_code")
	private String carrierCode;
	@Column(name="departure_station_code")
	private String departureStationCode;
	@Column(name="flight_number")
	private String flightNumber;
	@Column(name="flight_origin_date")
	private String flightOriginDate;
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
	public Long getCrewId() {
		return crewId;
	}
	public void setCrewId(Long crewId) {
		this.crewId = crewId;
	}
	public String getCrewName() {
		return crewName;
	}
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}
	public String getCrewType() {
		return crewType;
	}
	public void setCrewType(String crewType) {
		this.crewType = crewType;
	}
	public String getCrewEmailId() {
		return crewEmailId;
	}
	public void setCrewEmailId(String crewEmailId) {
		this.crewEmailId = crewEmailId;
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
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
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
	
	
	

}
