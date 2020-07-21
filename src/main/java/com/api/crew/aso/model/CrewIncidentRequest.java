package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.HrPOCDetails;
import com.api.crew.aso.model.Symptoms;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CrewIncidentRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T14:09:07.095Z")

public class CrewIncidentRequest   {
  @JsonProperty("crewDetails")
  private CrewDetails crewDetails = null;

  @JsonProperty("incidentStatus")
  private String incidentStatus = null;

  @JsonProperty("bedReq")
  private String bedReq = null;

  @JsonProperty("notificationStatus")
  private String notificationStatus = null;

  @JsonProperty("symptomList")
  @Valid
  private List<Symptoms> symptomList = null;

  @JsonProperty("hrPOCDetails")
  private HrPOCDetails hrPOCDetails = null;

  @JsonProperty("flightDetails")
  private FlightDetails flightDetails = null;

  public CrewIncidentRequest crewDetails(CrewDetails crewDetails) {
    this.crewDetails = crewDetails;
    return this;
  }

  /**
   * Get crewDetails
   * @return crewDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CrewDetails getCrewDetails() {
    return crewDetails;
  }

  public void setCrewDetails(CrewDetails crewDetails) {
    this.crewDetails = crewDetails;
  }

  public CrewIncidentRequest incidentStatus(String incidentStatus) {
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

  public CrewIncidentRequest bedReq(String bedReq) {
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

  public CrewIncidentRequest notificationStatus(String notificationStatus) {
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

  
  public CrewIncidentRequest symptomList(List<Symptoms> symptomList) {
    this.symptomList = symptomList;
    return this;
  }

  public CrewIncidentRequest addSymptomListItem(Symptoms symptomListItem) {
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

  public CrewIncidentRequest hrPOCDetails(HrPOCDetails hrPOCDetails) {
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

  public CrewIncidentRequest flightDetails(FlightDetails flightDetails) {
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
    CrewIncidentRequest crewIncidentRequest = (CrewIncidentRequest) o;
    return Objects.equals(this.crewDetails, crewIncidentRequest.crewDetails) &&
        Objects.equals(this.incidentStatus, crewIncidentRequest.incidentStatus) &&
        Objects.equals(this.bedReq, crewIncidentRequest.bedReq) &&
        Objects.equals(this.notificationStatus, crewIncidentRequest.notificationStatus) &&
        Objects.equals(this.symptomList, crewIncidentRequest.symptomList) &&
        Objects.equals(this.hrPOCDetails, crewIncidentRequest.hrPOCDetails) &&
        Objects.equals(this.flightDetails, crewIncidentRequest.flightDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crewDetails, incidentStatus, bedReq, notificationStatus, symptomList, hrPOCDetails, flightDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewIncidentRequest {\n");
    
    sb.append("    crewDetails: ").append(toIndentedString(crewDetails)).append("\n");
    sb.append("    incidentStatus: ").append(toIndentedString(incidentStatus)).append("\n");
    sb.append("    bedReq: ").append(toIndentedString(bedReq)).append("\n");
    sb.append("    notificationStatus: ").append(toIndentedString(notificationStatus)).append("\n");
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

