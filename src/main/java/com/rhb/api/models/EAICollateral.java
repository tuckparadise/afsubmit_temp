package com.rhb.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Schema(description = "Collateral Info")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-14T07:32:26.944084Z[GMT]")

@XmlRootElement(name = "Collateral")
@XmlAccessorType(XmlAccessType.FIELD)
public class EAICollateral {
    @XmlElement(name ="VehicleMarketValue")
    private String vehicleMarketValue = null;

    @XmlElement(name ="CollateralType")
    private String collateralType = null;

    public String getVehicleMarketValue() {
        return vehicleMarketValue;
    }

    public void setVehicleMarketValue(String vehicleMarketValue) {
        this.vehicleMarketValue = vehicleMarketValue;
    }

    public String getCollateralType() {
        return collateralType;
    }

    public void setCollateralType(String collateralType) {
        this.collateralType = collateralType;
    }

    public String getpNBMemberNo() {
        return pNBMemberNo;
    }

    public void setpNBMemberNo(String pNBMemberNo) {
        this.pNBMemberNo = pNBMemberNo;
    }

    public String getUnitTrustType() {
        return unitTrustType;
    }

    public void setUnitTrustType(String unitTrustType) {
        this.unitTrustType = unitTrustType;
    }

    public String getMakeofVehicle() {
        return makeofVehicle;
    }

    public void setMakeofVehicle(String makeofVehicle) {
        this.makeofVehicle = makeofVehicle;
    }

    public String getPurchasePriceOTR() {
        return purchasePriceOTR;
    }

    public void setPurchasePriceOTR(String purchasePriceOTR) {
        this.purchasePriceOTR = purchasePriceOTR;
    }

    public String getPropertyPostcode() {
        return propertyPostcode;
    }

    public void setPropertyPostcode(String propertyPostcode) {
        this.propertyPostcode = propertyPostcode;
    }

    public String getModelofVehicle() {
        return modelofVehicle;
    }

    public void setModelofVehicle(String modelofVehicle) {
        this.modelofVehicle = modelofVehicle;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCollateralValue() {
        return collateralValue;
    }

    public void setCollateralValue(String collateralValue) {
        this.collateralValue = collateralValue;
    }

    public String getCertificateAmount() {
        return certificateAmount;
    }

    public void setCertificateAmount(String certificateAmount) {
        this.certificateAmount = certificateAmount;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getVehicleUsage() {
        return vehicleUsage;
    }

    public void setVehicleUsage(String vehicleUsage) {
        this.vehicleUsage = vehicleUsage;
    }

    public Integer getSecuredMOA() {
        return securedMOA;
    }

    public void setSecuredMOA(Integer securedMOA) {
        this.securedMOA = securedMOA;
    }

    public String getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(String vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public String getPropertyState() {
        return propertyState;
    }

    public void setPropertyState(String propertyState) {
        this.propertyState = propertyState;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getNumberofUnitsPledged() {
        return numberofUnitsPledged;
    }

    public void setNumberofUnitsPledged(Integer numberofUnitsPledged) {
        this.numberofUnitsPledged = numberofUnitsPledged;
    }

    public Integer getpNBUnitTrust() {
        return pNBUnitTrust;
    }

    public void setpNBUnitTrust(Integer pNBUnitTrust) {
        this.pNBUnitTrust = pNBUnitTrust;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getbDMmorethan25kg() {
        return bDMmorethan25kg;
    }

    public void setbDMmorethan25kg(String bDMmorethan25kg) {
        this.bDMmorethan25kg = bDMmorethan25kg;
    }

    public Integer getYearMake() {
        return yearMake;
    }

    public void setYearMake(Integer yearMake) {
        this.yearMake = yearMake;
    }

    public String getThirdPartyFlag() {
        return thirdPartyFlag;
    }

    public void setThirdPartyFlag(String thirdPartyFlag) {
        this.thirdPartyFlag = thirdPartyFlag;
    }

    @XmlElement(name ="PNBMemberNo.")
    private String pNBMemberNo = null;

    @XmlElement(name ="UnitTrustType")
    private String unitTrustType = null;

    @XmlElement(name ="MakeofVehicle")
    private String makeofVehicle = null;

    @XmlElement(name ="PurchasePriceOTR")
    private String purchasePriceOTR = null;

    @XmlElement(name ="PropertyPostcode")
    private String propertyPostcode = null;

    @XmlElement(name ="ModelofVehicle")
    private String modelofVehicle = null;

    @XmlElement(name ="PropertyType")
    private String propertyType = null;

    @XmlElement(name ="RegistrationDate")
    private String registrationDate = null;

    @XmlElement(name ="CollateralValue")
    private String collateralValue = null;

    @XmlElement(name ="CertificateAmount")
    private String certificateAmount = null;

    @XmlElement(name ="VehicleType")
    private String vehicleType = null;

    @XmlElement(name ="EngineNo")
    private String engineNo = null;

    @XmlElement(name ="VehicleUsage")
    private String vehicleUsage = null;

    @XmlElement(name ="SecuredMOA")
    private Integer securedMOA = null;

    @XmlElement(name ="VehicleCondition")
    private String vehicleCondition = null;

    @XmlElement(name ="PropertyState")
    private String propertyState = null;

    @XmlElement(name ="MarketValue")
    private String marketValue = null;

    @XmlElement(name ="SecurityCode")
    private String securityCode = null;

    @XmlElement(name ="NumberofUnitsPledged")
    private Integer numberofUnitsPledged = null;

    @XmlElement(name ="PNBUnitTrust")
    private Integer pNBUnitTrust = null;

    @XmlElement(name ="RegistrationNo")
    private String registrationNo = null;

    @XmlElement(name ="ChassisNo")
    private String chassisNo = null;

    @XmlElement(name ="BDMmorethan2500kg")
    private String bDMmorethan25kg = null;

    @XmlElement(name ="YearMake")
    private Integer yearMake = null;

    @XmlElement(name = "ThirdPartyFlag")
    private String thirdPartyFlag = null;

}
