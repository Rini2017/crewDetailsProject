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
 * Symptoms
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T07:23:35.052Z")

public class Symptoms   {
  @JsonProperty("symptomName")
  private String symptomName = null;

  @JsonProperty("symptomValue")
  private String symptomValue = null;

  public Symptoms symptomName(String symptomName) {
    this.symptomName = symptomName;
    return this;
  }

  /**
   * Get symptomName
   * @return symptomName
  **/
  @ApiModelProperty(value = "")


  public String getSymptomName() {
    return symptomName;
  }

  public void setSymptomName(String symptomName) {
    this.symptomName = symptomName;
  }

  public Symptoms symptomValue(String symptomValue) {
    this.symptomValue = symptomValue;
    return this;
  }

  /**
   * Get symptomValue
   * @return symptomValue
  **/
  @ApiModelProperty(value = "")


  public String getSymptomValue() {
    return symptomValue;
  }

  public void setSymptomValue(String symptomValue) {
    this.symptomValue = symptomValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Symptoms symptoms = (Symptoms) o;
    return Objects.equals(this.symptomName, symptoms.symptomName) &&
        Objects.equals(this.symptomValue, symptoms.symptomValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symptomName, symptomValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Symptoms {\n");
    
    sb.append("    symptomName: ").append(toIndentedString(symptomName)).append("\n");
    sb.append("    symptomValue: ").append(toIndentedString(symptomValue)).append("\n");
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

