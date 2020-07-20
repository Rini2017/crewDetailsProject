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
 * SymptomDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-20T07:34:50.119Z")

public class SymptomDetails   {
  @JsonProperty("temperature")
  private String temperature = null;

  @JsonProperty("fever")
  private String fever = null;

  @JsonProperty("cold")
  private String cold = null;

  @JsonProperty("cough")
  private String cough = null;

  @JsonProperty("breathingProblem")
  private String breathingProblem = null;

  @JsonProperty("wearingMask")
  private String wearingMask = null;

  public SymptomDetails temperature(String temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * Get temperature
   * @return temperature
  **/
  @ApiModelProperty(value = "")


  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public SymptomDetails fever(String fever) {
    this.fever = fever;
    return this;
  }

  /**
   * Get fever
   * @return fever
  **/
  @ApiModelProperty(value = "")


  public String getFever() {
    return fever;
  }

  public void setFever(String fever) {
    this.fever = fever;
  }

  public SymptomDetails cold(String cold) {
    this.cold = cold;
    return this;
  }

  /**
   * Get cold
   * @return cold
  **/
  @ApiModelProperty(value = "")


  public String getCold() {
    return cold;
  }

  public void setCold(String cold) {
    this.cold = cold;
  }

  public SymptomDetails cough(String cough) {
    this.cough = cough;
    return this;
  }

  /**
   * Get cough
   * @return cough
  **/
  @ApiModelProperty(value = "")


  public String getCough() {
    return cough;
  }

  public void setCough(String cough) {
    this.cough = cough;
  }

  public SymptomDetails breathingProblem(String breathingProblem) {
    this.breathingProblem = breathingProblem;
    return this;
  }

  /**
   * Get breathingProblem
   * @return breathingProblem
  **/
  @ApiModelProperty(value = "")


  public String getBreathingProblem() {
    return breathingProblem;
  }

  public void setBreathingProblem(String breathingProblem) {
    this.breathingProblem = breathingProblem;
  }

  public SymptomDetails wearingMask(String wearingMask) {
    this.wearingMask = wearingMask;
    return this;
  }

  /**
   * Get wearingMask
   * @return wearingMask
  **/
  @ApiModelProperty(value = "")


  public String getWearingMask() {
    return wearingMask;
  }

  public void setWearingMask(String wearingMask) {
    this.wearingMask = wearingMask;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SymptomDetails symptomDetails = (SymptomDetails) o;
    return Objects.equals(this.temperature, symptomDetails.temperature) &&
        Objects.equals(this.fever, symptomDetails.fever) &&
        Objects.equals(this.cold, symptomDetails.cold) &&
        Objects.equals(this.cough, symptomDetails.cough) &&
        Objects.equals(this.breathingProblem, symptomDetails.breathingProblem) &&
        Objects.equals(this.wearingMask, symptomDetails.wearingMask);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, fever, cold, cough, breathingProblem, wearingMask);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SymptomDetails {\n");
    
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    fever: ").append(toIndentedString(fever)).append("\n");
    sb.append("    cold: ").append(toIndentedString(cold)).append("\n");
    sb.append("    cough: ").append(toIndentedString(cough)).append("\n");
    sb.append("    breathingProblem: ").append(toIndentedString(breathingProblem)).append("\n");
    sb.append("    wearingMask: ").append(toIndentedString(wearingMask)).append("\n");
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

