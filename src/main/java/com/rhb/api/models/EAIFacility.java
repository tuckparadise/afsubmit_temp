package com.rhb.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Schema(description = "Facility Info")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-14T07:32:26.944084Z[GMT]")

@XmlRootElement(name = "Facility")
@XmlAccessorType(XmlAccessType.FIELD)
public class EAIFacility {
    @XmlElement(name = "Product")
    private String product = "AFI02";

    @XmlElement(name = "FacilityType")
    private String facilityType = "HPFAC04";

    @XmlElement(name = "FacilityPackage")
    private String faciltyPackage;

    @XmlElement(name = "FEC")
    private String fec;

    @XmlElement(name = "FECAmount")
    private String fecAmount;


    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getFecAmount() {
        return fecAmount;
    }

    public void setFecAmount(String fecAmount) {
        this.fecAmount = fecAmount;
    }

    public String getFinancedFeeAmount() {
        return financedFeeAmount;
    }

    public void setFinancedFeeAmount(String financedFeeAmount) {
        this.financedFeeAmount = financedFeeAmount;
    }

    @XmlElement(name = "FinancedFeeAmount")
    private String financedFeeAmount;

    @XmlElement(name = "FacilityPurpose")
    private String facilityPurpose = null;

    @XmlElement(name = "FinancingAmount")
    private BigDecimal financingAmount = null;

    @XmlElement(name = "InsuranceRequired")
    private String insuranceRequired = null;

    @XmlElement(name = "InsuranceFinancedAmount")
    private String insuranceFinancedAmount = null;

    @XmlElement(name = "Subsidy")
    private String subsidy = null;

    @XmlElement(name = "Downpayment")
    private String cashDownpayment = null;

    @XmlElement(name = "HandlingFee")
    private String handlingFee ;

    @XmlElement(name = "ExtendedWarrantyPeriod")
    private String extendedWarrantyPeriod = null;

    @XmlElement(name = "PromotionFee")
    private String promotionFees;

    @XmlElement(name = "FacilityTenureYears")
    private Integer facilityTenure = null;

    @XmlElement(name = "SourceOfFund")
    private String sourceOfFund = null;

    @XmlElement(name = "PurposeOfAcctOpen")
    private String purposeOfAccountOpening = null;

    @XmlElementWrapper(name = "FacilityInsuranceList")
    @XmlElement(name = "FacilityInsurance")
    private List<EAIFacilityInsurance> facilityInsuranceList = null;

    public List<EAIFacilityInsurance> getFacilityInsuranceList() {
        return facilityInsuranceList;
    }

    public void setFacilityInsuranceList(List<EAIFacilityInsurance> facilityInsuranceList) {
        this.facilityInsuranceList = facilityInsuranceList;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityPackage() {
        return faciltyPackage;
    }

    public void setFacilityPackage(String facilityPackage) {
        this.faciltyPackage = facilityPackage;
    }

    public String getFacilityPurpose() {
        return facilityPurpose;
    }

    public void setFacilityPurpose(String facilityPurpose) {
        this.facilityPurpose = facilityPurpose;
    }

    public BigDecimal getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(BigDecimal financingAmount) {
        this.financingAmount = financingAmount;
    }

    public String getInsuranceRequired() {
        return insuranceRequired;
    }

    public void setInsuranceRequired(String insuranceRequired) {
        this.insuranceRequired = insuranceRequired;
    }

    public String getInsuranceFinancedAmount() {
        return insuranceFinancedAmount;
    }

    public void setInsuranceFinancedAmount(String insuranceFinancedAmount) {
        this.insuranceFinancedAmount = insuranceFinancedAmount;
    }

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy;
    }

    public String getCashDownpayment() {
        return cashDownpayment;
    }

    public void setCashDownpayment(String cashDownpayment) {
        this.cashDownpayment = cashDownpayment;
    }

    public String getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(String handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getExtendedWarrantyPeriod() {
        return extendedWarrantyPeriod;
    }

    public void setExtendedWarrantyPeriod(String extendedWarrantyPeriod) {
        this.extendedWarrantyPeriod = extendedWarrantyPeriod;
    }

    public String getPromotionFees() {
        return promotionFees;
    }

    public void setPromotionFees(String promotionFees) {
        this.promotionFees = promotionFees;
    }

    public Integer getFacilityTenure() {
        return facilityTenure;
    }

    public void setFacilityTenure(Integer facilityTenure) {
        this.facilityTenure = facilityTenure;
    }

    public String getSourceOfFund() {
        return sourceOfFund;
    }

    public void setSourceOfFund(String sourceOfFund) {
        this.sourceOfFund = sourceOfFund;
    }

    public String getPurposeOfAccountOpening() {
        return purposeOfAccountOpening;
    }

    public void setPurposeOfAccountOpening(String purposeOfAccountOpening) {
        this.purposeOfAccountOpening = purposeOfAccountOpening;
    }
}
