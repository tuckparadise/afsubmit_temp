package com.rhb.api.models;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

public class AFFlashResponseBody {

    @XmlElement(name = "ProcessID")
    private String processID = null;

    @XmlElement(name = "ProcessDate")
    private Date processDate = null;

    @XmlElement(name = "CustomerIDNo")
    private String customerIDNo = null;

    @XmlElement(name = "CustomerName")
    private String customerName = null;

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getCustomerIDNo() {
        return customerIDNo;
    }

    public void setCustomerIDNo(String customerIDNo) {
        this.customerIDNo = customerIDNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
