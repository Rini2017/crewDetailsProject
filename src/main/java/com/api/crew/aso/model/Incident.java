package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.HrPOCDetails;
import com.api.crew.aso.model.QuarantineDetails;
import com.api.crew.aso.model.Symptoms;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Incident
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T15:48:47.153Z")

public class Incident   {
  @JsonProperty("incidentId")
  private Long incidentId = null;

  @JsonProperty("incidentStatus")
  private String incidentStatus = null;

  @JsonProperty("bodyTemperature")
  private String bodyTemperature = null;

  @JsonProperty("symptomList")
  @Valid
  private List<Symptoms> symptomList = null;

  @JsonProperty("crewDetails")
  private CrewDetails crewDetails = null;

  @JsonProperty("flightDetails")
  private FlightDetails flightDetails = null;

  @JsonProperty("quarantineCentreDetails")
  private QuarantineDetails quarantineCentreDetails = null;

  @JsonProperty("hrPOCDetails")
  private HrPOCDetails hrPOCDetails = null;

  public Incident incidentId(Long incidentId) {
    this.incidentId = incidentId;
    return this;
  }

  /**
   * Get incidentId
   * @return incidentId
  **/
  @ApiModelProperty(value = "")


  public Long getIncidentId() {
    return incidentId;
  }

  public void setIncidentId(Long incidentId) {
    this.incidentId = incidentId;
  }

  public Incident incidentStatus(String incidentStatus) {
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

  public Incident bodyTemperature(String bodyTemperature) {
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

  public Incident symptomList(List<Symptoms> symptomList) {
    this.symptomList = symptomList;
    return this;
  }

  public Incident addSymptomListItem(Symptoms symptomListItem) {
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

  public Incident crewDetails(CrewDetails crewDetails) {
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

  public Incident flightDetails(FlightDetails flightDetails) {
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

  public Incident quarantineCentreDetails(QuarantineDetails quarantineCentreDetails) {
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

  public Incident hrPOCDetails(HrPOCDetails hrPOCDetails) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Incident incident = (Incident) o;
    return Objects.equals(this.incidentId, incident.incidentId) &&
        Objects.equals(this.incidentStatus, incident.incidentStatus) &&
        Objects.equals(this.bodyTemperature, incident.bodyTemperature) &&
        Objects.equals(this.symptomList, incident.symptomList) &&
        Objects.equals(this.crewDetails, incident.crewDetails) &&
        Objects.equals(this.flightDetails, incident.flightDetails) &&
        Objects.equals(this.quarantineCentreDetails, incident.quarantineCentreDetails) &&
        Objects.equals(this.hrPOCDetails, incident.hrPOCDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(incidentId, incidentStatus, bodyTemperature, symptomList, crewDetails, flightDetails, quarantineCentreDetails, hrPOCDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Incident {\n");
    
    sb.append("    incidentId: ").append(toIndentedString(incidentId)).append("\n");
    sb.append("    incidentStatus: ").append(toIndentedString(incidentStatus)).append("\n");
    sb.append("    bodyTemperature: ").append(toIndentedString(bodyTemperature)).append("\n");
    sb.append("    symptomList: ").append(toIndentedString(symptomList)).append("\n");
    sb.append("    crewDetails: ").append(toIndentedString(crewDetails)).append("\n");
    sb.append("    flightDetails: ").append(toIndentedString(flightDetails)).append("\n");
    sb.append("    quarantineCentreDetails: ").append(toIndentedString(quarantineCentreDetails)).append("\n");
    sb.append("    hrPOCDetails: ").append(toIndentedString(hrPOCDetails)).append("\n");
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

