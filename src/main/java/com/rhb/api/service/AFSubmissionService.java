package com.rhb.api.service;


import com.rhb.api.models.AFAIPSubmissionRequestBody;
import com.rhb.api.models.AFSubmissionResponse;
import org.springframework.http.ResponseEntity;

public interface AFSubmissionService {
    ResponseEntity<AFSubmissionResponse> afSubmitRequest(AFAIPSubmissionRequestBody request, String respEmail);

}
