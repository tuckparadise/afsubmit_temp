package com.rhb.api;
import com.rhb.api.models.*;
import com.rhb.api.service.AFSubmissionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Objects;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;


@SpringBootTest
 class AIPSubmissionTest {
    @Autowired
    Environment env;

    static String strCertKeyName ="certKeyName";
    static String strTokenKeyName = "tokenKeyName";
    static  String strEmploymentTypeForAddress = "employmentTypeForAddress";
    static String strFlashErrorList = "flashErrorList";



    public void populateValues() {
        System.setProperty("flashErrorList", "");
        System.setProperty("afSubmitUrl", "https://aws.loan.intra-uat1.rhbgroup.com:8084/APIFlash");
        System.setProperty("invalidApplication", "Application not found");
        System.setProperty("invalidApplicationCode", "API1012");
        System.setProperty("blankErrorCode", "API1002");
        System.setProperty("dateFormatErrorCode", "API1008");
        System.setProperty("lengthErrorCode", "API1004");
        System.setProperty("invalidErrorCode", "API1005");
        System.setProperty("invalidTypeErrorCode", "API1003");
        System.setProperty("invalidCharacterErrorCode", "API1006");
        System.setProperty("futureDateErrorCode", "API1011");
        System.setProperty("specialCharacterErrorCode", "API1006");
        System.setProperty("invalidFormatErrorCode", "API1007");
        System.setProperty("invalidYearMakeCode", "API1013");
        System.setProperty("dataTypeErrorCode", "API1003");
        System.setProperty("invalidYearMakeMsg", "Year is invalid");
        System.setProperty("blankCheckErrorCode", "Mandatory field cannot be blank");
        System.setProperty("invalidDataTypeErrorCode", "Incorrect field data type");
        System.setProperty("invalidLengthErrorCode", "Invalid data field length");
        System.setProperty("invalidFieldValueErrorCode", "Invalid field value");
        System.setProperty("invalidSpecialCharacterErrorCode", "Invalid Characters");
        System.setProperty("invalidDateErrorCode", "Date is invalid");
        System.setProperty("dateMismatchErrorCode", "Format is invalid");
        System.setProperty("invalidCodeProductQuantity1", "API2001");
        System.setProperty("duplicateCodeProductCode", "API2003");
        System.setProperty("invalidCodeProductEntity", "API2002");
        System.setProperty("invalidProductQuantity1", "Product quantity is invalid");
        System.setProperty("duplicateProductCode", "Product code is duplicated");
        System.setProperty("invalidProductEntity", "Product entity is invalid");
        System.setProperty("productQuantityDesc", "This request allows specific product quantity only");
        System.setProperty("duplicateProductCodeDesc", "This request can't contain duplicated product code\n");
        System.setProperty("productEntityDesc", "This request allows same product entity only");

        // error desc
        System.setProperty("productQuantityDesc", "This request allows specific product quantity only");
        System.setProperty("duplicateProductCodeDesc", "This request can't contain duplicated product code");
        System.setProperty("productEntityDesc", "This request allows same product entity only");
        System.setProperty("invalidFileFormatErrorDesc", "This field allows specific file formats only");
        System.setProperty("blankErrorDesc", "The required information is unavailable");
        System.setProperty("datatypeErrorDesc", "This field allows <alphabets/numbers/alphanumeric characters> only");
        System.setProperty("lengthErrorDesc", "This field must be specific length only");
        System.setProperty("invalidValueErrorDesc", "This field must be a valid data");
        System.setProperty("invalidCharacterErrorDesc", "This field allows selected special characters only");
        System.setProperty("invalidDateValueErrorDesc", "This field can't be a date in the future");
        System.setProperty("strInvalidFormatErrorDesc", "This field allows specific formats only");
        System.setProperty("invalidYearMakeDesc", "This field allows a year within the previous or next 12 months only");





        System.setProperty(strCertKeyName, "myrhbeaimbsit.crt");


        System.setProperty(strTokenKeyName, "tokenKeyName");


        System.setProperty("vehicleTypeList", "{\"04040\": \"020\",\"04041\": \"020\",\"04042\": \"020\",\"04043\": \"020\"}");

        System.setProperty("statePostcode", "{\"80000\" : \"J\",\"80050\" : \"J\",\"80100\" : \"J\",\"80150\" : \"J\",\"80200\" : \"J\",\"80250\" : \"J\",\"80300\" : \"J\",\"80350\" : \"J\",\"80400\" : \"J\"}");

        System.setProperty("newPackageCarList", "{\"33051\": \"Alza\", \"33057\": \"Alza\", \"33058\": \"Alza\", \"33063\": \"Alza\", \"33064\": \"Alza\", \"33065\": \"Alza\", \"33066\": \"Alza\"}");

        System.setProperty("modelList", "04040,04041,04042,04043,04044,04045,04046,04047,04048,04049,04050");

        System.setProperty("vehicleMake", "{\"04040\" :\"0004\",\"04041\" :\"0004\",\"04042\" :\"0004\",\"04043\" :\"0004\",\"04044\" :\"0004\",\"04045\" :\"0004\"}");


        System.setProperty(strFlashErrorList, "{\"0110\": \"Invalid XML message\",\"0120\": \"Mandatory field cannot be blank\",\"0130\": \"Invalid field data-type\",\"0135\": \"Invalid field data length\",\"0140\": \"Duplicated process ID\",\"0141\": \"Internal DCMS DB error: unable to insert/update\",\"0150\": \"Internal DCMS error: Unable to trigger Async\",\"0205\": \"Internal DCMS error: Unable process Principal Customer\",\"0210\": \"Customer Inquiry Integration error\",\"0220\": \"Invalid Principal Customer field value\",\"0230\": \"Invalid Application field value\",\"0240\": \"Internal DCMS error: Unable to create Principal Customer\",\"0250\": \"Internal DCMS error: Unable to create Application\",\"0260\": \"Internal DCMS error: Unable to Create workflow\",\"0405\": \"Unable to process Joint Customer\",\"0410\": \"Joint customer inquiry Integration error\",\"0420\": \"Invalid Joint Customer field value\",\"0425\": \"Internal DCMS error: Unable to create Joint Customer\",\"0475\": \"Unable to process Collateral\",\"0480\": \"Invalid Collateral field value\",\"0490\": \"Internal DCMS error: Unable to Create Collateral\",\"0510\": \"Invalid Facility field value\",\"0520\": \"Internal DCMS error: Unable to Create Facility\",\"0600\": \"Unable to process CreditCheck\",\"0610\": \"CreditCheck - CCRIS integration error\",\"0612\": \"CreditCheck - CCRIS integration Failed\",\"0614\": \"CreditCheck - CTOS integration error\",\"0616\": \"CreditCheck - CTOS integration Failed\",\"0618\": \"CreditCheck - AML integration error\",\"0620\": \"CreditCheck - AML integration Failed\",\"0622\": \"CreditCheck - DCHEQS integration error\",\"0624\": \"CreditCheck - DCHEQS integration Failed\",\"0626\": \"CreditCheck - ConnParty integration error\",\"0628\": \"CreditCheck - ConnParty integration Failed\"},  {\"0630\": \"DSR Calculation Credit Check Failed\",\"0660\": \"CreditCheck - CDE integration error\",\"0662\": \"CreditCheck - CDE integration Failed\",\"0670\": \"Create and trigger Workflow AIP error\",\"0672\": \"Workflow AIP Failed\",\"0700\": \"Internal DCMS error: Unable to prepare AIP response\",\"0710\": \"Internal DCMS error: Unable to send AIP Result to MQ/Mobile\",\"0430\": \"Joint customer-2 inquiry Integration error\",\"0440\": \"Invalid Joint Customer-2 field value\",\"0445\": \"Internal DCMS error: Unable to create Joint Customer-2\",\"0530\": \"Invalid Facility-2 field value\",\"0540\": \"Internal DCMS error: Unable to Create Facility-2\",\"0550\": \"Invalid Facility-3 field value\",\"0560\": \"Internal DCMS error: Unable to Create Facility-3\",\"0160\": \"Invalid User Id / Password\",\"0099\": \"AIP Request received successfully\"}");


        System.setProperty("addressTypes", "O,P,R");

        System.setProperty("employmentSectorTypeList", "01,02,07,08,09,10");

        System.setProperty("employmentTypeMonthlyNetIncome", "01,02,07,08,09");

        System.setProperty("marketValueList", "U,UR,UN");

        System.setProperty("mobilePhoneNoAreaCodeList", "MK,MI");

        System.setProperty("entityList", "C,I");

        System.setProperty(strEmploymentTypeForAddress, "01,02,07,08,09");

        System.setProperty("defaultAreaCodeList", "004,005,006,007,008,009,010,012,013,014,015,016,017,018,019,080,604,605,606,607,608,609,673,680");

        System.setProperty("kLAreaCode", "002,003,011,065,602,603");

        System.setProperty("vehicleConditonList", "N,U,UN,UR,PR");

        System.setProperty("genderList", "F,M");

        System.setProperty("countryCode", "AF,AX,AL,DZ,AS,AD,AO,AI,AQ,AG,AR,AW,AM,AU,AT,AZ,BS,BH,BD,BB,BY,BE,BZ,BJ,BM,BT,BO,BA,BW,BV,BR,IO,BN,BG,BF,BI,KH,CM,CA,CV,KY,CF,TD,CL,CN,CX,CC,CO,KM,CG,CD,CK,CR,CI,HR,CU,CY,CZ,DK,DJ,DM,DO,TP,EC,EG,SV,GQ,ER,EE,ET,XE,FK,FO,FJ,FI,FR,GF,PF,TF,GA,GM,GE,DE,GH,GI,GB,GR,GL,GD,GP,GU,GT,GG,GN,GW,GY,HT,HM,VA,HN,HK,HU,IS,IN,ID,IR,IQ,IE,IM,IL,IT,JM,JP,JE,JO,KZ,KE,KI,KP,KR,KW,KG,LN,LA,LV,LB,LS,LR,LY,LI,LT,LU,MO,MK,MG,MW,MY,MV,ML,MT,MH,MQ,MR,MU,YT,MX,FM,MD,MC,MN,ME,MS,MA,MZ,MM,NA,NR,NP,NL,AN,NT,NC,NZ,NI,NE,NG,NU,NF,MP,NO,OM,OT,PK,PW,PS,PA,PZ,PG,PY,PE,PH,PN,PL,PT,PR,QA,RE,RO,RU,RW,GS,BL,SH,KN,LC,MF,PM,VC,WS,SM,ST,SA,SN,RS,SC,SL,SG,SK,SI,SB,SO,ZA,ES,LK,SD,SR,SJ,SZ,SE,CH,SY,TW,TJ,TZ,TH,TL,TG,TK,TO,TT,TN,TR,TM,TC,TV,UG,UA,AE,US,UY,UM,UZ,VU,VE,VN,VG,VI,WF,EH,YE,YU,ZR,ZM,ZW");

        System.setProperty("sourceOfFundList", "08,05,04,01,24,30,20,23,22,21,18,17,15,13,36,28,27,26,25,32,31,35,34,33");

        System.setProperty("computationModeList", "00,01,02,03,04,05,06,07,08,09,15,16");

        System.setProperty("idTypeList", "MK,MI");

        System.setProperty("preferredBranchList", "000,004,005,006,007,008,009,010,011,012,013,014,015,016,017,018,019,020,021,022,024,025,026,027,028,029,030,031,032,033,034,035,036,037,038,039,040,041,042,043,044,046,047,048,049,050,051,053,054,055,056,057,058,059,060,061,062,063,064,065,066,067,068,069,070,073,074,075,076,077,078,079,080,081,082,083,084,086,087,089,091,092,093,094,095,098,101,102,103,104,106,107,110,111,112,113,115,116,118,121,123,124,125,126,128,130,131,132,133,134,136,139,140,142,144,145,150,153,158,161,163,165,169,176,177,182,183,187,188,190,195,196,202,203,204,205,207,208,213,218,219,223,224,225,228,231,232,233,235,237,239,240,242,252,260,261,264,266,268,269,271,272,273,275,276,278,280,281,282,286,288,289,290,291,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,312,313,314,315,316,317,318,319,320,321,322,323,389,399,400,401,402,403,404,405,407,408,409,411,412,413,426,457,473,479,491,637,710,712,861,931,999764,A0001,V000");

        System.setProperty("subEmploymentSectorList", "0111,0112,0113,0174,0175,0212,0271,0321,0361,0362,0384,0401,0421,0422,0423,0425");

        System.setProperty("employmentSectorList", "0010,0020,0030,0040,0050,0060,0070,0080,0090,0100,0110,0120,0130,0140,0150,0160,0170,0180,0190,0200,0210,0220,0230,0240,0250,0260,0270,0280,0290,0300,0310,0320,0330,0340,0350,0360,0370,0380,0390,0400,0410,0420,0430,0440,0450");

        System.setProperty("occupationCodeList", "001,005,007,008,009,010,011,012,013,014,015,016,017,018,019,020,022,023,024,025,026,027,028,029,031,032,034,035,036,038,040,041,042,043,044,045,046,047,048,049,050,051,053,054,055,057,058,060,061,063,064,068,070,071,072,073,075,076,077,078,079,080,082,083,084,085,086,087,088,090,091,094,095,096,097,098,099,100,101,102,104,105,107,108,109,110,111,112,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,135,136,137,138,139,140,142,143,144,145,146,147,149,150,151,152,154,155,156,157,158,159,160,161,162,163,164,165,166,168,169,170,171,172,175,176,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366");

        System.setProperty("nationalMake", "0033,0032");

        System.setProperty("nonNationalMake", "0004,0042,0005,0006,0007,0008,0009,0010,0012,0013,0014,0015,0016,0001,0002,0003,0011,0019,0020,0021,0022,0023,0024,0025,0A12,0017,0068,0047,00A5,0073,0040,0A14,0070,0094,0044,0035,0081,0018,0031,0030,0043,0052,0027,0088,0055,0028,0029,0036,0034,0037,0038,0039,0041,0061,0064,0065,0066,0067,0069,0071,0072,0074,0089,0078,0084,0048,0049,0080,0075,0076,0077,0079,0082,0083,0085,0092,0093,0087,0086,0046,0050,0051,0054,0059,0099,0095,0045,0096,0098,00A2,00A1,00A3,00A8,00A9,00A4,00A6,00A7,0A11,0A17,0A16,");

        System.setProperty("raceList", "01,02,03,04,05");

        System.setProperty("usedPackageCarList", "{\"33146\" : \"Ativa\", \"33145\" : \"Ativa\", \"33144\" : \"Ativa\",\"33135\" : \"Aruz\", \"33136\" : \"Aruz\",\"32198\": \"X70\", \"32199\": \"X70\", \"32201\": \"X70\", \"32200\": \"X70\", \"32187\": \"X70\", \"32188\": \"X70\", \"32186\": \"X70\", \"32189\": \"X70\", \"32215\": \"X70\", \"32214\": \"X70\", \"32213\": \"X70\", \"32212\": \"X70\",\"32205\": \"X50\", \"32204\": \"X50\", \"32203\": \"X50\", \"32202\": \"X50\"},");

        System.setProperty("educationLevelList", "01,02,03,04,05,06");

        System.setProperty("maritalStatusList", "D,E,M,S,W");



        System.setProperty("employmentTypeList", "01,02,03,04,05,06,07,08,09,10");

        System.setProperty("employmentTypeForLength", "01,02,07,08,09,10");

        System.setProperty("vehicleCondtionRegDate", "U,UR,PR");

        System.setProperty("bdmList", "Y,N");

        System.setProperty(strEmploymentTypeForAddress, "01,02,07,08,09");

        System.setProperty("sourceOfWealthlist", "01,02,03,04,05,06,07,08,09,10,11");

        System.setProperty("residenceTypeList", "AFF,AFL,AFO,AFR");

        System.setProperty("mobilePhoneNoAreaCode", "010,011,012,013,014,015,016,017,018,019");

        System.setProperty("postCodeList", "80000,80050,80100,80150,80200,80250,80300,80350,80400,80500,80506,80508,80516,80519,80534,80536,80542,80546,80558,80560,80564,80568,80578,80584,80586,80590,80592,80594");

// default values

        System.setProperty("collateralType", "MV");


        System.setProperty("entityC", "C");


        System.setProperty("entityI", "I");


        System.setProperty("vehicleUsage", "P");


        System.setProperty("applicantType", "P");


        System.setProperty("staffCode", "01");


        System.setProperty("customerType", "I");


        System.setProperty("defaultValueY", "Y");


        System.setProperty("defaultValue06", "06");


        System.setProperty("defaultValue104", "104");



        System.setProperty("employmentTypeForMultiNationalComp", "01,02,07,08,09,10");



        System.setProperty("defaultValue0033", "0033");


        System.setProperty("defaultValue0032", "0032");


        System.setProperty("defaultValue087", "087");


        System.setProperty("defaultValue050", "050");


        System.setProperty("defaultValue05", "05");



        System.setProperty("defaultValue080", "080");



        System.setProperty("defaultValue04", "04");


        System.setProperty("defaultValueMK", "MK");


        System.setProperty("defaultValue03", "03");


        System.setProperty("defaultValueZero", "0");


        System.setProperty("defaultValueF", "F");


        System.setProperty("defaultValueU", "U");


        System.setProperty("defaultValueM", "M");


        System.setProperty("defaultValuePP", "PP");


        System.setProperty("defaultValueP", "P");


        System.setProperty("defaultValueO", "O");


        System.setProperty("defaultValueMI", "MI");


        System.setProperty("defaultValueR", "R");



        System.setProperty("nationalityMY", "MY");


        System.setProperty("purposeOfAccountOpening", "12");


        System.setProperty("applicationTypeAF", "AF");


        System.setProperty("sourceSystem", "04");


        System.setProperty("sourceId", "API");


        System.setProperty("extTrxnCd", "REAIDC05");


        System.setProperty("facilityTypeVal1", "HPFAC01");


        System.setProperty("facilityTypeVal2", "HPFAC04");


        System.setProperty("facilityPurposeDefaultVal", "PRI01AF");



        System.setProperty("defaultValue0WithDecimal", "0.00");


        System.setProperty("handlingFeeDefaultVal", "600.00");


        System.setProperty("defaultValueN", "N");


        System.setProperty("defaultValue01", "01");


        System.setProperty("defaultValuePR", "PR");



        System.setProperty("productValue", "AFI02");


        System.setProperty("length20", "20");


        System.setProperty("length2", "2");


        System.setProperty("length9", "9");

        System.setProperty("length12", "12");


        System.setProperty("length40", "40");

        System.setProperty("length5", "5");


        System.setProperty("length6", "6");


        System.setProperty("length4", "4");


        System.setProperty("length3", "3");


        System.setProperty("length70", "70");


        System.setProperty("length7", "7");


        System.setProperty("length8", "8");


        System.setProperty("length80", "80");


        System.setProperty("length50", "50");


        System.setProperty("length13", "13");



    }

    public AFAIPSubmissionRequestBody populateReqBodyValues() {
        AFAIPSubmissionRequestBody body = new AFAIPSubmissionRequestBody();
        body.setEntity("I");
        body.setPreferredBranch("000");
        body.setDealerName("Nurul nabilah binti");
        body.setCollateralInformation(populateCollateralInformation());
        body.setCustomerInformation(populateCustomerInfo());
        body.setFacilityInformation(populateFacilityInfo());
        return body;
    }

    List<AFFacilityInformation> populateFacilityInfo() {
        List<AFFacilityInformation> list = new ArrayList<>();
        AFFacilityInformation facilityInformation = new AFFacilityInformation();
        facilityInformation.setFinancingAmount(new BigDecimal("110000.00"));
        facilityInformation.setCashDownpayment(new BigDecimal("5000"));
        facilityInformation.setFacilityTenure(11);
        facilityInformation.setSourceOfFund("05");
        list.add(facilityInformation);
        return list;
    }

    List<AFFacilityInsuranceInformation> populateInsuranceInfo() {
        List<AFFacilityInsuranceInformation> list = new ArrayList<>();
        AFFacilityInsuranceInformation insuranceInformation = new AFFacilityInsuranceInformation();
        insuranceInformation.setCalculationdate(new Date());
        insuranceInformation.setInsuranceTakafulOperator("edg");
        insuranceInformation.setInsuranceTakafulType("fwg");
        insuranceInformation.setCoveredName("wge");
        insuranceInformation.setFinancingType("AF");
        insuranceInformation.setOriginalFinancingAmount(1200);
        insuranceInformation.setPercentageCoverage(1);
        insuranceInformation.setPeriodOfCover(1);
        insuranceInformation.setPremiumFinanced(1);
        insuranceInformation.setPrimaryIdNo("h");
        list.add(insuranceInformation);
        return list;
    }

    List<AFAddressInformation> populateAddressInfo() {
        List<AFAddressInformation> list = new ArrayList<>();
        AFAddressInformation addressInformation = new AFAddressInformation();
        addressInformation.setAddressLine1("No 4 jalan db 10");
        addressInformation.setAddressLine2("Tamang");
        addressInformation.setAddressLine3("New city");
        addressInformation.setAddressType("O");
        addressInformation.setCity("Puchong");
        addressInformation.setPostcode("80050");
        list.add(addressInformation);
        return list;
    }


    List<AFCollateralInformation> populateCollateralInformation() {
        List<AFCollateralInformation> list = new ArrayList<>();
        AFCollateralInformation collateralInformation = new AFCollateralInformation();
        /*collateralInformation.setMarketValue(1.00);
        collateralInformation.setPurchasePrice();
        */
        collateralInformation.setChassisNo("aegsada");
        collateralInformation.setEngineNo("ehasdeffde6");
        collateralInformation.setBdmMoreThan2500kg("Y");
        collateralInformation.setModelOfVehicle("04040");
        collateralInformation.setRegistrationNo("asdffsd");
        collateralInformation.setResgistrationDate(LocalDate.now());
        collateralInformation.setVehicleCondition("UR");
        collateralInformation.setYearMake(1990);
        collateralInformation.setPurchasePrice(new BigDecimal("50000.00"));
        collateralInformation.setMarketValue(new BigDecimal("50000.00"));
        list.add(collateralInformation);
        return list;
    }

    List<AFCustomerInformation> populateCustomerInfo() {
        List<AFCustomerInformation> list = new ArrayList<>();
        AFCustomerInformation customerInformation = new AFCustomerInformation();
        customerInformation.setCutomerName("Nurul nabilah binti ahmad shukri");
        customerInformation.setIdType("MK");
        customerInformation.setIdNo("901010123458");
        customerInformation.setMobilePhoneNo("1234567");
        customerInformation.setMobilePhoneNoAreaCode("018");
        customerInformation.setMonthlyGrossIncome(new BigDecimal("10000"));
        customerInformation.setMonthlyNetIncome(new BigDecimal("90000"));
        customerInformation.setForeignPR("Y");
        customerInformation.setPrIdNumber("123456789123");
        customerInformation.setDateOfBirth(LocalDate.of(1990,10,10));
        customerInformation.setDateJoined(LocalDate.of(2020,05,29));
        customerInformation.setRace("02");
        customerInformation.setNoOfDependants(2);
        customerInformation.setGender("F");
        customerInformation.setInternationalPhoneNo("0966766");
        customerInformation.setInternationalPhoneNoAreaCode("077");
        customerInformation.setInternationalExtensionPhoneNo("91");
        customerInformation.setEducationLevel("02");
        customerInformation.setMaritalStatus("M");
        customerInformation.setEmploymentType("01");
        customerInformation.setEmployerName("Hi");
        customerInformation.setOccupation("008");
        customerInformation.setEmploymentSector("0010");
        customerInformation.setSubEmploymentSector("0111");

        customerInformation.setEmail("abc@gmail.com");
        customerInformation.setComputationMode("00");
        customerInformation.setResidenceType("AFF");
        customerInformation.setCountryOfPermanentResident("MY");
        customerInformation.setSourceOfWealth("08");
        customerInformation.setAddressInformation(populateAddressInfo());
        list.add(customerInformation);
        return list;

    }

    @Autowired
    AFSubmissionService service;
    List<AFSubmissionResHeader> expectedList = new ArrayList<>();

    @Test
    @DisplayName(" EducationLevel is Null: throws error- [API1002 - Mandatory field ( EducationLevel) cannot be blank ]")
    void inValidEducationLevelNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("educationLevel");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEducationLevel("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" EducationLevel with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidEducationLevelType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("educationLevel");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEducationLevel("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" EducationLevel with invalid length: throws error- [API1004 - Invalid data field( EducationLevel) length]")
    void inValidEducationLevelLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("educationLevel");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEducationLevel("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" EducationLevel with invalid value: throws error- [API1005 - Invalid field( EducationLevel) value]")
    void inValidEducationLevelInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("educationLevel");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEducationLevel("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SourceOfWealth is Null: throws error- [API1002 - Mandatory field ( SourceOfWealth) cannot be blank ]")
    void inValidSourceOfWealthNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("sourceOfWealth");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSourceOfWealth("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
       // Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SourceOfWealth with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidSourceOfWealthType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("sourceOfWealth");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSourceOfWealth("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SourceOfWealth with invalid length: throws error- [API1004 - Invalid data field( SourceOfWealth) length]")
    void inValidSourceOfWealthLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("sourceOfWealth");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSourceOfWealth("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SourceOfWealth with invalid value: throws error- [API1005 - Invalid field( SourceOfWealth) value]")
    void inValidSourceOfWealthInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("sourceOfWealth");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSourceOfWealth("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SubEmploymentSector is Null: throws error- [API1002 - Mandatory field ( SubEmploymentSector) cannot be blank ]")
    void inValidSubEmploymentSectorNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("subEmploymentSector");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSubEmploymentSector("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SubEmploymentSector with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidSubEmploymentSectorType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("subEmploymentSector");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSubEmploymentSector("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SubEmploymentSector with invalid length: throws error- [API1004 - Invalid data field( SubEmploymentSector) length]")
    void inValidSubEmploymentSectorLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("subEmploymentSector");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSubEmploymentSector("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" SubEmploymentSector with invalid value: throws error- [API1005 - Invalid field( SubEmploymentSector) value]")
    void inValidSubEmploymentSectorInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("subEmploymentSector");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setSubEmploymentSector("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" PrIdNumber is Null: throws error- [API1002 - Mandatory field ( PrIdNumber) cannot be blank ]")
    void inValidPrIdNumberNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("pRIDNo");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setPrIdNumber("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" PrIdNumber with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidPrIdNumberType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("pRIDNo");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setPrIdNumber("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" PrIdNumber with invalid length: throws error- [API1004 - Invalid data field( PrIdNumber) length]")
    void inValidPrIdNumberLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("pRIDNo");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setPrIdNumber("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }



    @Test
    @DisplayName(" Race is Null: throws error- [API1002 - Mandatory field ( Race) cannot be blank ]")
    void inValidRaceNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("race");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setRace("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Race with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidRaceType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("race");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setRace("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Race with invalid length: throws error- [API1004 - Invalid data field( Race) length]")
    void inValidRaceLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("race");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setRace("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Race with invalid value: throws error- [API1005 - Invalid field( Race) value]")
    void inValidRaceInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("race");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setRace("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" ResidenceType is Null: throws error- [API1002 - Mandatory field ( ResidenceType) cannot be blank ]")
    void inValidResidenceTypeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("residenceType");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setResidenceType("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" ResidenceType with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidResidenceTypeType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("residenceType");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setResidenceType("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" ResidenceType with invalid length: throws error- [API1004 - Invalid data field( ResidenceType) length]")
    void inValidResidenceTypeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("residenceType");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setResidenceType("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" ResidenceType with invalid value: throws error- [API1005 - Invalid field( ResidenceType) value]")
    void inValidResidenceTypeInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("residenceType");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setResidenceType("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Occupation is Null: throws error- [API1002 - Mandatory field ( Occupation) cannot be blank ]")
    void inValidOccupationNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("occupation");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setOccupation("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Occupation with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidOccupationType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("occupation");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setOccupation("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Occupation with invalid length: throws error- [API1004 - Invalid data field( Occupation) length]")
    void inValidOccupationLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("occupation");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setOccupation("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Occupation with invalid value: throws error- [API1005 - Invalid field( Occupation) value]")
    void inValidOccupationInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("occupation");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setOccupation("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }
    @Test
    @DisplayName("MonthlyGrossIncome is Null : throws error - [API1002 - Mandatory field (monthlyGrossIncome) cannot be blank]")
    void inValidMonthlyGrossIncomeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("monthlyGrossIncome");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setMonthlyGrossIncome(null);
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Invalid MonthlyGrossIncome length  : throws error - [API1004 - Invalid data field (monthlyGrossIncome) length]")
    void inValidMonthlyGrossIncomeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("monthlyGrossIncome");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setMonthlyGrossIncome(new BigDecimal("4000000000.0099"));
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MonthlyNetIncome is Null : throws error - [API1002 - Mandatory field (monthlyNetIncome) cannot be blank]")
    void inValidMonthlyNetIncomeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("monthlyNetIncome");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setMonthlyNetIncome(null);
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Invalid MonthlyNetIncome length  : throws error - [API1004 - Invalid data field (monthlyNetIncome) length]")
    void inValidMonthlyNetIncomeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("monthlyNetIncome");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setMonthlyNetIncome(new BigDecimal("4000000000.0099"));
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("MaritalStatus is Null: throws error- [API1002 - Mandatory field (MaritalStatus) cannot be blank ]")
    void inValidMaritalStatusNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("maritalStatus");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMaritalStatus("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MaritalStatus with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidMaritalStatusType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("maritalStatus");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMaritalStatus("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MaritalStatus with invalid length: throws error- [API1004 - Invalid data field( MaritalStatus) length]")
    void inValidMaritalStatusLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("maritalStatus");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMaritalStatus("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MaritalStatus with invalid value: throws error- [API1005 - Invalid field(MaritalStatus) value]")
    void inValidMaritalStatusInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("maritalStatus");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMaritalStatus("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNo is Null: throws error- [API1002 - Mandatory field (MobilePhoneNo) cannot be blank ]")
    void inValidMobilePhoneNoNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("mobilePhoneNo");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNo("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNo with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidMobilePhoneNoType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("mobilePhoneNo");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNo("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNo with invalid length: throws error- [API1004 - Invalid data field( MobilePhoneNo) length]")
    void inValidMobilePhoneNoLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("mobilePhoneNo");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNo("12346678900877553");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNo with invalid value: throws error- [API1005 - Invalid field(MobilePhoneNo) value]")
    void inValidMobilePhoneNoInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("mobilePhoneNo");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNo("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNoAreaCode is Null: throws error- [API1002 - Mandatory field (MobilePhoneNoAreaCode) cannot be blank ]")
    void inValidMobilePhoneNoAreaCodeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("mobilePhoneNoAreaCode");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNoAreaCode("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNoAreaCode with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidMobilePhoneNoAreaCodeType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("mobilePhoneNoAreaCode");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNoAreaCode("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNoAreaCode with invalid length: throws error- [API1004 - Invalid data field( MobilePhoneNoAreaCode) length]")
    void inValidMobilePhoneNoAreaCodeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("mobilePhoneNoAreaCode");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNoAreaCode("44554");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("MobilePhoneNoAreaCode with invalid value: throws error- [API1005 - Invalid field(MobilePhoneNoAreaCode) value]")
    void inValidMobilePhoneNoAreaCodeInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("mobilePhoneNoAreaCode");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setMobilePhoneNoAreaCode("242");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Gender with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidGenderType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("gender");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setGender("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Gender with invalid length: throws error- [API1004 - Invalid data field(Gender) length]")
    void inValidGenderLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("gender");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setGender("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Gender with invalid value: throws error- [API1005 - Invalid field(Gender) alue]")
    void inValidGenderInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("gender");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setGender("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" EmploymentSector is Null: throws error- [API1002 - Mandatory field ( EmploymentSector) cannot be blank ]")
    void inValidEmploymentSectorNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("employmentSector");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentSector("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" EmploymentSector with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidEmploymentSectorType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("employmentSector");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentSector("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" EmploymentSector with invalid length: throws error- [API1004 - Invalid data field( EmploymentSector) length]")
    void inValidEmploymentSectorLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("employmentSector");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentSector("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName(" EmploymentSector with invalid value: throws error- [API1005 - Invalid field( EmploymentSector) value]")
    void inValidEmploymentSectorInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("employmentSector");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentSector("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("EmploymentType is Null: throws error- [API1002 - Mandatory field (EmploymentType) cannot be blank ]")
    void inValidEmploymentTypeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("employmentType");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentType("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("EmploymentType with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidEmploymentTypeType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("employmentType");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentType("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("EmploymentType with invalid length: throws error- [API1004 - Invalid data field(EmploymentType) length]")
    void inValidEmploymentTypeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("employmentType");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentType("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("EmploymentType with invalid value: throws error- [API1005 - Invalid field(EmploymentType) value]")
    void inValidEmploymentTypeInvalid() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("employmentType");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmploymentType("tty");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Foreign PR is null : throws error- [API1002 - Mandatory field cannot (foreignPR) be blank]")
    void inValidForeignPRNull() {
        List<AFSubmissionResHeader> expectedList = new ArrayList<>();
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("foreignPR");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setForeignPR("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Foreign PR is invalid : throws error - [API1005 - Invalid Field (foreignPR) Value]")
    void inValidForeignPR() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setForeignPR("MKk");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        List<AFSubmissionResHeader> expectedList = new ArrayList<>();
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("foreignPR");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("ForeignPR with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidForeignPRType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("foreignPR");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setForeignPR("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("ForeignPR with invalid length: throws error- [API1004 - Invalid data field(ForeignPR) length]")
    void inValidForeignPRLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("foreignPR");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setForeignPR("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("RegistrationDate is Null: throws error- [API1002 - Mandatory field (RegistrationDate) cannot be blank ]")
    void inValidRegistrationDateNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("registrationDate");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setResgistrationDate(null);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("RegistrationDate with future date value: throws error- [API1011 - Invalid Date Value]")
    void inValidRegistrationDateFuture() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("futureDateErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidDateErrorCode"));
        messageList.setErrorTag("registrationDate");
        messageList.setErrorDesc(System.getProperty("invalidDateValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setResgistrationDate(LocalDate.of(2023, 8,26));
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("RegistrationNo is Null: throws error- [API1002 - Mandatory field(RegistrationNo) cannot be blank]")
    void inValidRegistrationNoNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("registrationNo");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setRegistrationNo("");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("RegistrationNo with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidRegistrationNoType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("registrationNo");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setRegistrationNo("202012yg@#$%31");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("RegistrationNo with invalid length: throws error- [API1004 - Invalid data field (RegistrationNo) length]")
    void inValidRegistrationNoLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("registrationNo");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setRegistrationNo("202012yhhddhfhfhhfhfhfjhfjhgsdfdjg764");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("EngineNo is Null when vehicleCondition = Used: throws error- [API1002 - Mandatory field (EngineNo) cannot be blank ]")
    void inValidEngineNoNoNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("EngineNo");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setEngineNo(null);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("EngineNo with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidEngineNoType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("EngineNo");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setEngineNo("202012yg@#$%31");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("EngineNo with invalid length: throws error- [API1004 - Invalid data field(EngineNo) length]")
    void inValidEngineNoLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("EngineNo");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setEngineNo("U272726365487484874787837763467");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }
    @Test
    @DisplayName("ChassisNo with invalid length: throws error- [API1004 - Invalid data field(ChassisNo) length]")
    void inValidChassisNoLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("chassisNo");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setChassisNo("U272726365487484874787837763467");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }
    @Test
    @DisplayName("ChassisNo is Null when vehicleCondition = Used: throws error- [API1002 - Mandatory field (ChassisNo) cannot be blank ]")
    void inValidChassisNoNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("chassisNo");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setChassisNo(null);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("ChassisNo with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidChassisNoType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("chassisNo");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setChassisNo("202012yg@#$%31");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }
    @Test
    @DisplayName("YearMake is Null when vehicleCondition = Used: throws error- [API1002 - Mandatory field (YearMake) cannot be blank ]")
    void inValidYearMakeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("yearMake");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("U");
        collateralInformation.get(0).setYearMake(null);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("YearMake is Null when vehicleCondition = Pre registered: throws error- [API1002 - Mandatory field (YearMake) cannot be blank ]")
    void inValidYearMakeNullTwo() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("yearMake");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("PR");
        collateralInformation.get(0).setYearMake(null);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("YearMake with invalid length: throws error- [API1004 - Invalid data field (YearMake) length]")
    void inValidYearMakeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("yearMake");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("PR");
        collateralInformation.get(0).setYearMake(12345);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("YearMake with future year: throws error- [API1011 - Invalid Date (YearMake) Value]")
    void inValidYearMakeValue() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidYearMakeCode"));
        messageList.setErrorMessage(System.getProperty("invalidYearMakeMsg"));
        messageList.setErrorTag("yearMake");
        messageList.setErrorDesc(System.getProperty("invalidYearMakeDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("PR");
        collateralInformation.get(0).setYearMake(2040);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Vehicle Condition is Invalid: throws error- [API1005 - Invalid Field (vehicleCondition) Value]")
    void inValidVehicleConditionValue() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("vehicleCondition");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));;
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("PP");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Vehicle Condition is null: throws error- [API1002 - Mandatory field (vehicleCondition) cannot be blank]")
    void inValidVehicleConditionNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("vehicleCondition");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));

    }

    @Test
    @DisplayName("Vehicle Condition with invalid characters: throws error- [API1006 - Invalid Characters (vehicleCondition)]")
    void inValidVehicleConditionType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("vehicleCondition");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("@#$%^^");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Vehicle Condition with invalid length: throws error- [API1004 - Invalid data field (vehicleCondition) length]")
    void inValidVehicleConditionLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("vehicleCondition");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setVehicleCondition("faggabagafvabhshssggsgsfvssg");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("BDM More than 2500 KG value is invalid : throws error- [API1005 - Invalid Field (bdmMoreThan2500kg) Value]")
    void inValidBDM() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("bdmMoreThan2500kg");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setBdmMoreThan2500kg("AA");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("BDM More than 2500 KG value contains invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidBDMType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("bdmMoreThan2500kg");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setBdmMoreThan2500kg("@#$%%^&**");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("BDM More than 2500 KG value with invalid length: throws error- [API1004 - Invalid data field(bdmMoreThan2500kg) length]")
    void inValidBDMLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("bdmMoreThan2500kg");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setBdmMoreThan2500kg("gtgsgsgsgsggbgshshhgsggsfgsggsg");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("BDM More than 2500 KG value is null : throws error- [API1002 - Mandatory field (bdmMoreThan2500kg) cannot be blank]")
    void inValidBDMNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("bdmMoreThan2500kg");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setBdmMoreThan2500kg("");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Financing amount is Null : throws error - [API1002 - Mandatory field (financingAmount) cannot be blank]")
    void inValidFinancingAmtNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("financingAmount");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setFinancingAmount(null);
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName(" Financing amount value with above maximum value : throws error - [API1005 - Invalid Field (financingAmount) Value]")
    void inValidFinancingAmtValue() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("financingAmount");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setFinancingAmount(BigDecimal.valueOf(99999999.99));
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName(" Financing amount value with below minimum value : throws error - [API1005 - Invalid Field (financingAmount) Value]")
    void inValidFinancingAmtMinValue() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("financingAmount");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setFinancingAmount(BigDecimal.valueOf(0345));
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Invalid Financing amount length  : throws error - [API1004 - Invalid data field (financingAmount) length]")
    void inValidFinancingAmtLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("financingAmount");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setFinancingAmount(BigDecimal.valueOf(4000000000.0099));
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Source Of Fund is Null or blank : throws error - [API1002 - Mandatory field (SourceOfFund) cannot be blank]")
    void inValidSourceOfFundNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("sourceOfFund");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setSourceOfFund(null);
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Source Of Fund with invalid characters : throws error - [API1006 - Invalid Characters (SourceOfFund)]")
    void inValidSourceOfFundType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("sourceOfFund");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setSourceOfFund("@#rth%");
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Source Of Fund with invalid value : throws error - [API1006 - Invalid Characters (SourceOfFund)]")
    void inValidSourceOfFundVlaue() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("sourceOfFund");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setSourceOfFund("88");
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Source Of Fund with invalid length : throws error - [API1004 - Invalid data field (SourceOfFund) length ]")
    void inValidSourceOfFundLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("sourceOfFund");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setSourceOfFund("8jdjdjdjdjdjdnnfjfjfj9949494994998");
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Market Value is Null : throws error - [API1002 - Mandatory field (marketValue) cannot be blank]")
    void inValidMarketValueNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("marketValue");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setMarketValue(null);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Invalid Market Value Length : throws error - [API1004 - Invalid data field (marketValue) length]")
    void inValidMarketValueLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("marketValue");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setMarketValue(new BigDecimal("12345678901234.0000"));
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Purchase Price(OTR) is Null: throws error - [API1002 - Mandatory field (purchasePriceOTR) cannot be blank]")
    void inValidPurchasePriceNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("purchasePriceOTR");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setPurchasePrice(null);
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Invalid Purchase Price(OTR) Length: throws error - [API1004 - Invalid data field (purchasePriceOTR) length]")
    void inValidPurchasePriceLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("purchasePriceOTR");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setPurchasePrice(new BigDecimal("234445.000"));
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("CashDownPayment is Null : throws error - [API1002 - Mandatory field (cashDownpayment) cannot be blank]")
    void inValidCashDownPaymentNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("downpayment");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setCashDownpayment(null);
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("CashDownPayment with invalid length : throws error - [API1004 - Invalid data field (cashDownpayment) length]")
    void inValidCashDownPaymentLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("downpayment");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setCashDownpayment(new BigDecimal(1234.9999));
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }



    @Test
    @DisplayName("Model of Vehicle is null : throws error - [API1002 - Mandatory field (modelOfVehicle) cannot be blank]")
    void inValidModelNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("modelOfVehicle");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setModelOfVehicle("");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Model is Invalid : throws error - [API1005 - Invalid Field (modelOfVehicle) Value]")
    void inValidModel() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("modelOfVehicle");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));;
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setModelOfVehicle("040");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Model with Invalid characters: throws error - [API1006 - Invalid Characters (modelOfVehicle)]")
    void inValidModelType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("modelOfVehicle");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setModelOfVehicle("@#$%^&");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Model with Invalid length: throws error - [API1004 - Invalid data field (modelOfVehicle) length]")
    void inValidModelLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("modelOfVehicle");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCollateralInformation> collateralInformation = populateCollateralInformation();
        collateralInformation.get(0).setModelOfVehicle("19181816616161651516672929");
        body.setCollateralInformation(collateralInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }





    @Test
    @DisplayName("Country of Permanent Resident is Null when <Foreign PR> = “Yes” : throws error - [API1002 - Mandatory field (countryOfPermanentResident) cannot be blank]")
    void inValidCountryPermanentResNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("countryOfPermanentResident");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setCountryOfPermanentResident("");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("NoOfDependants is Null : throws error - [API1002 - Mandatory field (noOfDependants) cannot be blank]")
    void inValidNoOfDependantsNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("noOfDependants");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setNoOfDependants(null);
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Invalid NoOfDependants Length : throws error - [API1004 - Invalid data field (noOfDependants) length]")
    void inValidNoOfDependantsLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("noOfDependants");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setNoOfDependants(13244);
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Country of Permanent Resident is Invalid : throws error - [API1005 - Invalid Field (countryOfPermanentResident) Value]")
    void inValidCountryPermanentRes() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("countryOfPermanentResident");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setCountryOfPermanentResident("Xy");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Country of Permanent Resident with Invalid Characters : throws error - [API1006 - Invalid Characters]")
    void inValidCountryPermanentResType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("countryOfPermanentResident");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setCountryOfPermanentResident("@#$%^");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Country of Permanent Resident with invalid length : throws error - [API1004 - Invalid data field (countryOfPermanentResident) length]")
    void inValidCountryOfPermanentResLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("countryOfPermanentResident");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setCountryOfPermanentResident("hjsjhjsjsjsjjnxzxnbxnbnxnbksksajsajshjhjsasdhjdshjhdfhdjdjjhsdhjdshjshdjjhshjshj");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("ComputationMode is Invalid : throws error - [API1005 - Invalid Field (computationMode) Value ]")
    void inValidComputationMode() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("computationMode");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setComputationMode("17");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }
    @Test
    @DisplayName("ComputationMode is Null : throws error - [API1002 - Mandatory field (computationMode) cannot be blank]")
    void inValidComputationModeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("computationMode");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setComputationMode("");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }
    @Test
    @DisplayName("ComputationMode with invalid length : throws error - [API1004 - Invalid data field (computationMode) length]")
    void inValidComputationModeLength() {
    populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("computationMode");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setComputationMode("hjsdhjdshjhdfhdjdjjhsdhjdshjshdjjhshjshj");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
}


    @Test
    @DisplayName("ComputationMode with invalid characters : throws error - [API1006 - Invalid Characters]")
    void inValidComputationModeType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("computationMode");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setComputationMode("@#$%^&jhshjshj");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Entity is Null Or blank : throws error - [API1002 - Mandatory field (entity) cannot be blank]")
    void inValidEntityNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("entity");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setEntity("");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Entity with invalid length : throws error - [API1002 - Mandatory field (entity) cannot be blank]")
    void inValidEntityLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("entity");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setEntity("qertyiopsghjksfsgsgfsghsshshgdffds");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Entity is invalid : throws error - [API1005 - Invalid Field (entity) Value]")
    void inValidEntity() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("entity");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setEntity("M");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Entity with Invalid characters : throws error - [API1006 - Invalid Characters]")
    void inValidEntityCharacter() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("entity");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setEntity("abc01@@#$");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Preferred Branch is Null : throws error - [API1002 - Mandatory field (preferred branch) cannot be blank]")
    void inValidPreferredBranchNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("preferredBranch");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setPreferredBranch("");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Preferred Branch is Invalid : throws error - [API1005 - Invalid Field (preferred branch) Value]")
    void inValidPreferredBranch() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("preferredBranch");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setPreferredBranch("abc01");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Preferred Branch with Invalid characters : throws error - [API1006 - Invalid Characters]")
    void inValidPreferredBranchCharacter() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("preferredBranch");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setPreferredBranch("abc01@@#$");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Preferred Branch with Invalid length : throws error - [API1004 - Invalid data field length]")
    void inValidPreferredBranchLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("preferredBranch");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setPreferredBranch("abc01hsgsgtsysysus8djdjjdjgdgdhh");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Dealer Name is Null : throws error - [API1002 - Mandatory field (Dealer name) cannot be blank]")
    void inValidDealerNameNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("dealerName");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setDealerName("");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Dealer Name Length is Invalid : throws error - [API1004 - Invalid data (Dealer name) field length]")
    void inValidDealerNameLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("dealerName");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setDealerName("sdafafsdgfdfhfhjghgghjg");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Dealer Name Length is Invalid : throws error - [API1004 - Invalid data (Dealer name) field length]")
    void inValidDealerNameCharacter() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("dealerName");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        body.setDealerName("sdafafsdgf@@$%^");
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("DateJoined with future date: throws error- [API1011- Invalid Date Value]")
    void inValidDateJoinedRange() {
        List<AFSubmissionResHeader> expectedList = new ArrayList<>();
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("futureDateErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidDateErrorCode"));
        messageList.setErrorTag("dateJoined");
        messageList.setErrorDesc(System.getProperty("invalidDateValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setDateJoined(LocalDate.of(2023, 10,26));
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("DateOfBirth with future date: throws error- [API1011- Invalid Date Value]")
    void inValidDateOfBirthRange() {
        List<AFSubmissionResHeader> expectedList = new ArrayList<>();
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("futureDateErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidDateErrorCode"));
        messageList.setErrorTag("dateOfBirth");
        messageList.setErrorDesc(System.getProperty("invalidDateValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setDateOfBirth(LocalDate.of(2024,8,22));
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Customer Name is null : throws error- [API1002 - Mandatory field (Customer name) cannot be blank]")
    void inValidCustomerNameNull() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setCutomerName("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("customerName");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Invalid Customer Name length : throws error- [API1004 - Invalid data (Customer name) field length]")
    void inValidCustomerNameLength() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setCutomerName("aS");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("customerName");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer Name with Invalid Characters : throws error- [API1006 - Invalid Characters]")
    void inValidCustomerNameType() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setCutomerName("|");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("customerName");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Employer Name is null : throws error- [API1002 - Mandatory field (EmployerName) cannot be blank]")
    void inValidEmployerNameNull() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmployerName("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("employerName");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Invalid Employer Name length : throws error- [API1004 - Invalid data (EmployerName) field length]")
    void inValidEmployerNameLength() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmployerName("auhsdhhdhdshjhjsdjhhjsdhjjhsdjhjhjhsduhsduhsdgghhgdhgshgshgshgshghgxdhghgsjhjhsdhjhjS");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("employerName");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Employer Name with Invalid Characters : throws error- [API1006 - Invalid Characters]")
    void inValidEmployerNameType() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setEmployerName("|");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("employerName");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("AF Submission ID is Null : throws error - [API1002 - Mandatory field(ID NO) cannot be blank]")
    void inValidAFSubmissionIdNull() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdNo("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("idNo");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

  
    
    @Test
    @DisplayName("AF Submission ID is Invalid : throws error - [API1005 - Invalid Field(ID NO) value]")
    void inValidAFSubmissionId() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdNo("987654326785");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("idNo");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("AF Submission ID Invalid Length : throws error - [API1004 - Invalid data field(ID NO) length]")
    void inValidAFSubmissionIdLength() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdNo("12347878766655678945667");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("idNo");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("AF Submission ID with Invalid Characters: throws error - [API1006 - Invalid Characters]")
    void inValidIdnoType() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdNo("@@@");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("dataTypeErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidDataTypeErrorCode"));
        messageList.setErrorTag("idNo");
        messageList.setErrorDesc(System.getProperty("datatypeErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("AF Submission ID type Invalid Null : throws error - [API1002 - Mandatory field(ID Type) cannot be blank]")
    void inValidAFSubmissionIdTypeNull() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdType("");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("idType");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("AF Submission ID type Invalid  : throws error - [API1005 - Invalid Field(ID Type) value]")
    void inValidAFSubmissionIdType() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdType("sdfssgfghgfhfdfg");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("idType");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("IDType with invalid characters: throws error- [API1006 - Invalid Characters]")
    void inValidIdTypeType() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("idType");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdType("@@%^&&");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("IDType with invalid length: throws error- [API1004 - Invalid data field(IdType) length]")
    void inValidIdTypeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("idType");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> customerInformation = populateCustomerInfo();
        customerInformation.get(0).setIdType("ahjshbjshdfhgjjsjh478478477863776jhbdjhdfjhjhjhhf897487847");
        body.setCustomerInformation(customerInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Customer City Null : throws error - [API1002 - Mandatory field(city) cannot be blank]")
    void inValidCustomerCityNull() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setCity("");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("city");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("blankErrorDesc"));

        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer City with Invalid Characters: throws error - [API1006 - Invalid Characters]")
    void inValidCustomerCity() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setCity("%S=@gk.com");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("city");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Customer City Invalid : throws error - [API1004 - Invalid data (city) field length]")
    void inValidCustomerCityLength() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setCity("asdfggfdhghfhjgjadfgasdfasdfalkasdfhawuerfhriewfaiuhefrjiuhegvsdakjbaskJhkvcas");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("City");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer Address1 Null : throws error - [API1002 - Mandatory field(Address Line 1) cannot be blank]")
    void inValidCustomerAddress1Null() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressLine1("");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("Address1");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer Address1 with Invalid characters: throws error - [API1006 - Invalid Characters]")
    void inValidCustomerAddress1Type() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressLine1("%S=:|");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("Address1");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer Address2 with Invalid Characters : throws error - [API1006 - Invalid Characters]")
    void inValidCustomerAddress2Type() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressLine2("%S=|");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("address2");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer Address1 Invalid Length: throws error - [API1004 - Invalid data (address1) field length]")
    void inValidCustomerAddress1Length() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        addressInformation.get(0).getAddressInformation().get(0).setAddressLine1("asdfggfdhghfhjgjsadfsdggfdgfdghghghgsadfdascfZXasdfdsavcasdfasdcxZSDFCasdfsafdas");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("Address1");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer Address2 Invalid Length: throws error - [API1004 - Invalid data (address2) field length]")
    void inValidCustomerAddress2Length() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressLine2("asdfggfdhghfhjgjsadfsdggfdgfdghghghgsadfdascfZXasdfdsavcasdfasdcxZSDFCasdfsafdas");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("address2");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Customer Address3 with Invalid Characters : throws error - [API1006 - Invalid Characters]")
    void inValidCustomerAddress3Type() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressLine3("%S=|");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("addressLine3");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Customer Address3 Invalid Length: throws error - [API1004 - Invalid data (address1) field length]")
    void inValidCustomerAddress3Length() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues();
        List<AFAddressInformation> addressInformations =body.getCustomerInformation().get(0).getAddressInformation();
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressLine3("asdfggfdhghfhjgjsadfsdggfdgfdghghghgsadfdascfZXasdfdsavcasdfasdcxZSDFCasdfsafdas");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("addressLine3");
        messageList.setErrorDesc(addressInformations.get(0).getAddressType() + "-" + System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }




    @Test
    @DisplayName("Invalid Email Id : throws error - [API1007 - Invalid Format]")
    void inValidEmail() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setEmail("asdasfdsfgf");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidFormatErrorCode"));
        messageList.setErrorMessage(System.getProperty("dateMismatchErrorCode"));
        messageList.setErrorTag("email");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Invalid Email Id Length : throws error - [API1004 - Invalid data (email) field length]")
    void inValidEmailLength() {
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> contactInformation = populateCustomerInfo();
        contactInformation.get(0).setEmail("asdasfdsfgfdasffgdfsggfhaasdasasdfadfadasfsfadasfafassadassddfadfadsf@gk.com");
        body.setCustomerInformation(contactInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("email");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }



    @Test
    @DisplayName("facilityTenure is null : throws error - [API1002 - Mandatory field(facilityTenureYears) cannot be blank]")
    void inValidFacilityTenureNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("facilityTenureYears");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setFacilityTenure(null);
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("facilityTenure Invalid Length : throws error - [API1004 - Invalid data (facilityTenure) field length]")
    void inValidFacilityTenureLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("facilityTenureYears");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFFacilityInformation> facilityInformation = populateFacilityInfo();
        facilityInformation.get(0).setFacilityTenure(12345);
        body.setFacilityInformation(facilityInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }


    @Test
    @DisplayName("Customer Address Type is Blank : throws error - [API1002 - Mandatory field(Address Type) cannot be blank]")
    void inValidCustomerAddressTypeNull() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("blankErrorCode"));
        messageList.setErrorMessage(System.getProperty("blankCheckErrorCode"));
        messageList.setErrorTag("AddressType");
        messageList.setErrorDesc(System.getProperty("blankErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressType("");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Invalid Address Type  : throws error - [API1005 - Invalid Field(Address Type) value]")
    void inValidCustomerAddressTypeValue() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("invalidErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidFieldValueErrorCode"));
        messageList.setErrorTag("AddressType");
        messageList.setErrorDesc(System.getProperty("invalidValueErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressType("hahsggsghsh");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Address Type with Invalid characters : throws error - [API1006 - Invalid Characters]")
    void inValidCustomerAddressTypeCharacter() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("specialCharacterErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidSpecialCharacterErrorCode"));
        messageList.setErrorTag("AddressType");
        messageList.setErrorDesc(System.getProperty("invalidCharacterErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressType("@#$%^&");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }

    @Test
    @DisplayName("Address Type with Invalid length : throws error - [API1004 - Invalid data field length]")
    void inValidCustomerAddressTypeLength() {
        populateValues();
AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        messageList.setErrorCode(System.getProperty("lengthErrorCode"));
        messageList.setErrorMessage(System.getProperty("invalidLengthErrorCode"));
        messageList.setErrorTag("AddressType");
        messageList.setErrorDesc(System.getProperty("lengthErrorDesc"));
        expectedList.add(messageList);
        AFAIPSubmissionRequestBody body = populateReqBodyValues(); 
        List<AFCustomerInformation> addressInformation = populateCustomerInfo();
        addressInformation.get(0).getAddressInformation().get(0).setAddressType("gagghgsdhdhjhsjdjhdhjhdjdjjjhfj");
        body.setCustomerInformation(addressInformation);
        AFSubmitRequest request = new AFSubmitRequest();
        request.setBody(body);
        Assertions.assertEquals(expectedList.get(0), Objects.requireNonNull(service.afSubmitRequest(body, "abc@gmail.com").getBody()).getHeader().get(0));
    }
}

