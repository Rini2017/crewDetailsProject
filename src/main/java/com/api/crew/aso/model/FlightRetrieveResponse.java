package com.api.crew.aso.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.api.crew.aso.model.RetrieveResponse;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FlightRetrieveResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-20T07:34:50.119Z")

public class FlightRetrieveResponse   {
  @JsonProperty("response")
  private List<RetrieveResponse> response = null;

  public FlightRetrieveResponse response(List<RetrieveResponse> response) {
    this.response = response;
    return this;
  }

  public FlightRetrieveResponse addResponseItem(RetrieveResponse responseItem) {
	    if (this.response == null) {
	      this.response = new ArrayList<RetrieveResponse>();
	    }
	    this.response.add(responseItem);
	    return this;
	  }

	  /**
	   * Get response
	   * @return response
	  **/
	  @ApiModelProperty(value = "")

	  @Valid

	  public List<RetrieveResponse> getResponse() {
	    return response;
	  }

	  public void setResponse(List<RetrieveResponse> response) {
	    this.response = response;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    FlightRetrieveResponse flightRetrieveResponse = (FlightRetrieveResponse) o;
	    return Objects.equals(this.response, flightRetrieveResponse.response);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(response);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class FlightRetrieveResponse {\n");
	    
	    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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

