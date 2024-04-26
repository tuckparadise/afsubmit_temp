package com.rhb.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response Body
 */
@Schema(description = "Response Body")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class PFSubmitResponseBody   {
  @JsonProperty("processID")
  private String processID = null;

  @JsonProperty("processDate")
  private Date processDate = null;

  @JsonProperty("customerIDNo")
  private String customerIDNo = null;

  @JsonProperty("customerName")
  private String customerName = null;

  public PFSubmitResponseBody processID(String processID) {
    this.processID = processID;
    return this;
  }

  /**
   * Process ID
   * @return processID
   **/
  @Schema(required = true, description = "Process ID")
      @NotNull

    public String getProcessID() {
    return processID;
  }

  public void setProcessID(String processID) {
    this.processID = processID;
  }

  public PFSubmitResponseBody processDate(Date processDate) {
    this.processDate = processDate;
    return this;
  }

  /**
   * Process Date
   * @return processDate
   **/
  @Schema(required = true, description = "Process Date")
      @NotNull

    @Valid
    public Date getProcessDate() {
    return processDate;
  }

  public void setProcessDate(Date processDate) {
    this.processDate = processDate;
  }

  public PFSubmitResponseBody customerIDNo(String customerIDNo) {
    this.customerIDNo = customerIDNo;
    return this;
  }

  /**
   * Customer ID No
   * @return customerIDNo
   **/
  @Schema(required = true, description = "Customer ID No")
      @NotNull

    public String getCustomerIDNo() {
    return customerIDNo;
  }

  public void setCustomerIDNo(String customerIDNo) {
    this.customerIDNo = customerIDNo;
  }

  public PFSubmitResponseBody customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * Customer ID No
   * @return customerName
   **/
  @Schema(required = true, description = "Customer ID No")
      @NotNull

    public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PFSubmitResponseBody pfSubmitResponseBody = (PFSubmitResponseBody) o;
    return Objects.equals(this.processID, pfSubmitResponseBody.processID) &&
        Objects.equals(this.processDate, pfSubmitResponseBody.processDate) &&
        Objects.equals(this.customerIDNo, pfSubmitResponseBody.customerIDNo) &&
        Objects.equals(this.customerName, pfSubmitResponseBody.customerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processID, processDate, customerIDNo, customerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PFSubmitResponseBody {\n");
    
    sb.append("    processID: ").append(toIndentedString(processID)).append("\n");
    sb.append("    processDate: ").append(toIndentedString(processDate)).append("\n");
    sb.append("    customerIDNo: ").append(toIndentedString(customerIDNo)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
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
