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
 * CrewMemberDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-09T07:58:16.858Z")

public class CrewMemberDetails   {
  @JsonProperty("employeeId")
  private String employeeId = null;

  @JsonProperty("roleCode")
  private String roleCode = null;

  @JsonProperty("baseCode")
  private String baseCode = null;

  @JsonProperty("rotationBeginDate")
  private String rotationBeginDate = null;

  public CrewMemberDetails employeeId(String employeeId) {
    this.employeeId = employeeId;
    return this;
  }
  

  /**
   * Get employeeId
   * @return employeeId
  **/
  @ApiModelProperty(value = "")


  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public CrewMemberDetails roleCode(String roleCode) {
    this.roleCode = roleCode;
    return this;
  }

  /**
   * Get roleCode
   * @return roleCode
  **/
  @ApiModelProperty(value = "")


  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  public CrewMemberDetails baseCode(String baseCode) {
    this.baseCode = baseCode;
    return this;
  }

  /**
   * Get baseCode
   * @return baseCode
  **/
  @ApiModelProperty(value = "")


  public String getBaseCode() {
    return baseCode;
  }

  public void setBaseCode(String baseCode) {
    this.baseCode = baseCode;
  }

  public CrewMemberDetails rotationBeginDate(String rotationBeginDate) {
    this.rotationBeginDate = rotationBeginDate;
    return this;
  }

  /**
   * Get rotationBeginDate
   * @return rotationBeginDate
  **/
  @ApiModelProperty(value = "")


  public String getRotationBeginDate() {
    return rotationBeginDate;
  }

  public void setRotationBeginDate(String rotationBeginDate) {
    this.rotationBeginDate = rotationBeginDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrewMemberDetails crewMemberDetails = (CrewMemberDetails) o;
    return Objects.equals(this.employeeId, crewMemberDetails.employeeId) &&
        Objects.equals(this.roleCode, crewMemberDetails.roleCode) &&
        Objects.equals(this.baseCode, crewMemberDetails.baseCode) &&
        Objects.equals(this.rotationBeginDate, crewMemberDetails.rotationBeginDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, roleCode, baseCode, rotationBeginDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrewMemberDetails {\n");
    
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    roleCode: ").append(toIndentedString(roleCode)).append("\n");
    sb.append("    baseCode: ").append(toIndentedString(baseCode)).append("\n");
    sb.append("    rotationBeginDate: ").append(toIndentedString(rotationBeginDate)).append("\n");
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

