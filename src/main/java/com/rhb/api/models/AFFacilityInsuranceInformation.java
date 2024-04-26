package com.rhb.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AF Facility Insurance Information
 */
@Schema(description = "AF Facility Insurance Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFFacilityInsuranceInformation   {
  @JsonProperty("insuranceTakafulOperator")
  private String insuranceTakafulOperator = null;

  @JsonProperty("insuranceTakafulType")
  private String insuranceTakafulType = null;

  @JsonProperty("financingType")
  private String financingType = null;

  @JsonProperty("coveredName")
  private String coveredName = null;

  @JsonProperty("primaryIdNo")
  private String primaryIdNo = null;

  @JsonProperty("calculationdate")
  private Date calculationdate = null;

  @JsonProperty("originalFinancingAmount")
  private Integer originalFinancingAmount = null;

  @JsonProperty("percentageCoverage")
  private Integer percentageCoverage = null;

  @JsonProperty("periodOfCover")
  private Integer periodOfCover = null;

  @JsonProperty("premiumFinanced")
  private Integer premiumFinanced = null;

  public AFFacilityInsuranceInformation insuranceTakafulOperator(String insuranceTakafulOperator) {
    this.insuranceTakafulOperator = insuranceTakafulOperator;
    return this;
  }

  /**
   * Insurance Takaful Operator
   * @return insuranceTakafulOperator
   **/
  @Schema(description = "Insurance Takaful Operator")
  
    public String getInsuranceTakafulOperator() {
    return insuranceTakafulOperator;
  }

  public void setInsuranceTakafulOperator(String insuranceTakafulOperator) {
    this.insuranceTakafulOperator = insuranceTakafulOperator;
  }

  public AFFacilityInsuranceInformation insuranceTakafulType(String insuranceTakafulType) {
    this.insuranceTakafulType = insuranceTakafulType;
    return this;
  }

  /**
   *  Insurance Takaful Type
   * @return insuranceTakafulType
   **/
  @Schema(description = " Insurance Takaful Type")
  
    public String getInsuranceTakafulType() {
    return insuranceTakafulType;
  }

  public void setInsuranceTakafulType(String insuranceTakafulType) {
    this.insuranceTakafulType = insuranceTakafulType;
  }

  public AFFacilityInsuranceInformation financingType(String financingType) {
    this.financingType = financingType;
    return this;
  }

  /**
   *  Financing Type 
   * @return financingType
   **/
  @Schema(description = " Financing Type ")
  
    public String getFinancingType() {
    return financingType;
  }

  public void setFinancingType(String financingType) {
    this.financingType = financingType;
  }

  public AFFacilityInsuranceInformation coveredName(String coveredName) {
    this.coveredName = coveredName;
    return this;
  }

  /**
   *  Covered Name
   * @return coveredName
   **/
  @Schema(description = " Covered Name")
  
    public String getCoveredName() {
    return coveredName;
  }

  public void setCoveredName(String coveredName) {
    this.coveredName = coveredName;
  }

  public AFFacilityInsuranceInformation primaryIdNo(String primaryIdNo) {
    this.primaryIdNo = primaryIdNo;
    return this;
  }

  /**
   *  Primary ID No
   * @return primaryIdNo
   **/
  @Schema(description = " Primary ID No")
  
    public String getPrimaryIdNo() {
    return primaryIdNo;
  }

  public void setPrimaryIdNo(String primaryIdNo) {
    this.primaryIdNo = primaryIdNo;
  }

  public AFFacilityInsuranceInformation calculationdate(Date calculationdate) {
    this.calculationdate = calculationdate;
    return this;
  }

  /**
   *  Calculation Date
   * @return calculationdate
   **/
  @Schema(description = " Calculation Date")
  
    @Valid
    public Date getCalculationdate() {
    return calculationdate;
  }

  public void setCalculationdate(Date calculationdate) {
    this.calculationdate = calculationdate;
  }

  public AFFacilityInsuranceInformation originalFinancingAmount(Integer originalFinancingAmount) {
    this.originalFinancingAmount = originalFinancingAmount;
    return this;
  }

  /**
   *  Original Financing Amount
   * @return originalFinancingAmount
   **/
  @Schema(description = " Original Financing Amount")
  
    public Integer getOriginalFinancingAmount() {
    return originalFinancingAmount;
  }

  public void setOriginalFinancingAmount(Integer originalFinancingAmount) {
    this.originalFinancingAmount = originalFinancingAmount;
  }

  public AFFacilityInsuranceInformation percentageCoverage(Integer percentageCoverage) {
    this.percentageCoverage = percentageCoverage;
    return this;
  }

  /**
   *  Percentage Coverage (%) 
   * @return percentageCoverage
   **/
  @Schema(description = " Percentage Coverage (%) ")
  
    public Integer getPercentageCoverage() {
    return percentageCoverage;
  }

  public void setPercentageCoverage(Integer percentageCoverage) {
    this.percentageCoverage = percentageCoverage;
  }

  public AFFacilityInsuranceInformation periodOfCover(Integer periodOfCover) {
    this.periodOfCover = periodOfCover;
    return this;
  }

  /**
   *  Period of Cover (Years)
   * @return periodOfCover
   **/
  @Schema(description = " Period of Cover (Years)")
  
    public Integer getPeriodOfCover() {
    return periodOfCover;
  }

  public void setPeriodOfCover(Integer periodOfCover) {
    this.periodOfCover = periodOfCover;
  }

  public AFFacilityInsuranceInformation premiumFinanced(Integer premiumFinanced) {
    this.premiumFinanced = premiumFinanced;
    return this;
  }

  /**
   *  Premium Financed
   * @return premiumFinanced
   **/
  @Schema(description = " Premium Financed")
  
    public Integer getPremiumFinanced() {
    return premiumFinanced;
  }

  public void setPremiumFinanced(Integer premiumFinanced) {
    this.premiumFinanced = premiumFinanced;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AFFacilityInsuranceInformation afFacilityInsuranceInformation = (AFFacilityInsuranceInformation) o;
    return Objects.equals(this.insuranceTakafulOperator, afFacilityInsuranceInformation.insuranceTakafulOperator) &&
        Objects.equals(this.insuranceTakafulType, afFacilityInsuranceInformation.insuranceTakafulType) &&
        Objects.equals(this.financingType, afFacilityInsuranceInformation.financingType) &&
        Objects.equals(this.coveredName, afFacilityInsuranceInformation.coveredName) &&
        Objects.equals(this.primaryIdNo, afFacilityInsuranceInformation.primaryIdNo) &&
        Objects.equals(this.calculationdate, afFacilityInsuranceInformation.calculationdate) &&
        Objects.equals(this.originalFinancingAmount, afFacilityInsuranceInformation.originalFinancingAmount) &&
        Objects.equals(this.percentageCoverage, afFacilityInsuranceInformation.percentageCoverage) &&
        Objects.equals(this.periodOfCover, afFacilityInsuranceInformation.periodOfCover) &&
        Objects.equals(this.premiumFinanced, afFacilityInsuranceInformation.premiumFinanced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(insuranceTakafulOperator, insuranceTakafulType, financingType, coveredName, primaryIdNo, calculationdate, originalFinancingAmount, percentageCoverage, periodOfCover, premiumFinanced);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFFacilityInsuranceInformation {\n");
    
    sb.append("    insuranceTakafulOperator: ").append(toIndentedString(insuranceTakafulOperator)).append("\n");
    sb.append("    insuranceTakafulType: ").append(toIndentedString(insuranceTakafulType)).append("\n");
    sb.append("    financingType: ").append(toIndentedString(financingType)).append("\n");
    sb.append("    coveredName: ").append(toIndentedString(coveredName)).append("\n");
    sb.append("    primaryIdNo: ").append(toIndentedString(primaryIdNo)).append("\n");
    sb.append("    calculationdate: ").append(toIndentedString(calculationdate)).append("\n");
    sb.append("    originalFinancingAmount: ").append(toIndentedString(originalFinancingAmount)).append("\n");
    sb.append("    percentageCoverage: ").append(toIndentedString(percentageCoverage)).append("\n");
    sb.append("    periodOfCover: ").append(toIndentedString(periodOfCover)).append("\n");
    sb.append("    premiumFinanced: ").append(toIndentedString(premiumFinanced)).append("\n");
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
