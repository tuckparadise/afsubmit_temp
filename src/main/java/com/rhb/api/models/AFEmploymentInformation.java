package com.rhb.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AF Employment Information
 */
@Schema(description = "AF Employment Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFEmploymentInformation   {
  @JsonProperty("employmentType")
  private String employmentType = null;

  @JsonProperty("employerName")
  private String employerName = null;

  @JsonProperty("occupation")
  private String occupation = null;

  @JsonProperty("employmentSector")
  private String employmentSector = null;

  @JsonProperty("subEmploymentSector")
  private String subEmploymentSector = null;

  @JsonProperty("dateJoined")
  private Date dateJoined = null;

  @JsonProperty("lenthOfServiceYear")
  private Integer lenthOfServiceYear = null;

  @JsonProperty("lengthOfServiceMonth")
  private Integer lengthOfServiceMonth = null;

  @JsonProperty("monthlyGrossIncome")
  private Integer monthlyGrossIncome = null;

  @JsonProperty("monthlyNetIncome")
  private Integer monthlyNetIncome = null;

  public AFEmploymentInformation employmentType(String employmentType) {
    this.employmentType = employmentType;
    return this;
  }

  /**
   *  Employment Type 
   * @return employmentType
   **/
  @Schema(required = true, description = " Employment Type ")
      @NotNull

    public String getEmploymentType() {
    return employmentType;
  }

  public void setEmploymentType(String employmentType) {
    this.employmentType = employmentType;
  }

  public AFEmploymentInformation employerName(String employerName) {
    this.employerName = employerName;
    return this;
  }

  /**
   * Employer Name / Own Company
   * @return employerName
   **/
  @Schema(required = true, description = "Employer Name / Own Company")
      @NotNull

    public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public AFEmploymentInformation occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   *  Occupation
   * @return occupation
   **/
  @Schema(required = true, description = " Occupation")
      @NotNull

    public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public AFEmploymentInformation employmentSector(String employmentSector) {
    this.employmentSector = employmentSector;
    return this;
  }

  /**
   *  Employment Sector
   * @return employmentSector
   **/
  @Schema(required = true, description = " Employment Sector")
      @NotNull

    public String getEmploymentSector() {
    return employmentSector;
  }

  public void setEmploymentSector(String employmentSector) {
    this.employmentSector = employmentSector;
  }

  public AFEmploymentInformation subEmploymentSector(String subEmploymentSector) {
    this.subEmploymentSector = subEmploymentSector;
    return this;
  }

  /**
   *  Sub Employment Sector
   * @return subEmploymentSector
   **/
  @Schema(required = true, description = " Sub Employment Sector")
      @NotNull

    public String getSubEmploymentSector() {
    return subEmploymentSector;
  }

  public void setSubEmploymentSector(String subEmploymentSector) {
    this.subEmploymentSector = subEmploymentSector;
  }

  public AFEmploymentInformation dateJoined(Date dateJoined) {
    this.dateJoined = dateJoined;
    return this;
  }

  /**
   *  Date joined
   * @return dateJoined
   **/
  @Schema(required = true, description = " Date joined")
      @NotNull

    @Valid
    public Date getDateJoined() {
    return dateJoined;
  }

  public void setDateJoined(Date dateJoined) {
    this.dateJoined = dateJoined;
  }

  public AFEmploymentInformation lenthOfServiceYear(Integer lenthOfServiceYear) {
    this.lenthOfServiceYear = lenthOfServiceYear;
    return this;
  }

  /**
   *  Length of Service (Year)
   * @return lenthOfServiceYear
   **/
  @Schema(required = true, description = " Length of Service (Year)")
      @NotNull

    public Integer getLenthOfServiceYear() {
    return lenthOfServiceYear;
  }

  public void setLenthOfServiceYear(Integer lenthOfServiceYear) {
    this.lenthOfServiceYear = lenthOfServiceYear;
  }

  public AFEmploymentInformation lengthOfServiceMonth(Integer lengthOfServiceMonth) {
    this.lengthOfServiceMonth = lengthOfServiceMonth;
    return this;
  }

  /**
   *  Length of Service (Month)
   * @return lengthOfServiceMonth
   **/
  @Schema(required = true, description = " Length of Service (Month)")
      @NotNull

    public Integer getLengthOfServiceMonth() {
    return lengthOfServiceMonth;
  }

  public void setLengthOfServiceMonth(Integer lengthOfServiceMonth) {
    this.lengthOfServiceMonth = lengthOfServiceMonth;
  }

  public AFEmploymentInformation monthlyGrossIncome(Integer monthlyGrossIncome) {
    this.monthlyGrossIncome = monthlyGrossIncome;
    return this;
  }

  /**
   *  Monthly Gross Income
   * @return monthlyGrossIncome
   **/
  @Schema(required = true, description = " Monthly Gross Income")
      @NotNull

    public Integer getMonthlyGrossIncome() {
    return monthlyGrossIncome;
  }

  public void setMonthlyGrossIncome(Integer monthlyGrossIncome) {
    this.monthlyGrossIncome = monthlyGrossIncome;
  }

  public AFEmploymentInformation monthlyNetIncome(Integer monthlyNetIncome) {
    this.monthlyNetIncome = monthlyNetIncome;
    return this;
  }

  /**
   *  Monthly Net Income
   * @return monthlyNetIncome
   **/
  @Schema(required = true, description = " Monthly Net Income")
      @NotNull

    public Integer getMonthlyNetIncome() {
    return monthlyNetIncome;
  }

  public void setMonthlyNetIncome(Integer monthlyNetIncome) {
    this.monthlyNetIncome = monthlyNetIncome;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AFEmploymentInformation afEmploymentInformation = (AFEmploymentInformation) o;
    return Objects.equals(this.employmentType, afEmploymentInformation.employmentType) &&
        Objects.equals(this.employerName, afEmploymentInformation.employerName) &&
        Objects.equals(this.occupation, afEmploymentInformation.occupation) &&
        Objects.equals(this.employmentSector, afEmploymentInformation.employmentSector) &&
        Objects.equals(this.subEmploymentSector, afEmploymentInformation.subEmploymentSector) &&
        Objects.equals(this.dateJoined, afEmploymentInformation.dateJoined) &&
        Objects.equals(this.lenthOfServiceYear, afEmploymentInformation.lenthOfServiceYear) &&
        Objects.equals(this.lengthOfServiceMonth, afEmploymentInformation.lengthOfServiceMonth) &&
        Objects.equals(this.monthlyGrossIncome, afEmploymentInformation.monthlyGrossIncome) &&
        Objects.equals(this.monthlyNetIncome, afEmploymentInformation.monthlyNetIncome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employmentType, employerName, occupation, employmentSector, subEmploymentSector, dateJoined, lenthOfServiceYear, lengthOfServiceMonth, monthlyGrossIncome, monthlyNetIncome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFEmploymentInformation {\n");
    
    sb.append("    employmentType: ").append(toIndentedString(employmentType)).append("\n");
    sb.append("    employerName: ").append(toIndentedString(employerName)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    employmentSector: ").append(toIndentedString(employmentSector)).append("\n");
    sb.append("    subEmploymentSector: ").append(toIndentedString(subEmploymentSector)).append("\n");
    sb.append("    dateJoined: ").append(toIndentedString(dateJoined)).append("\n");
    sb.append("    lenthOfServiceYear: ").append(toIndentedString(lenthOfServiceYear)).append("\n");
    sb.append("    lengthOfServiceMonth: ").append(toIndentedString(lengthOfServiceMonth)).append("\n");
    sb.append("    monthlyGrossIncome: ").append(toIndentedString(monthlyGrossIncome)).append("\n");
    sb.append("    monthlyNetIncome: ").append(toIndentedString(monthlyNetIncome)).append("\n");
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
