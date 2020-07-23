package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.Incident;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PassengerIncidentResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-23T05:52:49.446Z")

public class PassengerIncidentResponse   {
  @JsonProperty("incidentList")
  @Valid
  private List<IncidentPassenger> incidentList = null;

  public PassengerIncidentResponse incidentList(List<IncidentPassenger> incidentList) {
    this.incidentList = incidentList;
    return this;
  }

  public PassengerIncidentResponse addIncidentListItem(IncidentPassenger incidentListItem) {
    if (this.incidentList == null) {
      this.incidentList = new ArrayList<IncidentPassenger>();
    }
    this.incidentList.add(incidentListItem);
    return this;
  }

  /**
   * Get incidentList
   * @return incidentList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<IncidentPassenger> getIncidentList() {
    return incidentList;
  }

  public void setIncidentList(List<IncidentPassenger> incidentList) {
    this.incidentList = incidentList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PassengerIncidentResponse passengerIncidentResponse = (PassengerIncidentResponse) o;
    return Objects.equals(this.incidentList, passengerIncidentResponse.incidentList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(incidentList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PassengerIncidentResponse {\n");
    
    sb.append("    incidentList: ").append(toIndentedString(incidentList)).append("\n");
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

