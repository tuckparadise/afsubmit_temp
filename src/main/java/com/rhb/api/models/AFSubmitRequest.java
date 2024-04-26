package com.rhb.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AFSubmitRequest {

    @JsonProperty("header")
    private AFSubmitReqHeader header = null;
    @JsonProperty("Body")
    private AFAIPSubmissionRequestBody body = null;

    public AFSubmitReqHeader getHeader() {
        return header;
    }

    public void setHeader(AFSubmitReqHeader header) {
        this.header = header;
    }

    public AFAIPSubmissionRequestBody getBody() {
        return body;
    }

    public void setBody(AFAIPSubmissionRequestBody body) {
        this.body = body;
    }
}


