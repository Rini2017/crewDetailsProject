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
 * CrewIncidentRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-11T12:40:34.974Z")

public class CrewIncidentRequest   {
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

  @JsonProperty("bodyTemperature")
  private String bodyTemperature = null;

  @JsonProperty("symptoms")
  private String symptoms = null;

  @JsonProperty("arrivalStationCode")
  private String arrivalStationCode = null;

  @JsonProperty("carrierCode")
  private String carrierCode = null;

  @JsonProperty("departureStationCode")
  private String departureStationCode = null;

  @JsonProperty("flightNumber")
  private String flightNumber = null;

  @JsonProperty("flightOriginDate")
  private String flightOriginDate = null;

  public CrewIncidentRequest crewId(Long crewId) {
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

  public CrewIncidentRequest crewName(String crewName) {
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

  public CrewIncidentRequest crewType(String crewType) {
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

  public CrewIncidentRequest crewEmailId(String crewEmailId) {
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

  public CrewIncidentRequest phoneNumber(Long phoneNumber) {
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

  public CrewIncidentRequest emergencyContactNumber(Long emergencyContactNumber) {
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

  public CrewIncidentRequest bodyTemperature(String bodyTemperature) {
    this.bodyTemperature = bodyTemperature;
    return this;
  }

  /**
   * Get bodyTemperature
   * @return bodyTemperature
  **/
  @ApiModelProperty(value = "")


  public String getBodyTemperature() {
    return bodyTemperature;
  }

  public void setBodyTemperature(String bodyTemperature) {
    this.bodyTemperature = bodyTemperature;
  }

  public CrewIncidentRequest symptoms(String symptoms) {
    this.symptoms = symptoms;
    return this;
  }

  /**
   * Get symptoms
   * @return symptoms
  **/
  @ApiModelProperty(value = "")


  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public CrewIncidentRequest arrivalStationCode(String arrivalStationCode) {
    this.arrivalStationCode = arrivalStationCode;
    return this;
  }

  /**
   * Get arrivalStationCode
   * @return arrivalStationCode
  **/
  @ApiModelProperty(value = "")


  public String getArrivalStationCode() {
    return arrivalStationCode;
  }

  public void setArrivalStationCode(String arrivalStationCode) {
    this.arrivalStationCode = arrivalStationCode;
  }

  public CrewIncidentRequest carrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
    return this;
  }

  /**
   * Get carrierCode
   * @return carrierCode
  **/
  @ApiModelProperty(value = "")


  public String getCarrierCode() {
    return carrierCode;
  }

  public void setCarrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
  }

  public CrewIncidentRequest departureStationCode(String departureStationCode) {
    this.departureStationCode = departureStationCode;
    return this;
  }

  /**
   * Get departureStationCode
   * @return departureStationCode
  **/
  @ApiModelProperty(value = "")


  public String getDepartureStationCode() {
    return departureStationCode;
  }

  public void setDepartureStationCode(String departureStationCode) {
    this.departureStationCode = departureStationCode;
  }

  public CrewIncidentRequest flightNumber(String flightNumber) {
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

  public CrewIncidentRequest flightOriginDate(String flightOriginDate) {
    this.flightOriginDate = flightOriginDate;
    return this;
  }

  /**
   * Get flightOriginDate
   * @return flightOriginDate
  **/
  @ApiModelProperty(value = "")


  public String getFlightOriginDate() {
    return flightOriginDate;
  }

  public void setFlightOriginDate(String flightOriginDate) {
    this.flightOriginDate = flightOriginDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrewIncidentRequest crewIncidentRequest = (CrewIncidentRequest) o;
    return Objects.equals(this.crewId, crewIncidentRequest.crewId) &&
        Objects.equals(this.crewName, crewIncidentRequest.crewName) &&
        Objects.equals(this.crewType, crewIncidentRequest.crewType) &&
        Objects.equals(this.crewEmailId, crewIncidentRequest.crewEmailId) &&
        Objects.equals(this.phoneNumber, crewIncidentRequest.phoneNumber) &&
        Objects.equals(this.emergencyContactNumber, crewIncidentRequest.emergencyContactNumber) &&
        Objects.equals(this.bodyTemperature, crewIncidentRequest.bodyTemperature) &&
        Objects.equals(this.symptoms, crewIncidentRequest.symptoms) &&
        Objects.equals(this.arrivalStationCode, crewIncidentRequest.arrivalStationCode) &&
        Objects.equals(this.carrierCode, crewIncidentRequest.carrierCode) &&
        Objects.equals(this.departureStationCode, crewIncidentRequest.departureStationCode) &&
        Objects.equals(this.flightNumber, crewIncidentRequest.flightNumber) &&
        Objects.equals(this.flightOriginDate, crewIncidentRequest.flightOriginDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crewId, crewName, crewType, crewEmailId, phoneNumber, emergencyContactNumber, bodyTemperature, symptoms, arrivalStationCode, carrierCode, departureStationCode, flightNumber, flightOriginDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewIncidentRequest {\n");
    
    sb.append("    crewId: ").append(toIndentedString(crewId)).append("\n");
    sb.append("    crewName: ").append(toIndentedString(crewName)).append("\n");
    sb.append("    crewType: ").append(toIndentedString(crewType)).append("\n");
    sb.append("    crewEmailId: ").append(toIndentedString(crewEmailId)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    emergencyContactNumber: ").append(toIndentedString(emergencyContactNumber)).append("\n");
    sb.append("    bodyTemperature: ").append(toIndentedString(bodyTemperature)).append("\n");
    sb.append("    symptoms: ").append(toIndentedString(symptoms)).append("\n");
    sb.append("    arrivalStationCode: ").append(toIndentedString(arrivalStationCode)).append("\n");
    sb.append("    carrierCode: ").append(toIndentedString(carrierCode)).append("\n");
    sb.append("    departureStationCode: ").append(toIndentedString(departureStationCode)).append("\n");
    sb.append("    flightNumber: ").append(toIndentedString(flightNumber)).append("\n");
    sb.append("    flightOriginDate: ").append(toIndentedString(flightOriginDate)).append("\n");
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

