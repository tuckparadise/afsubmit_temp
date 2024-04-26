package com.rhb.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * AF Address Information
 */
@Schema(description = "AF Address Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")


public class AFAddressInformation   {
  @JsonProperty("addressType")
  private String addressType = null;

  @JsonProperty("addressLine1")
  private String addressLine1 = null;

  @JsonProperty("addressLine2")
  private String addressLine2 = null;

  @JsonProperty("addressLine3")
  private String addressLine3 = null;

  @JsonProperty("postcode")
  private String postcode = null;

  @JsonProperty("city")
  private String city = null;

  public AFAddressInformation addressType(String addressType) {
    this.addressType = addressType;
    return this;
  }

  /**
   *  Address Type
   * @return addressType
   **/
  @Schema(required = true, description = " Address Type")
      @NotNull

    public String getAddressType() {
    return addressType;
  }

  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  public AFAddressInformation addressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  /**
   * Address Line 1 
   * @return addressLine1
   **/
  @Schema(required = true, description = "Address Line 1 ")
      @NotNull

    public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public AFAddressInformation addressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  /**
   * Address Line 2 
   * @return addressLine2
   **/
  @Schema(description = "Address Line 2 ")
  
    public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public AFAddressInformation addressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
    return this;
  }

  /**
   * Address Line 3
   * @return addressLine3
   **/
  @Schema(description = "Address Line 3")
  
    public String getAddressLine3() {
    return addressLine3;
  }

  public void setAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
  }

  public AFAddressInformation postcode(String postcode) {
    this.postcode = postcode;
    return this;
  }

  /**
   *  Postcode 
   * @return postcode
   **/
  @Schema(required = true, description = " Postcode ")
      @NotNull

    public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public AFAddressInformation city(String city) {
    this.city = city;
    return this;
  }

  /**
   * City
   * @return city
   **/
  @Schema(required = true, description = "City")
      @NotNull

    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AFAddressInformation afAddressInformation = (AFAddressInformation) o;
    return Objects.equals(this.addressType, afAddressInformation.addressType) &&
        Objects.equals(this.addressLine1, afAddressInformation.addressLine1) &&
        Objects.equals(this.addressLine2, afAddressInformation.addressLine2) &&
        Objects.equals(this.addressLine3, afAddressInformation.addressLine3) &&
        Objects.equals(this.postcode, afAddressInformation.postcode) &&
        Objects.equals(this.city, afAddressInformation.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressType, addressLine1, addressLine2, addressLine3, postcode, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AFAddressInformation {\n");
    
    sb.append("    addressType: ").append(toIndentedString(addressType)).append("\n");
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    addressLine3: ").append(toIndentedString(addressLine3)).append("\n");
    sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
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
