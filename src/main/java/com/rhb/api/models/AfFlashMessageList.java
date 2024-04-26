package com.rhb.api.models;

import javax.xml.bind.annotation.XmlElement;

public class AfFlashMessageList {
    @XmlElement(name = "ProgId")
    private String progId = null;

    @XmlElement(name = "MsgCd")
    private String msgCd = null;

    @XmlElement(name = "MsgSev")
    private String msgSev = null;

    @XmlElement(name = "MsgDscp")
    private String msgDscp = null;

    public String getProgId() {
        return progId;
    }

    public void setProgId(String progId) {
        this.progId = progId;
    }

    public String getMsgCd() {
        return msgCd;
    }

    public void setMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }

    public String getMsgSev() {
        return msgSev;
    }

    public void setMsgSev(String msgSev) {
        this.msgSev = msgSev;
    }

    public String getMsgDscp() {
        return msgDscp;
    }

    public void setMsgDscp(String msgDscp) {
        this.msgDscp = msgDscp;
    }




}
