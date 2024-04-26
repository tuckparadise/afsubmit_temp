package com.rhb.api;


import com.amazonaws.auth.WebIdentityTokenCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.rhb.api.configuration.GetParameter;
import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import springfox.documentation.oas.annotations.EnableOpenApi;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.apache.commons.lang3.StringUtils;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableOpenApi
@EnableWebMvc
@ComponentScan(basePackages = {"com.rhb.api", "com.rhb.api.controllers", "io.swagger.configuration"})
public class Application {


    String applicantType;
    String staffCode;
    String customerType;
    String defaultValueY;
    String nationalityMY;
    String purposeOfAccountOpening;
    String applicationTypeAF;
    String sourceSystem;
    String sourceId;
    String extTrxnCd;
    String facilityTypeVal1;
    String facilityTypeVal2;
    String facilityPurposeDefaultVal;
    String defaultValue0WithDecimal;
    String handlingFeeDefaultVal;
    String defaultValueN;
    String defaultValueM;
    String defaultValue01;
    String defaultValue03;
    String productValue;
    String defaultValueP;
    String defaultValueR;
    String defaultValueO;
    String defaultValueMI;
    String defaultValueMK;
    String defaultValueF;
    String defaultValue050;
    String defaultValue04;
    String defaultValue080;
    String defaultValue05;
    String defaultValue087;
    String defaultValue06;
    String defaultValue104;
    String defaultValue0033;
    String defaultValue0032;
    String entityI;
    String entityC;
    String employmentTypeForMultiNationalComp;

    String dataTypeErrorCode;
    String invalidErrorCode;
    String blankErrorCode;
    String lengthErrorCode;
    String invalidFormatErrorCode;
    String futureDateErrorCode;
    String specialCharacterErrorCode;
    String invalidReqCode;
    String invalidYearMakeCode;

    String blankCheckErrorCode;
    String invalidDataTypeErrorCode;
    String invalidLengthErrorCode;
    String invalidFieldValueErrorCode;
    String invalidSpecialCharacterErrorCode;
    String invalidDateErrorCode;
    String dateMismatchErrorCode;
    String invalidReqMsg;
    String invalidYearMakeMsg;

    String invalidFormatErrorDesc;
    String invalidRequestErrorDesc;
    String datatypeErrorDesc;
    String blankErrorDesc;
    String lengthErrorDesc;
    String invalidValueErrorDesc;
    String invalidCharacterErrorDesc;
    String invalidDateValueErrorDesc;
    String invalidYearMakeDesc;
    String tokenKeyName;

    static String strTokenKeyName = "tokenKeyName";
    static String appSb = "/apps/sb/";
    static String strCertKeyName ="certKeyName";
    static String strFlashErrorList = "flashErrorList";
    static String strInvalidFormatErrorDesc = "invalidFormatErrorDesc";
    static String strInvalidRequestErrorDesc = "invalidRequestErrorDesc";
static String strDatatypeErrorDesc = "datatypeErrorDesc";
      String strEmploymentTypeForAddress = "employmentTypeForAddress";
    static FileOutputStream fos;
    static FileOutputStream fos1;
    static FileInputStream fis;

    private static final Log log = LogFactory.getLog(Application.class);
    GetParameter parameter = new GetParameter();

    public static void main(String[] args) throws IOException {
        String awsRoleArn = "AWS_ROLE_ARN";
        String awsWebIdentityTokenFile = "AWS_WEB_IDENTITY_TOKEN_FILE";
        new SpringApplication(Application.class).run(args);
            new Application().populateValues();
            String tokenKeyName = System.getProperty(strTokenKeyName);
            String bucketName = "flash-" + System.getenv("spring.profiles.active") + "-certificate";
            log.info("Downloading %s from S3 bucket %s...\n" + tokenKeyName + bucketName);
        String awsArnRole = System.getenv(awsRoleArn);
        String webIdentityTokenFilePath = System.getenv(awsWebIdentityTokenFile);
        WebIdentityTokenCredentialsProvider credentials = WebIdentityTokenCredentialsProvider.builder()
                .roleArn(awsArnRole)
                .webIdentityTokenFile(webIdentityTokenFilePath)
                .build();

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(credentials)
                .withRegion(Regions.AP_SOUTHEAST_1).build();
            S3Object o = s3.getObject(bucketName, tokenKeyName);
            S3ObjectInputStream s3is = o.getObjectContent();
            fos = new FileOutputStream(new File(appSb,tokenKeyName));
            byte[] readBuf = new byte[1024];
            int readLen;
            while ((readLen = s3is.read(readBuf)) > 0) {
                fos.write(readBuf, 0, readLen);
                //log.info("File Content : " + Arrays.toString(readBuf));
            }
            fis = new FileInputStream(new File(appSb,tokenKeyName));
            byte[] buffer = new byte[10];
            StringBuilder sb = new StringBuilder();
            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }
            fis.close();
            fos.close();
            s3is.close();
            String content = sb.toString();

            System.setProperty("SecurityToken", content);
            log.info("tokenContent"+content);

            String keyName = System.getProperty(strCertKeyName);
            log.info("Downloading %s from S3 bucket %s...\n" + keyName + bucketName);

            S3Object certObj = s3.getObject(bucketName, keyName);
            S3ObjectInputStream certis = certObj.getObjectContent();
            fos1 = new FileOutputStream(appSb + keyName);
            byte[] readBuf1 = new byte[1024];
            int readLen1;
            while ((readLen1 = certis.read(readBuf1)) > 0) {
                fos1.write(readBuf1, 0, readLen1);
                //log.info("File Content : " + Arrays.toString(readBuf1));
            }
            certis.close();
            fos1.close();
            fis.close();
    }

    public void populateErrorResponseValues() {
        // error code
        dataTypeErrorCode = parameter.getParamAsString("datatype");
        System.setProperty("dataTypeErrorCode", dataTypeErrorCode);
        invalidErrorCode = parameter.getParamAsString("invalid.code");
        System.setProperty("invalidErrorCode", invalidErrorCode);
        blankErrorCode = parameter.getParamAsString("blank.code");
        System.setProperty("blankErrorCode", blankErrorCode);
        lengthErrorCode = parameter.getParamAsString("length.code");
        System.setProperty("lengthErrorCode", lengthErrorCode);
        invalidFormatErrorCode = parameter.getParamAsString("invalid.format");
        System.setProperty("invalidFormatErrorCode", invalidFormatErrorCode);
        futureDateErrorCode = parameter.getParamAsString("future.date");
        System.setProperty("futureDateErrorCode", futureDateErrorCode);
        specialCharacterErrorCode = parameter.getParamAsString("invalid.specialCharacterCode");
        System.setProperty("specialCharacterErrorCode", specialCharacterErrorCode);
        invalidReqCode = parameter.getParamAsString("invalidReqCode");
        System.setProperty("invalidReqCode", String.valueOf(invalidReqCode));
        invalidYearMakeCode = parameter.getParamAsString("invalidYearMakeCode");
        System.setProperty("invalidYearMakeCode", String.valueOf(invalidYearMakeCode));

        //error message
        blankCheckErrorCode = parameter.getParamAsString("blankCheck");
        System.setProperty("blankCheckErrorCode", blankCheckErrorCode);
        invalidDataTypeErrorCode = parameter.getParamAsString("invalid.dataTypeCheck");
        System.setProperty("invalidDataTypeErrorCode", invalidDataTypeErrorCode);
        invalidLengthErrorCode = parameter.getParamAsString("invalid.lengthCheck");
        System.setProperty("invalidLengthErrorCode", invalidLengthErrorCode);
        invalidFieldValueErrorCode = parameter.getParamAsString("invalid.fieldValue");
        System.setProperty("invalidFieldValueErrorCode", invalidFieldValueErrorCode);
        invalidSpecialCharacterErrorCode = parameter.getParamAsString("invalid.specialCharacter");
        System.setProperty("invalidSpecialCharacterErrorCode", invalidSpecialCharacterErrorCode);
        invalidDateErrorCode = parameter.getParamAsString("date.invalid");
        System.setProperty("invalidDateErrorCode", invalidDateErrorCode);
        dateMismatchErrorCode = parameter.getParamAsString("date.mismatch");
        System.setProperty("dateMismatchErrorCode", dateMismatchErrorCode);
        invalidReqMsg = parameter.getParamAsString("invalidReqMsg");
        System.setProperty("invalidReqMsg", invalidReqMsg);
        invalidYearMakeMsg = parameter.getParamAsString("invalidYearMakeMsg");
        System.setProperty("invalidYearMakeMsg", invalidYearMakeMsg);

        //error description
        invalidFormatErrorDesc = parameter.getParamAsString(strInvalidFormatErrorDesc);
        System.setProperty(strInvalidFormatErrorDesc, invalidFormatErrorDesc);

        invalidRequestErrorDesc = parameter.getParamAsString(strInvalidRequestErrorDesc);
        System.setProperty(strInvalidRequestErrorDesc, invalidRequestErrorDesc);

        datatypeErrorDesc = parameter.getParamAsString(strDatatypeErrorDesc);
        System.setProperty(strDatatypeErrorDesc, datatypeErrorDesc);

        blankErrorDesc = parameter.getParamAsString("blankErrorDesc");
        System.setProperty("blankErrorDesc", blankErrorDesc);
        datatypeErrorDesc = parameter.getParamAsString(strDatatypeErrorDesc);
        System.setProperty(strDatatypeErrorDesc, datatypeErrorDesc);
        lengthErrorDesc = parameter.getParamAsString("lengthErrorDesc");
        System.setProperty("lengthErrorDesc", lengthErrorDesc);
        invalidValueErrorDesc = parameter.getParamAsString("invalidValueErrorDesc");
        System.setProperty("invalidValueErrorDesc", invalidValueErrorDesc);
        invalidCharacterErrorDesc = parameter.getParamAsString("invalidCharacterErrorDesc");
        System.setProperty("invalidCharacterErrorDesc", invalidCharacterErrorDesc);
        invalidDateValueErrorDesc = parameter.getParamAsString("invalidDateValueErrorDesc");
        System.setProperty("invalidDateValueErrorDesc", invalidDateValueErrorDesc);
        invalidFormatErrorDesc = parameter.getParamAsString(strInvalidFormatErrorDesc);
        System.setProperty(strInvalidFormatErrorDesc, invalidFormatErrorDesc);
        invalidRequestErrorDesc = parameter.getParamAsString(strInvalidRequestErrorDesc);
        System.setProperty(strInvalidRequestErrorDesc, invalidRequestErrorDesc);
        invalidYearMakeDesc = parameter.getParamAsString("invalidYearMakeDesc");
        System.setProperty("invalidYearMakeDesc", invalidYearMakeDesc);
    }

    public void populateValues() {
        populateErrorResponseValues();
        String certKeyName = parameter.getParamAsString(strCertKeyName);
        System.setProperty(strCertKeyName, certKeyName);

        tokenKeyName = parameter.getParamAsString(strTokenKeyName);
        System.setProperty(strTokenKeyName, tokenKeyName);

        
        String statePostcode = combineValue("statePostcode");
        System.setProperty("statePostcode", statePostcode);
        
        // GDTAPI-2906- update latest model list        
        
        String newPackageCarListSize = parameter.getParamAsString("newPackageCarListSize");
        System.setProperty("newPackageCarListSize", newPackageCarListSize);
        
        int intnewPackageCarListSize = Integer.parseInt(newPackageCarListSize);
        
        String newPackageCarList = combineNPackageCarList("newPackageCarList",intnewPackageCarListSize);
        System.setProperty("newPackageCarList", newPackageCarList);
        log.info("newPackageCarList : " + System.getProperty("newPackageCarList"));
        

        String dealerPackageCarListSize = parameter.getParamAsString("dealerPackageCarListSize");
        System.setProperty("dealerPackageCarListSize", dealerPackageCarListSize);
        //log.info("dealerPackageCarListSize : " + System.getProperty("dealerPackageCarListSize"));
        
        int intdealerPackageCarListSize = Integer.parseInt(dealerPackageCarListSize);
        
        String dealerPackageCarList = combineNDealerPackageCarList("dealerPackageCarList",intdealerPackageCarListSize);
        System.setProperty("dealerPackageCarList", dealerPackageCarList);
        
        //log.info("dealerPackageCarList : " + System.getProperty("dealerPackageCarList"));

        String vehicleMakeListSize = parameter.getParamAsString("vehicleMakeListSize");
        System.setProperty("vehicleMakeListSize", vehicleMakeListSize);
        log.info("vehicleMakeListSize : " + System.getProperty("vehicleMakeListSize"));
        
        int intvehicleMakeListSize = Integer.parseInt(vehicleMakeListSize);
        
        String vehicleMake = combineValuePackage("vehicleMake",intvehicleMakeListSize);
        System.setProperty("vehicleMake", vehicleMake);
        
        
        String vehicleTypeListSize = parameter.getParamAsString("vehicleTypeListSize");
        System.setProperty("vehicleTypeListSize", vehicleTypeListSize);
        log.info("vehicleTypeListSize : " + System.getProperty("vehicleTypeListSize"));
        
        int intvehicleTypeListSize = Integer.parseInt(vehicleTypeListSize);
        
        String vehicleTypeList = combineVehicleType("vehicleTypeList",intvehicleTypeListSize);
        System.setProperty("vehicleTypeList", vehicleTypeList);
        
        String modelListSize = parameter.getParamAsString("modelListSize");
        System.setProperty("modelListSize", modelListSize);
        log.info("modelListSize : " + System.getProperty("modelListSize"));
        
        int intmodelListSize = Integer.parseInt(modelListSize);
        
        String modelList = combineModel("modelList",intmodelListSize);
        System.setProperty("modelList", modelList);
        


        // GDTAPI-2906- update latest model list
        
        // GDTAPI-2908- set to different package code if financing amount is less than 100k or more than 500k for hybrid & national green 
        
        String financingAmountPackageRuleMin = parameter.getParamAsString("FinancingAmountPackageRuleMin");
        System.setProperty("FinancingAmountPackageRuleMin", (financingAmountPackageRuleMin));
        
        log.info("financingAmountPackageRuleMin : " + System.getProperty("FinancingAmountPackageRuleMin"));
        
        String financingAmountPackageRuleMax = parameter.getParamAsString("FinancingAmountPackageRuleMax");
        System.setProperty("FinancingAmountPackageRuleMax", (financingAmountPackageRuleMax));
        
        log.info("financingAmountPackageRuleMax : " + System.getProperty("FinancingAmountPackageRuleMax"));
        
        String hybridPackageCode = parameter.getParamAsString("HybridPackageCode");
        hybridPackageCode = StringUtils.strip(hybridPackageCode);
        System.setProperty("HybridPackageCode", (hybridPackageCode));
        
        log.info("hybridPackageCode : " + System.getProperty("HybridPackageCode"));
        
        String nationalGreenPackageCode = parameter.getParamAsString("NationalGreenPackageCode");
        nationalGreenPackageCode = StringUtils.strip(nationalGreenPackageCode);
        System.setProperty("NationalGreenPackageCode", (nationalGreenPackageCode));
        
        log.info("nationalGreenPackageCode : " + System.getProperty("NationalGreenPackageCode"));
        
        String volvoPackageCode = parameter.getParamAsString("VolvoPackageCode");
        volvoPackageCode = StringUtils.strip(volvoPackageCode);
        System.setProperty("VolvoPackageCode", (volvoPackageCode));
        
        log.info("volvoPackageCode : " + System.getProperty("VolvoPackageCode"));
        // GDTAPI-2908- set to different package code if financing amount is less than 100k or more than 500k for hybrid & national green 
         
         
        String flashErrorList = parameter.getParamAsString(strFlashErrorList);
        System.setProperty(strFlashErrorList, flashErrorList);
        String afSubmitUrl = parameter.getParamAsString("afSubmit.url");
        System.setProperty("afSubmitUrl", afSubmitUrl);
        String addressTypes = parameter.getParamAsString("addressTypes");
        System.setProperty("addressTypes", (addressTypes));
        String employmentSectorTypeList = parameter.getParamAsString("employmentDetails");
        System.setProperty("employmentSectorTypeList", (employmentSectorTypeList));
        String marketValueList = parameter.getParamAsString("marketValueList");
        System.setProperty("marketValueList", (marketValueList));
        String mobilePhoneNoAreaCodeList = parameter.getParamAsString("idTypeForMblPhnNoAreaCode");
        System.setProperty("mobilePhoneNoAreaCodeList", (mobilePhoneNoAreaCodeList));
        String entityList = parameter.getParamAsString("entity");
        
        entityList = StringUtils.strip(entityList);
        
        System.setProperty("entityList", (entityList));
        
        log.info("entityList : " + System.getProperty("entityList"));
        
        String employmentTypeForAddress = parameter.getParamAsString(strEmploymentTypeForAddress);
        System.setProperty(strEmploymentTypeForAddress, (employmentTypeForAddress));
        String defaultAreaCodeList = parameter.getParamAsString("defaultAreaCodeList");
        System.setProperty("defaultAreaCodeList", (defaultAreaCodeList));
        String kLAreaCode = parameter.getParamAsString("kLAreaCode");
        System.setProperty("kLAreaCode", (kLAreaCode));
        String vehicleConditonList = parameter.getParamAsString("vehicleConditonList");
        System.setProperty("vehicleConditonList", (vehicleConditonList));
        String genderList = parameter.getParamAsString("gender");
        System.setProperty("genderList", (genderList));
        String countryCode = parameter.getParamAsString("countryCode");
        System.setProperty("countryCode", (countryCode));
        String sourceOfFundList = parameter.getParamAsString("sourceOfFundList");
        System.setProperty("sourceOfFundList", (sourceOfFundList));
        
        /* GDTAPI-2951: new AF product code */ 
        String ProductList = parameter.getParamAsString("ProductList");
        System.setProperty("ProductList", (ProductList));
        
        log.info("ProductList : " + System.getProperty("ProductList"));
        
        /* GDTAPI-2951: new AF product code */ 
        
        String computationModeList = parameter.getParamAsString("computationModeList");
        System.setProperty("computationModeList", (computationModeList));
        String idTypeList = parameter.getParamAsString("idTypes");
        System.setProperty("idTypeList", (idTypeList));
        String preferredBranchList = parameter.getParamAsString("preferredBranch");
        System.setProperty("preferredBranchList", (preferredBranchList));
        String subEmploymentSectorList = parameter.getParamAsString("afsubEmploymentSectorList");
        System.setProperty("subEmploymentSectorList", (subEmploymentSectorList));
        String employmentSectorList = parameter.getParamAsString("employmentSector");
        System.setProperty("employmentSectorList", (employmentSectorList));
        String occupationCodeList = parameter.getParamAsString("occupation");
        System.setProperty("occupationCodeList", (occupationCodeList));
        String nationalMake = parameter.getParamAsString("nationalMake");
        System.setProperty("nationalMake", nationalMake);
        String nonNationalMake = parameter.getParamAsString("nonNationalMake");
        System.setProperty("nonNationalMake", nonNationalMake);
        String raceList = parameter.getParamAsString("racelistForIdType");
        System.setProperty("raceList", (raceList));
        String usedPackageCarList = parameter.getParamAsString("usedPackageCarList");
        System.setProperty("usedPackageCarList", usedPackageCarList);
        String educationLevelList = parameter.getParamAsString("educationLevel");
        System.setProperty("educationLevelList", (educationLevelList));
        String maritalStatusList = parameter.getParamAsString("maritalStatus");
        System.setProperty("maritalStatusList", (maritalStatusList));
        String employmentTypeList = parameter.getParamAsString("employmentType");
        System.setProperty("employmentTypeList", (employmentTypeList));
        String employmentTypeForLength = parameter.getParamAsString("employmentDetails");
        System.setProperty("employmentTypeForLength", (employmentTypeForLength));
        String vehicleCondtionRegDate = parameter.getParamAsString("vehicleCondtionRegDate");
        System.setProperty("vehicleCondtionRegDate", (vehicleCondtionRegDate));
        String bdmList = parameter.getParamAsString("bdmList");
        System.setProperty("bdmList", (bdmList));
        String employmentTypeMonthlyNetIncome = parameter.getParamAsString(strEmploymentTypeForAddress);
        System.setProperty("employmentTypeMonthlyNetIncome", (employmentTypeMonthlyNetIncome));
        String sourceOfWealthlist = parameter.getParamAsString("sourceOfWealthList");
        System.setProperty("sourceOfWealthlist", (sourceOfWealthlist));
        String residenceTypeList = parameter.getParamAsString("residenceTypeList");
        System.setProperty("residenceTypeList", (residenceTypeList));
        String mobilePhoneNoAreaCode = parameter.getParamAsString("mobilePhoneNoAreaCode");
        System.setProperty("mobilePhoneNoAreaCode", (mobilePhoneNoAreaCode));
        String postCodeList = combinePostCode("postCodeList");
        System.setProperty("postCodeList", postCodeList);

// default values
        String collateralType = parameter.getParamAsString("collateralType");
        System.setProperty("collateralType", (collateralType));

        entityC = parameter.getParamAsString("entityC");
        System.setProperty("entityC", (entityC));

        entityI = parameter.getParamAsString("entityI");
        System.setProperty("entityI", (entityI));

        String vehicleUsage = parameter.getParamAsString("vehicleUsage");
        System.setProperty("vehicleUsage", (vehicleUsage));

        applicantType = parameter.getParamAsString("applicantType");
        System.setProperty("applicantType", (applicantType));

        staffCode = parameter.getParamAsString("staffCode");
        System.setProperty("staffCode", (staffCode));

        customerType = parameter.getParamAsString("customerType");
        System.setProperty("customerType", (customerType));

        defaultValueY = parameter.getParamAsString("defaultValueY");
        System.setProperty("defaultValueY", (defaultValueY));

        defaultValue06 = parameter.getParamAsString("defaultValue06");
        System.setProperty("defaultValue06", (defaultValue06));

        defaultValue104 = parameter.getParamAsString("defaultValue104");
        System.setProperty("defaultValue104", (defaultValue104));


        employmentTypeForMultiNationalComp = parameter.getParamAsString("employmentTypeForMultiNationalComp");
        System.setProperty("employmentTypeForMultiNationalComp", (employmentTypeForMultiNationalComp));


        defaultValue0033 = parameter.getParamAsString("defaultValue0033");
        System.setProperty("defaultValue0033", (defaultValue0033));

        defaultValue0032 = parameter.getParamAsString("defaultValue0032");
        System.setProperty("defaultValue0032", (defaultValue0032));

        defaultValue087 = parameter.getParamAsString("defaultValue087");
        System.setProperty("defaultValue087", (defaultValue087));

        defaultValue050 = parameter.getParamAsString("defaultValue050");
        System.setProperty("defaultValue050", (defaultValue050));

        defaultValue05 = parameter.getParamAsString("defaultValue05");
        System.setProperty("defaultValue05", (defaultValue05));


        defaultValue080 = parameter.getParamAsString("defaultValue080");
        System.setProperty("defaultValue080", (defaultValue080));


        defaultValue04 = parameter.getParamAsString("defaultValue04");
        System.setProperty("defaultValue04", (defaultValue04));

        defaultValueMK = parameter.getParamAsString("defaultValueMK");
        System.setProperty("defaultValueMK", (defaultValueMK));

        defaultValue03 = parameter.getParamAsString("defaultValue03");
        System.setProperty("defaultValue03", (defaultValue03));

        String defaultValueZero = parameter.getParamAsString("defaultValueZero");
        System.setProperty("defaultValueZero", (defaultValueZero));

        defaultValueF = parameter.getParamAsString("defaultValueF");
        System.setProperty("defaultValueF", (defaultValueF));

        String defaultValueU = parameter.getParamAsString("defaultValueU");
        System.setProperty("defaultValueU", (defaultValueU));

        defaultValueM = parameter.getParamAsString("defaultValueM");
        System.setProperty("defaultValueM", (defaultValueM));

        String defaultValuePP = parameter.getParamAsString("defaultValuePP");
        System.setProperty("defaultValuePP", (defaultValuePP));

        defaultValueP = parameter.getParamAsString("defaultValueP");
        System.setProperty("defaultValueP", defaultValueP);

        defaultValueO = parameter.getParamAsString("defaultValueO");
        System.setProperty("defaultValueO", defaultValueO);

        defaultValueMI = parameter.getParamAsString("defaultValueMI");
        System.setProperty("defaultValueMI", defaultValueMI);

        defaultValueR = parameter.getParamAsString("defaultValueR");
        System.setProperty("defaultValueR", defaultValueR);


        nationalityMY = parameter.getParamAsString("nationalityMY");
        System.setProperty("nationalityMY", (nationalityMY));

        purposeOfAccountOpening = parameter.getParamAsString("purposeOfAccountOpening");
        System.setProperty("purposeOfAccountOpening", (purposeOfAccountOpening));

        applicationTypeAF = parameter.getParamAsString("applicationTypeAF");
        System.setProperty("applicationTypeAF", (applicationTypeAF));

        sourceSystem = parameter.getParamAsString("sourceSystem");
        System.setProperty("sourceSystem", (sourceSystem));

        sourceId = parameter.getParamAsString("sourceId");
        System.setProperty("sourceId", (sourceId));

        extTrxnCd = parameter.getParamAsString("extTrxnCd");
        System.setProperty("extTrxnCd", extTrxnCd);

        facilityTypeVal1 = parameter.getParamAsString("facilityTypeVal1");
        System.setProperty("facilityTypeVal1", facilityTypeVal1);

        facilityTypeVal2 = parameter.getParamAsString("facilityTypeVal2");
        System.setProperty("facilityTypeVal2", facilityTypeVal2);

        facilityPurposeDefaultVal = parameter.getParamAsString("facilityPurposeDefaultVal");
        System.setProperty("facilityPurposeDefaultVal", facilityPurposeDefaultVal);


        defaultValue0WithDecimal = parameter.getParamAsString("defaultValue0.00");
        System.setProperty("defaultValue0WithDecimal", defaultValue0WithDecimal);

        handlingFeeDefaultVal = parameter.getParamAsString("handlingFeeDefaultVal");
        System.setProperty("handlingFeeDefaultVal", handlingFeeDefaultVal);

        defaultValueN = parameter.getParamAsString("defaultValueN");
        System.setProperty("defaultValueN", defaultValueN);

        defaultValue01 = parameter.getParamAsString("defaultValue01");
        System.setProperty("defaultValue01", defaultValue01);

        String defaultValuePR = parameter.getParamAsString("defaultValuePR");
        System.setProperty("defaultValuePR", defaultValuePR);


        productValue = parameter.getParamAsString("productValue");
        System.setProperty("productValue", productValue);

        String length20 = parameter.getParamAsString("length20");
        System.setProperty("length20", length20);

        String length2 = parameter.getParamAsString("length2");
        System.setProperty("length2", length2);

        String length9 = parameter.getParamAsString("length9");
        System.setProperty("length9", length9);


        String length12 = parameter.getParamAsString("length12");
        System.setProperty("length12", length12);

        String length40 = parameter.getParamAsString("length40");
        System.setProperty("length40", length40);


        String length5 = parameter.getParamAsString("length5");
        System.setProperty("length5", length5);

        String length6 = parameter.getParamAsString("length6");
        System.setProperty("length6", length6);

        String length4 = parameter.getParamAsString("length4");
        System.setProperty("length4", length4);

        String length3 = parameter.getParamAsString("length3");
        System.setProperty("length3", length3);

        String length70 = parameter.getParamAsString("length70");
        System.setProperty("length70", length70);

        String length7 = parameter.getParamAsString("length7");
        System.setProperty("length7", length7);

        String length8 = parameter.getParamAsString("length8");
        System.setProperty("length8", length8);

        String length80 = parameter.getParamAsString("length80");
        System.setProperty("length80", length80);

        String length50 = parameter.getParamAsString("length50");
        System.setProperty("length50", length50);

        String length13 = parameter.getParamAsString("length13");
        System.setProperty("length13", length13);


    }

    private String combineValue(String statePostcode) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            result.append(parameter.getParamAsString(statePostcode + i));
        }
        return result.toString();
    }

    private String combinePostCode(String postCodeList) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            result.append(parameter.getParamAsString(postCodeList + i));
        }
        return result.toString();
    }

    private String combineVehicleType(String vehicleTypeList ,int vehicleTypeListSize) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= vehicleTypeListSize; i++) {
            result.append(parameter.getParamAsString(vehicleTypeList + i));
        }
        return result.toString();
    }

    private String combineModel(String modelList, int intmodelListSize) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= intmodelListSize; i++) {
            result.append(parameter.getParamAsString(modelList + i));
        }
        return result.toString();
    }


    private String combineNPackageCarList(String newPackageCarList, int intnewPackageCarListSize) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= intnewPackageCarListSize; i++) {
            result.append(parameter.getParamAsString(newPackageCarList + i));
        }
        return result.toString();
    }

    private String combineNDealerPackageCarList(String dealerPackageCarList, int dealerPackageCarListSize) {
        
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= dealerPackageCarListSize; i++) {
            result.append(parameter.getParamAsString(dealerPackageCarList + i));
        }
        return result.toString();
    }   
    
    private String combineValuePackage(String vehicleMake,int vehicleMakeListSize) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= vehicleMakeListSize; i++) {
            result.append(parameter.getParamAsString(vehicleMake + i));
        }
        return result.toString();
    }
}
