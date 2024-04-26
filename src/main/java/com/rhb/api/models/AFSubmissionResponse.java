package com.rhb.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AFSubmissionResponse {
    @JsonProperty("header")
    private List<AFSubmissionResHeader> header = null;

    public List<AFSubmissionResHeader> getHeader() {
        return header;
    }

    public void setHeader(List<AFSubmissionResHeader> header) {
        this.header = header;
    }

    public AFSubmitResponseBody getBody() {
        return body;
    }

    public void setBody(AFSubmitResponseBody body) {
        this.body = body;
    }

    @JsonProperty("Body")
    private AFSubmitResponseBody body = null;

}
