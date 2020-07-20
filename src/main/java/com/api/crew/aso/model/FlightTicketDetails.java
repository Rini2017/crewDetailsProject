package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.FlightDetails;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FlightTicketDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-20T07:34:50.119Z")

public class FlightTicketDetails   {
  @JsonProperty("flightDetails")
  private FlightDetails flightDetails = null;

  @JsonProperty("ticketNo")
  private String ticketNo = null;

  @JsonProperty("pnrNo")
  private String pnrNo = null;

  public FlightTicketDetails flightDetails(FlightDetails flightDetails) {
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

  public FlightTicketDetails ticketNo(String ticketNo) {
    this.ticketNo = ticketNo;
    return this;
  }

  /**
   * Get ticketNo
   * @return ticketNo
  **/
  @ApiModelProperty(value = "")


  public String getTicketNo() {
    return ticketNo;
  }

  public void setTicketNo(String ticketNo) {
    this.ticketNo = ticketNo;
  }

  public FlightTicketDetails pnrNo(String pnrNo) {
    this.pnrNo = pnrNo;
    return this;
  }

  /**
   * Get pnrNo
   * @return pnrNo
  **/
  @ApiModelProperty(value = "")


  public String getPnrNo() {
    return pnrNo;
  }

  public void setPnrNo(String pnrNo) {
    this.pnrNo = pnrNo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlightTicketDetails flightTicketDetails = (FlightTicketDetails) o;
    return Objects.equals(this.flightDetails, flightTicketDetails.flightDetails) &&
        Objects.equals(this.ticketNo, flightTicketDetails.ticketNo) &&
        Objects.equals(this.pnrNo, flightTicketDetails.pnrNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flightDetails, ticketNo, pnrNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlightTicketDetails {\n");
    
    sb.append("    flightDetails: ").append(toIndentedString(flightDetails)).append("\n");
    sb.append("    ticketNo: ").append(toIndentedString(ticketNo)).append("\n");
    sb.append("    pnrNo: ").append(toIndentedString(pnrNo)).append("\n");
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

