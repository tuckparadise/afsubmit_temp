package com.rhb.api.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AF Collateral Information
 */
@Schema(description = "AF Collateral Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFCollateralInformation   {

  @JsonProperty("vehicleCondition")
  private String vehicleCondition = null;

  @JsonProperty("modelOfVehicle")
  private String modelOfVehicle = null;

  @JsonProperty("yearMake")
  private Integer yearMake = null;

  @JsonProperty("registrationDate")
  private LocalDate registrationDate = null;

  @JsonProperty("registrationNo")
  private String registrationNo = null;

  @JsonProperty("engineNo")
  private String engineNo = null;

  @JsonProperty("chassisNo")
  private String chassisNo = null;

  @JsonProperty("bdmMoreThan2500kg")
  private String bdmMoreThan2500kg = null;

  @JsonProperty("purchasePriceOTR")
  private BigDecimal purchasePrice = null;

  @JsonProperty("marketValue")
  private BigDecimal marketValue = null;

  public AFCollateralInformation vehicleCondition(String vehicleCondition) {
    this.vehicleCondition = vehicleCondition;
    return this;
  }

  /**
   *  Vehicle Condition 
   * @return vehicleCondition
   **/
  @Schema(required = true, description = " Vehicle Condition ")
      @NotNull

    public String getVehicleCondition() {
    return vehicleCondition;
  }

  public void setVehicleCondition(String vehicleCondition) {
    this.vehicleCondition = vehicleCondition;
  }

  public AFCollateralInformation modelOfVehicle(String modelOfVehicle) {
    this.modelOfVehicle = modelOfVehicle;
    return this;
  }

  /**
   *  Model of Vehicle
   * @return modelOfVehicle
   **/
  @Schema(required = true, description = " Model of Vehicle")
      @NotNull

    public String getModelOfVehicle() {
    return modelOfVehicle;
  }

  public void setModelOfVehicle(String modelOfVehicle) {
    this.modelOfVehicle = modelOfVehicle;
  }

  public AFCollateralInformation yearMake(Integer yearMake) {
    this.yearMake = yearMake;
    return this;
  }

  /**
   * Year Make
   * @return yearMake
   **/
  @Schema(required = true, description = "Year Make")
    public Integer getYearMake() {
    return yearMake;
  }

  public void setYearMake(Integer yearMake) {
    this.yearMake = yearMake;
  }

  public AFCollateralInformation resgistrationDate(LocalDate resgistrationDate) {
    this.registrationDate = resgistrationDate;
    return this;
  }

  /**
   *  Registration Date
   * @return resgistrationDate
   **/
  @Schema(required = true, description = " Registration Date")

    @Valid
    public LocalDate getRegistrationDate() {
    return registrationDate;
  }

  public void setResgistrationDate(LocalDate resgistrationDate) {
    this.registrationDate = resgistrationDate;
  }

  public AFCollateralInformation registrationNo(String registrationNo) {
    this.registrationNo = registrationNo;
    return this;
  }

  /**
   *  Registration No
   * @return registrationNo
   **/
  @Schema(required = true, description = " Registration No")
      @NotNull

    public String getRegistrationNo() {
    return registrationNo;
  }

  public void setRegistrationNo(String registrationNo) {
    this.registrationNo = registrationNo;
  }

  public AFCollateralInformation engineNo(String engineNo) {
    this.engineNo = engineNo;
    return this;
  }

  /**
   *  Engine No
   * @return engineNo
   **/
  @Schema(description = " Engine No")
  
    public String getEngineNo() {
    return engineNo;
  }

  public void setEngineNo(String engineNo) {
    this.engineNo = engineNo;
  }

  public AFCollateralInformation chassisNo(String chassisNo) {
    this.chassisNo = chassisNo;
    return this;
  }

  /**
   *  Chassis No 
   * @return chassisNo
   **/
  @Schema(description = " Chassis No ")
  
    public String getChassisNo() {
    return chassisNo;
  }

  public void setChassisNo(String chassisNo) {
    this.chassisNo = chassisNo;
  }

  public AFCollateralInformation bdmMoreThan2500kg(String bdmMoreThan2500kg) {
    this.bdmMoreThan2500kg = bdmMoreThan2500kg;
    return this;
  }

  /**
   *  BDM more than 2500kg 
   * @return bdmMoreThan2500kg
   **/
  @Schema(required = true, description = " BDM more than 2500kg ")
      @NotNull

    public String getBdmMoreThan2500kg() {
    return bdmMoreThan2500kg;
  }

  public void setBdmMoreThan2500kg(String bdmMoreThan2500kg) {
    this.bdmMoreThan2500kg = bdmMoreThan2500kg;
  }

  public AFCollateralInformation purchasePrice(BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
    return this;
  }

  /**
   *  Purchase Price (OTR)
   * @return purchasePrice
   **/
  @Schema(required = true, description = " Purchase Price (OTR)")

    public BigDecimal getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public AFCollateralInformation marketValue(BigDecimal marketValue) {
    this.marketValue = marketValue;
    return this;
  }

  /**
   *  Market Value 
   * @return marketValue
   **/
  @Schema(required = true, description = " Market Value ")

    public BigDecimal getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(BigDecimal marketValue) {
    this.marketValue = marketValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AFCollateralInformation afCollateralInformation = (AFCollateralInformation) o;
    return Objects.equals(this.vehicleCondition, afCollateralInformation.vehicleCondition) &&
        Objects.equals(this.modelOfVehicle, afCollateralInformation.modelOfVehicle) &&
        Objects.equals(this.yearMake, afCollateralInformation.yearMake) &&
        Objects.equals(this.registrationDate, afCollateralInformation.registrationDate) &&
        Objects.equals(this.registrationNo, afCollateralInformation.registrationNo) &&
        Objects.equals(this.engineNo, afCollateralInformation.engineNo) &&
        Objects.equals(this.chassisNo, afCollateralInformation.chassisNo) &&
        Objects.equals(this.bdmMoreThan2500kg, afCollateralInformation.bdmMoreThan2500kg) &&
        Objects.equals(this.purchasePrice, afCollateralInformation.purchasePrice) &&
        Objects.equals(this.marketValue, afCollateralInformation.marketValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleCondition, modelOfVehicle, yearMake, registrationDate, registrationNo, engineNo, chassisNo, bdmMoreThan2500kg, purchasePrice, marketValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFCollateralInformation {\n");
    
    sb.append("    vehicleCondition: ").append(toIndentedString(vehicleCondition)).append("\n");
    sb.append("    modelOfVehicle: ").append(toIndentedString(modelOfVehicle)).append("\n");
    sb.append("    yearMake: ").append(toIndentedString(yearMake)).append("\n");
    sb.append("    resgistrationDate: ").append(toIndentedString(registrationDate)).append("\n");
    sb.append("    registrationNo: ").append(toIndentedString(registrationNo)).append("\n");
    sb.append("    engineNo: ").append(toIndentedString(engineNo)).append("\n");
    sb.append("    chassisNo: ").append(toIndentedString(chassisNo)).append("\n");
    sb.append("    bdmMoreThan2500kg: ").append(toIndentedString(bdmMoreThan2500kg)).append("\n");
    sb.append("    purchasePrice: ").append(toIndentedString(purchasePrice)).append("\n");
    sb.append("    marketValue: ").append(toIndentedString(marketValue)).append("\n");
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
