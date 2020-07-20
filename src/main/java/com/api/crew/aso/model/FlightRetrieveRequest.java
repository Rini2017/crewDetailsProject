package com.api.crew.aso.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.FlightTicketDetails;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FlightRetrieveRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-20T07:34:50.119Z")

public class FlightRetrieveRequest   {
  @JsonProperty("flightTicketDetails")
  private FlightTicketDetails flightTicketDetails = null;

  public FlightRetrieveRequest flightTicketDetails(FlightTicketDetails flightTicketDetails) {
    this.flightTicketDetails = flightTicketDetails;
    return this;
  }

  /**
   * Get flightTicketDetails
   * @return flightTicketDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FlightTicketDetails getFlightTicketDetails() {
    return flightTicketDetails;
  }

  public void setFlightTicketDetails(FlightTicketDetails flightTicketDetails) {
    this.flightTicketDetails = flightTicketDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlightRetrieveRequest flightRetrieveRequest = (FlightRetrieveRequest) o;
    return Objects.equals(this.flightTicketDetails, flightRetrieveRequest.flightTicketDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flightTicketDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlightRetrieveRequest {\n");
    
    sb.append("    flightTicketDetails: ").append(toIndentedString(flightTicketDetails)).append("\n");
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

