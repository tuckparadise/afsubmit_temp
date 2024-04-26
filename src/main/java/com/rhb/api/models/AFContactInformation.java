package com.rhb.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * AF Contact Information
 */
@Schema(description = "AF Contact Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFContactInformation   {
  @JsonProperty("mobilePhoneNoAreaCode")
  private String mobilePhoneNoAreaCode = null;

  @JsonProperty("mobilePhoneNo")
  private String mobilePhoneNo = null;

  @JsonProperty("internationalPhoneNoAreaCode")
  private String internationalPhoneNoAreaCode = null;

  @JsonProperty("internationalPhoneNo")
  private String internationalPhoneNo = null;

  @JsonProperty("internationalExtensionPhoneNo")
  private String internationalExtensionPhoneNo = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("residenceType")
  private String residenceType = null;

  @JsonProperty("countryOfPermanentResident")
  private String countryOfPermanentResident = null;

  @JsonProperty("computationMode")
  private String computationMode = null;

  @JsonProperty("jointDsr")
  private String jointDsr = null;

  @JsonProperty("drivingLicenseIndicator")
  private String drivingLicenseIndicator = null;

  @JsonProperty("sourceOfWealth")
  private String sourceOfWealth = null;

  public AFContactInformation mobilePhoneNoAreaCode(String mobilePhoneNoAreaCode) {
    this.mobilePhoneNoAreaCode = mobilePhoneNoAreaCode;
    return this;
  }

  /**
   *  Mobile Phone No (Area Code)
   * @return mobilePhoneNoAreaCode
   **/
  @Schema(required = true, description = " Mobile Phone No (Area Code)")
      @NotNull

    public String getMobilePhoneNoAreaCode() {
    return mobilePhoneNoAreaCode;
  }

  public void setMobilePhoneNoAreaCode(String mobilePhoneNoAreaCode) {
    this.mobilePhoneNoAreaCode = mobilePhoneNoAreaCode;
  }

  public AFContactInformation mobilePhoneNo(String mobilePhoneNo) {
    this.mobilePhoneNo = mobilePhoneNo;
    return this;
  }

  /**
   *  Mobile Phone No
   * @return mobilePhoneNo
   **/
  @Schema(required = true, description = " Mobile Phone No")
      @NotNull

    public String getMobilePhoneNo() {
    return mobilePhoneNo;
  }

  public void setMobilePhoneNo(String mobilePhoneNo) {
    this.mobilePhoneNo = mobilePhoneNo;
  }

  public AFContactInformation internationalPhoneNoAreaCode(String internationalPhoneNoAreaCode) {
    this.internationalPhoneNoAreaCode = internationalPhoneNoAreaCode;
    return this;
  }

  /**
   * International Phone No Area Code
   * @return internationalPhoneNoAreaCode
   **/
  @Schema(required = true, description = "International Phone No Area Code")
      @NotNull

    public String getInternationalPhoneNoAreaCode() {
    return internationalPhoneNoAreaCode;
  }

  public void setInternationalPhoneNoAreaCode(String internationalPhoneNoAreaCode) {
    this.internationalPhoneNoAreaCode = internationalPhoneNoAreaCode;
  }

  public AFContactInformation internationalPhoneNo(String internationalPhoneNo) {
    this.internationalPhoneNo = internationalPhoneNo;
    return this;
  }

  /**
   * International Phone No
   * @return internationalPhoneNo
   **/
  @Schema(required = true, description = "International Phone No")
      @NotNull

    public String getInternationalPhoneNo() {
    return internationalPhoneNo;
  }

  public void setInternationalPhoneNo(String internationalPhoneNo) {
    this.internationalPhoneNo = internationalPhoneNo;
  }

  public AFContactInformation internationalExtensionPhoneNo(String internationalExtensionPhoneNo) {
    this.internationalExtensionPhoneNo = internationalExtensionPhoneNo;
    return this;
  }

  /**
   * International Extension Phone No
   * @return internationalExtensionPhoneNo
   **/
  @Schema(required = true, description = "International Extension Phone No")
      @NotNull

    public String getInternationalExtensionPhoneNo() {
    return internationalExtensionPhoneNo;
  }

  public void setInternationalExtensionPhoneNo(String internationalExtensionPhoneNo) {
    this.internationalExtensionPhoneNo = internationalExtensionPhoneNo;
  }

  public AFContactInformation email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email
   * @return email
   **/
  @Schema(description = "Email")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AFContactInformation residenceType(String residenceType) {
    this.residenceType = residenceType;
    return this;
  }

  /**
   *  Residence Type / Premise Type
   * @return residenceType
   **/
  @Schema(required = true, description = " Residence Type / Premise Type")
      @NotNull

    public String getResidenceType() {
    return residenceType;
  }

  public void setResidenceType(String residenceType) {
    this.residenceType = residenceType;
  }

  public AFContactInformation countryOfPermanentResident(String countryOfPermanentResident) {
    this.countryOfPermanentResident = countryOfPermanentResident;
    return this;
  }

  /**
   *  Country of Permanent Resident
   * @return countryOfPermanentResident
   **/
  @Schema(required = true, description = " Country of Permanent Resident")
      @NotNull

    public String getCountryOfPermanentResident() {
    return countryOfPermanentResident;
  }

  public void setCountryOfPermanentResident(String countryOfPermanentResident) {
    this.countryOfPermanentResident = countryOfPermanentResident;
  }

  public AFContactInformation computationMode(String computationMode) {
    this.computationMode = computationMode;
    return this;
  }

  /**
   *  Computation Mode (Core Income)
   * @return computationMode
   **/
  @Schema(required = true, description = " Computation Mode (Core Income)")
      @NotNull

    public String getComputationMode() {
    return computationMode;
  }

  public void setComputationMode(String computationMode) {
    this.computationMode = computationMode;
  }

  public AFContactInformation jointDsr(String jointDsr) {
    this.jointDsr = jointDsr;
    return this;
  }

  /**
   * Joint DSR
   * @return jointDsr
   **/
  @Schema(description = "Joint DSR")
  
    public String getJointDsr() {
    return jointDsr;
  }

  public void setJointDsr(String jointDsr) {
    this.jointDsr = jointDsr;
  }

  public AFContactInformation drivingLicenseIndicator(String drivingLicenseIndicator) {
    this.drivingLicenseIndicator = drivingLicenseIndicator;
    return this;
  }

  /**
   *  Driving License Indicator
   * @return drivingLicenseIndicator
   **/
  @Schema(required = true, description = " Driving License Indicator")
      @NotNull

    public String getDrivingLicenseIndicator() {
    return drivingLicenseIndicator;
  }

  public void setDrivingLicenseIndicator(String drivingLicenseIndicator) {
    this.drivingLicenseIndicator = drivingLicenseIndicator;
  }

  public AFContactInformation sourceOfWealth(String sourceOfWealth) {
    this.sourceOfWealth = sourceOfWealth;
    return this;
  }

  /**
   *  Source of Wealth
   * @return sourceOfWealth
   **/
  @Schema(description = " Source of Wealth")
  
    public String getSourceOfWealth() {
    return sourceOfWealth;
  }

  public void setSourceOfWealth(String sourceOfWealth) {
    this.sourceOfWealth = sourceOfWealth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AFContactInformation afContactInformation = (AFContactInformation) o;
    return Objects.equals(this.mobilePhoneNoAreaCode, afContactInformation.mobilePhoneNoAreaCode) &&
        Objects.equals(this.mobilePhoneNo, afContactInformation.mobilePhoneNo) &&
        Objects.equals(this.internationalPhoneNoAreaCode, afContactInformation.internationalPhoneNoAreaCode) &&
        Objects.equals(this.internationalPhoneNo, afContactInformation.internationalPhoneNo) &&
        Objects.equals(this.internationalExtensionPhoneNo, afContactInformation.internationalExtensionPhoneNo) &&
        Objects.equals(this.email, afContactInformation.email) &&
        Objects.equals(this.residenceType, afContactInformation.residenceType) &&
        Objects.equals(this.countryOfPermanentResident, afContactInformation.countryOfPermanentResident) &&
        Objects.equals(this.computationMode, afContactInformation.computationMode) &&
        Objects.equals(this.jointDsr, afContactInformation.jointDsr) &&
        Objects.equals(this.drivingLicenseIndicator, afContactInformation.drivingLicenseIndicator) &&
        Objects.equals(this.sourceOfWealth, afContactInformation.sourceOfWealth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mobilePhoneNoAreaCode, mobilePhoneNo, internationalPhoneNoAreaCode, internationalPhoneNo, internationalExtensionPhoneNo, email, residenceType, countryOfPermanentResident, computationMode, jointDsr, drivingLicenseIndicator, sourceOfWealth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFContactInformation {\n");
    
    sb.append("    mobilePhoneNoAreaCode: ").append(toIndentedString(mobilePhoneNoAreaCode)).append("\n");
    sb.append("    mobilePhoneNo: ").append(toIndentedString(mobilePhoneNo)).append("\n");
    sb.append("    internationalPhoneNoAreaCode: ").append(toIndentedString(internationalPhoneNoAreaCode)).append("\n");
    sb.append("    internationalPhoneNo: ").append(toIndentedString(internationalPhoneNo)).append("\n");
    sb.append("    internationalExtensionPhoneNo: ").append(toIndentedString(internationalExtensionPhoneNo)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    residenceType: ").append(toIndentedString(residenceType)).append("\n");
    sb.append("    countryOfPermanentResident: ").append(toIndentedString(countryOfPermanentResident)).append("\n");
    sb.append("    computationMode: ").append(toIndentedString(computationMode)).append("\n");
    sb.append("    jointDsr: ").append(toIndentedString(jointDsr)).append("\n");
    sb.append("    drivingLicenseIndicator: ").append(toIndentedString(drivingLicenseIndicator)).append("\n");
    sb.append("    sourceOfWealth: ").append(toIndentedString(sourceOfWealth)).append("\n");
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
