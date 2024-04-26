package com.rhb.api.models;

import java.math.BigDecimal;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * AF Facility Information
 */
@Schema(description = "AF Facility Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFFacilityInformation   {
  @JsonProperty("financingAmount")
  private BigDecimal financingAmount = null;

  @JsonProperty("downpayment")
  private BigDecimal cashDownpayment = null;

  @JsonProperty("facilityTenureYears")
  private Integer facilityTenure = null;

  @JsonProperty("sourceOfFund")
  private String sourceOfFund = null;

  /* GDTAPI-2951: new AF product code */ 
  @JsonProperty("product")
  private String product = null;
  /* GDTAPI-2951: new AF product code */ 
  
  public AFFacilityInformation financingAmount(BigDecimal financingAmount) {
    this.financingAmount = financingAmount;
    return this;
  }

  /**
   *  Financing Amount
   * @return financingAmount
   **/
  @Schema(description = " Financing Amount")
  
    public BigDecimal getFinancingAmount() {
    return financingAmount;
  }

  public void setFinancingAmount(BigDecimal financingAmount) {
    this.financingAmount = financingAmount;
  }

  public AFFacilityInformation cashDownpayment(BigDecimal cashDownpayment) {
    this.cashDownpayment = cashDownpayment;
    return this;
  }

  /**
   *  Cash Downpayment
   * @return cashDownpayment
   **/
  @Schema(required = true, description = " Cash Downpayment")

    public BigDecimal getCashDownpayment() {
    return cashDownpayment;
  }

  public void setCashDownpayment(BigDecimal cashDownpayment) {
    this.cashDownpayment = cashDownpayment;
  }

  public AFFacilityInformation facilityTenure(Integer facilityTenure) {
    this.facilityTenure = facilityTenure;
    return this;
  }

  /**
   *  Facility Tenure (Years)
   * @return facilityTenure
   **/
  @Schema(required = true, description = " Facility Tenure (Years)")

    public Integer getFacilityTenure() {
    return facilityTenure;
  }

  public void setFacilityTenure(Integer facilityTenure) {
    this.facilityTenure = facilityTenure;
  }

  public AFFacilityInformation sourceOfFund(String sourceOfFund) {
    this.sourceOfFund = sourceOfFund;
    return this;
  }

  /**
   *  Source of Fund 
   * @return sourceOfFund
   **/
  @Schema(description = " Source of Fund ")
  
    public String getSourceOfFund() {
    return sourceOfFund;
  }

  public void setSourceOfFund(String sourceOfFund) {
    this.sourceOfFund = sourceOfFund;
  }
  
  /* GDTAPI-2951: new AF product code */ 
  public AFFacilityInformation product(String product) {
    this.product = product;
    return this;
  }

  /**
   *  product
   * @return product
   **/
  @Schema(description = " product")
  
    public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }
  /* GDTAPI-2951: new AF product code */ 
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AFFacilityInformation afFacilityInformation = (AFFacilityInformation) o;
    return Objects.equals(this.financingAmount, afFacilityInformation.financingAmount) &&
        Objects.equals(this.cashDownpayment, afFacilityInformation.cashDownpayment) &&
        Objects.equals(this.facilityTenure, afFacilityInformation.facilityTenure) &&
        Objects.equals(this.sourceOfFund, afFacilityInformation.sourceOfFund) &&
        Objects.equals(this.product, afFacilityInformation.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financingAmount, cashDownpayment, facilityTenure, sourceOfFund, product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFFacilityInformation {\n");
    
    sb.append("    financingAmount: ").append(toIndentedString(financingAmount)).append("\n");
    sb.append("    cashDownpayment: ").append(toIndentedString(cashDownpayment)).append("\n");
    sb.append("    facilityTenure: ").append(toIndentedString(facilityTenure)).append("\n");
    sb.append("    sourceOfFund: ").append(toIndentedString(sourceOfFund)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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
