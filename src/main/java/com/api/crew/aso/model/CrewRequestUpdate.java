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
 * CrewRequestUpdate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-10T08:57:02.905Z")

public class CrewRequestUpdate   {
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

  @JsonProperty("employeeIdToReplace")
  private Long employeeIdToReplace = null;
  
  @JsonProperty("employeeIdReplaceWith")
  private Long employeeIdReplaceWith = null;

  public CrewRequestUpdate arrivalStationCode(String arrivalStationCode) {
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

  public CrewRequestUpdate carrierCode(String carrierCode) {
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

  public CrewRequestUpdate departureStationCode(String departureStationCode) {
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

  public CrewRequestUpdate flightNumber(String flightNumber) {
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

  public CrewRequestUpdate flightOriginDate(String flightOriginDate) {
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

  public CrewRequestUpdate employeeIdToReplace(Long employeeIdToReplace) {
    this.employeeIdToReplace = employeeIdToReplace;
    return this;
  }
  
  public CrewRequestUpdate employeeIdReplaceWith(Long employeeIdReplaceWith) {
	    this.employeeIdReplaceWith = employeeIdReplaceWith;
	    return this;
  }

 


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrewRequestUpdate crewRequestUpdate = (CrewRequestUpdate) o;
    return Objects.equals(this.arrivalStationCode, crewRequestUpdate.arrivalStationCode) &&
        Objects.equals(this.carrierCode, crewRequestUpdate.carrierCode) &&
        Objects.equals(this.departureStationCode, crewRequestUpdate.departureStationCode) &&
        Objects.equals(this.flightNumber, crewRequestUpdate.flightNumber) &&
        Objects.equals(this.flightOriginDate, crewRequestUpdate.flightOriginDate) &&
        Objects.equals(this.employeeIdToReplace, crewRequestUpdate.employeeIdToReplace) &&
    	Objects.equals(this.employeeIdReplaceWith, crewRequestUpdate.employeeIdReplaceWith);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arrivalStationCode, carrierCode, departureStationCode, flightNumber, flightOriginDate, employeeIdToReplace,employeeIdReplaceWith );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewRequestUpdate {\n");
    
    sb.append("    arrivalStationCode: ").append(toIndentedString(arrivalStationCode)).append("\n");
    sb.append("    carrierCode: ").append(toIndentedString(carrierCode)).append("\n");
    sb.append("    departureStationCode: ").append(toIndentedString(departureStationCode)).append("\n");
    sb.append("    flightNumber: ").append(toIndentedString(flightNumber)).append("\n");
    sb.append("    flightOriginDate: ").append(toIndentedString(flightOriginDate)).append("\n");
    sb.append("    employeeIdToReplace: ").append(toIndentedString(employeeIdToReplace)).append("\n");
    sb.append("    employeeIdReplaceWith: ").append(toIndentedString(employeeIdReplaceWith)).append("\n");
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

public Long getEmployeeIdToReplace() {
	return employeeIdToReplace;
}

public void setEmployeeIdToReplace(Long employeeIdToReplace) {
	this.employeeIdToReplace = employeeIdToReplace;
}

public Long getEmployeeIdReplaceWith() {
	return employeeIdReplaceWith;
}

public void setEmployeeIdReplaceWith(Long employeeIdReplaceWith) {
	this.employeeIdReplaceWith = employeeIdReplaceWith;
}
}

