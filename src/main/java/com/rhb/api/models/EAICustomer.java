package com.rhb.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Schema(description = "Customer Info")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-14T07:32:26.944084Z[GMT]")

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class EAICustomer {
    @XmlElement(name = "CustomerName")
    private String customerName = null;

    @XmlElement(name = "DrivingLicense")
    private String drivingLicense;

    @XmlElement(name = "SourceOfWealth")
    private String sourceOfWealth;

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getComputationMode() {
        return computationMode;
    }

    public void setComputationMode(String computationMode) {
        this.computationMode = computationMode;
    }

    @XmlElement(name = "ComputationModeCoreInc")
    private String computationMode;
    @XmlElement(name = "IdNo")
    private String idNo = null;

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }


    @XmlElement(name = "StaffCode")
    private String staffCode = null;

    public String getSourceOfWealth() {
        return sourceOfWealth;
    }

    public void setSourceOfWealth(String sourceOfWealth) {
        this.sourceOfWealth = sourceOfWealth;
    }

    public String getEmploymentSector() {
        return employmentSector;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getNoOfDependants() {
        return noOfDependants;
    }

    public void setNoOfDependants(Integer noOfDependants) {
        this.noOfDependants = noOfDependants;
    }

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



    public void setEmploymentSector(String employmentSector) {
        this.employmentSector = employmentSector;
    }

    public String getSubEmploymentSector() {
        return subEmploymentSector;
    }

    public void setSubEmploymentSector(String subEmploymentSector) {
        this.subEmploymentSector = subEmploymentSector;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getLengthOfServiceYear() {
        return lengthOfServiceYear;
    }

    public void setLengthOfServiceYear(String lengthOfServiceYear) {
        this.lengthOfServiceYear = lengthOfServiceYear;
    }

    public String getLengthOfServiceMonth() {
        return lengthOfServiceMonth;
    }

    public void setLengthOfServiceMonth(String lengthOfServiceMonth) {
        this.lengthOfServiceMonth = lengthOfServiceMonth;
    }

    public String getMonthlyGrossIncome() {
        return monthlyGrossIncome;
    }

    public void setMonthlyGrossIncome(String monthlyGrossIncome) {
        this.monthlyGrossIncome = monthlyGrossIncome;
    }

    public String getMonthlyNetIncome() {
        return monthlyNetIncome;
    }

    public void setMonthlyNetIncome(String monthlyNetIncome) {
        this.monthlyNetIncome = monthlyNetIncome;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }


    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public List<EAIAddress> getAddress() {
        return address;
    }

    public void setAddress(List<EAIAddress> address) {
        this.address = address;
    }

    public String getCisNo() {
        return cisNo;
    }

    public void setCisNo(String cisNo) {
        this.cisNo = cisNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getRelationshipToPrincipal() {
        return relationshipToPrincipal;
    }

    public void setRelationshipToPrincipal(String relationshipToPrincipal) {
        this.relationshipToPrincipal = relationshipToPrincipal;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getAlternateIdType() {
        return alternateIdType;
    }

    public void setAlternateIdType(String alternateIdType) {
        this.alternateIdType = alternateIdType;
    }

    public String getAlternateIdNo() {
        return alternateIdNo;
    }

    public void setAlternateIdNo(String alternateIdNo) {
        this.alternateIdNo = alternateIdNo;
    }

    public String getForeignPR() {
        return foreignPR;
    }

    public void setForeignPR(String foreignPR) {
        this.foreignPR = foreignPR;
    }

    public String getpRIDNo() {
        return pRIDNo;
    }

    public void setpRIDNo(String pRIDNo) {
        this.pRIDNo = pRIDNo;
    }


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

    public String getCountryOfPermanentResident() {
        return countryOfPermanentResident;
    }

    public void setCountryOfPermanentResident(String countryOfPermanentResident) {
        this.countryOfPermanentResident = countryOfPermanentResident;
    }


    public String getJointDSR() {
        return jointDSR;
    }

    public void setJointDSR(String jointDSR) {
        this.jointDSR = jointDSR;
    }

    @XmlElement(name = "DateOfBirth")
    private String dateOfBirth = null;

    @XmlElement(name = "Age")
    private Integer age = null;

    @XmlElement(name = "Nationality")
    private String nationality = null;

    @XmlElement(name = "Race")
    private String race = null;

    @XmlElement(name = "Gender")
    private String gender = null;

    @XmlElement(name = "EducationLevel")
    private String educationLevel = null;

    @XmlElement(name = "MaritalStatus")
    private String maritalStatus = null;

    @XmlElement(name = "NoOfDependants")
    private Integer noOfDependants = null;

    @XmlElement(name = "EmploymentType")
    private String employmentType = null;

    @XmlElement(name = "EmployerName")
    private String employerName = null;

    @XmlElement(name = "Occupation")
    private String occupation = null;

    @XmlElement(name = "EmploymentSector")
    private String employmentSector = null;

    @XmlElement(name = "SubEmploymentSector")
    private String subEmploymentSector = null;

    @XmlElement(name = "DateJoined")
    private String dateJoined = null;

    @XmlElement(name = "LengthOfServiceYear")
    private String lengthOfServiceYear = null;

    @XmlElement(name = "LengthOfServiceMonth")
    private String lengthOfServiceMonth = null;

    @XmlElement(name = "MonthlyGrossIncome")
    private String monthlyGrossIncome = null;

    @XmlElement(name = "MonthlyNetIncome")
    private String monthlyNetIncome = null;

    @XmlElement(name = "MobilePhoneNoAreaCode")
    private String mobilePhoneNoAreaCode = null;

    @XmlElement(name = "MobilePhoneNo")
    private String mobilePhoneNo = null;

    @XmlElement(name = "Email")
    private String email = null;

    @XmlElement(name = "ResidenceType")
    private String residenceType = null;


    @XmlElement(name = "EmploymentStatus")
    private String employmentStatus = null;


    @XmlElementWrapper(name = "AddressList")
    @XmlElement(name = "Address")
    private List<EAIAddress> address = null;

    @XmlElement(name = "CisNo")
    private String cisNo = null;

    @XmlElement(name = "CustomerType")
    private String customerType = "I";

    @XmlElement(name = "ApplicantType")
    private String applicantType = "P";

    @XmlElement(name = "RelationshipToPrincipal")
    private String relationshipToPrincipal = null;

    @XmlElement(name = "IdType")
    private String idType = null;

    @XmlElement(name = "AlternateIdType")
    private String alternateIdType = null;

    @XmlElement(name = "AlternateIdNo")
    private String alternateIdNo = null;

    @XmlElement(name = "ForeignPR")
    private String foreignPR = null;

    @XmlElement(name = "PRIDNo")
    private String pRIDNo = null;

    @XmlElement(name = "InternationalPhoneNoAreaCode")
    private String internationalPhoneNoAreaCode = null;

    @XmlElement(name = "InternationalPhoneNo")
    private String internationalPhoneNo = null;

    @XmlElement(name = "InternationalExtensionPhoneNo")
    private String internationalExtensionPhoneNo = null;

    @XmlElement(name = "CountryOfPermanentResident")
    private String countryOfPermanentResident = null;

    @XmlElement(name = "JointDSR")
    private String jointDSR = null;

}
