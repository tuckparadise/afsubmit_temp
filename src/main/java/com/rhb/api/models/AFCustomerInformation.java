package com.rhb.api.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AF Customer Information
 */
@Schema(description = "AF Customer Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFCustomerInformation   {
  public List<AFAddressInformation> getAddressInformation() {
    return addressInformation;
  }

  public void setAddressInformation(List<AFAddressInformation> addressInformation) {
    this.addressInformation = addressInformation;
  }

  @JsonProperty("residenceType")
  private String residenceType = null;

  public String getResidenceType() {
    return residenceType;
  }

  @JsonProperty("sourceOfWealth")
  private String sourceOfWealth = null;

  public String getSourceOfWealth() {
    return sourceOfWealth;
  }

  public void setSourceOfWealth(String sourceOfWealth) {
    this.sourceOfWealth = sourceOfWealth;
  }

  @JsonProperty("computationMode")
  private String computationMode = null;

  public String getComputationMode() {
    return computationMode;
  }

  public void setComputationMode(String computationMode) {
    this.computationMode = computationMode;
  }

  @JsonProperty("internationalPhoneNoAreaCode")
  private String internationalPhoneNoAreaCode = null;

  @JsonProperty("internationalPhoneNo")
  private String internationalPhoneNo = null;

  @JsonProperty("internationalExtensionPhoneNo")
  private String internationalExtensionPhoneNo = null;

  public String getInternationalPhoneNoAreaCode() {
    return internationalPhoneNoAreaCode;
  }

  public void setInternationalPhoneNoAreaCode(String internationalPhoneNoAreaCode) {
    this.internationalPhoneNoAreaCode = internationalPhoneNoAreaCode;
  }

  public String getInternationalPhoneNo() {
    return internationalPhoneNo;
  }

  public void setInternationalPhoneNo(String internationalPhoneNo) {
    this.internationalPhoneNo = internationalPhoneNo;
  }

  public String getInternationalExtensionPhoneNo() {
    return internationalExtensionPhoneNo;
  }

  public void setInternationalExtensionPhoneNo(String internationalExtensionPhoneNo) {
    this.internationalExtensionPhoneNo = internationalExtensionPhoneNo;
  }

  @JsonProperty("mobilePhoneNoAreaCode")
  private String mobilePhoneNoAreaCode = null;

  @JsonProperty("mobilePhoneNo")
  private String mobilePhoneNo = null;

  public String getMobilePhoneNoAreaCode() {
    return mobilePhoneNoAreaCode;
  }

  public void setMobilePhoneNoAreaCode(String mobilePhoneNoAreaCode) {
    this.mobilePhoneNoAreaCode = mobilePhoneNoAreaCode;
  }

  public String getMobilePhoneNo() {
    return mobilePhoneNo;
  }

  public void setMobilePhoneNo(String mobilePhoneNo) {
    this.mobilePhoneNo = mobilePhoneNo;
  }

  public void setResidenceType(String residenceType) {
    this.residenceType = residenceType;
  }


  @JsonProperty("addressList")
  private List<AFAddressInformation> addressInformation = null;

  @JsonProperty("customerName")
  private String cutomerName = null;

  @JsonProperty("idType")
  private String idType = null;

  @JsonProperty("idNo")
  private String idNo = null;

  @JsonProperty("foreignPR")
  private String foreignPR = null;

  @JsonProperty("pRIDNo")
  private String prIdNumber = null;

  @JsonProperty("dateOfBirth")
  private LocalDate dateOfBirth = null;

  @JsonProperty("race")
  private String race = null;

  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("educationLevel")
  private String educationLevel = null;

  @JsonProperty("maritalStatus")
  private String maritalStatus = null;

  @JsonProperty("noOfDependants")
  private Integer noOfDependants = null;

  @JsonProperty("employmentType")
  private String employmentType = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("countryOfPermanentResident")
  private String countryOfPermanentResident = null;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCountryOfPermanentResident() {
    return countryOfPermanentResident;
  }

  public void setCountryOfPermanentResident(String countryOfPermanentResident) {
    this.countryOfPermanentResident = countryOfPermanentResident;
  }

  @JsonProperty("employerName")
  private String employerName = null;

  @JsonProperty("occupation")
  private String occupation = null;

  @JsonProperty("employmentSector")
  private String employmentSector = null;

  @JsonProperty("subEmploymentSector")
  private String subEmploymentSector = null;

  @JsonProperty("dateJoined")
  private LocalDate dateJoined = null;


  public String getEmploymentType() {
    return employmentType;
  }

  public void setEmploymentType(String employmentType) {
    this.employmentType = employmentType;
  }

  public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getEmploymentSector() {
    return employmentSector;
  }

  public void setEmploymentSector(String employmentSector) {
    this.employmentSector = employmentSector;
  }

  public String getSubEmploymentSector() {
    return subEmploymentSector;
  }

  public void setSubEmploymentSector(String subEmploymentSector) {
    this.subEmploymentSector = subEmploymentSector;
  }

  public LocalDate getDateJoined() {
    return dateJoined;
  }

  public void setDateJoined(LocalDate dateJoined) {
    this.dateJoined = dateJoined;
  }

  public BigDecimal getMonthlyGrossIncome() {
    return monthlyGrossIncome;
  }

  public void setMonthlyGrossIncome(BigDecimal monthlyGrossIncome) {
    this.monthlyGrossIncome = monthlyGrossIncome;
  }

  public BigDecimal getMonthlyNetIncome() {
    return monthlyNetIncome;
  }

  public void setMonthlyNetIncome(BigDecimal monthlyNetIncome) {
    this.monthlyNetIncome = monthlyNetIncome;
  }

  @JsonProperty("monthlyGrossIncome")
  private BigDecimal monthlyGrossIncome = null;

  @JsonProperty("monthlyNetIncome")
  private BigDecimal monthlyNetIncome = null;

  public AFCustomerInformation cutomerName(String cutomerName) {
    this.cutomerName = cutomerName;
    return this;
  }

  /**
   *  Customer Name
   * @return cutomerName
   **/
  @Schema(required = true, description = " Customer Name")
      @NotNull

    public String getCutomerName() {
    return cutomerName;
  }

  public void setCutomerName(String cutomerName) {
    this.cutomerName = cutomerName;
  }

  public AFCustomerInformation idType(String idType) {
    this.idType = idType;
    return this;
  }

  /**
   * ID Type
   * @return idType
   **/
  @Schema(required = true, description = "ID Type")
      @NotNull

    public String getIdType() {
    return idType;
  }

  public void setIdType(String idType) {
    this.idType = idType;
  }

  public AFCustomerInformation idNo(String idNo) {
    this.idNo = idNo;
    return this;
  }

  /**
   *  ID No
   * @return idNo
   **/
  @Schema(required = true, description = " ID No")
      @NotNull

    public String getIdNo() {
    return idNo;
  }

  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  public AFCustomerInformation foreignPR(String foreignPR) {
    this.foreignPR = foreignPR;
    return this;
  }

  /**
   *  Foreign PR
   * @return foreignPR
   **/
  @Schema(required = true, description = " Foreign PR")
      @NotNull

    public String getForeignPR() {
    return foreignPR;
  }

  public void setForeignPR(String foreignPR) {
    this.foreignPR = foreignPR;
  }

  public AFCustomerInformation prIdNumber(String prIdNumber) {
    this.prIdNumber = prIdNumber;
    return this;
  }

  /**
   *  PR ID Number
   * @return prIdNumber
   **/
  @Schema(required = true, description = " PR ID Number")
      @NotNull

    public String getPrIdNumber() {
    return prIdNumber;
  }

  public void setPrIdNumber(String prIdNumber) {
    this.prIdNumber = prIdNumber;
  }

  public AFCustomerInformation dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   *  Date of Birth / Date of Incorporation
   * @return dateOfBirth
   **/
  @Schema(required = true, description = " Date of Birth / Date of Incorporation")


    @Valid
    public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public AFCustomerInformation race(String race) {
    this.race = race;
    return this;
  }

  /**
   *  Race
   * @return race
   **/
  @Schema(required = true, description = " Race")
      @NotNull

    public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public AFCustomerInformation gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   *  Gender
   * @return gender
   **/
  @Schema(required = true, description = " Gender")
      @NotNull

    public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public AFCustomerInformation educationLevel(String educationLevel) {
    this.educationLevel = educationLevel;
    return this;
  }

  /**
   *  Education Level
   * @return educationLevel
   **/
  @Schema(required = true, description = " Education Level")
      @NotNull

    public String getEducationLevel() {
    return educationLevel;
  }

  public void setEducationLevel(String educationLevel) {
    this.educationLevel = educationLevel;
  }

  public AFCustomerInformation maritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Marital Status
   * @return maritalStatus
   **/
  @Schema(required = true, description = "Marital Status")
      @NotNull

    public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public AFCustomerInformation noOfDependants(Integer noOfDependants) {
    this.noOfDependants = noOfDependants;
    return this;
  }

  /**
   *  No of dependants
   * @return noOfDependants
   **/
  @Schema(required = true, description = " No of dependants")

    public Integer getNoOfDependants() {
    return noOfDependants;
  }

  public void setNoOfDependants(Integer noOfDependants) {
    this.noOfDependants = noOfDependants;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AFCustomerInformation afCustomerInformation = (AFCustomerInformation) o;
    return Objects.equals(this.cutomerName, afCustomerInformation.cutomerName) &&
        Objects.equals(this.idType, afCustomerInformation.idType) &&
        Objects.equals(this.idNo, afCustomerInformation.idNo) &&
        Objects.equals(this.foreignPR, afCustomerInformation.foreignPR) &&
        Objects.equals(this.prIdNumber, afCustomerInformation.prIdNumber) &&
        Objects.equals(this.dateOfBirth, afCustomerInformation.dateOfBirth) &&
        Objects.equals(this.race, afCustomerInformation.race) &&
        Objects.equals(this.gender, afCustomerInformation.gender) &&
        Objects.equals(this.educationLevel, afCustomerInformation.educationLevel) &&
        Objects.equals(this.maritalStatus, afCustomerInformation.maritalStatus) &&
        Objects.equals(this.noOfDependants, afCustomerInformation.noOfDependants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cutomerName, idType, idNo, foreignPR, prIdNumber, dateOfBirth, race, gender, educationLevel, maritalStatus, noOfDependants);
  }


//  @Override
//  public String toString() {
//    return "AFCustomerInformation{" +
//            "residenceType='" + residenceType + '\'' +
//            ", sourceOfWealth='" + sourceOfWealth + '\'' +
//            ", computationMode='" + computationMode + '\'' +
//            ", internationalPhoneNoAreaCode='" + internationalPhoneNoAreaCode + '\'' +
//            ", internationalPhoneNo='" + internationalPhoneNo + '\'' +
//            ", internationalExtensionPhoneNo='" + internationalExtensionPhoneNo + '\'' +
//            ", mobilePhoneNoAreaCode='" + mobilePhoneNoAreaCode + '\'' +
//            ", mobilePhoneNo='" + mobilePhoneNo + '\'' +
//            ", addressInformation=" + addressInformation +
//            ", cutomerName='" + cutomerName + '\'' +
//            ", idType='" + idType + '\'' +
//            ", idNo='" + idNo + '\'' +
//            ", foreignPR='" + foreignPR + '\'' +
//            ", prIdNumber='" + prIdNumber + '\'' +
//            ", dateOfBirth=" + dateOfBirth +
//            ", race='" + race + '\'' +
//            ", gender='" + gender + '\'' +
//            ", educationLevel='" + educationLevel + '\'' +
//            ", maritalStatus='" + maritalStatus + '\'' +
//            ", noOfDependants=" + noOfDependants +
//            ", employmentType='" + employmentType + '\'' +
//            ", email='" + email + '\'' +
//            ", countryOfPermanentResident='" + countryOfPermanentResident + '\'' +
//            ", employerName='" + employerName + '\'' +
//            ", occupation='" + occupation + '\'' +
//            ", employmentSector='" + employmentSector + '\'' +
//            ", subEmploymentSector='" + subEmploymentSector + '\'' +
//            ", dateJoined=" + dateJoined +
//            ", monthlyGrossIncome=" + monthlyGrossIncome +
//            ", monthlyNetIncome=" + monthlyNetIncome +
//            '}';
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFCustomerInformation {\n");

    sb.append("    cutomerName: ").append(toIndentedString(cutomerName)).append("\n");
    sb.append("    residenceType: ").append(toIndentedString(residenceType)).append("\n");
    sb.append("    sourceOfWealth: ").append((sourceOfWealth)).append("\n");
    sb.append("    computationMode: ").append(toIndentedString(computationMode)).append("\n");
    sb.append("    internationalPhoneNoAreaCode: ").append(toIndentedString(internationalPhoneNoAreaCode)).append("\n");
    sb.append("    mobilePhoneNoAreaCode: ").append(toIndentedString(mobilePhoneNoAreaCode)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    educationLevel: ").append(toIndentedString(educationLevel)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
    sb.append("    noOfDependants: ").append(toIndentedString(noOfDependants)).append("\n");
    sb.append("    employmentType: ").append(toIndentedString(employmentType)).append("\n");
    sb.append("    employerName: ").append(toIndentedString(employerName)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    employmentSector: ").append(toIndentedString(employmentSector)).append("\n");
    sb.append("    subEmploymentSector: ").append(toIndentedString(subEmploymentSector)).append("\n");
    sb.append("    dateJoined: ").append((dateJoined)).append("\n");
    sb.append("    internationalPhoneNo: ").append(toIndentedString(internationalPhoneNo)).append("\n");
    sb.append("    internationalExtensionPhoneNo: ").append(toIndentedString(internationalExtensionPhoneNo)).append("\n");
    sb.append("    monthlyGrossIncome: ").append(toIndentedString(monthlyGrossIncome)).append("\n");
    sb.append("    monthlyNetIncome: ").append(toIndentedString(monthlyNetIncome)).append("\n");
    sb.append("    mobilePhoneNo: ").append(toIndentedString(mobilePhoneNo)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    residenceType: ").append(toIndentedString(residenceType)).append("\n");
    sb.append("    idNo: ").append(toIndentedString(idNo)).append("\n");
    sb.append("    foreignPR: ").append(toIndentedString(foreignPR)).append("\n");
    sb.append("    prIdNumber: ").append(toIndentedString(prIdNumber)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    race: ").append(toIndentedString(race)).append("\n");
    sb.append("    countryOfPermanentResident: ").append(toIndentedString(countryOfPermanentResident)).append("\n");
   sb.append("    sourceOfWealth: ").append(toIndentedString(sourceOfWealth)).append("\n");
    sb.append("    addressInformation: ").append(toIndentedString(addressInformation)).append("\n");
    sb.append("    idType: ").append(toIndentedString(idType)).append("\n");
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
