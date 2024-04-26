package com.rhb.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * Description of AFStatusReqHeader
 */
@Schema(description = "Description of AFStatusReqHeader")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T05:42:18.865906Z[GMT]")


public class AFSubmitReqHeader {
    @JsonProperty("sourceID")
    private String sourceID = "API";

    @JsonProperty("destQueueManager")
    private String destQueueManager = null;

    @JsonProperty("loginID")
    private Integer loginID = null;

    @JsonProperty("recordLength")
    private Integer recordLength = null;

    @JsonProperty("errorMessage")
    private String errorMessage = null;

    @JsonProperty("errorCode")
    private Integer errorCode = null;

    @JsonProperty("terminalID")
    private String terminalID = null;

    @JsonProperty("trxnDate")
    private String trxnDate = null;

    @JsonProperty("trxnTime")
    private String trxnTime = null;

    @JsonProperty("replyRefNo")
    private String replyRefNo = null;

    @JsonProperty("dplName")
    private String dplName = null;

    @JsonProperty("extTrxnCd")
    private String extTrxnCd = "REAIDCI1";

    @JsonProperty("destQueue")
    private String destQueue = null;

    @JsonProperty("msgRefNo")
    private String msgRefNo = null;

    @JsonProperty("systemStatus")
    private String systemStatus = null;

    @JsonProperty("msgverNo")
    private Double msgverNo = 1.0d;

    @JsonProperty("filler")
    private String filler = null;

    @JsonProperty("noOfRecords")
    private Integer noOfRecords = null;

    @JsonProperty("pan")
    private String pan = null;

    @JsonProperty("overrideTellerId")
    private Integer overrideTellerId = null;

    public AFSubmitReqHeader sourceID(String sourceID) {
        this.sourceID = sourceID;
        return this;
    }

    /**
     * Source ID
     * @return sourceID
     **/
    @Schema(required = true, description = "Source ID")
    @NotNull

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public AFSubmitReqHeader destQueueManager(String destQueueManager) {
        this.destQueueManager = destQueueManager;
        return this;
    }

    /**
     * Destination Queue Manager
     * @return destQueueManager
     **/
    @Schema(description = "Destination Queue Manager")

    public String getDestQueueManager() {
        return destQueueManager;
    }

    public void setDestQueueManager(String destQueueManager) {
        this.destQueueManager = destQueueManager;
    }

    public AFSubmitReqHeader loginID(Integer loginID) {
        this.loginID = loginID;
        return this;
    }

    /**
     * Login ID
     * @return loginID
     **/
    @Schema(description = "Login ID")

    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
    }

    public AFSubmitReqHeader recordLength(Integer recordLength) {
        this.recordLength = recordLength;
        return this;
    }

    /**
     * Record Length
     * @return recordLength
     **/
    @Schema(description = "Record Length")

    public Integer getRecordLength() {
        return recordLength;
    }

    public void setRecordLength(Integer recordLength) {
        this.recordLength = recordLength;
    }

    public AFSubmitReqHeader errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * Error Message
     * @return errorMessage
     **/
    @Schema(description = "Error Message")

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public AFSubmitReqHeader errorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Error Code
     * @return errorCode
     **/
    @Schema(description = "Error Code")

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public AFSubmitReqHeader terminalID(String terminalID) {
        this.terminalID = terminalID;
        return this;
    }

    /**
     * Terminal ID
     * @return terminalID
     **/
    @Schema(description = "Terminal ID")

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public AFSubmitReqHeader trxnDate(String trxnDate) {
        this.trxnDate = trxnDate;
        return this;
    }

    /**
     * Transaction Date
     * @return transactionDate
     **/
    @Schema(required = true, description = "Transaction Date ")
    @NotNull

    public String getTrxnDate() {
        return trxnDate;
    }

    public void setTrxnDate(String trxnDate) {
        this.trxnDate = trxnDate;
    }

    public AFSubmitReqHeader trxnTime(String trxnTime) {
        this.trxnTime = trxnTime;
        return this;
    }

    /**
     * Transaction Time
     * @return transactionTime
     **/
    @Schema(required = true, description = "Transaction Time ")
    @NotNull

    public String getTrxnTime() {
        return trxnTime;
    }

    public void setTrxnTime(String trxnTime) {
        this.trxnTime = trxnTime;
    }

    public AFSubmitReqHeader replyRefNo(String replyRefNo) {
        this.replyRefNo = replyRefNo;
        return this;
    }

    /**
     * Reply Ref No
     * @return replyRefNo
     **/
    @Schema(description = "Reply Ref No")

    public String getReplyRefNo() {
        return replyRefNo;
    }

    public void setReplyRefNo(String replyRefNo) {
        this.replyRefNo = replyRefNo;
    }

    public AFSubmitReqHeader dplName(String dplName) {
        this.dplName = dplName;
        return this;
    }

    /**
     * Dpl Name
     * @return dplName
     **/
    @Schema(description = "Dpl Name ")

    public String getDplName() {
        return dplName;
    }

    public void setDplName(String dplName) {
        this.dplName = dplName;
    }

    public AFSubmitReqHeader extTrxnCd(String extTrxnCd) {
        this.extTrxnCd = extTrxnCd;
        return this;
    }

    /**
     * External Transaction Code
     * @return extTransactionCode
     **/
    @Schema(required = true, description = "External Transaction Code")
    @NotNull

    public String getExtTrxnCd() {
        return extTrxnCd;
    }

    public void setExtTrxnCd(String extTrxnCd) {
        this.extTrxnCd = extTrxnCd;
    }

    public AFSubmitReqHeader destQueue(String destQueue) {
        this.destQueue = destQueue;
        return this;
    }

    /**
     * Destination Queue
     * @return destQueue
     **/
    @Schema(description = "Destination Queue")

    public String getDestQueue() {
        return destQueue;
    }

    public void setDestQueue(String destQueue) {
        this.destQueue = destQueue;
    }

    public AFSubmitReqHeader msgRefNo(String msgRefNo) {
        this.msgRefNo = msgRefNo;
        return this;
    }

    /**
     * Message Reference No
     * @return msgRefNo
     **/
    @Schema(example = "MGECO000120220611012345000001", required = true, description = "Message Reference No")
    @NotNull

    public String getMsgRefNo() {
        return msgRefNo;
    }

    public void setMsgRefNo(String msgRefNo) {
        this.msgRefNo = msgRefNo;
    }

    public AFSubmitReqHeader systemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
        return this;
    }

    /**
     * System Status
     * @return systemStatus
     **/
    @Schema(description = "System Status")

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public AFSubmitReqHeader msgverNo(Double msgverNo) {
        this.msgverNo = msgverNo;
        return this;
    }

    /**
     * Message Version No
     * @return msgverNo
     **/
    @Schema(required = true, description = "Message Version No")
    @NotNull

    public Double getMsgverNo() {
        return msgverNo;
    }

    public void setMsgverNo(Double msgverNo) {
        this.msgverNo = msgverNo;
    }

    public AFSubmitReqHeader filler(String filler) {
        this.filler = filler;
        return this;
    }

    /**
     * Filler
     * @return filler
     **/
    @Schema(description = "Filler")

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public AFSubmitReqHeader noOfRecords(Integer noOfRecords) {
        this.noOfRecords = noOfRecords;
        return this;
    }

    /**
     * No of records
     * @return noOfRecords
     **/
    @Schema(description = "No of records")

    public Integer getNoOfRecords() {
        return noOfRecords;
    }

    public void setNoOfRecords(Integer noOfRecords) {
        this.noOfRecords = noOfRecords;
    }

    public AFSubmitReqHeader pan(String pan) {
        this.pan = pan;
        return this;
    }

    /**
     * Pan
     * @return pan
     **/
    @Schema(description = "Pan")

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public AFSubmitReqHeader overrideTellerId(Integer overrideTellerId) {
        this.overrideTellerId = overrideTellerId;
        return this;
    }

    /**
     * Override Teller Id
     * @return overrideTellerId
     **/
    @Schema(description = "Override Teller Id")

    public Integer getOverrideTellerId() {
        return overrideTellerId;
    }

    public void setOverrideTellerId(Integer overrideTellerId) {
        this.overrideTellerId = overrideTellerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AFSubmitReqHeader afSubmitReqHeader = (AFSubmitReqHeader) o;
        return Objects.equals(this.sourceID, afSubmitReqHeader.sourceID) &&
                Objects.equals(this.destQueueManager, afSubmitReqHeader.destQueueManager) &&
                Objects.equals(this.loginID, afSubmitReqHeader.loginID) &&
                Objects.equals(this.recordLength, afSubmitReqHeader.recordLength) &&
                Objects.equals(this.errorMessage, afSubmitReqHeader.errorMessage) &&
                Objects.equals(this.errorCode, afSubmitReqHeader.errorCode) &&
                Objects.equals(this.terminalID, afSubmitReqHeader.terminalID) &&
                Objects.equals(this.trxnDate, afSubmitReqHeader.trxnDate) &&
                Objects.equals(this.trxnTime, afSubmitReqHeader.trxnTime) &&
                Objects.equals(this.replyRefNo, afSubmitReqHeader.replyRefNo) &&
                Objects.equals(this.dplName, afSubmitReqHeader.dplName) &&
                Objects.equals(this.extTrxnCd, afSubmitReqHeader.extTrxnCd) &&
                Objects.equals(this.destQueue, afSubmitReqHeader.destQueue) &&
                Objects.equals(this.msgRefNo, afSubmitReqHeader.msgRefNo) &&
                Objects.equals(this.systemStatus, afSubmitReqHeader.systemStatus) &&
                Objects.equals(this.msgverNo, afSubmitReqHeader.msgverNo) &&
                Objects.equals(this.filler, afSubmitReqHeader.filler) &&
                Objects.equals(this.noOfRecords, afSubmitReqHeader.noOfRecords) &&
                Objects.equals(this.pan, afSubmitReqHeader.pan) &&
                Objects.equals(this.overrideTellerId, afSubmitReqHeader.overrideTellerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceID, destQueueManager, loginID, recordLength, errorMessage, errorCode, terminalID, trxnTime, trxnTime, replyRefNo, dplName, extTrxnCd, destQueue, msgRefNo, systemStatus, msgverNo, filler, noOfRecords, pan, overrideTellerId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AFStatusReqHeader {\n");

        sb.append("    sourceID: ").append(toIndentedString(sourceID)).append("\n");
        sb.append("    destQueueManager: ").append(toIndentedString(destQueueManager)).append("\n");
        sb.append("    loginID: ").append(toIndentedString(loginID)).append("\n");
        sb.append("    recordLength: ").append(toIndentedString(recordLength)).append("\n");
        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
        sb.append("    terminalID: ").append(toIndentedString(terminalID)).append("\n");
        sb.append("    trxnDate: ").append(toIndentedString(trxnDate)).append("\n");
        sb.append("    trxnTime: ").append(toIndentedString(trxnTime)).append("\n");
        sb.append("    replyRefNo: ").append(toIndentedString(replyRefNo)).append("\n");
        sb.append("    dplName: ").append(toIndentedString(dplName)).append("\n");
        sb.append("    extTrxnCd: ").append(toIndentedString(extTrxnCd)).append("\n");
        sb.append("    destQueue: ").append(toIndentedString(destQueue)).append("\n");
        sb.append("    msgRefNo: ").append(toIndentedString(msgRefNo)).append("\n");
        sb.append("    systemStatus: ").append(toIndentedString(systemStatus)).append("\n");
        sb.append("    msgverNo: ").append(toIndentedString(msgverNo)).append("\n");
        sb.append("    filler: ").append(toIndentedString(filler)).append("\n");
        sb.append("    noOfRecords: ").append(toIndentedString(noOfRecords)).append("\n");
        sb.append("    pan: ").append(toIndentedString(pan)).append("\n");
        sb.append("    overrideTellerId: ").append(toIndentedString(overrideTellerId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}