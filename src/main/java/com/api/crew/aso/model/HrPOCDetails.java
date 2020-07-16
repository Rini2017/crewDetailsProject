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
 * HrPOCDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T07:23:35.052Z")

public class HrPOCDetails   {
  @JsonProperty("hrPOCName")
  private String hrPOCName = null;

  @JsonProperty("hrPOCEmailId")
  private String hrPOCEmailId = null;

  @JsonProperty("hrPOCPhoneNo")
  private String hrPOCPhoneNo = null;

  public HrPOCDetails hrPOCName(String hrPOCName) {
    this.hrPOCName = hrPOCName;
    return this;
  }

  /**
   * Get hrPOCName
   * @return hrPOCName
  **/
  @ApiModelProperty(value = "")


  public String getHrPOCName() {
    return hrPOCName;
  }

  public void setHrPOCName(String hrPOCName) {
    this.hrPOCName = hrPOCName;
  }

  public HrPOCDetails hrPOCEmailId(String hrPOCEmailId) {
    this.hrPOCEmailId = hrPOCEmailId;
    return this;
  }

  /**
   * Get hrPOCEmailId
   * @return hrPOCEmailId
  **/
  @ApiModelProperty(value = "")


  public String getHrPOCEmailId() {
    return hrPOCEmailId;
  }

  public void setHrPOCEmailId(String hrPOCEmailId) {
    this.hrPOCEmailId = hrPOCEmailId;
  }

  public HrPOCDetails hrPOCPhoneNo(String hrPOCPhoneNo) {
    this.hrPOCPhoneNo = hrPOCPhoneNo;
    return this;
  }

  /**
   * Get hrPOCPhoneNo
   * @return hrPOCPhoneNo
  **/
  @ApiModelProperty(value = "")


  public String getHrPOCPhoneNo() {
    return hrPOCPhoneNo;
  }

  public void setHrPOCPhoneNo(String hrPOCPhoneNo) {
    this.hrPOCPhoneNo = hrPOCPhoneNo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HrPOCDetails hrPOCDetails = (HrPOCDetails) o;
    return Objects.equals(this.hrPOCName, hrPOCDetails.hrPOCName) &&
        Objects.equals(this.hrPOCEmailId, hrPOCDetails.hrPOCEmailId) &&
        Objects.equals(this.hrPOCPhoneNo, hrPOCDetails.hrPOCPhoneNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hrPOCName, hrPOCEmailId, hrPOCPhoneNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HrPOCDetails {\n");
    
    sb.append("    hrPOCName: ").append(toIndentedString(hrPOCName)).append("\n");
    sb.append("    hrPOCEmailId: ").append(toIndentedString(hrPOCEmailId)).append("\n");
    sb.append("    hrPOCPhoneNo: ").append(toIndentedString(hrPOCPhoneNo)).append("\n");
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

