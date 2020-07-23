package com.api.crew.aso.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quarantine_centre_detail")
public class QuarantineDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column(name="crew_id")
	private Long crewId;
	@Column(name="qr_center_id")
	private String qrCenterId;
	@Column(name="floor_no")
	private String floorNo;
	@Column(name="room_no")
	private String roomNo;
	@Column(name="bed_no")
	private String bedNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQrCenterId() {
		return qrCenterId;
	}
	public void setQrCenterId(String qrCenterId) {
		this.qrCenterId = qrCenterId;
	}
	public String getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public Long getCrewId() {
		return crewId;
	}
	public void setCrewId(Long crewId) {
		this.crewId = crewId;
	}
}
