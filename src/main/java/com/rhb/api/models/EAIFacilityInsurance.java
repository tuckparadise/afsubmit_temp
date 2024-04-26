package com.rhb.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Schema(description = "Facility Insurance Info")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-14T07:32:26.944084Z[GMT]")

@XmlAccessorType(XmlAccessType.FIELD)
public class EAIFacilityInsurance {


    @XmlElement(name ="PremiumFinanced")
    private Double premiumFinanced = null;
    public Double getPremiumFinanced() {
        return premiumFinanced;
    }

    public void setPremiumFinanced(Double premiumFinanced) {
        this.premiumFinanced = premiumFinanced;
    }


    public String getInsuranceTakafulOperator() {
        return insuranceTakafulOperator;
    }

    public void setInsuranceTakafulOperator(String insuranceTakafulOperator) {
        this.insuranceTakafulOperator = insuranceTakafulOperator;
    }

    public String getInsuranceTakafulType() {
        return insuranceTakafulType;
    }

    public void setInsuranceTakafulType(String insuranceTakafulType) {
        this.insuranceTakafulType = insuranceTakafulType;
    }

    public String getFinancingType() {
        return financingType;
    }

    public void setFinancingType(String financingType) {
        this.financingType = financingType;
    }

    public String getCoveredName() {
        return coveredName;
    }

    public void setCoveredName(String coveredName) {
        this.coveredName = coveredName;
    }

    public String getPrimaryIDNo() {
        return primaryIDNo;
    }

    public void setPrimaryIDNo(String primaryIDNo) {
        this.primaryIDNo = primaryIDNo;
    }

    public String getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(String calculationDate) {
        this.calculationDate = calculationDate;
    }

    public Integer getOriginalFinancingAmount() {
        return originalFinancingAmount;
    }

    public void setOriginalFinancingAmount(Integer originalFinancingAmount) {
        this.originalFinancingAmount = originalFinancingAmount;
    }

    public Integer getPercentageCoverage() {
        return percentageCoverage;
    }

    public void setPercentageCoverage(Integer percentageCoverage) {
        this.percentageCoverage = percentageCoverage;
    }

    public Integer getPeriodofCoverYears() {
        return periodofCoverYears;
    }

    public void setPeriodofCoverYears(Integer periodofCoverYears) {
        this.periodofCoverYears = periodofCoverYears;
    }

    @XmlElement(name ="InsuranceTakafulOperator")
    private String insuranceTakafulOperator = null;

    @XmlElement(name ="InsuranceTakafulType")
    private String insuranceTakafulType = null;

    @XmlElement(name ="FinancingType")
    private String financingType = null;

    @XmlElement(name ="CoveredName")
    private String coveredName = null;

    @XmlElement(name ="PrimaryIDNo")
    private String primaryIDNo = null;

    @XmlElement(name ="CalculationDate")
    private String calculationDate = null;

    @XmlElement(name = "OriginalFinancingAmount")
    private Integer originalFinancingAmount = null;

    @XmlElement(name = "PercentageCoverage")
    private Integer percentageCoverage = null;

    @XmlElement(name = "PeriodofCoverYears")
    private Integer periodofCoverYears = null;

}
