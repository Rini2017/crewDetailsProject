package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PassengerDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-20T07:34:50.119Z")

public class PassengerDetails   {
	@JsonProperty("pnr")
	  private String pnr = null;

	  @JsonProperty("ticketNo")
	  private String ticketNo = null;

	  @JsonProperty("passengerId")
	  private Long passengerId = null;

	  @JsonProperty("passengerName")
	  private String passengerName = null;

	  @JsonProperty("memberType")
	  private String memberType = null;

	  @JsonProperty("seatnumber")
	  private String seatnumber = null;

	  @JsonProperty("passengerEmailId")
	  private String passengerEmailId = null;

	  @JsonProperty("phoneNumber")
	  private String phoneNumber = null;

	  @JsonProperty("address")
	  private String address = null;

	  public PassengerDetails pnr(String pnr) {
	    this.pnr = pnr;
	    return this;
	  }

	  /**
	   * Get pnr
	   * @return pnr
	  **/
	  @ApiModelProperty(value = "")


	  public String getPnr() {
	    return pnr;
	  }

	  public void setPnr(String pnr) {
	    this.pnr = pnr;
	  }

	  public PassengerDetails ticketNo(String ticketNo) {
	    this.ticketNo = ticketNo;
	    return this;
	  }

	  /**
	   * Get ticketNo
	   * @return ticketNo
	  **/
	  @ApiModelProperty(value = "")


	  public String getTicketNo() {
	    return ticketNo;
	  }

	  public void setTicketNo(String ticketNo) {
	    this.ticketNo = ticketNo;
	  }

	  public PassengerDetails passengerId(Long passengerId) {
	    this.passengerId = passengerId;
	    return this;
	  }

	  /**
	   * Get passengerId
	   * @return passengerId
	  **/
	  @ApiModelProperty(value = "")


	  public Long getPassengerId() {
	    return passengerId;
	  }

	  public void setPassengerId(Long passengerId) {
	    this.passengerId = passengerId;
	  }

	  public PassengerDetails passengerName(String passengerName) {
	    this.passengerName = passengerName;
	    return this;
	  }

	  /**
	   * Get passengerName
	   * @return passengerName
	  **/
	  @ApiModelProperty(value = "")


	  public String getPassengerName() {
	    return passengerName;
	  }

	  public void setPassengerName(String passengerName) {
	    this.passengerName = passengerName;
	  }

	  public PassengerDetails memberType(String memberType) {
	    this.memberType = memberType;
	    return this;
	  }

	  /**
	   * Get memberType
	   * @return memberType
	  **/
	  @ApiModelProperty(value = "")


	  public String getMemberType() {
	    return memberType;
	  }

	  public void setMemberType(String memberType) {
	    this.memberType = memberType;
	  }

	  public PassengerDetails seatnumber(String seatnumber) {
	    this.seatnumber = seatnumber;
	    return this;
	  }

	  /**
	   * Get seatnumber
	   * @return seatnumber
	  **/
	  @ApiModelProperty(value = "")


	  public String getSeatnumber() {
	    return seatnumber;
	  }

	  public void setSeatnumber(String seatnumber) {
	    this.seatnumber = seatnumber;
	  }

	  public PassengerDetails passengerEmailId(String passengerEmailId) {
	    this.passengerEmailId = passengerEmailId;
	    return this;
	  }

	  /**
	   * Get passengerEmailId
	   * @return passengerEmailId
	  **/
	  @ApiModelProperty(value = "")


	  public String getPassengerEmailId() {
	    return passengerEmailId;
	  }

	  public void setPassengerEmailId(String passengerEmailId) {
	    this.passengerEmailId = passengerEmailId;
	  }

	  public PassengerDetails phoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	    return this;
	  }

	  /**
	   * Get phoneNumber
	   * @return phoneNumber
	  **/
	  @ApiModelProperty(value = "")


	  public String getPhoneNumber() {
	    return phoneNumber;
	  }

	  public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	  }

	  public PassengerDetails address(String address) {
	    this.address = address;
	    return this;
	  }

	  /**
	   * Get address
	   * @return address
	  **/
	  @ApiModelProperty(value = "")


	  public String getAddress() {
	    return address;
	  }

	  public void setAddress(String address) {
	    this.address = address;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    PassengerDetails passengerDetails = (PassengerDetails) o;
	    return Objects.equals(this.pnr, passengerDetails.pnr) &&
	        Objects.equals(this.ticketNo, passengerDetails.ticketNo) &&
	        Objects.equals(this.passengerId, passengerDetails.passengerId) &&
	        Objects.equals(this.passengerName, passengerDetails.passengerName) &&
	        Objects.equals(this.memberType, passengerDetails.memberType) &&
	        Objects.equals(this.seatnumber, passengerDetails.seatnumber) &&
	        Objects.equals(this.passengerEmailId, passengerDetails.passengerEmailId) &&
	        Objects.equals(this.phoneNumber, passengerDetails.phoneNumber) &&
	        Objects.equals(this.address, passengerDetails.address);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(pnr, ticketNo, passengerId, passengerName, memberType, seatnumber, passengerEmailId, phoneNumber, address);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class PassengerDetails {\n");
	    
	    sb.append("    pnr: ").append(toIndentedString(pnr)).append("\n");
	    sb.append("    ticketNo: ").append(toIndentedString(ticketNo)).append("\n");
	    sb.append("    passengerId: ").append(toIndentedString(passengerId)).append("\n");
	    sb.append("    passengerName: ").append(toIndentedString(passengerName)).append("\n");
	    sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
	    sb.append("    seatnumber: ").append(toIndentedString(seatnumber)).append("\n");
	    sb.append("    passengerEmailId: ").append(toIndentedString(passengerEmailId)).append("\n");
	    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
	    sb.append("    address: ").append(toIndentedString(address)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}

