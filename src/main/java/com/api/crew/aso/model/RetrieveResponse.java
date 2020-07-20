package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.PassengerDetails;
import com.api.crew.aso.model.SymptomDetails;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RetrieveResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-20T07:34:50.119Z")

public class RetrieveResponse   {
  @JsonProperty("flightDetails")
  private FlightDetails flightDetails = null;

  @JsonProperty("passengerDetails")
  private PassengerDetails passengerDetails = null;

  @JsonProperty("symptom")
  private SymptomDetails symptom = null;

  public RetrieveResponse flightDetails(FlightDetails flightDetails) {
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

  public RetrieveResponse passengerDetails(PassengerDetails passengerDetails) {
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

  public RetrieveResponse symptom(SymptomDetails symptom) {
    this.symptom = symptom;
    return this;
  }

  /**
   * Get symptom
   * @return symptom
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SymptomDetails getSymptom() {
    return symptom;
  }

  public void setSymptom(SymptomDetails symptom) {
    this.symptom = symptom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetrieveResponse retrieveResponse = (RetrieveResponse) o;
    return Objects.equals(this.flightDetails, retrieveResponse.flightDetails) &&
        Objects.equals(this.passengerDetails, retrieveResponse.passengerDetails) &&
        Objects.equals(this.symptom, retrieveResponse.symptom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flightDetails, passengerDetails, symptom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrieveResponse {\n");
    
    sb.append("    flightDetails: ").append(toIndentedString(flightDetails)).append("\n");
    sb.append("    passengerDetails: ").append(toIndentedString(passengerDetails)).append("\n");
    sb.append("    symptom: ").append(toIndentedString(symptom)).append("\n");
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

