package com.rhb.api.configuration;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

public class GetParameter {

    String awsRole = "AWS_ROLE_ARN";
    String tokenFile = "AWS_WEB_IDENTITY_TOKEN_FILE";
    String config = "/config/";
    String flash = "/flash/";
    private static final Log log = LogFactory.getLog(GetParameter.class);


    String profile = System.getenv("spring.profiles.active");

    public JSONObject getParamAsJson(String paramName) {
        log.info("Getting params");
        String awsArnRole = System.getenv(awsRole);
        Path webIdentityTokenFilePath = Paths.get(System.getenv(tokenFile));

        Region region = Region.AP_SOUTHEAST_1;
        AwsCredentialsProvider credentials = WebIdentityTokenFileCredentialsProvider.builder()
                .roleArn(awsArnRole)
                .webIdentityTokenFile(webIdentityTokenFilePath)
                .build();

        SsmClient ssmClient = SsmClient.builder()
                .credentialsProvider(credentials)
                .region(region)
                .build();

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(config + profile + flash + paramName)
                    .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);

            String paramResponse = parameterResponse.parameter().value();
            return new JSONObject(paramResponse);
        } catch (SsmException | JSONException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public String getParamAsString(String paramName) {
        String awsArnRole = System.getenv(awsRole);
        Path webIdentityTokenFilePath = Paths.get(System.getenv(tokenFile));

        Region region = Region.AP_SOUTHEAST_1;
        AwsCredentialsProvider credentials = WebIdentityTokenFileCredentialsProvider.builder()
                .roleArn(awsArnRole)
                .webIdentityTokenFile(webIdentityTokenFilePath)
                .build();

        SsmClient ssmClient = SsmClient.builder()
                .credentialsProvider(credentials)
                .region(region)
                .build();

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(config + profile + flash + paramName)
                    .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);

            return parameterResponse.parameter().value();
        } catch (SsmException e) {
            log.error(e.getMessage());
        }
        return null;
    }
    public List<String> getParam(String paramName) {

        String awsArnRole = System.getenv(awsRole);
        Path webIdentityTokenFilePath = Paths.get(System.getenv(tokenFile));

        Region region = Region.AP_SOUTHEAST_1;
        AwsCredentialsProvider credentials = WebIdentityTokenFileCredentialsProvider.builder()
                .roleArn(awsArnRole)
                .webIdentityTokenFile(webIdentityTokenFilePath)
                .build();

        SsmClient ssmClient = SsmClient.builder()
                .credentialsProvider(credentials)
                .region(region)
                .build();

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(config + profile + flash + paramName)
                    .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);

            String paramResponse = parameterResponse.parameter().value();
            return Arrays.asList(paramResponse.split(","));
        } catch (SsmException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }
}