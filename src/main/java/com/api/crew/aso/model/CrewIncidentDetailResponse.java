package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.QuarantineDetails;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CrewIncidentDetailResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-11T12:40:34.974Z")

public class CrewIncidentDetailResponse   {
  @JsonProperty("crewId")
  private Long crewId = null;

  @JsonProperty("crewName")
  private String crewName = null;

  @JsonProperty("crewType")
  private String crewType = null;

  @JsonProperty("crewEmailId")
  private String crewEmailId = null;

  @JsonProperty("phoneNumber")
  private Long phoneNumber = null;

  @JsonProperty("emergencyContactNumber")
  private Long emergencyContactNumber = null;

  @JsonProperty("flightDetails")
  private FlightDetails flightDetails = null;

  @JsonProperty("quarantineCentreDetails")
  private QuarantineDetails quarantineCentreDetails = null;

  public CrewIncidentDetailResponse crewId(Long crewId) {
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

  public CrewIncidentDetailResponse crewName(String crewName) {
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

  public CrewIncidentDetailResponse crewType(String crewType) {
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

  public CrewIncidentDetailResponse crewEmailId(String crewEmailId) {
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

  public CrewIncidentDetailResponse phoneNumber(Long phoneNumber) {
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

  public CrewIncidentDetailResponse emergencyContactNumber(Long emergencyContactNumber) {
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

  public CrewIncidentDetailResponse flightDetails(FlightDetails flightDetails) {
    this.flightDetails = flightDetails;
    return this;
  }

  /**
   * Get flightDetails
   * @return flightDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FlightDetails getFlightDetails() {
    return flightDetails;
  }

  public void setFlightDetails(FlightDetails flightDetails) {
    this.flightDetails = flightDetails;
  }

  public CrewIncidentDetailResponse quarantineCentreDetails(QuarantineDetails quarantineCentreDetails) {
    this.quarantineCentreDetails = quarantineCentreDetails;
    return this;
  }

  /**
   * Get quarantineCentreDetails
   * @return quarantineCentreDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public QuarantineDetails getQuarantineCentreDetails() {
    return quarantineCentreDetails;
  }

  public void setQuarantineCentreDetails(QuarantineDetails quarantineCentreDetails) {
    this.quarantineCentreDetails = quarantineCentreDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrewIncidentDetailResponse crewIncidentDetailResponse = (CrewIncidentDetailResponse) o;
    return Objects.equals(this.crewId, crewIncidentDetailResponse.crewId) &&
        Objects.equals(this.crewName, crewIncidentDetailResponse.crewName) &&
        Objects.equals(this.crewType, crewIncidentDetailResponse.crewType) &&
        Objects.equals(this.crewEmailId, crewIncidentDetailResponse.crewEmailId) &&
        Objects.equals(this.phoneNumber, crewIncidentDetailResponse.phoneNumber) &&
        Objects.equals(this.emergencyContactNumber, crewIncidentDetailResponse.emergencyContactNumber) &&
        Objects.equals(this.flightDetails, crewIncidentDetailResponse.flightDetails) &&
        Objects.equals(this.quarantineCentreDetails, crewIncidentDetailResponse.quarantineCentreDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crewId, crewName, crewType, crewEmailId, phoneNumber, emergencyContactNumber, flightDetails, quarantineCentreDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewIncidentDetailResponse {\n");
    
    sb.append("    crewId: ").append(toIndentedString(crewId)).append("\n");
    sb.append("    crewName: ").append(toIndentedString(crewName)).append("\n");
    sb.append("    crewType: ").append(toIndentedString(crewType)).append("\n");
    sb.append("    crewEmailId: ").append(toIndentedString(crewEmailId)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    emergencyContactNumber: ").append(toIndentedString(emergencyContactNumber)).append("\n");
    sb.append("    flightDetails: ").append(toIndentedString(flightDetails)).append("\n");
    sb.append("    quarantineCentreDetails: ").append(toIndentedString(quarantineCentreDetails)).append("\n");
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

