package com.rhb.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Schema(description = "Address info")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-14T07:32:26.944084Z[GMT]")


@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
public class EAIAddress {
    @XmlElement(name = "AddressType")
    private String addressType = null;

    @XmlElement(name = "AddressLine1")
    private String addressLine1 = null;

    @XmlElement(name = "AddressLine2")
    private String addressLine2 = null;

    @XmlElement(name = "AddressLine3")
    private String addressLine3 = null;

    @XmlElement(name = "Postcode")
    private String postcode = null;

    @XmlElement(name = "City")
    private String city = null;

    @XmlElement(name = "State")
    private String state = null;

    @XmlElement(name = "Country")
    private String country = null;


    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
