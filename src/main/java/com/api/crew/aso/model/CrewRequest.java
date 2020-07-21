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
 * CrewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-09T07:58:16.858Z")

public class CrewRequest   {
  @JsonProperty("arrivalStationCode")
  private String arrivalStationCode = null;

  @JsonProperty("departureStationCode")
  private String departureStationCode = null;

  @JsonProperty("flightNumber")
  private String flightNumber = null;

  @JsonProperty("flightOriginDate")
  private String flightOriginDate = null;

  public CrewRequest arrivalStationCode(String arrivalStationCode) {
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


  public CrewRequest departureStationCode(String departureStationCode) {
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

  public CrewRequest flightNumber(String flightNumber) {
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

  public CrewRequest flightOriginDate(String flightOriginDate) {
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
    CrewRequest crewRequest = (CrewRequest) o;
    return Objects.equals(this.arrivalStationCode, crewRequest.arrivalStationCode) &&
        Objects.equals(this.departureStationCode, crewRequest.departureStationCode) &&
        Objects.equals(this.flightNumber, crewRequest.flightNumber) &&
        Objects.equals(this.flightOriginDate, crewRequest.flightOriginDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arrivalStationCode, departureStationCode, flightNumber, flightOriginDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewRequest {\n");
    
    sb.append("    arrivalStationCode: ").append(toIndentedString(arrivalStationCode)).append("\n");
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

