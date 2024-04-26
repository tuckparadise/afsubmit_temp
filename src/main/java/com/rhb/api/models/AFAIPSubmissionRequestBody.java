package com.rhb.api.models;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AF AIP Submission Request Body
 */
@Schema(description = "AF AIP Submission Request Body")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFAIPSubmissionRequestBody   {

  @JsonProperty("entity")
  private String entity = null;

  @JsonProperty("preferredBranch")
  private String preferredBranch = null;

  @JsonProperty("dealerName")
  private String dealerName = null;

  /**
   *  Entity
   * @return entity
   **/
  @Schema(required = true, description = " Entity ")
  @NotNull

  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }

  /**
   *  Preferred branch
   * @return preferredBranch
   **/
  @Schema(description = " Preferred branch")

  public String getPreferredBranch() {
    return preferredBranch;
  }

  public void setPreferredBranch(String preferredBranch) {
    this.preferredBranch = preferredBranch;
  }

  /**
   *  Dealer Name
   * @return dealerName
   **/
  @Schema(required = true, description = " Dealer Name ")
  @NotNull

  public String getDealerName() {
    return dealerName;
  }

  public void setDealerName(String dealerName) {
    this.dealerName = dealerName;
  }

  @JsonProperty("customerList")
  private List<AFCustomerInformation> customerInformation = null;

  @JsonProperty("collateral")
  private List<AFCollateralInformation> collateralInformation = null;

  @JsonProperty("facility")
  private List<AFFacilityInformation> facilityInformation = null;

  public AFAIPSubmissionRequestBody customerInformation(List<AFCustomerInformation> customerInformation) {
    this.customerInformation = customerInformation;
    return this;
  }

  /**
   * Get customerInformation
   * @return customerInformation
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public List<AFCustomerInformation> getCustomerInformation() {
    return customerInformation;
  }


  public void setCustomerInformation(List<AFCustomerInformation> customerInformation) {
    this.customerInformation = customerInformation;
  }
  /**
   * Get collateralInformation
   * @return collateralInformation
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public List<AFCollateralInformation> getCollateralInformation() {
    return collateralInformation;
  }

  public void setCollateralInformation(List<AFCollateralInformation> collateralInformation) {
    this.collateralInformation = collateralInformation;
  }

  public AFAIPSubmissionRequestBody facilityInformation(List<AFFacilityInformation> facilityInformation) {
    this.facilityInformation = facilityInformation;
    return this;
  }

  /**
   * Get facilityInformation
   * @return facilityInformation
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public List<AFFacilityInformation> getFacilityInformation() {
    return facilityInformation;
  }

  public void setFacilityInformation(List<AFFacilityInformation> facilityInformation) {
    this.facilityInformation = facilityInformation;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFAIPSubmissionRequestBody {\n");
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    sb.append("    preferredBranch: ").append(toIndentedString(preferredBranch)).append("\n");
    sb.append("    dealerName: ").append(toIndentedString(dealerName)).append("\n");
    sb.append("    customerInformation: ").append(customerInformation).append("\n");
    sb.append("    facilityInformation: ").append(facilityInformation).append("\n");
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
