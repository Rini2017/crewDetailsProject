package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.HrPOCDetails;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CrewDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-20T15:33:04.604Z")

public class CrewDetailsResponse   {
  @JsonProperty("crewDetails")
  private CrewDetails crewDetails = null;

  @JsonProperty("hrPOCDetails")
  private HrPOCDetails hrPOCDetails = null;

  public CrewDetailsResponse crewDetails(CrewDetails crewDetails) {
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

  public CrewDetailsResponse hrPOCDetails(HrPOCDetails hrPOCDetails) {
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
    CrewDetailsResponse crewDetailsResponse = (CrewDetailsResponse) o;
    return Objects.equals(this.crewDetails, crewDetailsResponse.crewDetails) &&
        Objects.equals(this.hrPOCDetails, crewDetailsResponse.hrPOCDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crewDetails, hrPOCDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewDetailsResponse {\n");
    
    sb.append("    crewDetails: ").append(toIndentedString(crewDetails)).append("\n");
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

