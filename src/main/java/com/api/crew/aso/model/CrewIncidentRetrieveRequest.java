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

public class CrewIncidentRetrieveRequest   {
  @JsonProperty("flightNumber")
  private String flightNumber = null;

  @JsonProperty("bedReq")
  private String bedReq = null;
  
  @JsonProperty("date")
  private String date = null;
  
  @JsonProperty("crewId")
  private Long crewId = null;
  
  @JsonProperty("incidentId")
  private Long incidentId = null;
  
  public CrewIncidentRetrieveRequest date(String date) {
	    this.date = date;
	    return this;
 }

  /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  
  public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public CrewIncidentRetrieveRequest crewId(Long crewId) {
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
	
	public CrewIncidentRetrieveRequest incidentId(Long incidentId) {
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


  public CrewIncidentRetrieveRequest bedReq(String bedReq) {
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
  
  public CrewIncidentRetrieveRequest flightNumber(String flightNumber) {
	    this.flightNumber = flightNumber;
	    return this;
	  }
  
  /**
   * Get flightNo
   * @return flightNo
  **/
  @ApiModelProperty(value = "")
  
  public String getFlightNumber() {
		return flightNumber;
   }

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrewIncidentRetrieveRequest crewIncidentRequest = (CrewIncidentRetrieveRequest) o;
    return 
        Objects.equals(this.bedReq, crewIncidentRequest.bedReq);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bedReq);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewIncidentRetrieveRequest {\n");
    sb.append("    bedReq: ").append(toIndentedString(bedReq)).append("\n");
    
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

