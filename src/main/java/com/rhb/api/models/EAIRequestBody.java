package com.rhb.api.models;


import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.validation.annotation.Validated;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-14T07:32:26.944084Z[GMT]")

@Schema(description = "FLASH Mapping Field <Request>")
@Validated
@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class EAIRequestBody {

    @XmlElement(name = "SourceSystem")
    private String sourceSystem = null;

    @XmlElement(name = "PartnerEmail")
    private String partnerEmail = null;

    @XmlElement(name = "Username")
    private String username = null;

    @XmlElement(name = "ProcessID")
    private String processId = null;

    @Schema(required = true, description = "")
    @NotNull
    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    @Schema(required = true, description = "")
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Schema(required = true, description = "")
    @NotNull
    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Schema(required = true, description = "")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Schema(required = true, description = "")
    @NotNull
    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    @XmlElement(name = "Password")
    private String password = null;

    @XmlElement(name = "FinancingApplicationType")
    private String financingApplicationType = null;

    @XmlElement(name = "DateApplied")
    private String dateApplied = null;

    @XmlElement(name = "Entity")
    private String entity = null;

    public String getFinancingApplicationType() {
        return financingApplicationType;
    }

    public void setFinancingApplicationType(String financingApplicationType) {
        this.financingApplicationType = financingApplicationType;
    }

    public String getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getPreferredBranch() {
        return preferredBranch;
    }

    public void setPreferredBranch(String preferredBranch) {
        this.preferredBranch = preferredBranch;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getPceQualifiedStaff() {
        return pceQualifiedStaff;
    }

    public void setPceQualifiedStaff(String pceQualifiedStaff) {
        this.pceQualifiedStaff = pceQualifiedStaff;
    }

    public String getStaffApplication() {
        return staffApplication;
    }

    public void setStaffApplication(String staffApplication) {
        this.staffApplication = staffApplication;
    }

    public String getPartnerEmail() {
        return partnerEmail;
    }

    public void setPartnerEmail(String partnerEmail) {
        this.partnerEmail = partnerEmail;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    @XmlElement(name = "PreferredBranch")
    private String preferredBranch = null;

    @XmlElement(name = "Originator")
    private String originator = null;

    @XmlElement(name = "PceQualifiedStaff")
    private String pceQualifiedStaff = null;

    @XmlElement(name = "StaffApplication")
    private String staffApplication = null;

    @XmlElement(name = "DealerName")
    private String dealerName = null;

    @XmlElement(name = "ProcessDate")
    private String processDate = null;

    @XmlElementWrapper(name = "CustomerList")
    @XmlElement(name = "Customer")
    private List<EAICustomer> customerInformation = null;

    @XmlElementWrapper(name = "CollateralList")
    @XmlElement(name = "Collateral")
    private List<EAICollateral> collateralInformation = null;

    @XmlElementWrapper(name = "FacilityList")
    @XmlElement(name = "Facility")
    private List<EAIFacility> facilityInformation = null;

    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public List<EAICustomer> getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(List<EAICustomer> customerInformation) {
        this.customerInformation = customerInformation;
    }

    public List<EAICollateral> getCollateralInformation() {
        return collateralInformation;
    }

    public void setCollateralInformation(List<EAICollateral> collateralInformation) {
        this.collateralInformation = collateralInformation;
    }

    /**
     * Get facilityInformation
     * @return facilityInformation
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public List<EAIFacility> getFacilityInformation() {
        return facilityInformation;
    }

    public void setFacilityInformation(List<EAIFacility> facilityInformation) {
        this.facilityInformation = facilityInformation;
    }
}
