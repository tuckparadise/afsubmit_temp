package com.rhb.api.utilities;

import com.rhb.api.configuration.GetParameter;
import com.rhb.api.models.*;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.Year;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.rhb.api.models.AFSubmissionResHeader;

import java.math.BigDecimal;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.apache.commons.lang3.StringUtils;

@Component
public class AfValidators {


    private static final Log LOG = LogFactory.getLog(AfValidators.class);
    String blankErrorCode = "blankErrorCode";
    String blankCheckErrorCode = "blankCheckErrorCode";
    String blankErrorDesc = "blankErrorDesc";
    String dataTypeErrorCode = "dataTypeErrorCode";
    String invalidDateValueErrorDesc = "invalidDateValueErrorDesc";
    String invalidDataTypeErrorCode = "invalidDataTypeErrorCode";
    String datatypeErrorDesc = "datatypeErrorDesc";
    String lengthErrorCode ="lengthErrorCode";
    String invalidLengthErrorCode = "invalidLengthErrorCode";
    String lengthErrorDesc = "lengthErrorDesc";
    String invalidYearMakeCode = "invalidYearMakeCode";
    String invalidYearMakeMsg = "invalidYearMakeMsg";
    String invalidYearMakeDesc = "invalidYearMakeDesc";
    String specialCharacterErrorCode ="specialCharacterErrorCode";
    String invalidSpecialCharacterErrorCode = "invalidSpecialCharacterErrorCode";
    String futureDateErrorCode = "futureDateErrorCode";
    String invalidCharacterErrorDesc = "invalidCharacterErrorDesc";
    String invalidDateErrorCode = "invalidDateErrorCode";
    String invalidValueErrorDesc = "invalidValueErrorDesc";
    String invalidErrorCode = "invalidErrorCode";
    String invalidFieldValueErrorCode = "invalidFieldValueErrorCode";
    String alphaNumericCode = "^[a-zA-Z0-9]+$";
    String bigDecimalCode = "^[0-9]*.?[0-9]+$";
    String defaultValuePR = "defaultValuePR";
    String defaultValueU = "defaultValueU";
    String defaultValueN = "defaultValueN";
    String defaultValuePP = "defaultValuePP";
    String defaultValueO = "defaultValueO";
    String defaultValueP = "defaultValueP";
    String defaultValueR = "defaultValueR";
    String defaultValueMI = "defaultValueMI";
    String length20 = "length20";
    String length3 = "length3";
    String length13 = "length13";
    String length40 = "length40";
    String length12 = "length12";
    String length2 = "length2";    
    String length9 = "length9";

    String employmentSectorTypeList = "employmentSectorTypeList";
    String strVehicleMake = "vehicleMake";
    String employmentTypeForAddress = "employmentTypeForAddress";
    
    /* main */
    String strEntity = "entity";
    String strPreferredBranch = "preferredBranch";
    String strDealerName = "dealerName";
    String facility = "facility";
    String customerList = "customerList";
    String collateral = "collateral";
    /* main */
    
    /* customer */
    String strIdNo = "idNo";           
    String strMonthlyNetIncome = "monthlyNetIncome";
    String computationMode = "computationMode";
    String countryOfPermanentResident = "countryOfPermanentResident";
    String educationLevel = "educationLevel";
    String employerName = "employerName";
    String occupation = "occupation";
    String foreignPR = "foreignPR";
    String sourceOfWealth = "sourceOfWealth";
    String strMonthlyGrossIncome = "monthlyGrossIncome";
    String residenceType = "residenceType";
    String employmentType = "employmentType";
    String mobilePhoneNo = "mobilePhoneNo";
    String strDateJoined = "dateJoined";
    String maritalStatus = "maritalStatus";
    String pRIDNo = "pRIDNo";
    String subEmploymentSector = "subEmploymentSector";
    String idType = "idType";
    String noOfDependants = "noOfDependants";
    String mobilePhoneNoAreaCode = "mobilePhoneNoAreaCode";
    String employmentSector = "employmentSector";
    String internationalExtensionPhoneNo = "internationalExtensionPhoneNo";
    String internationalPhoneNoAreaCode = "internationalPhoneNoAreaCode";
    String internationalPhoneNo = "internationalPhoneNo";
    String customerName = "customerName";
    
    String strDateOfBirth = "dateOfBirth";
    String gender = "gender";
    /* customer */
    
    /* collateral */
    String vehicleCondition = "vehicleCondition";
    String modelOfVehicle = "modelOfVehicle";    
    String strMarketValue = "marketValue";
    String registrationNo = "registrationNo";
    String purchasePriceOTR = "purchasePriceOTR";
    String chassisNo = "chassisNo";
    String yearMake = "yearMake";
    String bdmMoreThan2500kg = "bdmMoreThan2500kg";
    String engineNo = "EngineNo";
    String registrationDate = "registrationDate";
    /* collateral */
        
    /* Address */
    String addressType = "addressType";
    String address1 = "addressLine1";
    String postCode = "postcode";
    String addressList = "addressList";    
    String addressTypeR = "addressType R";
    String addressTypeP = "addressType P";
    /* Address */
    
    /* facility */    
    String facilityTenureYears = "facilityTenureYears";
    String downpayment = "downpayment";
    String strFinancingAmount = "financingAmount";
    String sourceOfFund = "sourceOfFund";
    String product = "product";
    /* facility */    
        

    
    public List<AFSubmissionResHeader> isValidPayload(AFAIPSubmissionRequestBody body, String respEmail) {
        List<AFSubmissionResHeader> list = new ArrayList<>();
        if 
        (
            Boolean.TRUE.equals(
                /* level 1 validation */
                /* rhb */
                isValidRespEmail(list, respEmail) &&
                validateEntity(list, body.getEntity()) &&
                validatePreferredBranch(list, body.getPreferredBranch()) &&
                validateDealerName(list, body.getDealerName()) &&                    
                validateFacilityTag(list,body) && 
                validateCustomerListTag(list,body) && 
                validateCollateralTag(list,body) 
                /* rhb */
            )  
        )
        {
             if (!list.isEmpty()) 
             {
                 return list;
             }
             else 
             {
                 if (Boolean.TRUE.equals(
                    /* level 2 validation */
                    /* customer basic info */                    
                    validateCustomerName(list, body.getCustomerInformation().get(0)) &&
                    isvalidEducationLevel(list, body.getCustomerInformation().get(0)) &&
                    isValidEmail(list, body.getCustomerInformation().get(0).getEmail()) &&
                    isValidEmployerName(list, body.getCustomerInformation().get(0)) &&
                    isvalidEmploymentType(list, body.getCustomerInformation().get(0)) &&
                    isValidOccupation(list, body.getCustomerInformation().get(0)) &&
                    isValidEmploymentSector(list, body.getCustomerInformation().get(0)) &&
                    isValidSubEmploymentSector(list, body.getCustomerInformation().get(0)) &&
                    isValidDateJoined(list, body.getCustomerInformation().get(0)) &&
                    validateforeignPr(list, body.getCustomerInformation().get(0)) &&
                    validateprIdNumber(list, body.getCustomerInformation().get(0)) &&
                    validateCountryOfPermanentResident(list, body.getCustomerInformation().get(0)) &&
                    validateIdNo(list, body.getCustomerInformation().get(0)) &&
                    validateIdType(list, body.getCustomerInformation().get(0)) &&
                    validationOfMobilePhoneNoAreaCode(list, body.getCustomerInformation().get(0)) &&
                    validationOfMobilePhoneNo(list, body.getCustomerInformation().get(0)) &&                    
                    isValidInternationalExtnPhoneNo(list, body.getCustomerInformation().get(0)) &&                    
                    isvalidMaritalStatus(list, body.getCustomerInformation().get(0)) &&
                    isValidIntPhoneNo(list, body.getCustomerInformation().get(0)) &&
                    isValidIntPhoneNoAreaCode(list, body.getCustomerInformation().get(0)) &&
                    isValidMonthlyNetIncome(list, body.getCustomerInformation().get(0)) &&
                    isValidMonthlyGrossIncome(list, body.getCustomerInformation().get(0)) &&
                    isvalidNoOfDependants(list, body.getCustomerInformation().get(0)) &&
                    isValidRace(list, body.getCustomerInformation().get(0)) &&
                    isValidResidenceType(list, body.getCustomerInformation().get(0)) &&
                    isValidSourceOfWealth(list, body.getCustomerInformation().get(0)) &&                    
                    validateComputationMode(list, body.getCustomerInformation().get(0)) &&
                    
                    isvalidGender(list, body.getCustomerInformation().get(0)) &&
                    isValidDateOfBirth(list, body.getCustomerInformation().get(0)) &&
                    validateAge(list, body.getCustomerInformation().get(0)) && 
                    
                    validateAddressListTag(list,body.getCustomerInformation().get(0)) && 
                    
                    /* collateral */                    
                    validateVehicleCondition(list, body.getCollateralInformation().get(0)) &&
                    isValidModelOfVehicle(list, body.getCollateralInformation().get(0)) &&
                    isValidYearMake(list, body.getCollateralInformation().get(0)) &&                    
                    isValidRegistrationDate(list, body.getCollateralInformation().get(0)) &&
                    isValidRegistrationNo(list, body.getCollateralInformation().get(0)) &&
                    validateEngineNo(list, body.getCollateralInformation().get(0)) &&
                    validateChassisNo(list, body.getCollateralInformation().get(0)) &&
                    validateBDM(list, body.getCollateralInformation().get(0)) &&
                    validpurchasePrice(list, body.getCollateralInformation().get(0)) &&                    
                    validateMarketValue(list, body.getCollateralInformation().get(0)) &&                    
                    /* collateral */ 
                    
                    /* facility */                     
                    validateFinancingAmount(list, body.getFacilityInformation().get(0)) &&
                    validateCashDownpayment(list, body.getFacilityInformation().get(0)) &&
                    validateFacilityTenure(list, body.getFacilityInformation().get(0)) &&
                    isValidSourceOfFund(list, body.getFacilityInformation().get(0)) &&
                    isValidProduct(list, body.getFacilityInformation().get(0)) 
                    /* facility */
                 ))
                 {
                     if (!list.isEmpty()) 
                     {
                         return list;
                     }
                     else 
                     {
                         if (Boolean.TRUE.equals(
                            /* level 3 validation */
                             /* address */                   
                            validateAddressType(list, body.getCustomerInformation().get(0)) &&
                            isValidAddress1(list, body.getCustomerInformation().get(0)) &&
                            isValidAddress2(list, body.getCustomerInformation().get(0)) &&
                            isValidAddress3(list, body.getCustomerInformation().get(0)) &&
                            validatePostCode(list, body.getCustomerInformation().get(0)) &&
                            isValidCity(list, body.getCustomerInformation().get(0)) && 
                            validateAddressTypePExists(list, body.getCustomerInformation().get(0)) &&
                            validateAddressTypeRExists(list, body.getCustomerInformation().get(0))
                            /* address */
                         ))
                         {
                             return list;
                         }
                     }
                 }
             }
        }
        return list;
    }

    private boolean validateEngineNo(List<AFSubmissionResHeader> list, AFCollateralInformation collateralInformation) {
        LOG.info("in validateEngineNo");
        if (!StringUtils.isEmpty(collateralInformation.getVehicleCondition()))
        {
            if ((collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueU)) || collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValuePR))) && (collateralInformation.getEngineNo() == null || collateralInformation.getEngineNo().isEmpty() || collateralInformation.getEngineNo().isBlank())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(engineNo);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
            }
            if (collateralInformation.getEngineNo() != null && !collateralInformation.getEngineNo().isEmpty() && !collateralInformation.getEngineNo().isBlank()) {
                if (!collateralInformation.getEngineNo().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(engineNo);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (collateralInformation.getEngineNo().length() > Integer.parseInt(System.getProperty(length20))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(engineNo);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            }
        }
        

        return true;
    }

    public boolean isValidInternationalExtnPhoneNo(List<AFSubmissionResHeader> list, AFCustomerInformation afContactInformation) {
        LOG.info("in isValidInternationalExtnPhoneNo");
        
        if (!StringUtils.isEmpty(afContactInformation.getIdType()))
        {
            if (afContactInformation.getIdType().equals(System.getProperty(defaultValuePP))) 
            {
                //if (afContactInformation.getInternationalExtensionPhoneNo() == null || afContactInformation.getInternationalExtensionPhoneNo().isEmpty() || afContactInformation.getInternationalExtensionPhoneNo().isBlank()) 
                if (StringUtils.isEmpty(afContactInformation.getInternationalExtensionPhoneNo())) 
                {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(internationalExtensionPhoneNo);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                }
            } else
                //if (afContactInformation.getInternationalExtensionPhoneNo() != null && !afContactInformation.getInternationalExtensionPhoneNo().isEmpty() && !afContactInformation.getInternationalExtensionPhoneNo().isBlank()) 
                if (!StringUtils.isEmpty(afContactInformation.getInternationalExtensionPhoneNo())) 
                {
                    if (!afContactInformation.getInternationalExtensionPhoneNo().matches(alphaNumericCode)) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                        messageList.setErrorTag(internationalExtensionPhoneNo);
                        messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                        list.add(messageList);
                    } else if (afContactInformation.getInternationalExtensionPhoneNo().length() > Integer.parseInt(System.getProperty("length4"))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(internationalExtensionPhoneNo);
                        messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
            }
        }
        
        return true;
    }

    public boolean isValidIntPhoneNoAreaCode(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) 
    {
        LOG.info("in isValidIntPhoneNoAreaCode");
        if (!StringUtils.isEmpty(afCustomerInformation.getIdType()))
        {
            //if (afCustomerInformation.getIdType().equals(System.getProperty(defaultValuePP)) && (afCustomerInformation.getInternationalPhoneNoAreaCode() == null || afCustomerInformation.getInternationalPhoneNoAreaCode().isBlank() || afCustomerInformation.getInternationalPhoneNoAreaCode().isEmpty())) 
            if (afCustomerInformation.getIdType().equals(System.getProperty(defaultValuePP)) && 
                StringUtils.isEmpty(afCustomerInformation.getInternationalPhoneNoAreaCode())) 
            {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(internationalPhoneNoAreaCode);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
            }
            else
                //if(afCustomerInformation.getInternationalPhoneNoAreaCode() != null && !afCustomerInformation.getInternationalPhoneNoAreaCode().isEmpty() && !afCustomerInformation.getInternationalPhoneNoAreaCode().isBlank()) {
                if(!StringUtils.isEmpty(afCustomerInformation.getInternationalPhoneNoAreaCode())) {
                    if (!afCustomerInformation.getInternationalPhoneNoAreaCode().matches("\\d+")) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                        messageList.setErrorTag(internationalPhoneNoAreaCode);
                        messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                        list.add(messageList);
                    } else if (afCustomerInformation.getInternationalPhoneNoAreaCode().length() != Integer.parseInt(System.getProperty(length3))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(internationalPhoneNoAreaCode);
                        messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
            }
        }
        
        return true;
    }

    public boolean isValidIntPhoneNo(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) 
    {
        LOG.info("in isValidIntPhoneNo");       
        
        if (!StringUtils.isEmpty(customerInformation.getIdType()))
        {
            if (customerInformation.getIdType().equals(System.getProperty(defaultValuePP))) 
            {
                if (StringUtils.isEmpty(customerInformation.getInternationalPhoneNo())) 
                {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(internationalPhoneNo);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                }
            }
            else if (!StringUtils.isEmpty(customerInformation.getInternationalPhoneNo())) 
            {
                /* GDTAPI-2968: AF submit error when optional internationalPhoneNo field is not provided. */
                Pattern pattern = Pattern.compile(" ");
                Pattern patternPhn = Pattern.compile("[A-Za-z\\p{Punct}]+");
                Matcher matcher = pattern.matcher(customerInformation.getInternationalPhoneNo());
                Matcher matcherPhn = patternPhn.matcher(customerInformation.getInternationalPhoneNo());
                /* GDTAPI-2968: AF submit error when optional internationalPhoneNo field is not provided. */
                
                if (matcherPhn.find() || (matcher.find())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(internationalPhoneNo);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (customerInformation.getInternationalPhoneNo().length() < Integer.parseInt(System.getProperty("length6")) || customerInformation.getInternationalPhoneNo().length() > Integer.parseInt(System.getProperty("length9"))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(internationalPhoneNo);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            }
        }
        
        return true;
    }

    public boolean isValidSourceOfFund(List<AFSubmissionResHeader> list, AFFacilityInformation afFacilityInformation) {
        LOG.info("in isValidSourceOfFund");
        if (afFacilityInformation.getSourceOfFund() == null || afFacilityInformation.getSourceOfFund().isBlank() || afFacilityInformation.getSourceOfFund().isEmpty()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(sourceOfFund);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);

        } else if (!afFacilityInformation.getSourceOfFund().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(sourceOfFund);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afFacilityInformation.getSourceOfFund().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(sourceOfFund);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("sourceOfFundList").split(",")).contains(afFacilityInformation.getSourceOfFund())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(sourceOfFund);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

     /* GDTAPI-2951: new AF product code */ 
    public boolean isValidProduct(List<AFSubmissionResHeader> list, AFFacilityInformation afFacilityInformation) {
        LOG.info("in isValidProduct");
        if (afFacilityInformation.getProduct() == null || afFacilityInformation.getProduct().isBlank() || afFacilityInformation.getProduct().isEmpty()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(product);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);        
        } 
        
        else if (!afFacilityInformation.getProduct().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(product);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afFacilityInformation.getProduct().length() != 5) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(product);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        }
        
        else if (!Arrays.asList(System.getProperty("ProductList").split(",")).contains(afFacilityInformation.getProduct())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(product);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }
    
    public boolean isValidYearMake(List<AFSubmissionResHeader> list, AFCollateralInformation afCollateralInformation) {
        LOG.info("in isValidYearMake");
        if (!StringUtils.isEmpty(afCollateralInformation.getVehicleCondition()))
        {
            // (PR or Used) & Year Make is blank
            if (( afCollateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueU)) || afCollateralInformation.getVehicleCondition().equals(System.getProperty(defaultValuePR))) && 
                ( afCollateralInformation.getYearMake() == null
                    || afCollateralInformation.getYearMake().toString().isEmpty()
                    || afCollateralInformation.getYearMake().toString().isBlank())) 
            {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(yearMake);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            }
            
            if 
            (
                // year make is not blank 
                !(afCollateralInformation.getYearMake() == null || afCollateralInformation.getYearMake().toString().isEmpty() || afCollateralInformation.getYearMake().toString().isBlank())) 
            {
                int currentYear = Year.now().getValue();
                if (afCollateralInformation.getYearMake().toString().length() != Integer.parseInt(System.getProperty("length4"))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(yearMake);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!afCollateralInformation.getYearMake().toString().matches("\\d+")) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(yearMake);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (afCollateralInformation.getYearMake() > LocalDate.now().getYear()
                || (afCollateralInformation.getVehicleCondition().equals(System.getProperty(defaultValuePR))
                        && (!(afCollateralInformation.getYearMake() == currentYear
                        || afCollateralInformation.getYearMake() == (currentYear - 1)))
                        || (afCollateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueN))
                        && !(afCollateralInformation.getYearMake() == null
                        || afCollateralInformation.getYearMake().toString().isEmpty()
                        || afCollateralInformation.getYearMake().toString().isBlank())
                        && (afCollateralInformation.getYearMake() < LocalDate.now().getYear() -1) )) ) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidYearMakeCode));
                    messageList.setErrorMessage(System.getProperty(invalidYearMakeMsg));
                    messageList.setErrorTag(yearMake);
                    messageList.setErrorDesc(System.getProperty(invalidYearMakeDesc));
                    list.add(messageList);
                }
            } 
            else if (afCollateralInformation.getYearMake() == null || afCollateralInformation.getYearMake().toString().isEmpty() || afCollateralInformation.getYearMake().toString().isBlank()) {
                afCollateralInformation.setYearMake(LocalDate.now().getYear());
            }
        }
        

        return true;
    }

    public Boolean validatePostCode(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in validatePostCode");
        String repetitveRegex = "\b(\\d+)\1+\b";
        
        for (AFAddressInformation aD : afCustomerInformation.getAddressInformation()) 
        {
            if (!StringUtils.isEmpty(aD.getAddressType()))
            {
                if ((
                        aD.getAddressType().equals(System.getProperty(defaultValueO))
                        || aD.getAddressType().equals(System.getProperty(defaultValueP))
                        || aD.getAddressType().equals(System.getProperty(defaultValueR))
                   )) 
                {
                    //if (aD.getPostcode().isBlank() || aD.getPostcode().isEmpty() || aD.getPostcode() == null) 
                    if (StringUtils.isEmpty(aD.getPostcode()))                 
                    {
                        
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(blankErrorCode));
                        messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                        messageList.setErrorTag(postCode);
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(blankErrorDesc));
                        list.add(messageList);
                    } else if (!aD.getPostcode().matches(alphaNumericCode) && !aD.getPostcode().matches(repetitveRegex)) {
                        
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                        messageList.setErrorTag(postCode);
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(invalidCharacterErrorDesc));
                        list.add(messageList);
                    } else if (aD.getPostcode().length() > Integer.parseInt(System.getProperty("length5"))) {
                        
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(postCode);
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    } else if (!Arrays.asList(System.getProperty("postCodeList").split(",")).contains(aD.getPostcode())) {
                        
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(invalidErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                        messageList.setErrorTag(postCode);
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(invalidValueErrorDesc));
                        list.add(messageList);
                    }
                }
               
                //if (aD.getPostcode() != null || !Objects.requireNonNull(aD.getPostcode()).isBlank() || !aD.getPostcode().isEmpty()) 
                if (!StringUtils.isEmpty(aD.getPostcode()))
                {
                    EAIAddress address = new EAIAddress();
                    if (Arrays.asList(System.getProperty("postCodeList").split(",")).contains(aD.getPostcode())) {
                        address.setState(setStateCode(aD));
                    }
                }            
            }
            
            
        }
        
        return true;
    }

    public boolean isValidRegistrationDate(List<AFSubmissionResHeader> list, AFCollateralInformation afCollateralInformation) {
        LOG.info("in isValidRegistrationDate");
        if (!StringUtils.isEmpty(afCollateralInformation.getVehicleCondition()))
        {
            if (Arrays.asList(System.getProperty("vehicleCondtionRegDate").split(",")).contains(afCollateralInformation.getVehicleCondition()) && (afCollateralInformation.getRegistrationDate() == null)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(registrationDate);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                }
            if (afCollateralInformation.getRegistrationDate() != null) {
                LocalDate todaysdate = LocalDate.now();
                LocalDate newRegDate = LocalDate.now();
                try {
                    newRegDate = afCollateralInformation.getRegistrationDate();
                } catch (DateTimeException e) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                    messageList.setErrorTag(registrationDate);
                    if (e.getLocalizedMessage().contains(":"))
                        messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                    else
                        messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                    list.add(messageList);
                }
                if (newRegDate.isAfter(todaysdate)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(futureDateErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDateErrorCode));
                    messageList.setErrorTag(registrationDate);
                    messageList.setErrorDesc(System.getProperty(invalidDateValueErrorDesc));
                    list.add(messageList);
                }

            }
        }
        
        
        return true;
    }

    public boolean isValidRegistrationNo(List<AFSubmissionResHeader> list, AFCollateralInformation afCollateralInformation) {
        LOG.info("in isValidRegistrationNo");
        
        if (!StringUtils.isEmpty(afCollateralInformation.getVehicleCondition()))
        {
            if (Arrays.asList(System.getProperty("vehicleCondtionRegDate").split(",")).contains(afCollateralInformation.getVehicleCondition())) {
                //if (afCollateralInformation.getRegistrationNo() == null || afCollateralInformation.getRegistrationNo().isEmpty() || afCollateralInformation.getRegistrationNo().isBlank()) {
                if (StringUtils.isEmpty(afCollateralInformation.getRegistrationNo())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(registrationNo);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                } else if (!afCollateralInformation.getRegistrationNo().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(registrationNo);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (afCollateralInformation.getRegistrationNo().length() > Integer.parseInt(System.getProperty(length20))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(registrationNo);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            } else if (afCollateralInformation.getRegistrationNo() != null || !afCollateralInformation.getRegistrationNo().isEmpty() || !afCollateralInformation.getRegistrationNo().isBlank()) {
                String uppercase = afCollateralInformation.getRegistrationNo().toUpperCase();
                String strPattern = "[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]";
                Pattern p = Pattern.compile(strPattern);
                Matcher m = p.matcher(uppercase);
                if ((m.find())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(registrationNo);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                }
            }
        }
        
        
        return true;
    }

    public boolean isValidSourceOfWealth(List<AFSubmissionResHeader> list, AFCustomerInformation afContactInformation) {
        LOG.info("in isValidSourceOfWealth");
        if (afContactInformation.getSourceOfWealth() == null || afContactInformation.getSourceOfWealth().isBlank() || afContactInformation.getSourceOfWealth().isEmpty()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(sourceOfWealth);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afContactInformation.getSourceOfWealth().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(sourceOfWealth);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afContactInformation.getSourceOfWealth().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(sourceOfWealth);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("sourceOfWealthlist").split(",")).contains(afContactInformation.getSourceOfWealth())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(sourceOfWealth);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public boolean isValidResidenceType(List<AFSubmissionResHeader> list, AFCustomerInformation afContactInformation) {
        LOG.info("in isValidResidenceType");
        if (afContactInformation.getResidenceType() == null || afContactInformation.getResidenceType().isBlank() || afContactInformation.getResidenceType().isEmpty()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(residenceType);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afContactInformation.getResidenceType().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(residenceType);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afContactInformation.getResidenceType().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(residenceType);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("residenceTypeList").split(",")).contains(afContactInformation.getResidenceType())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(residenceType);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public boolean isValidCity(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in isValidCity");
        for (AFAddressInformation aD : customerInformation.getAddressInformation()) {
            if (!StringUtils.isEmpty(aD.getAddressType()))
            {
                if (aD.getAddressType().equals(System.getProperty(defaultValueP)) || aD.getAddressType().equals(System.getProperty(defaultValueR)) ||
                    (aD.getAddressType().equals(System.getProperty(defaultValueO)) && Arrays.asList(System.getProperty(employmentTypeForAddress).split(",")).contains(customerInformation.getEmploymentType()))) 
                {
                    if (aD.getCity() == null || aD.getCity().isBlank() || aD.getCity().isEmpty()) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(blankErrorCode));
                        messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                        messageList.setErrorTag("city");
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(blankErrorDesc));
                        list.add(messageList);
                    } else  {
                        if (!aD.getCity().matches("^[a-zA-Z0-9 !@#$%^&*(\")='_\\\\+{}\\[\\],<>?|-]+$")) {
                            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                            messageList.setErrorTag("city");
                            messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(invalidCharacterErrorDesc));
                            list.add(messageList);
                        } else if (aD.getCity().length() > Integer.parseInt(System.getProperty(length20))) {
                            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                            messageList.setErrorCode(System.getProperty(lengthErrorCode));
                            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                            messageList.setErrorTag("City");
                            messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(lengthErrorDesc));
                            list.add(messageList);
                        }
                    }
                }
            }
            
            
        }
        return true;
    }

    public boolean isValidAddress1(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in isValidAddress1");
        String strPattern = "^[a-zA-Z0-9 ~!@#$%^&*(\")='_\\\\`+{}\\[\\]:;,.<>/?-]+$";
        Pattern p = Pattern.compile(strPattern);
       
        for (AFAddressInformation aD : customerInformation.getAddressInformation()) {
            if (!StringUtils.isEmpty(aD.getAddressType()))
            {
                if (    aD.getAddressType().equals(System.getProperty(defaultValueP)) || 
                        aD.getAddressType().equals(System.getProperty(defaultValueR)) ||
                    (   aD.getAddressType().equals(System.getProperty(defaultValueO)) && 
                    Arrays.asList(System.getProperty(employmentTypeForAddress).split(",")).contains(customerInformation.getEmploymentType()))) 
                {
                    if (aD.getAddressLine1() == null || aD.getAddressLine1().isEmpty() || aD.getAddressLine1().isBlank()) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(blankErrorCode));
                        messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                        messageList.setErrorTag(address1);
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(blankErrorDesc));
                        list.add(messageList);
                    } else  {
                        Matcher m = p.matcher(aD.getAddressLine1());
                        if (!m.find()) {
                            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                            messageList.setErrorTag(address1);
                            messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(invalidCharacterErrorDesc));
                            list.add(messageList);
                        } else if (aD.getAddressLine1().length() > Integer.parseInt(System.getProperty(length40))) {
                            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                            messageList.setErrorCode(System.getProperty(lengthErrorCode));
                            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                            messageList.setErrorTag(address1);
                            messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(lengthErrorDesc));
                            list.add(messageList);
                        }
                    }
                }
            }
        
            
        }
        return true;
    }

    public Boolean validateAddressType(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in validateAddressType"); 
        for (AFAddressInformation aD : customerInformation.getAddressInformation()) {
            /*
            //if (aD.getAddressType() == null || aD.getAddressType().isBlank() || aD.getAddressType().isEmpty()) {
            if (StringUtils.isEmpty(aD.getAddressType())) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(addressType);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } 
            */
            if (!StringUtils.isEmpty(aD.getAddressType())) 
            {
                if (!aD.getAddressType().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(addressType);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (aD.getAddressType().length() > Integer.parseInt(System.getProperty(length20))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(addressType);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!Arrays.asList(System.getProperty("addressTypes").split(",")).contains(aD.getAddressType())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(addressType);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            }
        }
        return true;
    }

    public Boolean validateFacilityTenure(List<AFSubmissionResHeader> list, AFFacilityInformation facilityInformation) {
        LOG.info("in validateFacilityTenure");
        if (facilityInformation.getFacilityTenure() == null) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(facilityTenureYears);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!facilityInformation.getFacilityTenure().toString().matches("\\d+")) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
            messageList.setErrorTag(facilityTenureYears);
            messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
            list.add(messageList);
        } else if (facilityInformation.getFacilityTenure().toString().length() > Integer.parseInt(System.getProperty(length3))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(facilityTenureYears);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean isValidEmail(List<AFSubmissionResHeader> list, String email) {
        LOG.info("in isValidEmail");
        if (email != null && !email.isEmpty() && !email.isBlank()) {
            //String regex = "^[-A-Za-z0-9._]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$";
          	String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty("invalidFormatErrorCode"));
                messageList.setErrorMessage(System.getProperty("dateMismatchErrorCode"));
                messageList.setErrorTag("email");
                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                list.add(messageList);
            } else if (email.length() > Integer.parseInt(System.getProperty("length70"))) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(lengthErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                messageList.setErrorTag("email");
                messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                list.add(messageList);
            }
        }
        return true;
    }

    public Boolean isValidAddress2(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in isValidAddress2");
        String strPattern = "^[a-zA-Z0-9\\s~!@#$%^&*(\")='_\\\\`+{}\\[\\]:;,.<>/?-]+$";
        for (AFAddressInformation aD : customerInformation.getAddressInformation()) {
            if (!StringUtils.isEmpty(aD.getAddressType()))
            {
                if ((aD.getAddressType().equals(System.getProperty(defaultValueP))
                    || aD.getAddressType().equals(System.getProperty(defaultValueR))
                    || aD.getAddressType().equals(System.getProperty(defaultValueO)))
                    && Arrays.asList(System.getProperty(employmentTypeForAddress).split(",")).contains(customerInformation.getEmploymentType())
                    && (aD.getAddressLine2() != null && !aD.getAddressLine2().isEmpty() && !aD.getAddressLine2().isBlank())) 
                {
                    if (!aD.getAddressLine2().matches(strPattern)) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                        messageList.setErrorTag("addressLine2");
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(invalidCharacterErrorDesc));
                        list.add(messageList);
                    } else if (aD.getAddressLine2().length() > Integer.parseInt(System.getProperty(length40))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag("addressLine2");
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
                }
            }
            
            
        }
        return true;
    }

    public Boolean isValidAddress3(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in isValidAddress3");
        String strPattern = "^[0-9a-zA-Z\\s~!@#$%^&\"*()='\\\\_+`{}\\[\\]:;,.<>/?-]+$";
        for (AFAddressInformation aD : customerInformation.getAddressInformation()) {
            if (!StringUtils.isEmpty(aD.getAddressType()))
            {
                if ((aD.getAddressType().equals(System.getProperty(defaultValueP))
                    || aD.getAddressType().equals(System.getProperty(defaultValueR))
                    || aD.getAddressType().equals(System.getProperty(defaultValueO)))
                    && Arrays.asList(System.getProperty(employmentTypeForAddress).split(",")).contains(customerInformation.getEmploymentType())
                    && (aD.getAddressLine3() != null && !aD.getAddressLine3().isEmpty() && !aD.getAddressLine3().isBlank())) 
                {
                    if (!aD.getAddressLine3().matches(strPattern)) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                        messageList.setErrorTag("addressLine3");
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(invalidCharacterErrorDesc));
                        list.add(messageList);
                    } else if (aD.getAddressLine3().length() > Integer.parseInt(System.getProperty(length40))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag("addressLine3");
                        messageList.setErrorDesc(aD.getAddressType() + "-" + System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
                }
            }
            
            
        }
        return true;
    }


    public boolean validationOfMobilePhoneNoAreaCode(List<AFSubmissionResHeader> list, AFCustomerInformation afContactInformation) {
        LOG.info("in validationOfMobilePhoneNoAreaCode");
        if (!StringUtils.isEmpty(afContactInformation.getIdType()))
        {
            if (Arrays.asList(System.getProperty("mobilePhoneNoAreaCodeList").split(",")).contains(afContactInformation.getIdType())) {
                if (afContactInformation.getMobilePhoneNoAreaCode() == null || afContactInformation.getMobilePhoneNoAreaCode().isBlank()
                        || afContactInformation.getMobilePhoneNoAreaCode().isEmpty()) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(mobilePhoneNoAreaCode);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                } else if (!afContactInformation.getMobilePhoneNoAreaCode().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(mobilePhoneNoAreaCode);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (afContactInformation.getMobilePhoneNoAreaCode().length() != Integer.parseInt(System.getProperty(length3))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(mobilePhoneNoAreaCode);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!Arrays.asList(System.getProperty(mobilePhoneNoAreaCode).split(",")).contains(afContactInformation.getMobilePhoneNoAreaCode())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(mobilePhoneNoAreaCode);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            }
        }
        
        return true;
    }

    public boolean validationOfMobilePhoneNo(List<AFSubmissionResHeader> list, AFCustomerInformation afContactInformation) {
        LOG.info("in validationOfMobilePhoneNo");
        
        //if (afContactInformation.getMobilePhoneNo() == null || afContactInformation.getMobilePhoneNo().isEmpty() || afContactInformation.getMobilePhoneNo().isBlank()) {
        if (!StringUtils.isEmpty(afContactInformation.getMobilePhoneNoAreaCode()))
        {
            if (StringUtils.isEmpty(afContactInformation.getMobilePhoneNo())) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(mobilePhoneNo);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } 
            else 
            {
                Pattern pattern = Pattern.compile(" ");
                Matcher matcher = pattern.matcher(afContactInformation.getMobilePhoneNo());
            
                if (!afContactInformation.getMobilePhoneNo().matches("\\d+")) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(mobilePhoneNo);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (matcher.find()) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(mobilePhoneNo);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                } else if (Arrays.asList(System.getProperty("defaultAreaCodeList").split(",")).contains(afContactInformation.getMobilePhoneNoAreaCode())) {
                    if (afContactInformation.getMobilePhoneNo().length() != Integer.parseInt(System.getProperty("length7"))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(mobilePhoneNo);
                        messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
                } else if (Arrays.asList(System.getProperty("kLAreaCode").split(",")).contains(afContactInformation.getMobilePhoneNoAreaCode())) {
                    if (afContactInformation.getMobilePhoneNo().length() != Integer.parseInt(System.getProperty("length8"))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(mobilePhoneNo);
                        messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
                } else if (afContactInformation.getMobilePhoneNo().length() > Integer.parseInt(System.getProperty("length9"))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(mobilePhoneNo);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            }
        }
        
        
        
        return true;
    }

    public Boolean validateIdType(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in validateIdType");
        //if (customerInformation.getIdType() == null || customerInformation.getIdType().isBlank() || customerInformation.getIdType().isEmpty()) {
        if (StringUtils.isEmpty(customerInformation.getIdType())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(idType);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!customerInformation.getIdType().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(idType);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (customerInformation.getIdType().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(idType);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("idTypeList").split(",")).contains(customerInformation.getIdType())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(idType);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean validateAge(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in validateAge");
        LocalDate todaysDate = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.now();
        if (customerInformation.getDateOfBirth() != null) {
            for (AFSubmissionResHeader header : list) {
                if (header.getErrorTag().equalsIgnoreCase(strDateOfBirth))
                    return true;
            }
            try {
                dateOfBirth = customerInformation.getDateOfBirth();
            } catch (DateTimeException e) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                messageList.setErrorTag(strDateOfBirth);
                if (e.getLocalizedMessage().contains(":"))
                    messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                else
                    messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                list.add(messageList);
            }
            Period p = Period.between(dateOfBirth, todaysDate);
            if (p.getYears() < 18 || p.getYears() > 65) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(invalidErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                messageList.setErrorTag(strDateOfBirth);
                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                list.add(messageList);
            }
        }
        return true;
    }

    public Integer calculateAge(AFCustomerInformation customerInformation) {
        LocalDate todaysDate = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.now();
        if (customerInformation.getDateOfBirth() != null) {
            try {
                dateOfBirth = customerInformation.getDateOfBirth();
            } catch (DateTimeException e) {
                List<AFSubmissionResHeader> list = new ArrayList<>();
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                messageList.setErrorTag(strDateOfBirth);
                if (e.getLocalizedMessage().contains(":"))
                    messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                else
                    messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                list.add(messageList);
            }

            Period p = Period.between(dateOfBirth, todaysDate);
            return p.getYears();
        }
        return null;
    }

    public Boolean validateEntity(List<AFSubmissionResHeader> list, String entity) {
        LOG.info("in validateEntity");
        if (entity == null || entity.isBlank() || entity.isEmpty()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(strEntity);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!entity.matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(strEntity);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (entity.length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(strEntity);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!(Arrays.asList(System.getProperty("entityList").split(",")).contains(entity))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(strEntity);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean validateEmptyString(String value) {
        return value != null && !value.isEmpty() && !value.isBlank();
    }

    public Boolean validateLength(String value, Integer length) {
        return value.length() > length;
    }

    public Boolean validateDealerName(List<AFSubmissionResHeader> list, String dealerName) {
        LOG.info("in validateDealerName");
        if (Boolean.FALSE.equals(validateEmptyString(dealerName))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(strDealerName);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!dealerName.matches("^[ a-zA-Z0-9]+$")) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(strDealerName);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (Boolean.TRUE.equals(validateLength(dealerName, 20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(strDealerName);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        }
        return true;
    }


    public Boolean validateCustomerName(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in validateCustomerName");
        
        if (!StringUtils.isEmpty(customerInformation.getIdType()))
        {
            //if (Boolean.FALSE.equals(validateEmptyString(customerInformation.getCutomerName()))) {            
            if (StringUtils.isEmpty(customerInformation.getCutomerName())) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(customerName);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } 
            else
            {
                String strPattern = "\\s{2,}";
                Pattern p = Pattern.compile(strPattern);
                Matcher m = p.matcher(customerInformation.getCutomerName());
            
                if (customerInformation.getIdType().equals(System.getProperty(defaultValueMI))) {
                    if (!customerInformation.getCutomerName().matches("^[-a-zA-Z0-9\\s@().',\"/]+$")) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                        messageList.setErrorTag(customerName);
                        messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                        list.add(messageList);
                    }else if (customerInformation.getCutomerName().length() < Integer.parseInt(System.getProperty(length3)) || customerInformation.getCutomerName().length() > Integer.parseInt(System.getProperty("length80"))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(customerName);
                        messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
                } else if (!(customerInformation.getCutomerName().matches("^[-A-Za-z0-9\\s@()'/`.\\\\]+$")) || (m.find())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(customerName);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (customerInformation.getCutomerName().length() < Integer.parseInt(System.getProperty(length3)) || customerInformation.getCutomerName().length() > Integer.parseInt(System.getProperty("length80"))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(customerName);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            }
        }
        
        return true;
    }

    public Boolean validateCountryOfPermanentResident(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in validateCountryOfPermanentResident");
        if (!StringUtils.isEmpty(afCustomerInformation.getForeignPR()))
        {
            if (afCustomerInformation.getForeignPR().equals(System.getProperty("defaultValueY"))) {
                if (afCustomerInformation.getCountryOfPermanentResident() == null || afCustomerInformation.getCountryOfPermanentResident().isBlank()
                        || afCustomerInformation.getCountryOfPermanentResident().isEmpty()) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(countryOfPermanentResident);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                } else if (!afCustomerInformation.getCountryOfPermanentResident().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(countryOfPermanentResident);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (afCustomerInformation.getCountryOfPermanentResident().length() > Integer.parseInt(System.getProperty("length50"))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(countryOfPermanentResident);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!Arrays.asList(System.getProperty("countryCode").split(",")).contains(afCustomerInformation.getCountryOfPermanentResident())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(countryOfPermanentResident);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            }
        }
        
        return true;
    }

    public Boolean validateComputationMode(List<AFSubmissionResHeader> list, AFCustomerInformation afContactInformation) {
        LOG.info("in validateComputationMode");
        if (afContactInformation.getComputationMode() == null || afContactInformation.getComputationMode().isEmpty()
                || afContactInformation.getComputationMode().isBlank()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(computationMode);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afContactInformation.getComputationMode().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(computationMode);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afContactInformation.getComputationMode().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(computationMode);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("computationModeList").split(",")).contains(afContactInformation.getComputationMode())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(computationMode);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }


    public Boolean isValidModelOfVehicle(List<AFSubmissionResHeader> list, AFCollateralInformation collateralInformation) {
        LOG.info("in isValidModelOfVehicle");
        //if (collateralInformation.getModelOfVehicle().isEmpty() || collateralInformation.getModelOfVehicle().isBlank() || collateralInformation.getModelOfVehicle() == null) {
        if (StringUtils.isEmpty(collateralInformation.getModelOfVehicle())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(modelOfVehicle);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!collateralInformation.getModelOfVehicle().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(modelOfVehicle);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (collateralInformation.getModelOfVehicle().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(modelOfVehicle);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("modelList").split(",")).contains(collateralInformation.getModelOfVehicle())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(modelOfVehicle);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public boolean isValidRespEmail(List<AFSubmissionResHeader> list, String respEmail) {
        LOG.info("in isValidRespEmail");
        if (respEmail == null || respEmail.isEmpty() || respEmail.isBlank()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag("respEmail");
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        }
        return true;
    }


    public Boolean validateforeignPr(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in validateforeignPr");
        List<String> foreignPr = new ArrayList<>();
        foreignPr.add("Y");
        foreignPr.add("N");

        //need to check
        //if (afCustomerInformation.getForeignPR() == null || afCustomerInformation.getForeignPR().isBlank() || afCustomerInformation.getForeignPR().isEmpty()) {
        if (StringUtils.isEmpty(afCustomerInformation.getForeignPR())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(foreignPR);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCustomerInformation.getForeignPR().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(foreignPR);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afCustomerInformation.getForeignPR().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(foreignPR);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!foreignPr.contains(afCustomerInformation.getForeignPR())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(foreignPR);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean validateprIdNumber(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in validateprIdNumber");
        if (!StringUtils.isEmpty(afCustomerInformation.getForeignPR()))
        {
            if (afCustomerInformation.getForeignPR().equals(System.getProperty("defaultValueY"))) {
                if (afCustomerInformation.getPrIdNumber() == null || afCustomerInformation.getPrIdNumber().isBlank() ||
                        afCustomerInformation.getPrIdNumber().isEmpty()) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(pRIDNo);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                } else if (afCustomerInformation.getPrIdNumber() != null) {
                    if (!afCustomerInformation.getPrIdNumber().matches(alphaNumericCode)) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                        messageList.setErrorTag(pRIDNo);
                        messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                        list.add(messageList);
                    } else if (afCustomerInformation.getPrIdNumber().length() > Integer.parseInt(System.getProperty(length12))) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(pRIDNo);
                        messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
                }
            }
        }
        
        return true;
    }


    public Boolean validatePreferredBranch(List<AFSubmissionResHeader> list, String preferredBranch) {
        LOG.info("in validatePreferredBranch");
        if (preferredBranch == null || preferredBranch.isEmpty() || preferredBranch.isBlank()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(strPreferredBranch);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!preferredBranch.matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(strPreferredBranch);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (preferredBranch.length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(strPreferredBranch);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!(Arrays.asList(System.getProperty("preferredBranchList").split(",")).contains(preferredBranch))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(strPreferredBranch);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean validateVehicleCondition(List<AFSubmissionResHeader> list, AFCollateralInformation afCollateralInformation) {
        LOG.info("in validateVehicleCondition");
        //if (afCollateralInformation.getVehicleCondition() == null || afCollateralInformation.getVehicleCondition().isEmpty() ||afCollateralInformation.getVehicleCondition().isBlank()) {
        if (StringUtils.isEmpty(afCollateralInformation.getVehicleCondition())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(vehicleCondition);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCollateralInformation.getVehicleCondition().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(vehicleCondition);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afCollateralInformation.getVehicleCondition().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(vehicleCondition);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("vehicleConditonList").split(",")).contains(afCollateralInformation.getVehicleCondition())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(vehicleCondition);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean validateBDM(List<AFSubmissionResHeader> list, AFCollateralInformation afCollateralInformation) {
        LOG.info("in validateBDM");
        if (afCollateralInformation.getBdmMoreThan2500kg() == null || afCollateralInformation.getBdmMoreThan2500kg().isBlank()
                || afCollateralInformation.getBdmMoreThan2500kg().isEmpty()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(bdmMoreThan2500kg);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCollateralInformation.getBdmMoreThan2500kg().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(bdmMoreThan2500kg);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afCollateralInformation.getBdmMoreThan2500kg().length() > Integer.parseInt(System.getProperty(length2))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(bdmMoreThan2500kg);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("bdmList").split(",")).contains(afCollateralInformation.getBdmMoreThan2500kg())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(bdmMoreThan2500kg);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }

        return true;
    }

    public Boolean validateFinancingAmount(List<AFSubmissionResHeader> list, AFFacilityInformation afFacilityInformation) {
        LOG.info("in validateFinancingAmount");
        if (afFacilityInformation.getFinancingAmount() == null ) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(strFinancingAmount);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afFacilityInformation.getFinancingAmount().toString().matches(bigDecimalCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
            messageList.setErrorTag(strFinancingAmount);
            messageList.setErrorDesc("Only numeric values are allowed");
            list.add(messageList);
        } else if (afFacilityInformation.getFinancingAmount() != null) {
            String financingAmount = "";
                if (!afFacilityInformation.getFinancingAmount().toString().contains("\\.")) {
                    financingAmount = (afFacilityInformation.getFinancingAmount().toString().concat(".00"));
                } else {
                    financingAmount = afFacilityInformation.getFinancingAmount().toString();
                }
                String[] strings = financingAmount.split("\\.");
                BigDecimal maxValue = new BigDecimal("9999999.99");
                BigDecimal minValue = new BigDecimal("5000.00");
                boolean maximumValue = (maxValue.compareTo(afFacilityInformation.getFinancingAmount()) > 0 || maxValue.compareTo(afFacilityInformation.getFinancingAmount()) == 0);
                boolean minimumValue = (afFacilityInformation.getFinancingAmount().compareTo(minValue)) == 0
                        || afFacilityInformation.getFinancingAmount().compareTo(minValue) > 0;
                if (!(strings[0].length() <= Integer.parseInt(System.getProperty(length13)) && strings[1].length() == Integer.parseInt(System.getProperty(length2)))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(strFinancingAmount);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!(maximumValue && minimumValue)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(strFinancingAmount);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
        }
        return true;
    }

    public Boolean validpurchasePrice(List<AFSubmissionResHeader> list, AFCollateralInformation afCollateralInformation) {
        LOG.info("in validpurchasePrice");
        String strPattern = "[~!@#$%^&*()_+{}\\[\\]:;,<>/?-]";
        if (afCollateralInformation.getPurchasePrice() == null) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(purchasePriceOTR);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCollateralInformation.getPurchasePrice().toString().matches(bigDecimalCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
            messageList.setErrorTag(purchasePriceOTR);
            messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
            list.add(messageList);
        } else if (afCollateralInformation.getPurchasePrice() != null) {
            Pattern p = Pattern.compile(strPattern);
            Matcher m = p.matcher(afCollateralInformation.getPurchasePrice().toString());
            String purchasePrice = "";
            if (!m.find()) {
                if (!afCollateralInformation.getPurchasePrice().toString().contains(".")) {
                    purchasePrice = (afCollateralInformation.getPurchasePrice().toString().concat(".00"));
                } else {
                    purchasePrice = afCollateralInformation.getPurchasePrice().toString();

                }
                String[] strings = purchasePrice.split("\\.");
                if (strings[1].equals(System.getProperty("defaultValueZero")) || (!(strings[0].length() <= Integer.parseInt(System.getProperty(length13)) && strings[1].length() == Integer.parseInt(System.getProperty(length2))))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(purchasePriceOTR);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            } else if (m.find()) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                messageList.setErrorTag(purchasePriceOTR);
                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                list.add(messageList);
            }
        }
        return true;
    }

    public Boolean validateChassisNo(List<AFSubmissionResHeader> list, AFCollateralInformation collateralInformation) {
        LOG.info("in validateChassisNo");
        if (!StringUtils.isEmpty(collateralInformation.getVehicleCondition()))
        {
            if ((collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueU)) || collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValuePR))) && (collateralInformation.getChassisNo() == null || collateralInformation.getChassisNo().isBlank() || collateralInformation.getChassisNo().isEmpty())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(chassisNo);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
            }
            if (collateralInformation.getChassisNo() != null && !collateralInformation.getChassisNo().isEmpty() && !collateralInformation.getChassisNo().isBlank()) {
                if (!collateralInformation.getChassisNo().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(chassisNo);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (collateralInformation.getChassisNo().length() > Integer.parseInt(System.getProperty(length20))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(chassisNo);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            }
        }
        
        

        return true;
    }

    public Boolean validateMarketValue(List<AFSubmissionResHeader> list, AFCollateralInformation afCollateralInformation) {
        LOG.info("in validateMarketValue");
        String stringPattern = "[A-Za-z~!@#$%^&*()_+{}\\[\\]:;,<>/?-]";
        if (!StringUtils.isEmpty(afCollateralInformation.getVehicleCondition()))
        {
            if (Arrays.asList(System.getProperty("marketValueList").split(",")).contains(afCollateralInformation.getVehicleCondition()) && (afCollateralInformation.getMarketValue() == null)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(strMarketValue);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                }
            if (afCollateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueN))
                    && afCollateralInformation.getMarketValue() == null) {
                    return true;
            }
            if (afCollateralInformation.getMarketValue() != null) {
                if (!afCollateralInformation.getMarketValue().toString().matches(bigDecimalCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                    messageList.setErrorTag(strMarketValue);
                    messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                    list.add(messageList);
                } else {
                    Pattern p = Pattern.compile(stringPattern);
                    Matcher m = p.matcher(afCollateralInformation.getMarketValue().toString());
                    String marketValue = "";
                    if (!m.find()) {
                        if (!afCollateralInformation.getMarketValue().toString().contains("\\.")) {
                            marketValue = (afCollateralInformation.getMarketValue().toString().concat(".00"));
                        } else {
                            marketValue = afCollateralInformation.getMarketValue().toString();
                        }
                        String[] strings = marketValue.split("\\.");
                        if (!(strings[0].length() <= Integer.parseInt(System.getProperty(length13)) && strings[1].length() == Integer.parseInt(System.getProperty(length2)))) {
                            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                            messageList.setErrorCode(System.getProperty(lengthErrorCode));
                            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                            messageList.setErrorTag(strMarketValue);
                            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                            list.add(messageList);
                        }
                    } else if (m.find()) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                        messageList.setErrorTag(strMarketValue);
                        messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                        list.add(messageList);
                    }
                }
            }
        }
        
        return true;
    }

    public Boolean validateCashDownpayment(List<AFSubmissionResHeader> list, AFFacilityInformation afFacilityInformation) {
        LOG.info("in validateCashDownpayment");
        String strPattern = "[A-Za-z~!@#$%^&*()_+{}\\[\\]:;,<>/?-]";
        if (afFacilityInformation.getCashDownpayment() == null) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(downpayment);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afFacilityInformation.getCashDownpayment().toString().matches(bigDecimalCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
            messageList.setErrorTag(downpayment);
            messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
            list.add(messageList);
        } else if (afFacilityInformation.getCashDownpayment() != null) {
            Pattern p = Pattern.compile(strPattern);
            Matcher m = p.matcher(afFacilityInformation.getCashDownpayment().toString());
            String cashDownPayment = "";
            if (!m.find()) {
                if (!afFacilityInformation.getCashDownpayment().toString().contains("\\.")) {
                    cashDownPayment = (afFacilityInformation.getCashDownpayment().toString().concat(".00"));
                } else {
                    cashDownPayment = afFacilityInformation.getCashDownpayment().toString();
                }
                String[] strings = cashDownPayment.split("\\.");
                if (!(strings[0].length() <= Integer.parseInt(System.getProperty(length13)) && strings[1].length() == Integer.parseInt(System.getProperty(length2)))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(downpayment);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                }
            } else if (m.find()) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                messageList.setErrorTag(downpayment);
                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                list.add(messageList);
            }
        }
        return true;
    }

    public Boolean isValidRace(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in isValidRace");
        if (afCustomerInformation.getRace() == null || afCustomerInformation.getRace().isEmpty() || afCustomerInformation.getRace().isBlank()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag("race");
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCustomerInformation.getRace().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag("race");
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afCustomerInformation.getRace().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag("race");
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("raceList").split(",")).contains(afCustomerInformation.getRace())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag("race");
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean isValidMonthlyGrossIncome(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isValidMonthlyGrossIncome");
        String strPattern = "^[A-Za-z\\s~!@#$%^&*()_+{}\\[\\]:;,<>/?-]+$";
        if (Arrays.asList(System.getProperty("employmentTypeMonthlyNetIncome").split(",")).contains(afEmploymentInformation.getEmploymentType()) && (afEmploymentInformation.getMonthlyGrossIncome() == null)) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(strMonthlyGrossIncome);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
        }
        if(afEmploymentInformation.getMonthlyGrossIncome() != null){
            if (!afEmploymentInformation.getMonthlyGrossIncome().toString().matches(bigDecimalCode)) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                messageList.setErrorTag(strMonthlyGrossIncome);
                messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                list.add(messageList);
            } else {
                Pattern p = Pattern.compile(strPattern);
                Matcher m = p.matcher(afEmploymentInformation.getMonthlyGrossIncome().toString());
                String monthlyGrossIncome = "";
                if (!m.find()) {
                    if (!afEmploymentInformation.getMonthlyGrossIncome().toString().contains("\\.")) {
                        monthlyGrossIncome = (afEmploymentInformation.getMonthlyGrossIncome().toString().concat(".00"));
                    } else {
                        monthlyGrossIncome = afEmploymentInformation.getMonthlyGrossIncome().toString();
                    }
                    String[] strings = monthlyGrossIncome.split("\\.");
                    //GDTAPI-2897: PF submission getting application not found due to monthlyGrossIncome & monthlyNetIncome exceeding FLASH limit
                    if ((strings[0].length() > Integer.parseInt(System.getProperty(length9)) || strings[1].length() != Integer.parseInt(System.getProperty(length2)))) {
                    //GDTAPI-2897: PF submission getting application not found due to monthlyGrossIncome & monthlyNetIncome exceeding FLASH limit
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(lengthErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                        messageList.setErrorTag(strMonthlyGrossIncome);
                        messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                        list.add(messageList);
                    }
                } else if (m.find()) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                    messageList.setErrorTag(strMonthlyGrossIncome);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            }
        }
        return true;
    }

    public Boolean isValidDateOfBirth(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in isValidDateOfBirth");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth;
        
        if (!StringUtils.isEmpty(afCustomerInformation.getIdType()) && !StringUtils.isEmpty(afCustomerInformation.getIdNo()))
        {
            if (Arrays.asList(System.getProperty("idTypeList").split(",")).contains(afCustomerInformation.getIdType())) {
                if (afCustomerInformation.getDateOfBirth() != null) {
                    try {
                        dateOfBirth = afCustomerInformation.getDateOfBirth();
                    } catch (DateTimeException e) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                        messageList.setErrorTag(strDateOfBirth);
                        if (e.getLocalizedMessage().contains(":"))
                            messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                        else
                            messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                        list.add(messageList);
                        return true;
                    }

                    if (dateOfBirth.isAfter(today)) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(futureDateErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidDateErrorCode));
                        messageList.setErrorTag(strDateOfBirth);
                        messageList.setErrorDesc(System.getProperty(invalidDateValueErrorDesc));
                        list.add(messageList);
                    }
                }
                    if (!afCustomerInformation.getIdNo().isBlank() && !afCustomerInformation.getIdNo().isEmpty() && afCustomerInformation.getIdNo() != null) {
                        for (AFSubmissionResHeader header : list) {
                            if (header.getErrorTag().equalsIgnoreCase(strIdNo))
                                return true;
                            if (header.getErrorTag().equalsIgnoreCase(strDateOfBirth))
                                return true;
                        }
                        if (afCustomerInformation.getDateOfBirth() != null) {
                            String prefix = "20";
                            String idYear = prefix + afCustomerInformation.getIdNo().substring(0, 2);
                            int todayYear = LocalDate.now().getYear();
                            if (Integer.parseInt(idYear) >= todayYear) {
                                idYear = "19" + afCustomerInformation.getIdNo().substring(0, 2);
                            }
                            if (!(idYear.equals(String.valueOf(afCustomerInformation.getDateOfBirth().getYear())))
                                    || (!(afCustomerInformation.getIdNo().substring(2, 4).equals(afCustomerInformation.getDateOfBirth().toString().split("-")[1])))
                                    || (!(afCustomerInformation.getIdNo().substring(4, 6).equals(afCustomerInformation.getDateOfBirth().toString().split("-")[2])))
                            ) {
                                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                                messageList.setErrorCode(System.getProperty(invalidErrorCode));
                                messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                                messageList.setErrorTag(strDateOfBirth);
                                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                                list.add(messageList);
                            }
                        } else {
                            if (afCustomerInformation.getDateOfBirth() == null) {
                                String dob = afCustomerInformation.getIdNo().substring(0, 6);
                                String prefix = "20";
                                String idYear = prefix + afCustomerInformation.getIdNo().substring(0, 2);
                                int todayYear = LocalDate.now().getYear();
                                if (Integer.parseInt(idYear) >= todayYear) {
                                    idYear = "19" + afCustomerInformation.getIdNo().substring(0, 2);}
                                else {
                                    idYear=prefix+afCustomerInformation.getIdNo().substring(0,2);
                                }
                                dob = dob.substring(4,6) + "/" + dob.substring(2,4) + "/" + idYear;
                                afCustomerInformation.setDateOfBirth(LocalDate.parse(dob, formatter));

                            }
                        }
                    }

            }
        }
        
        return true;
    }

    public Boolean isvalidGender(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in isvalidGender");
        if (!StringUtils.isEmpty(afCustomerInformation.getIdType()) && !StringUtils.isEmpty(afCustomerInformation.getIdNo()) )
        {
            if (!(afCustomerInformation.getGender() == null || afCustomerInformation.getGender().isBlank() || afCustomerInformation.getGender().isEmpty())) {
                if (!afCustomerInformation.getGender().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(gender);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (afCustomerInformation.getGender().length() > Integer.parseInt(System.getProperty(length20))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(gender);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!Arrays.asList(System.getProperty("genderList").split(",")).contains(afCustomerInformation.getGender())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(gender);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            }
            if (afCustomerInformation.getIdType().equals(System.getProperty(defaultValueMI))
                    || afCustomerInformation.getIdType().equals(System.getProperty("defaultValueMK"))
                    && !(afCustomerInformation.getIdNo().isBlank()
                    || afCustomerInformation.getIdNo().isEmpty() || afCustomerInformation.getIdNo() == null) && afCustomerInformation.getIdNo().length() == 12) {
                    for (AFSubmissionResHeader header : list) {
                        if (header.getErrorTag().equalsIgnoreCase(strIdNo) || header.getErrorTag().equalsIgnoreCase(gender))
                            return true;
                    }
                    if (!(afCustomerInformation.getGender() == null || afCustomerInformation.getGender().isEmpty() || afCustomerInformation.getGender().isBlank())) {
                        for (AFSubmissionResHeader header : list) {
                            if (header.getErrorTag().equalsIgnoreCase(gender))
                                return true;
                        }
                        int lastDigit = Integer.parseInt(afCustomerInformation.getIdNo().substring(11));
                        if (lastDigit % 2 == 0) {
                            if (!afCustomerInformation.getGender().equals(System.getProperty("defaultValueF"))) {
                                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                                messageList.setErrorCode(System.getProperty(invalidErrorCode));
                                messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                                messageList.setErrorTag(gender);
                                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                                list.add(messageList);
                            }
                        } else {
                            if (!afCustomerInformation.getGender().equals(System.getProperty("defaultValueM"))) {
                                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                                messageList.setErrorCode(System.getProperty(invalidErrorCode));
                                messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                                messageList.setErrorTag(gender);
                                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                                list.add(messageList);
                            }
                        }
                    } else if (afCustomerInformation.getGender() == null || afCustomerInformation.getGender().isBlank() || afCustomerInformation.getGender().isEmpty()) {
                        int lastDigit = Integer.parseInt(afCustomerInformation.getIdNo().substring(11));
                        if (lastDigit % 2 == 0) {
                            afCustomerInformation.setGender("F");
                        } else {
                            afCustomerInformation.setGender("M");
                        }
                    }
            }
        }
        
        return true;
    }

    public Boolean isvalidEducationLevel(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in isvalidEducationLevel");
        if (afCustomerInformation.getEducationLevel() == null || afCustomerInformation.getEducationLevel().isEmpty() || afCustomerInformation.getEducationLevel().isBlank()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(educationLevel);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCustomerInformation.getEducationLevel().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(educationLevel);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afCustomerInformation.getEducationLevel().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(educationLevel);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("educationLevelList").split(",")).contains(afCustomerInformation.getEducationLevel())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(educationLevel);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean isvalidMaritalStatus(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in isvalidMaritalStatus");
        if (afCustomerInformation.getMaritalStatus() == null || afCustomerInformation.getMaritalStatus().isEmpty() || afCustomerInformation.getMaritalStatus().isBlank()) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(maritalStatus);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCustomerInformation.getMaritalStatus().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(maritalStatus);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afCustomerInformation.getMaritalStatus().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(maritalStatus);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("maritalStatusList").split(",")).contains(afCustomerInformation.getMaritalStatus())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(maritalStatus);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean isvalidNoOfDependants(List<AFSubmissionResHeader> list, AFCustomerInformation afCustomerInformation) {
        LOG.info("in isvalidNoOfDependants");
        if (afCustomerInformation.getNoOfDependants() == null) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(noOfDependants);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afCustomerInformation.getNoOfDependants().toString().matches("\\d+")) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
            messageList.setErrorTag(noOfDependants);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        } else if (afCustomerInformation.getNoOfDependants().toString().length() > Integer.parseInt(System.getProperty(length2))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(noOfDependants);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public Boolean isvalidEmploymentType(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isvalidEmploymentType");
        //if (afEmploymentInformation.getEmploymentType() == null || afEmploymentInformation.getEmploymentType().isEmpty() || afEmploymentInformation.getEmploymentType().isBlank()) {
        if (StringUtils.isEmpty(afEmploymentInformation.getEmploymentType())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(employmentType);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        } else if (!afEmploymentInformation.getEmploymentType().matches(alphaNumericCode)) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
            messageList.setErrorTag(employmentType);
            messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
            list.add(messageList);
        } else if (afEmploymentInformation.getEmploymentType().length() > Integer.parseInt(System.getProperty(length20))) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(lengthErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
            messageList.setErrorTag(employmentType);
            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
            list.add(messageList);
        } else if (!Arrays.asList(System.getProperty("employmentTypeList").split(",")).contains(afEmploymentInformation.getEmploymentType())) {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(invalidErrorCode));
            messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
            messageList.setErrorTag(employmentType);
            messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
            list.add(messageList);
        }
        return true;
    }

    public String convertDate(LocalDate date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public Boolean isValidDateJoined(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isValidDateJoined");
        LocalDate todaysDate = LocalDate.now();
        LocalDate dateJoined;
        LocalDate dateApplied;
        if (Arrays.asList(System.getProperty(employmentSectorTypeList).split(",")).contains(afEmploymentInformation.getEmploymentType())) {
            if (afEmploymentInformation.getDateJoined() == null) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(strDateJoined);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } else if (afEmploymentInformation.getDateJoined() != null) {
                try {
                    dateJoined = afEmploymentInformation.getDateJoined();
                } catch (DateTimeException e) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                    messageList.setErrorTag(strDateJoined);
                    if (e.getLocalizedMessage().contains(":"))
                        messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                    else
                        messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                    list.add(messageList);
                    return true;
                }
                try {
                    dateApplied = LocalDate.now();
                } catch (DateTimeException e) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                    messageList.setErrorTag("dateApplied");
                    if (e.getLocalizedMessage().contains(":"))
                        messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                    else
                        messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                    list.add(messageList);
                    return true;
                }

                if (dateJoined.isAfter(todaysDate)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(futureDateErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDateErrorCode));
                    messageList.setErrorTag(strDateJoined);
                    messageList.setErrorDesc(System.getProperty(invalidDateValueErrorDesc));
                    list.add(messageList);
                } else if (dateJoined.isAfter(dateApplied)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(strDateJoined);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            }
        }
        return true;
    }

    public Boolean isValidEmployerName(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isValidEmployerName");
        if (Arrays.asList(System.getProperty("employmentTypeForMultiNationalComp").split(",")).contains(afEmploymentInformation.getEmploymentType())) {
            if (afEmploymentInformation.getEmployerName() == null || afEmploymentInformation.getEmployerName().isBlank() ||
                    afEmploymentInformation.getEmployerName().isEmpty()) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(employerName);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } else if (afEmploymentInformation.getEmployerName().length() > Integer.parseInt(System.getProperty(length40))) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(lengthErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                messageList.setErrorTag(employerName);
                messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                list.add(messageList);
            } else if (!afEmploymentInformation.getEmployerName().matches("^[-A-Za-z0-9@()\\s'/`.\\\\]+$") || (afEmploymentInformation.getEmployerName().matches("(?!.*[ ]{2})"))) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                messageList.setErrorTag(employerName);
                messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                list.add(messageList);
            }
        }
        return true;
    }

    public Boolean isValidSubEmploymentSector(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isValidSubEmploymentSector");
        if (Arrays.asList(System.getProperty(employmentSectorTypeList).split(",")).contains(afEmploymentInformation.getEmploymentType())) {
            if (afEmploymentInformation.getSubEmploymentSector() == null || afEmploymentInformation.getSubEmploymentSector().isEmpty() || afEmploymentInformation.getSubEmploymentSector().isBlank()) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(subEmploymentSector);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } else if (!afEmploymentInformation.getSubEmploymentSector().matches(alphaNumericCode)) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                messageList.setErrorTag(subEmploymentSector);
                messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                list.add(messageList);
            } else if (afEmploymentInformation.getSubEmploymentSector().length() > Integer.parseInt(System.getProperty(length20))) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(lengthErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                messageList.setErrorTag(subEmploymentSector);
                messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                list.add(messageList);
            } else if (!Arrays.asList(System.getProperty("subEmploymentSectorList").split(",")).contains(afEmploymentInformation.getSubEmploymentSector())) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(invalidErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                messageList.setErrorTag(subEmploymentSector);
                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                list.add(messageList);
            }
        }
        return true;
    }

    public Boolean isValidEmploymentSector(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isValidEmploymentSector");
        if (Arrays.asList(System.getProperty(employmentSectorTypeList).split(",")).contains(afEmploymentInformation.getEmploymentType())) {
            if (afEmploymentInformation.getEmploymentSector() == null || afEmploymentInformation.getEmploymentSector().isEmpty() || afEmploymentInformation.getEmploymentSector().isBlank()) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(employmentSector);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } else if (!afEmploymentInformation.getEmploymentSector().matches(alphaNumericCode)) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                messageList.setErrorTag(employmentSector);
                messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                list.add(messageList);
            } else if (afEmploymentInformation.getEmploymentSector().length() > Integer.parseInt(System.getProperty(length20))) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(lengthErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                messageList.setErrorTag(employmentSector);
                messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                list.add(messageList);
            } else if (!Arrays.asList(System.getProperty("employmentSectorList").split(",")).contains(afEmploymentInformation.getEmploymentSector())) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(invalidErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                messageList.setErrorTag(employmentSector);
                messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                list.add(messageList);
            }
        }
        return true;
    }

    public Boolean isValidOccupation(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isValidOccupation");
        
        if (!StringUtils.isEmpty(afEmploymentInformation.getEmploymentType()))
        {
            if (Arrays.asList(System.getProperty("employmentTypeForLength").split(",")).contains(afEmploymentInformation.getEmploymentType())) {
                if (afEmploymentInformation.getOccupation() == null || afEmploymentInformation.getOccupation().isEmpty() || afEmploymentInformation.getOccupation().isBlank()) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(blankErrorCode));
                    messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                    messageList.setErrorTag(occupation);
                    messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                    list.add(messageList);
                } else if (!afEmploymentInformation.getOccupation().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(occupation);
                    messageList.setErrorDesc(System.getProperty(invalidCharacterErrorDesc));
                    list.add(messageList);
                } else if (afEmploymentInformation.getOccupation().length() > Integer.parseInt(System.getProperty(length20))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(occupation);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!Arrays.asList(System.getProperty("occupationCodeList").split(",")).contains(afEmploymentInformation.getOccupation())) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(occupation);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            } else if ((afEmploymentInformation.getEmploymentType().equals(System.getProperty("defaultValue03"))
                    && !afEmploymentInformation.getOccupation().equals(System.getProperty("defaultValue050")))
                    || (afEmploymentInformation.getEmploymentType().equals(System.getProperty("defaultValue04"))
                    && !afEmploymentInformation.getOccupation().equals(System.getProperty("defaultValue080")))
                    || (afEmploymentInformation.getEmploymentType().equals(System.getProperty("defaultValue05"))
                    && !afEmploymentInformation.getOccupation().equals(System.getProperty("defaultValue087")))
                    || (afEmploymentInformation.getEmploymentType().equals(System.getProperty("defaultValue06"))
                    && !afEmploymentInformation.getOccupation().equals(System.getProperty("defaultValue104")))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(occupation);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
            }
        }
        
        return true;
    }

    public Boolean isValidMonthlyNetIncome(List<AFSubmissionResHeader> list, AFCustomerInformation afEmploymentInformation) {
        LOG.info("in isValidMonthlyNetIncome");
        if (Arrays.asList(System.getProperty("employmentTypeMonthlyNetIncome").split(",")).contains(afEmploymentInformation.getEmploymentType())) {
            if (afEmploymentInformation.getMonthlyNetIncome() == null) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(strMonthlyNetIncome);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } else if (!afEmploymentInformation.getMonthlyNetIncome().toString().matches(bigDecimalCode)) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                messageList.setErrorTag(strMonthlyNetIncome);
                messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                list.add(messageList);
            } else {

                String strPattern = "[A-Za-z\\s~!@#$%^&*()_+{}\\[\\]:;,<>/?-]";
                if (afEmploymentInformation.getMonthlyNetIncome() != null) {
                    Pattern p = Pattern.compile(strPattern);
                    Matcher m = p.matcher(afEmploymentInformation.getMonthlyNetIncome().toString());
                    String monthlyNetIncome = "";
                    if (!m.find()) {
                        if (!afEmploymentInformation.getMonthlyNetIncome().toString().contains("\\.")) {
                            monthlyNetIncome = (afEmploymentInformation.getMonthlyNetIncome().toString().concat(".00"));
                        } else {
                            monthlyNetIncome = afEmploymentInformation.getMonthlyNetIncome().toString();
                        }
                        String[] strings = monthlyNetIncome.split("\\.");                        
                        if ((strings[0].length() > Integer.parseInt(System.getProperty(length9)) || strings[1].length() != Integer.parseInt(System.getProperty(length2)))) {                        
                            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                            messageList.setErrorCode(System.getProperty(lengthErrorCode));
                            messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                            messageList.setErrorTag(strMonthlyNetIncome);
                            messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                            list.add(messageList);
                        }
                    } else if (m.find()) {
                        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                        messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                        messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                        messageList.setErrorTag(strMonthlyNetIncome);
                        messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                        list.add(messageList);
                    }
                }
            }
        }
        return true;
    }

    public String setVehicleMake(AFCollateralInformation afCollateralInformation) {
        try {
            return new JSONObject(System.getProperty(strVehicleMake)).opt(afCollateralInformation.getModelOfVehicle()).toString();
        } catch (JSONException e) {
            LOG.error(e);
        }
        return null;
    }

    public String setValidPackageType(String entity, AFCollateralInformation collateralInformation, BigDecimal financingAmount,String dealerCode) 
    {
        String packageCode ="";               
        
        try {
            
            // get car age from payload 
            int carAge = (LocalDate.now().getYear() - collateralInformation.getYearMake()) - 1;
            
            // get make from package group 
            String vehicleMake = new JSONObject(System.getProperty(strVehicleMake)).get(collateralInformation.getModelOfVehicle()).toString();
            
            // get package by model in param store 
            JSONObject packageCarList = new JSONObject(System.getProperty("newPackageCarList"));
            GetParameter parameter = new GetParameter();
            
            String hybridPackageCode = System.getProperty("HybridPackageCode");
            String volvoPackageCode = System.getProperty("VolvoPackageCode");
            String nationalGreenPackageCode = System.getProperty("NationalGreenPackageCode");
             
            // if (car condition = new ) 
            // OR 
            // ( pr & make NOT equal 0033(perodua) or 0032(proton) )
            if (collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueN)) || (collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValuePR)) && carAge <= 1 && !(vehicleMake.equals(System.getProperty("defaultValue0033")) || vehicleMake.equals(System.getProperty("defaultValue0032"))))) {
                
                // if model is within any package 
                if (packageCarList.has(collateralInformation.getModelOfVehicle())) {
                    // if model can be found in hybrid and National others package group list 
                    if 
                    (
                        packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals("Hybrid") || 
                        packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals("NModel")) 
                    {
                        // possible package as of 1/10/2023: 
                        // I/N/Hybrid: AVRHYEV, 
                        // I/PR/Hybrid: AVRHYEV, 
                        // I/N/NModel: AFFRNN9I
                        packageCode = parameter.getParamAsString(entity + "/" + collateralInformation.getVehicleCondition() + "/" +packageCarList.get(collateralInformation.getModelOfVehicle()).toString());
                        
                        // GDTAPI-2908- set to different package code if financing amount is less than 100k or more than 500k for hybrid & national green 
                        //if ( packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals("Hybrid") && 
                        if ( packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals(hybridPackageCode) && 
                            (  financingAmount.compareTo(new BigDecimal(System.getProperty("FinancingAmountPackageRuleMin"))) < 0 ||
                            financingAmount.compareTo(new BigDecimal(System.getProperty("FinancingAmountPackageRuleMax"))) > 0
                            ) ) 
                        {
                            packageCode = parameter.getParamAsString(entity + "/" + collateralInformation.getVehicleCondition() + "/" +"Hybrid_Alternative");
                        }
                    } 
                    else 
                    {
                        // possible package as of 1/10/2023: 
                        // I/N/0033/Alza: AVRNPALZA,
                        // I/N/0033/Aruz: FRNPARUZ9I, -- TBD 
                        // I/N/0033/MyVi: FRNPMYVI, -- TBD 
                        // I/N/0032/X70: FRNPX709RI,
                        // I/N/0032/X50: AVRNPX50
                        // I/N/0032/NATIONGREEN : AVRNNEV
                        // I/N/0044/Volvo: AVRNVOLVO
                        // I/PR/0044/Volvo: AVRNVOLVO
                        packageCode = parameter.getParamAsString(entity + "/" + collateralInformation.getVehicleCondition() + "/"+ vehicleMake + "/" +packageCarList.get(collateralInformation.getModelOfVehicle()).toString());
                        
                         // GDTAPI-2908- set to different package code if financing amount is less than 100k or more than 500k for hybrid & national green 
                        if 
                        //( packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals("NATIONGREEN") && 
                        ( packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals(nationalGreenPackageCode) && 
                            ( financingAmount.compareTo(new BigDecimal(System.getProperty("FinancingAmountPackageRuleMin"))) < 0 ||
                            financingAmount.compareTo(new BigDecimal(System.getProperty("FinancingAmountPackageRuleMax"))) > 0) 
                        )
                        {
                            packageCode = parameter.getParamAsString(entity + "/" + collateralInformation.getVehicleCondition() + "/" +"NATIONGREEN_Alternative");
                        }
                        
                        if 
                        //( packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals("Volvo") && 
                        ( packageCarList.get(collateralInformation.getModelOfVehicle()).toString().equals(volvoPackageCode) && 
                            ( financingAmount.compareTo(new BigDecimal(System.getProperty("FinancingAmountPackageRuleMin"))) < 0 ||
                            financingAmount.compareTo(new BigDecimal(System.getProperty("FinancingAmountPackageRuleMax"))) > 0) 
                        )
                        {
                            packageCode = parameter.getParamAsString(entity + "/" + collateralInformation.getVehicleCondition() + "/" +"Volvo_Alternative");
                        }
                        
                        // GDTAPI-2908- set to different package code if financing amount is less than 100k or more than 500k for hybrid & national green 
                    }
                } 
                // if model is not in any package 
                else {
                    // possible package: 
                    // I/N/Default: FRNNN9I
                    packageCode = parameter.getParamAsString(entity + "/" + collateralInformation.getVehicleCondition() + "/" + "Default");
                }
            }
            // else if car condition =  pr & 
            // car age <= 1 year & 
            // make = 0033(perodua) or 0032(proton)
            else if (collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValuePR)) && carAge <= 1 && (vehicleMake.equals(System.getProperty("defaultValue0033")) || vehicleMake.equals(System.getProperty("defaultValue0032")))) {
                // possible package: I/PR/National: AVRPRN                 
                packageCode = parameter.getParamAsString(entity + "/" + collateralInformation.getVehicleCondition() + "/" + "National");
                
            } 
            else if (collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueU))) {
                if (Arrays.asList(System.getProperty("nationalMake").split(",")).contains(vehicleMake)) {
                    if (new JSONObject(System.getProperty("usedPackageCarList")).has(collateralInformation.getModelOfVehicle())) {                        
                        packageCode = parameter.getParamAsString(
                                entity + "/" + collateralInformation.getVehicleCondition() + "/" + vehicleMake + "/" +
                                        new JSONObject(System.getProperty("usedPackageCarList")).get(collateralInformation.getModelOfVehicle()));
                    } else {                       
                        packageCode = parameter.getParamAsString(
                                entity + "/" + collateralInformation.getVehicleCondition() + "/" + vehicleMake + "/" +
                                        "NModel");
                    }
                } else if (Arrays.asList(System.getProperty("nonNationalMake").split(",")).contains(vehicleMake)) {
                                      
                    packageCode = parameter.getParamAsString(
                            entity + "/" + collateralInformation.getVehicleCondition() + "/" + "NonNational");
                }
            }
            
            LOG.info("ori packageCode:" + packageCode);
            
            
            if (collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValueN)) || (collateralInformation.getVehicleCondition().equals(System.getProperty(defaultValuePR))))
            {
                String dealerXmodelpackageCode = setValidPackageTypeStep2(collateralInformation,dealerCode);
                
                LOG.info("dealerXmodelpackageCode:" + dealerXmodelpackageCode);
                
                if (!StringUtils.isEmpty(dealerXmodelpackageCode)) 
                {
                    packageCode = dealerXmodelpackageCode;
                    
                }
            }
            
        } catch (JSONException e) {
            LOG.error(e);
        }
        
        LOG.info("new packageCode:" + packageCode);
        
        return packageCode;
    }
    
    private static String getModelXDealerPackage(JSONArray array, String dealer, String model) {
        
        String value = "";
        // Iterate over the records array
        for (int i = 0; i < array.length(); i++) {
            // Get each record as a JSONObject
            try
            {
                JSONObject record = array.getJSONObject(i);
                String key = "compositeKey";
                JSONObject compositeKey = record.getJSONObject(key);
                
                LOG.info(" dealer value:" + compositeKey.getString("dealer"));
                LOG.info(" model value:" + compositeKey.getString("model"));
                LOG.info(" value value:" + record.getString("value"));
                    
                // Check if the parts match the search criteria
                if (compositeKey.getString("dealer").equals(dealer) && compositeKey.getString("model").equals(model)) {
                    // Return the value associated with the composite key
                    
                    LOG.info("found dealer value:" + compositeKey.getString("dealer"));
                    LOG.info("found model value:" + compositeKey.getString("model"));
                    LOG.info(" found value:" + record.getString("value"));
                    
                    value = record.getString("value");
                    //return record.getString("value");
                }                    
            }
            catch (JSONException e) 
            {                
                LOG.error(e);
            }
        }
        return value;
    }
    
    public String setValidPackageTypeStep2(AFCollateralInformation collateralInformation, String dealerCode) 
    {
        String ModelXDealerPackage = "";
        
        try {
            
            //GetParameter parameter = new GetParameter();
            
            // get package by dealerXmodel in param store             
             
             String model = collateralInformation.getModelOfVehicle();
             
            // Parse the JSON string
            JSONObject packageCarList = new JSONObject(System.getProperty("dealerPackageCarList"));
            
            // Extract the array of records
            JSONArray recordsArray = packageCarList.getJSONArray("records");
        
            
            ModelXDealerPackage = getModelXDealerPackage(recordsArray, dealerCode,model);
                        
            
            
        } catch (JSONException e) {
            LOG.error(e);
        }
        return ModelXDealerPackage;
    }
    
    public Boolean validateIdNo(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in validateIdNo");
        if (!StringUtils.isEmpty(customerInformation.getIdType()))
        {
            //if (customerInformation.getIdNo() == null || customerInformation.getIdNo().isBlank() || customerInformation.getIdNo().isEmpty()) {
            if (StringUtils.isEmpty(customerInformation.getIdNo())) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(blankErrorCode));
                messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
                messageList.setErrorTag(strIdNo);
                messageList.setErrorDesc(System.getProperty(blankErrorDesc));
                list.add(messageList);
            } else if (customerInformation.getIdType().equals(System.getProperty("defaultValueMK")) || customerInformation.getIdType().equals(System.getProperty(defaultValueMI))) {
                if (!customerInformation.getIdNo().matches("\\d+")) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(dataTypeErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidDataTypeErrorCode));
                    messageList.setErrorTag(strIdNo);
                    messageList.setErrorDesc(System.getProperty(datatypeErrorDesc));
                    list.add(messageList);
                } else if (customerInformation.getIdNo().length() != Integer.parseInt(System.getProperty(length12))) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(lengthErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                    messageList.setErrorTag(strIdNo);
                    messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                    list.add(messageList);
                } else if (!customerInformation.getIdNo().substring(0, 6).matches("[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])")) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(invalidErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidFieldValueErrorCode));
                    messageList.setErrorTag(strIdNo);
                    messageList.setErrorDesc(System.getProperty(invalidValueErrorDesc));
                    list.add(messageList);
                }
            }
            else if (!customerInformation.getIdNo().matches(alphaNumericCode)) {
                    AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                    messageList.setErrorCode(System.getProperty(specialCharacterErrorCode));
                    messageList.setErrorMessage(System.getProperty(invalidSpecialCharacterErrorCode));
                    messageList.setErrorTag(strIdNo);
                    messageList.setErrorDesc("Only alphabets and numbers are allowed");
                    list.add(messageList);
            } else if (customerInformation.getIdNo().length() != Integer.parseInt(System.getProperty(length12))) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty(lengthErrorCode));
                messageList.setErrorMessage(System.getProperty(invalidLengthErrorCode));
                messageList.setErrorTag(strIdNo);
                messageList.setErrorDesc(System.getProperty(lengthErrorDesc));
                list.add(messageList);
            }
        }
        
        
        return true;
    }

    public String setStateCode(AFAddressInformation afAddressInformation) {
        try {
            return new JSONObject(System.getProperty("statePostcode")).get(afAddressInformation.getPostcode()).toString();
        } catch (JSONException e) {
            LOG.info(e.getMessage());
        }
        return "";
    }

    public String setVehicleMake(AFAddressInformation afAddressInformation) {
        try {
            return new JSONObject(System.getProperty(strVehicleMake)).get(afAddressInformation.getPostcode()).toString();
        } catch (JSONException e) {
            LOG.info(e.getMessage());
        }
        return "";
    }

    public Boolean validateFacilityTag(List<AFSubmissionResHeader> list, AFAIPSubmissionRequestBody body) {
        LOG.info("in validateFacilityTag");
        int empty = 0; 
        
        //if (body.facilityInformation == null) empty = 1;
        if (body.getFacilityInformation() == null) empty = 1;
        else 
        {
            List<AFFacilityInformation> facilityList = body.getFacilityInformation();
            if (facilityList.size() == 0) empty = 1;
        }
        
        if (empty == 1)
        {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(facility);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);  
        }
        return true;
    }
    
    public Boolean validateCustomerListTag(List<AFSubmissionResHeader> list, AFAIPSubmissionRequestBody body) {
        LOG.info("in validateCustomerListTag");
        int empty = 0; 
        
        //if (body.customerInformation == null) empty = 1;
        if (body.getCustomerInformation() == null) empty = 1;
        else 
        {           
            List<AFCustomerInformation> arrcustomerList = body.getCustomerInformation();
            if (arrcustomerList.size() == 0) empty = 1;
        }
        
        if (empty == 1)
        {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(customerList);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);  
        }
        
        return true;
    }
    
    public Boolean validateCollateralTag(List<AFSubmissionResHeader> list, AFAIPSubmissionRequestBody body) {
        LOG.info("in validateCollateralTag");
        int empty = 0; 
        
        //if (body.collateralInformation == null) empty = 1;
        if (body.getCollateralInformation() == null) empty = 1;
        else 
        {
            List<AFCollateralInformation> collateralList = body.getCollateralInformation();
            if (collateralList.size() == 0) empty = 1;            
        }
        
        if (empty == 1)
        {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(collateral);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);  
        }        

        return true;
    }
    
    public Boolean validateAddressListTag(List<AFSubmissionResHeader> list, AFCustomerInformation body) {
        LOG.info("in validateAddressListTag");
        int empty = 0; 
        
        //if (body.addressInformation == null) empty = 1;
        if (body.getAddressInformation() == null) empty = 1;
        else 
        {
            List<AFAddressInformation> addressList = body.getAddressInformation();
            if (addressList.size() == 0) empty = 1;            
        }
        
        if (empty == 1)
        {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(addressList);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);  
        }        

        return true;
    }
    
    public Boolean validateAddressTypeRExists(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in validateAddressTypeRExists"); 
        int addressTypeRExists = 0;
        
        for (AFAddressInformation aD : customerInformation.getAddressInformation()) {
            if (!StringUtils.isEmpty(aD.getAddressType())) {
                if (aD.getAddressType().equals(System.getProperty(defaultValueR)))
                {
                    addressTypeRExists = 1;
                }
            }
            
        }
        if (addressTypeRExists == 0)
        {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(addressTypeR);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        }
            
        return true;
    }
    
    public Boolean validateAddressTypePExists(List<AFSubmissionResHeader> list, AFCustomerInformation customerInformation) {
        LOG.info("in validateAddressTypePExists"); 
        int addressTypePExists = 0;
        
        for (AFAddressInformation aD : customerInformation.getAddressInformation()) {
            if (!StringUtils.isEmpty(aD.getAddressType())) {
                if (aD.getAddressType().equals(System.getProperty(defaultValueP)))
                {
                    addressTypePExists = 1;
                }
            }
            
        }
        if (addressTypePExists == 0)
        {
            AFSubmissionResHeader messageList = new AFSubmissionResHeader();
            messageList.setErrorCode(System.getProperty(blankErrorCode));
            messageList.setErrorMessage(System.getProperty(blankCheckErrorCode));
            messageList.setErrorTag(addressTypeP);
            messageList.setErrorDesc(System.getProperty(blankErrorDesc));
            list.add(messageList);
        }
            
        return true;
    }
}

