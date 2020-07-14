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
 * NotificationResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-11T12:40:34.974Z")

public class NotificationResponse   {
  @JsonProperty("crewId")
  private Long crewId = null;

  @JsonProperty("pocId")
  private String pocId = null;

  @JsonProperty("statusCode")
  private String statusCode = null;

  @JsonProperty("message")
  private String message = null;

  public NotificationResponse crewId(Long crewId) {
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

  public NotificationResponse pocId(String pocId) {
    this.pocId = pocId;
    return this;
  }

  /**
   * Get pocId
   * @return pocId
  **/
  @ApiModelProperty(value = "")


  public String getPocId() {
    return pocId;
  }

  public void setPocId(String pocId) {
    this.pocId = pocId;
  }

  public NotificationResponse statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   * @return statusCode
  **/
  @ApiModelProperty(value = "")


  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public NotificationResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationResponse notificationResponse = (NotificationResponse) o;
    return Objects.equals(this.crewId, notificationResponse.crewId) &&
        Objects.equals(this.pocId, notificationResponse.pocId) &&
        Objects.equals(this.statusCode, notificationResponse.statusCode) &&
        Objects.equals(this.message, notificationResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crewId, pocId, statusCode, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationResponse {\n");
    
    sb.append("    crewId: ").append(toIndentedString(crewId)).append("\n");
    sb.append("    pocId: ").append(toIndentedString(pocId)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

