package com.api.crew.aso.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hr_poc_detail_passenger")
public class HRContactPassengerDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="passenger_id")
	private Long passengerId;
	@Column(name="hr_name")
	private String hrName;
	@Column(name="hr_email_id")
	private String hrEmailId;
	@Column(name="hr_contact_no")
	private String hrContactNo;
	
	
	
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public String getHrEmailId() {
		return hrEmailId;
	}
	public void setHrEmailId(String hrEmailId) {
		this.hrEmailId = hrEmailId;
	}
	public String getHrContactNo() {
		return hrContactNo;
	}
	public void setHrContactNo(String hrContactNo) {
		this.hrContactNo = hrContactNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

}
