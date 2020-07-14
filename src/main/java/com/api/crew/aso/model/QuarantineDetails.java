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
 * QuarantineDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-11T12:40:34.974Z")

public class QuarantineDetails   {
  @JsonProperty("bedNo")
  private String bedNo = null;

  @JsonProperty("floorNo")
  private String floorNo = null;

  @JsonProperty("qrCenterId")
  private String qrCenterId = null;

  @JsonProperty("roomNo")
  private String roomNo = null;

  public QuarantineDetails bedNo(String bedNo) {
    this.bedNo = bedNo;
    return this;
  }

  /**
   * Get bedNo
   * @return bedNo
  **/
  @ApiModelProperty(value = "")


  public String getBedNo() {
    return bedNo;
  }

  public void setBedNo(String bedNo) {
    this.bedNo = bedNo;
  }

  public QuarantineDetails floorNo(String floorNo) {
    this.floorNo = floorNo;
    return this;
  }

  /**
   * Get floorNo
   * @return floorNo
  **/
  @ApiModelProperty(value = "")


  public String getFloorNo() {
    return floorNo;
  }

  public void setFloorNo(String floorNo) {
    this.floorNo = floorNo;
  }

  public QuarantineDetails qrCenterId(String qrCenterId) {
    this.qrCenterId = qrCenterId;
    return this;
  }

  /**
   * Get qrCenterId
   * @return qrCenterId
  **/
  @ApiModelProperty(value = "")


  public String getQrCenterId() {
    return qrCenterId;
  }

  public void setQrCenterId(String qrCenterId) {
    this.qrCenterId = qrCenterId;
  }

  public QuarantineDetails roomNo(String roomNo) {
    this.roomNo = roomNo;
    return this;
  }

  /**
   * Get roomNo
   * @return roomNo
  **/
  @ApiModelProperty(value = "")


  public String getRoomNo() {
    return roomNo;
  }

  public void setRoomNo(String roomNo) {
    this.roomNo = roomNo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuarantineDetails quarantineDetails = (QuarantineDetails) o;
    return Objects.equals(this.bedNo, quarantineDetails.bedNo) &&
        Objects.equals(this.floorNo, quarantineDetails.floorNo) &&
        Objects.equals(this.qrCenterId, quarantineDetails.qrCenterId) &&
        Objects.equals(this.roomNo, quarantineDetails.roomNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bedNo, floorNo, qrCenterId, roomNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuarantineDetails {\n");
    
    sb.append("    bedNo: ").append(toIndentedString(bedNo)).append("\n");
    sb.append("    floorNo: ").append(toIndentedString(floorNo)).append("\n");
    sb.append("    qrCenterId: ").append(toIndentedString(qrCenterId)).append("\n");
    sb.append("    roomNo: ").append(toIndentedString(roomNo)).append("\n");
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

