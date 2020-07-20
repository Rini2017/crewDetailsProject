package com.api.crew.aso.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_symptom_details")
public class PassengerDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MSD_ROWID")
	private Integer msdRowid;
	
	@Column(name="flight_no")
	private String flightNo;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="flight_date")
	private String flightDate;
	
	@Column(name="pnr")
	private String pnr;
	
	@Column(name="ticket_no")
	private String ticketNo;
	
	@Column(name="member_id")
	private String memberId;	
	
	@Column(name="member_type")
	private String memberType;
	
	@Column(name="seat_number")
	private String seatNumber;
	
	@Column(name="temperature")
	private String temperature;
	
	@Column(name="fever")
	private String fever;
	
	@Column(name="cold")
	private String cold;
	
	@Column(name="cough")
	private String cough;
	
	@Column(name="breathing_problem")
	private String breathingProblem;
	
	@Column(name="testing_date")
	private Timestamp testingDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="modified_date")
	private String modifiedDate;

	public Integer getMsdRowid() {
		return msdRowid;
	}

	public void setMsdRowid(Integer msdRowid) {
		this.msdRowid = msdRowid;
	}



	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}


	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getFever() {
		return fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	public String getCold() {
		return cold;
	}

	public void setCold(String cold) {
		this.cold = cold;
	}

	public String getCough() {
		return cough;
	}

	public void setCough(String cough) {
		this.cough = cough;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBreathingProblem() {
		return breathingProblem;
	}

	public void setBreathingProblem(String breathingProblem) {
		this.breathingProblem = breathingProblem;
	}

	public Timestamp getTestingDate() {
		return testingDate;
	}

	public void setTestingDate(Timestamp testingDate) {
		this.testingDate = testingDate;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	
}
