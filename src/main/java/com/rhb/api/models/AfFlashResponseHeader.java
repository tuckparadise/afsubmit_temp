package com.rhb.api.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class AfFlashResponseHeader {
    @XmlElement(name = "MsgVerNo")
    private Double msgVerNo;

    @XmlElement(name = "SourceId")
    private String sourceId;
    @XmlElement(name = "MsgRefNo")
    private String msgRefNo;
    @XmlElement(name = "LoginId")
    private Integer loginId;
    @XmlElement(name = "Pan")
    private String pan;
    @XmlElement(name = "ExtTrxnCd")
    private String extTrxnCd;
    @XmlElement(name = "DplName")
    private String dplName;
    @XmlElement(name = "Filler")
    private String filler;
    @XmlElement(name = "Reclen")
    private Integer reclen;
    @XmlElement(name = "NoOfRec")
    private Integer noOfRec;
    @XmlElement(name = "TrxnDate")
    private Integer trxnDate;
    @XmlElement(name = "TrxnTime")
    private Integer trxnTime;
    @XmlElement(name = "DestQueueMgr")
    private String destQueueMgr;
    @XmlElement(name = "DestQueue")
    private String destQueue;
    @XmlElement(name = "ErrCode")
    private Integer errCode;
    @XmlElement(name = "SystemStatus")
    private String systemStatus;
    @XmlElement(name = "ErrMsg")
    private String errMsg;
    @XmlElement(name = "TerminalId")
    private String terminalId;
    @XmlElement(name = "RepRefNo")
    private String repRefNo;
    @XmlElement(name = "OvdTellerId")
    private Integer ovdTellerID;
    @XmlElement(name = "PriAcctCurrNo")
    private String priAcctCurrNo;
    @XmlElementWrapper(name = "RepliedMsg")
    @XmlElement(name = "Msg")
    private List<AfFlashMessageList> msgList;


    public Double getMsgVerNo() {
        return msgVerNo;
    }

    public void setMsgVerNo(Double msgVerNo) {
        this.msgVerNo = msgVerNo;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getMsgRefNo() {
        return msgRefNo;
    }

    public void setMsgRefNo(String msgRefNo) {
        this.msgRefNo = msgRefNo;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExtTrxnCd() {
        return extTrxnCd;
    }

    public void setExtTrxnCd(String extTrxnCd) {
        this.extTrxnCd = extTrxnCd;
    }

    public String getDplName() {
        return dplName;
    }

    public void setDplName(String dplName) {
        this.dplName = dplName;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public Integer getReclen() {
        return reclen;
    }

    public void setReclen(Integer reclen) {
        this.reclen = reclen;
    }

    public Integer getNoOfRec() {
        return noOfRec;
    }

    public void setNoOfRec(Integer noOfRec) {
        this.noOfRec = noOfRec;
    }

    public Integer getTrxnDate() {
        return trxnDate;
    }

    public void setTrxnDate(Integer trxnDate) {
        this.trxnDate = trxnDate;
    }

    public Integer getTrxnTime() {
        return trxnTime;
    }

    public void setTrxnTime(Integer trxnTime) {
        this.trxnTime = trxnTime;
    }

    public String getDestQueueMgr() {
        return destQueueMgr;
    }

    public void setDestQueueMgr(String destQueueMgr) {
        this.destQueueMgr = destQueueMgr;
    }

    public String getDestQueue() {
        return destQueue;
    }

    public void setDestQueue(String destQueue) {
        this.destQueue = destQueue;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getRepRefNo() {
        return repRefNo;
    }

    public void setRepRefNo(String repRefNo) {
        this.repRefNo = repRefNo;
    }

    public Integer getOvdTellerID() {
        return ovdTellerID;
    }

    public void setOvdTellerID(Integer ovdTellerID) {
        this.ovdTellerID = ovdTellerID;
    }

    public String getPriAcctCurrNo() {
        return priAcctCurrNo;
    }

    public void setPriAcctCurrNo(String priAcctCurrNo) {
        this.priAcctCurrNo = priAcctCurrNo;
    }

    public List<AfFlashMessageList> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<AfFlashMessageList> msgList) {
        this.msgList = msgList;
    }
}
