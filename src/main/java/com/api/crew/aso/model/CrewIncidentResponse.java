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
 * CrewIncidentResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T10:42:04.981Z")

public class CrewIncidentResponse   {
  @JsonProperty("incidentList")
  @Valid
  private List<Incident> incidentList = null;

  public CrewIncidentResponse incidentList(List<Incident> incidentList) {
    this.incidentList = incidentList;
    return this;
  }

  public CrewIncidentResponse addIncidentListItem(Incident incidentListItem) {
    if (this.incidentList == null) {
      this.incidentList = new ArrayList<Incident>();
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

  public List<Incident> getIncidentList() {
    return incidentList;
  }

  public void setIncidentList(List<Incident> incidentList) {
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
    CrewIncidentResponse crewIncidentResponse = (CrewIncidentResponse) o;
    return Objects.equals(this.incidentList, crewIncidentResponse.incidentList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(incidentList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewIncidentResponse {\n");
    
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

