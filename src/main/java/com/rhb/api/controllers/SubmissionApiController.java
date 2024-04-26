package com.rhb.api.controllers;

import com.rhb.api.models.AFAIPSubmissionRequestBody;
import com.rhb.api.models.AFSubmissionResponse;
import com.rhb.api.service.AFSubmissionService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-20T06:47:20.552442Z[GMT]")
@RestController
public class SubmissionApiController implements SubmissionApi {

    private static final Logger log = LoggerFactory.getLogger(SubmissionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SubmissionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    AFSubmissionService service;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<AFSubmissionResponse> addingOperations(@Parameter(in = ParameterIn.DEFAULT, description = "AF AIP Submission Request Body", required = true, schema = @Schema()) @RequestBody AFAIPSubmissionRequestBody body, @Parameter(in = ParameterIn.HEADER, description = "Partner Email", required = true, schema = @Schema())
    @RequestHeader(value = "respEmail") String respEmail) throws Exception {
        ResponseEntity<AFSubmissionResponse> response = new ResponseEntity<AFSubmissionResponse>(HttpStatus.OK);
        String accept = request.getHeader("Accept");
        if (accept != null) {
         log.info("Inside Controller impl");
            response = service.afSubmitRequest(body, respEmail);
            System.out.println("BODYVALUE "+body);

        }

        return response;
    }

    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }

}
