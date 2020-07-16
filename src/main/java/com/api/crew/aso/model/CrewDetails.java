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
 * CrewDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T07:23:35.052Z")

public class CrewDetails   {
  @JsonProperty("crewId")
  private Long crewId = null;

  @JsonProperty("crewName")
  private String crewName = null;

  @JsonProperty("crewType")
  private String crewType = null;

  @JsonProperty("crewEmailId")
  private String crewEmailId = null;

  @JsonProperty("flightNumber")
  private String flightNumber = null;

  @JsonProperty("phoneNumber")
  private Long phoneNumber = null;

  @JsonProperty("emergencyContactNumber")
  private Long emergencyContactNumber = null;

  @JsonProperty("addressToContact")
  private String addressToContact = null;

  public CrewDetails crewId(Long crewId) {
    this.crewId = crewId;
    return this;
  }

  /**
   * Get crewId
   * @return crewId
  **/
  @ApiModelProperty(value = "")


  public Long getCrewId() {
    return crewId;
  }

  public void setCrewId(Long crewId) {
    this.crewId = crewId;
  }

  public CrewDetails crewName(String crewName) {
    this.crewName = crewName;
    return this;
  }

  /**
   * Get crewName
   * @return crewName
  **/
  @ApiModelProperty(value = "")


  public String getCrewName() {
    return crewName;
  }

  public void setCrewName(String crewName) {
    this.crewName = crewName;
  }

  public CrewDetails crewType(String crewType) {
    this.crewType = crewType;
    return this;
  }

  /**
   * Get crewType
   * @return crewType
  **/
  @ApiModelProperty(value = "")


  public String getCrewType() {
    return crewType;
  }

  public void setCrewType(String crewType) {
    this.crewType = crewType;
  }

  public CrewDetails crewEmailId(String crewEmailId) {
    this.crewEmailId = crewEmailId;
    return this;
  }

  /**
   * Get crewEmailId
   * @return crewEmailId
  **/
  @ApiModelProperty(value = "")


  public String getCrewEmailId() {
    return crewEmailId;
  }

  public void setCrewEmailId(String crewEmailId) {
    this.crewEmailId = crewEmailId;
  }

  public CrewDetails flightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
    return this;
  }

  /**
   * Get flightNumber
   * @return flightNumber
  **/
  @ApiModelProperty(value = "")


  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public CrewDetails phoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "")


  public Long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public CrewDetails emergencyContactNumber(Long emergencyContactNumber) {
    this.emergencyContactNumber = emergencyContactNumber;
    return this;
  }

  /**
   * Get emergencyContactNumber
   * @return emergencyContactNumber
  **/
  @ApiModelProperty(value = "")


  public Long getEmergencyContactNumber() {
    return emergencyContactNumber;
  }

  public void setEmergencyContactNumber(Long emergencyContactNumber) {
    this.emergencyContactNumber = emergencyContactNumber;
  }

  public CrewDetails addressToContact(String addressToContact) {
    this.addressToContact = addressToContact;
    return this;
  }

  /**
   * Get addressToContact
   * @return addressToContact
  **/
  @ApiModelProperty(value = "")


  public String getAddressToContact() {
    return addressToContact;
  }

  public void setAddressToContact(String addressToContact) {
    this.addressToContact = addressToContact;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrewDetails crewDetails = (CrewDetails) o;
    return Objects.equals(this.crewId, crewDetails.crewId) &&
        Objects.equals(this.crewName, crewDetails.crewName) &&
        Objects.equals(this.crewType, crewDetails.crewType) &&
        Objects.equals(this.crewEmailId, crewDetails.crewEmailId) &&
        Objects.equals(this.flightNumber, crewDetails.flightNumber) &&
        Objects.equals(this.phoneNumber, crewDetails.phoneNumber) &&
        Objects.equals(this.emergencyContactNumber, crewDetails.emergencyContactNumber) &&
        Objects.equals(this.addressToContact, crewDetails.addressToContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crewId, crewName, crewType, crewEmailId, flightNumber, phoneNumber, emergencyContactNumber, addressToContact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewDetails {\n");
    
    sb.append("    crewId: ").append(toIndentedString(crewId)).append("\n");
    sb.append("    crewName: ").append(toIndentedString(crewName)).append("\n");
    sb.append("    crewType: ").append(toIndentedString(crewType)).append("\n");
    sb.append("    crewEmailId: ").append(toIndentedString(crewEmailId)).append("\n");
    sb.append("    flightNumber: ").append(toIndentedString(flightNumber)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    emergencyContactNumber: ").append(toIndentedString(emergencyContactNumber)).append("\n");
    sb.append("    addressToContact: ").append(toIndentedString(addressToContact)).append("\n");
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

