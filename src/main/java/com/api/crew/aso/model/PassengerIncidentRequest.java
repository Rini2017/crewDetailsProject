package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.HrPOCDetails;
import com.api.crew.aso.model.PassengerDetails;
import com.api.crew.aso.model.Symptoms;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PassengerIncidentRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-23T05:52:49.446Z")

public class PassengerIncidentRequest   {
  @JsonProperty("passengerDetails")
  private PassengerDetails passengerDetails = null;

  @JsonProperty("incidentStatus")
  private String incidentStatus = null;

  @JsonProperty("bedReq")
  private String bedReq = null;

  @JsonProperty("notificationStatus")
  private String notificationStatus = null;

  @JsonProperty("bodyTemperature")
  private String bodyTemperature = null;

  @JsonProperty("symptomList")
  @Valid
  private List<Symptoms> symptomList = null;

  @JsonProperty("hrPOCDetails")
  private HrPOCDetails hrPOCDetails = null;

  @JsonProperty("flightDetails")
  private FlightDetails flightDetails = null;

  public PassengerIncidentRequest passengerDetails(PassengerDetails passengerDetails) {
    this.passengerDetails = passengerDetails;
    return this;
  }

  /**
   * Get passengerDetails
   * @return passengerDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PassengerDetails getPassengerDetails() {
    return passengerDetails;
  }

  public void setPassengerDetails(PassengerDetails passengerDetails) {
    this.passengerDetails = passengerDetails;
  }

  public PassengerIncidentRequest incidentStatus(String incidentStatus) {
    this.incidentStatus = incidentStatus;
    return this;
  }

  /**
   * Get incidentStatus
   * @return incidentStatus
  **/
  @ApiModelProperty(value = "")


  public String getIncidentStatus() {
    return incidentStatus;
  }

  public void setIncidentStatus(String incidentStatus) {
    this.incidentStatus = incidentStatus;
  }

  public PassengerIncidentRequest bedReq(String bedReq) {
    this.bedReq = bedReq;
    return this;
  }

  /**
   * Get bedReq
   * @return bedReq
  **/
  @ApiModelProperty(value = "")


  public String getBedReq() {
    return bedReq;
  }

  public void setBedReq(String bedReq) {
    this.bedReq = bedReq;
  }

  public PassengerIncidentRequest notificationStatus(String notificationStatus) {
    this.notificationStatus = notificationStatus;
    return this;
  }

  /**
   * Get notificationStatus
   * @return notificationStatus
  **/
  @ApiModelProperty(value = "")


  public String getNotificationStatus() {
    return notificationStatus;
  }

  public void setNotificationStatus(String notificationStatus) {
    this.notificationStatus = notificationStatus;
  }

  public PassengerIncidentRequest bodyTemperature(String bodyTemperature) {
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

  public PassengerIncidentRequest symptomList(List<Symptoms> symptomList) {
    this.symptomList = symptomList;
    return this;
  }

  public PassengerIncidentRequest addSymptomListItem(Symptoms symptomListItem) {
    if (this.symptomList == null) {
      this.symptomList = new ArrayList<Symptoms>();
    }
    this.symptomList.add(symptomListItem);
    return this;
  }

  /**
   * Get symptomList
   * @return symptomList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Symptoms> getSymptomList() {
    return symptomList;
  }

  public void setSymptomList(List<Symptoms> symptomList) {
    this.symptomList = symptomList;
  }

  public PassengerIncidentRequest hrPOCDetails(HrPOCDetails hrPOCDetails) {
    this.hrPOCDetails = hrPOCDetails;
    return this;
  }

  /**
   * Get hrPOCDetails
   * @return hrPOCDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public HrPOCDetails getHrPOCDetails() {
    return hrPOCDetails;
  }

  public void setHrPOCDetails(HrPOCDetails hrPOCDetails) {
    this.hrPOCDetails = hrPOCDetails;
  }

  public PassengerIncidentRequest flightDetails(FlightDetails flightDetails) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PassengerIncidentRequest passengerIncidentRequest = (PassengerIncidentRequest) o;
    return Objects.equals(this.passengerDetails, passengerIncidentRequest.passengerDetails) &&
        Objects.equals(this.incidentStatus, passengerIncidentRequest.incidentStatus) &&
        Objects.equals(this.bedReq, passengerIncidentRequest.bedReq) &&
        Objects.equals(this.notificationStatus, passengerIncidentRequest.notificationStatus) &&
        Objects.equals(this.bodyTemperature, passengerIncidentRequest.bodyTemperature) &&
        Objects.equals(this.symptomList, passengerIncidentRequest.symptomList) &&
        Objects.equals(this.hrPOCDetails, passengerIncidentRequest.hrPOCDetails) &&
        Objects.equals(this.flightDetails, passengerIncidentRequest.flightDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passengerDetails, incidentStatus, bedReq, notificationStatus, bodyTemperature, symptomList, hrPOCDetails, flightDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PassengerIncidentRequest {\n");
    
    sb.append("    passengerDetails: ").append(toIndentedString(passengerDetails)).append("\n");
    sb.append("    incidentStatus: ").append(toIndentedString(incidentStatus)).append("\n");
    sb.append("    bedReq: ").append(toIndentedString(bedReq)).append("\n");
    sb.append("    notificationStatus: ").append(toIndentedString(notificationStatus)).append("\n");
    sb.append("    bodyTemperature: ").append(toIndentedString(bodyTemperature)).append("\n");
    sb.append("    symptomList: ").append(toIndentedString(symptomList)).append("\n");
    sb.append("    hrPOCDetails: ").append(toIndentedString(hrPOCDetails)).append("\n");
    sb.append("    flightDetails: ").append(toIndentedString(flightDetails)).append("\n");
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

