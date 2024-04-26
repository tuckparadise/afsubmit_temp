package com.rhb.api.models;

import javax.xml.bind.annotation.XmlElement;

public class AFFlashResponse {

    @XmlElement(name = "Header")
    private AfFlashResponseHeader flashResponseHeader = null;

    @XmlElement(name = "Body")
    private AFFlashResponseBody flashResponseBody = null;
    public AfFlashResponseHeader getFlashResponseHeader() {
        return flashResponseHeader;
    }

    public void setFlashResponseHeader(AfFlashResponseHeader flashResponseHeader) {
        this.flashResponseHeader = flashResponseHeader;
    }

    public AFFlashResponseBody getFlashResponseBody() {
        return flashResponseBody;
    }

    public void setFlashResponseBody(AFFlashResponseBody flashResponseBody) {
        this.flashResponseBody = flashResponseBody;
    }
}
