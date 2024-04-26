package com.rhb.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.rhb.api.models.*;

import com.rhb.api.utilities.AfValidators;

import java.io.*;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.*;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.squareup.okhttp.*;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.time.temporal.ChronoUnit;

@Service
public class AFSubmissionServiceImpl implements AFSubmissionService {

    private static final Log LOG = LogFactory.getLog(AFSubmissionServiceImpl.class);
    FileInputStream fis;
    static String entityI = "entityI";
    static String defaultValue0WithDecimal = "defaultValue0WithDecimal";

    @Autowired
    AfValidators validator;

    @Override
    public ResponseEntity<AFSubmissionResponse> afSubmitRequest(AFAIPSubmissionRequestBody request, String respEmail) {
        AFSubmissionResponse partnerResponse = new AFSubmissionResponse();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
        try {
            List<AFSubmissionResHeader> validatorResponse = validator.isValidPayload(request, respEmail);
            if (!validatorResponse.isEmpty()) {
                partnerResponse.setHeader(validatorResponse);
                AFSubmitResponseBody responseBody = new AFSubmitResponseBody();
                partnerResponse.setBody(responseBody);
                for (AFSubmissionResHeader header : validatorResponse
                ) {
                    return ResponseEntity.unprocessableEntity().body(partnerResponse);
                    /*
                    if (header.getErrorCode().equals(System.getProperty("invalidErrorCode"))) {
                        return ResponseEntity.unprocessableEntity().body(partnerResponse);
                    } else {
                        return ResponseEntity.unprocessableEntity().body(partnerResponse);
                    }
                    */
                }
            }
            EAIRequestHeader header = new EAIRequestHeader();
            EAIRequest eaiRequest = new EAIRequest();
            EAIRequestBody eaiRequestBody = new EAIRequestBody();

            eaiRequestBody.setCollateralInformation(setCollateralInfo(request, formatter));

            eaiRequestBody.setCustomerInformation(setCustomerInfo(request, formatter));

            eaiRequestBody.setFacilityInformation(setFacilityInfo(request));
            eaiRequestBody.setFinancingApplicationType(System.getProperty("applicationTypeAF"));
            eaiRequestBody.setDateApplied(LocalDate.now().format(formatter));
            eaiRequestBody.setDealerName(request.getDealerName());
            eaiRequestBody.setOriginator("");
            eaiRequestBody.setEntity(request.getEntity());
            eaiRequestBody.setPceQualifiedStaff("");
            eaiRequestBody.setPreferredBranch(request.getPreferredBranch());
            eaiRequestBody.setPassword("");
            eaiRequestBody.setUsername("");

            String datePID = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            eaiRequestBody.setProcessId("AF" + datePID + System.currentTimeMillis());
            eaiRequestBody.setPartnerEmail(respEmail);
            eaiRequestBody.setStaffApplication(System.getProperty("staffCode"));
            eaiRequestBody.setSourceSystem(System.getProperty("sourceSystem"));
            eaiRequestBody.setProcessDate(date + time);
            AtomicLong value = new AtomicLong(000001);
            header.setMessageVersionNo(1.0D);
            // messageReferenceNo
            header.setMessageRefNo("AP" + date + time + 99999 + value.getAndIncrement());
            header.setSourceID(System.getProperty("sourceId"));
            header.setLoginID("");
            header.setPan("");
            header.setExtTransactionCode(System.getProperty("extTrxnCd"));
            header.setDplName("");
            header.setFiller("");
            header.setRecordLength("");
            header.setNoOfRecords("");
            header.setTransactionDate(Integer.valueOf(date));
            header.setTransactionTime(Integer.valueOf(time));
            header.setDestQueueManager("");
            header.setDestQueue("");
            header.setErrorCode("");
            header.setSystemStatus("");
            header.setErrorMessage("");
            header.setTerminalID("");
            header.setReplyRefNo("");
            header.setOverrideTellerId("");

            eaiRequest.setHeader(header);
            eaiRequest.setBody(eaiRequestBody);
            String xml = createXmlString(eaiRequest);
            LOG.info("Request to EAI : " + xml);
            String eaiResponse = callSoapService(xml);
            LOG.info("Result " + eaiResponse);
            partnerResponse = setResponse(eaiResponse, partnerResponse);
         } catch (JSONException e) {
            LOG.info("JSON Processing Exception" + e.getMessage());
            AFSubmissionResHeader resHeader = new AFSubmissionResHeader();
            resHeader.setErrorDesc("Back-end system is currently not available");
            resHeader.setErrorTag("");
            resHeader.setErrorMessage("Back-end system is currently not available");
            resHeader.setErrorCode("500");
            List<AFSubmissionResHeader> list = new ArrayList<>();
            list.add(resHeader);
            partnerResponse.setHeader(list);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(partnerResponse);
        }
        
        catch (Exception e) {
            LOG.info(e.getMessage());
        }
        
        
        return ResponseEntity.ok(partnerResponse);
    }

    public AFSubmissionResponse setResponse(String eaiResponse, AFSubmissionResponse partnerResponse) throws JsonProcessingException, JSONException {
        char quote = '"';
        eaiResponse = eaiResponse.replace("<?xml version=" + quote + "1.0" + quote + " encoding=" + quote + "UTF-8" + quote + " standalone=" + quote + "no" + quote + "?>", "").
                replace("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:eai=\"http://www.eai.rhb.com\">", "").
                replace("<soapenv:Body>", "").
                replace("</soapenv:Body>", "").
                replace("<MsgList>", "").
                replace("</MsgList>", "").
                replace("</soapenv:Envelope>", "").trim();

        XmlMapper xmlMapper = new XmlMapper();
        AnnotationIntrospector aiJaxb = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
        xmlMapper.setAnnotationIntrospector(aiJaxb);
        AFFlashResponse response = xmlMapper.readValue(eaiResponse, AFFlashResponse.class);
        List<AfFlashMessageList> responseHeaderList = response.getFlashResponseHeader().getMsgList();
        List<AFSubmissionResHeader> resHeaderList = new ArrayList<>();
        if (responseHeaderList.isEmpty()) {
            for (int i = 0; i < responseHeaderList.size(); i++) {
                if (responseHeaderList.get(i).getMsgSev().equals(System.getProperty("defaultValueF"))) {
                    AFSubmissionResHeader resHeader = new AFSubmissionResHeader();
                    resHeader.setErrorCode(responseHeaderList.get(i).getMsgCd());
                    resHeader.setErrorDesc(responseHeaderList.get(i).getMsgDscp());
                    String[] tag = responseHeaderList.get(i).getMsgDscp().split(" ");
                    resHeader.setErrorTag(tag[0]);
                    if (new JSONObject(System.getProperty("flashErrorList")).has(responseHeaderList.get(i).getMsgCd().substring(2, 6))) {
                        resHeader.setErrorMessage(new JSONObject(System.getProperty("flashErrorList")).
                                opt(responseHeaderList.get(i).getMsgCd().substring(2, 6)).toString());
                    } else {
                        resHeader.setErrorMessage(responseHeaderList.get(i).getMsgDscp());
                    }
                    resHeaderList.add(resHeader);
                }
            }
            partnerResponse.setHeader(resHeaderList);
        }
        if (responseHeaderList.get(0).getMsgSev().equals(System.getProperty(entityI))) {
            AFSubmitResponseBody body = new AFSubmitResponseBody();
            body.setProcessDate(response.getFlashResponseBody().getProcessDate());
            body.setCustomerName(response.getFlashResponseBody().getCustomerName());
            body.setCustomerIDNo(response.getFlashResponseBody().getCustomerIDNo());
            body.setProcessID(response.getFlashResponseBody().getProcessID());
            partnerResponse.setBody(body);
        }
        return partnerResponse;
    }

    public List<EAIFacility> setFacilityInfo(AFAIPSubmissionRequestBody request) {

        List<EAIFacilityInsurance> insuranceList = new ArrayList<>();
        List<EAIFacility> eaiFacilities = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            EAIFacility facility = new EAIFacility();
            
           // GDTAPI-2908- set to different package code if financing amount is less than 100k or more than 500k for hybrid & national green 
            String dealer = request.getDealerName();
            facility.setFacilityPackage(validator.setValidPackageType(request.getEntity(), request.getCollateralInformation().get(i),request.getFacilityInformation().get(i).getFinancingAmount(),dealer));
           // GDTAPI-2908- set to different package code if financing amount is less than 100k or more than 500k for hybrid & national green 
            
            if (request.getEntity().equals(System.getProperty("entityC"))) {
                facility.setFacilityType(System.getProperty("facilityTypeVal1"));
            } else if (request.getEntity().equals(System.getProperty(entityI))) {
                facility.setFacilityType(System.getProperty("facilityTypeVal2"));
            }
            facility.setFec("");
            facility.setFecAmount("");
            facility.setFinancedFeeAmount("");
            facility.setFacilityPurpose(System.getProperty("facilityPurposeDefaultVal"));
            facility.setFacilityTenure(request.getFacilityInformation().get(i).getFacilityTenure());
            facility.setCashDownpayment(request.getFacilityInformation().get(i).getCashDownpayment().toString());
            facility.setExtendedWarrantyPeriod(System.getProperty(defaultValue0WithDecimal));
            facility.setFinancingAmount(request.getFacilityInformation().get(i).getFinancingAmount());
            facility.setSubsidy(System.getProperty(defaultValue0WithDecimal));
            facility.setHandlingFee(System.getProperty("handlingFeeDefaultVal"));
            facility.setInsuranceRequired(System.getProperty("defaultValueN"));
            /* GDTAPI-2951: new AF product code */ 
            /*
            if (request.getEntity().equals(System.getProperty("entityC"))) {
                facility.setProduct(System.getProperty("defaultValue01"));
            } else if (request.getEntity().equals(System.getProperty(entityI))) {
                facility.setProduct(System.getProperty("productValue"));
            }
            */
            facility.setProduct(request.getFacilityInformation().get(i).getProduct());
            /* GDTAPI-2951: new AF product code */ 
            
            facility.setInsuranceFinancedAmount(System.getProperty(defaultValue0WithDecimal));
            facility.setPromotionFees(System.getProperty(defaultValue0WithDecimal));
            facility.setSourceOfFund(request.getFacilityInformation().get(i).getSourceOfFund());

            facility.setPurposeOfAccountOpening(System.getProperty("purposeOfAccountOpening"));
            facility.setFacilityInsuranceList(insuranceList);
            eaiFacilities.add(facility);
        }
        return eaiFacilities;
    }

    public List<EAICustomer> setCustomerInfo(AFAIPSubmissionRequestBody request, DateTimeFormatter formatter) {
        List<EAICustomer> customers = new ArrayList<>();
        for (int i = 0; i < request.getCustomerInformation().size(); i++) {
            EAICustomer customer = new EAICustomer();
            customer.setAge(validator.calculateAge(request.getCustomerInformation().get(i)));
            customer.setAlternateIdNo("");
            customer.setAlternateIdType("");
            customer.setApplicantType(System.getProperty("applicantType"));
            customer.setStaffCode(System.getProperty("staffCode"));
            customer.setCustomerName(request.getCustomerInformation().get(i).getCutomerName());
            customer.setCustomerType(System.getProperty("customerType"));
            customer.setCountryOfPermanentResident(request.getCustomerInformation().get(i).getCountryOfPermanentResident());
            if (request.getCustomerInformation().get(i).getDateJoined() != null)
                customer.setDateJoined(request.getCustomerInformation().get(i).getDateJoined().format(formatter));
            if (request.getCustomerInformation().get(i).getDateOfBirth() != null)
                customer.setDateOfBirth(request.getCustomerInformation().get(i).getDateOfBirth().format(formatter));
            customer.setEducationLevel(request.getCustomerInformation().get(i).getEducationLevel());
            customer.setEmail(request.getCustomerInformation().get(i).getEmail());
            customer.setEmployerName(request.getCustomerInformation().get(i).getEmployerName());
            customer.setEmploymentSector(request.getCustomerInformation().get(i).getEmploymentSector());
            customer.setEmploymentType(request.getCustomerInformation().get(i).getEmploymentType());
            customer.setForeignPR(request.getCustomerInformation().get(i).getForeignPR());
            customer.setCisNo("");
            customer.setRelationshipToPrincipal("");
            customer.setGender(request.getCustomerInformation().get(i).getGender());
            customer.setIdNo(request.getCustomerInformation().get(i).getIdNo());
            customer.setIdType(request.getCustomerInformation().get(i).getIdType());
            customer.setInternationalExtensionPhoneNo(request.getCustomerInformation().get(i).getInternationalExtensionPhoneNo());
            customer.setInternationalPhoneNo(request.getCustomerInformation().get(i).getInternationalPhoneNo());
            customer.setInternationalPhoneNoAreaCode(request.getCustomerInformation().get(i).getInternationalPhoneNoAreaCode());
            customer.setJointDSR("");
            customer.setSourceOfWealth(request.getCustomerInformation().get(i).getSourceOfWealth());
            customer.setDrivingLicense(System.getProperty("defaultValueY"));
            customer.setLengthOfServiceYear(String.format("%02d", isValidLengthOfServiceYear(request.getCustomerInformation().get(i))));
            customer.setLengthOfServiceMonth(String.format("%02d", isValidLengthOfServiceMonth(request.getCustomerInformation().get(i))));
            customer.setMaritalStatus(request.getCustomerInformation().get(i).getMaritalStatus());
            customer.setMobilePhoneNo(request.getCustomerInformation().get(i).getMobilePhoneNo());
            customer.setMobilePhoneNoAreaCode(request.getCustomerInformation().get(i).getMobilePhoneNoAreaCode());
            setIncomeFields(request.getCustomerInformation().get(i), customer);
            customer.setNationality(System.getProperty("nationalityMY"));
            customer.setNoOfDependants(request.getCustomerInformation().get(i).getNoOfDependants());
            customer.setOccupation(request.getCustomerInformation().get(i).getOccupation());
            customer.setpRIDNo(request.getCustomerInformation().get(i).getPrIdNumber());
            customer.setRace(request.getCustomerInformation().get(i).getRace());
            customer.setResidenceType(request.getCustomerInformation().get(i).getResidenceType());
            customer.setSubEmploymentSector(request.getCustomerInformation().get(i).getSubEmploymentSector());
            customer.setComputationMode(request.getCustomerInformation().get(i).getComputationMode());

            customer.setAddress(setAddressInfo(request.getCustomerInformation().get(i)));
            customers.add(customer);
        }
        return customers;
    }

    public void setIncomeFields (AFCustomerInformation request, EAICustomer customer) {
        if (request.getMonthlyGrossIncome() != null) {
            if (!request.getMonthlyGrossIncome().toString().contains("."))
                customer.setMonthlyGrossIncome(request.getMonthlyGrossIncome().toString().concat(".00"));
            else if (request.getMonthlyGrossIncome().toString().split("\\.")[1].length() == 1)
                customer.setMonthlyGrossIncome(request.getMonthlyGrossIncome().toString().concat("0"));
            else
                customer.setMonthlyGrossIncome(request.getMonthlyGrossIncome().toString());
        }
        if (request.getMonthlyNetIncome() != null) {
            if (!request.getMonthlyNetIncome().toString().contains("."))
                customer.setMonthlyNetIncome(request.getMonthlyNetIncome().toString().concat(".00"));
            else if (request.getMonthlyNetIncome().toString().split("\\.")[1].length() == 1)
                customer.setMonthlyNetIncome(request.getMonthlyNetIncome().toString().concat("0"));
            else
                customer.setMonthlyNetIncome(request.getMonthlyNetIncome().toString());
        }
    }

    public List<EAIAddress> setAddressInfo(AFCustomerInformation request) {
        List<EAIAddress> eaiAddresses = new ArrayList<>();
        for (int j = 0; j < request.getAddressInformation().size(); j++) {
            EAIAddress address = new EAIAddress();
            address.setAddressLine1(request.getAddressInformation().get(j).getAddressLine1());
            address.setAddressLine2(request.getAddressInformation().get(j).getAddressLine2());
            address.setAddressLine3(request.getAddressInformation().get(j).getAddressLine3());
            address.setAddressType(request.getAddressInformation().get(j).getAddressType());
            address.setCity(request.getAddressInformation().get(j).getCity());
            address.setCountry(System.getProperty("nationalityMY"));
            address.setState(validator.setStateCode(request.getAddressInformation().get(j)));
            address.setPostcode(request.getAddressInformation().get(j).getPostcode());
            eaiAddresses.add(address);
        }
        return eaiAddresses;
    }
    public List<EAICollateral> setCollateralInfo(AFAIPSubmissionRequestBody request, DateTimeFormatter formatter) throws JSONException {

        List<EAICollateral> eaiCollaterals = new ArrayList<>();
        for (int i = 0; i < request.getCollateralInformation().size(); i++) {
            EAICollateral eaiCollateral = new EAICollateral();
            eaiCollateral.setCollateralType(System.getProperty("collateralType"));
            eaiCollateral.setCertificateAmount("");

            eaiCollateral.setMakeofVehicle(new JSONObject(System.getProperty("vehicleMake")).get(request.getCollateralInformation().get(i).getModelOfVehicle()).toString());
            eaiCollateral.setChassisNo(request.getCollateralInformation().get(i).getChassisNo());
            eaiCollateral.setEngineNo(request.getCollateralInformation().get(i).getEngineNo());
            eaiCollateral.setModelofVehicle(request.getCollateralInformation().get(i).getModelOfVehicle());
            if (request.getCollateralInformation().get(i).getMarketValue() == null) {
                eaiCollateral.setMarketValue(null);
            } else {
                eaiCollateral.setMarketValue(request.getCollateralInformation().get(i).getMarketValue().toString());
                if (!eaiCollateral.getMarketValue().contains("."))
                    eaiCollateral.setMarketValue(eaiCollateral.getMarketValue().concat(".00"));
                else if (eaiCollateral.getMarketValue().split("\\.")[1].length() == 1)
                    eaiCollateral.setMarketValue(eaiCollateral.getMarketValue().concat("0"));
            }
            eaiCollateral.setbDMmorethan25kg(request.getCollateralInformation().get(i).getBdmMoreThan2500kg());
            eaiCollateral.setPurchasePriceOTR(request.getCollateralInformation().get(i).getPurchasePrice().toString());
            if (!eaiCollateral.getPurchasePriceOTR().contains("."))
                eaiCollateral.setPurchasePriceOTR(eaiCollateral.getPurchasePriceOTR().concat(".00"));
            else if (eaiCollateral.getPurchasePriceOTR().split("\\.")[1].length() == 1)
                eaiCollateral.setPurchasePriceOTR(eaiCollateral.getPurchasePriceOTR().concat("0"));
            if (request.getCollateralInformation().get(i).getRegistrationDate() != null)
                eaiCollateral.setRegistrationDate(request.getCollateralInformation().get(i).getRegistrationDate().format(formatter));
            eaiCollateral.setRegistrationNo(request.getCollateralInformation().get(i).getRegistrationNo().toUpperCase(Locale.ROOT));
            eaiCollateral.setVehicleCondition(request.getCollateralInformation().get(i).getVehicleCondition());
            eaiCollateral.setVehicleType(new JSONObject(System.getProperty("vehicleTypeList")).opt(request.getCollateralInformation().get(i).getModelOfVehicle()).toString());
            eaiCollateral.setVehicleUsage(System.getProperty("vehicleUsage"));
            eaiCollateral.setYearMake(request.getCollateralInformation().get(i).getYearMake());
            eaiCollateral.setPropertyType("");
            eaiCollateral.setPropertyPostcode("");
            eaiCollateral.setPropertyState("");
            eaiCollateral.setCollateralValue("");
            eaiCollateral.setVehicleMarketValue("");
            eaiCollaterals.add(eaiCollateral);
        }
        return eaiCollaterals;
    }
    private String createXmlString(EAIRequest request) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(EAIRequest.class);
            Marshaller m = context.createMarshaller();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
            m.marshal(request, doc);

            MessageFactory mfactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = mfactory.createMessage();
            SOAPBody soapBody = soapMessage.getSOAPBody();
            soapBody.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            soapBody.addDocument(doc);
            createSOAPHeader(soapMessage);
            var baos = new ByteArrayOutputStream();
            soapMessage.writeTo(baos);
            xmlString = baos.toString(StandardCharsets.UTF_8);
            xmlString = xmlString.replace("&#13;", " ");
            xmlString = xmlString.replace("&#0;", "");
            xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + xmlString;
        } catch (JAXBException | SOAPException | ParserConfigurationException | IOException e) {
            LOG.info(e.getMessage());
        }
        return xmlString;
    }

    private SOAPElement addBinarySecurityToken(SOAPElement securityElement,
                                               String cert) {
        try {
            SOAPElement binarySecurityToken = securityElement.addChildElement("BinarySecurityToken", "wsse");
            binarySecurityToken.setAttribute("ValueType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3");
            binarySecurityToken.setAttribute("EncodingType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
            binarySecurityToken.addTextNode(cert);
        } catch (SOAPException e) {
            LOG.info(e.getMessage());
        }
        return securityElement;
    }

    private SOAPMessage createSOAPHeader(SOAPMessage soapMessage) {
        // Create the security element
        try {
            SOAPElement soapHeader = soapMessage.getSOAPHeader();

            SOAPElement securityElement = soapHeader.addChildElement("Security",
                    "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

            securityElement.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

            addBinarySecurityToken(securityElement, System.getProperty("SecurityToken"));

        } catch (SOAPException e) {
            LOG.info(e.getMessage());
        }
        return soapMessage;
    }

    private static X509Certificate loadCertificate(File certificateFile) throws IOException, CertificateException {
        try (FileInputStream inputStream = new FileInputStream(certificateFile)) {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(inputStream);
        }
    }

    private static SSLSocketFactory createSslSocketFactory(KeyStore trustStore) throws GeneralSecurityException {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        TrustManager[] trustManagers = tmf.getTrustManagers();

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, trustManagers, null);
        return sslContext.getSocketFactory();
    }

    public String callSoapService(String soapRequest) {
        String responseString;
        StringBuilder outputString = new StringBuilder();
        String formattedSOAPResponse = "";
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            URL url = new URL(System.getProperty("afSubmitUrl"));
            if (url.toString().startsWith("http://")) {
                    URLConnection connection = url.openConnection();
                    HttpURLConnection httpConn = (HttpURLConnection) connection;
                    byte[] buffer = soapRequest.getBytes();
                bout.write(buffer);
                byte[] b = bout.toByteArray();
                httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
                httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
                httpConn.setRequestMethod("POST");
                httpConn.setDoOutput(true);
                httpConn.setDoInput(true);
                OutputStream out = httpConn.getOutputStream();
                // Write the content of the request to the outputstream of the HTTP Connection.
                out.write(b);
                out.close();
                // Ready with sending the request.
                // Read the response.
                InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(isr);
                // Write the SOAP message response to a String.
                while ((responseString = in.readLine()) != null) {
                    outputString.append(responseString);
                }
                // Write the SOAP message formatted to the console.
                formattedSOAPResponse = formatXML(outputString.toString());

            } else if (url.toString().startsWith("https://")) {
                // Create a new trust store, use getDefaultType for .jks files or "pkcs12" for .p12 files
                KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
                // Create a new trust store, use getDefaultType for .jks files or "pkcs12" for .p12 files
                trustStore.load(null, null);

                // If you comment out the following, the request will fail
                trustStore.setCertificateEntry(
                        "test",
                        // To test, download the certificate from stackoverflow.com with your browser
                        loadCertificate(new File("/apps/sb/" + System.getProperty("certKeyName")))
                );
                fis = new FileInputStream("/apps/sb/" + System.getProperty("certKeyName"));
                byte[] buffer = new byte[10];
                StringBuilder sb = new StringBuilder();
                while (fis.read(buffer) != -1) {
                    sb.append(new String(buffer));
                    buffer = new byte[10];
                }

                SSLSocketFactory sslSocketFactory = createSslSocketFactory(trustStore);

                OkHttpClient client = new OkHttpClient().
                        setSslSocketFactory(sslSocketFactory);
                MediaType mediaType = MediaType.parse("application/xml");
                RequestBody body = RequestBody.create(mediaType, soapRequest);
                Request request = new Request.Builder()
                        .url(url)
                        .method("POST", body)
                        .addHeader("Content-Type", "application/xml")
                        .build();
                Response response = client.newCall(request).execute();

                // Write the SOAP message formatted to the console.
                formattedSOAPResponse = formatXML(response.body().string());
            }
        } catch (IOException | GeneralSecurityException e) {
            LOG.error(e.getMessage());
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
        return formattedSOAPResponse;
    }



    // format the XML in pretty String
    private static String formatXML(String unformattedXml) {
        try {
            Document document = parseXmlFile(unformattedXml);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            transformerFactory.setAttribute("indent-number", 3);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            transformer.transform(source, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (TransformerException e) {
            LOG.info(e.getMessage());
        }
        return null;
    }

    // parse XML
    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            dbf.setExpandEntityReferences(false);

            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            LOG.info(e.getMessage());
        }
        return null;
    }

    public Integer isValidLengthOfServiceYear(AFCustomerInformation afCustomerInformation) {
        int calculateServiceYear = 0;
        if (afCustomerInformation.getDateJoined() != null) {
            try {
                LocalDate dateOfJoin = afCustomerInformation.getDateJoined();
                LocalDate todaysDate = LocalDate.now();
                calculateServiceYear = Period.between(dateOfJoin, todaysDate).getYears();
            } catch (DateTimeParseException e) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty("dataTypeErrorCode"));
                messageList.setErrorMessage(System.getProperty("invalidDataTypeErrorCode"));
                messageList.setErrorTag("dateJoined");
                if (e.getLocalizedMessage().contains(":"))
                    messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                else messageList.setErrorDesc("Input data is invalid format");
            }
        }
        return calculateServiceYear;
    }

    public Integer isValidLengthOfServiceMonth(AFCustomerInformation afCustomerInformation) {
        int calculateServiceMonth = 0;
        List<AFSubmissionResHeader> list = new ArrayList<>();
        if (afCustomerInformation.getDateJoined() != null) {
            try {
                /* GDTAPI-2900- fix date join culculation */
                LocalDate dateOfJoin = afCustomerInformation.getDateJoined();
                LocalDate todaysDate = LocalDate.now();                
                
                long monthsDifference = ChronoUnit.MONTHS.between(dateOfJoin, todaysDate);
                calculateServiceMonth = (int) (monthsDifference % 12);               
                
                int daydateOfJoin = dateOfJoin.getDayOfMonth();
                int daytodaysDate = todaysDate.getDayOfMonth();
                if (daydateOfJoin> daytodaysDate)
                {
                    calculateServiceMonth = calculateServiceMonth + 1;
                }
                
                 /* GDTAPI-2900- fix date join culculation */
            } catch (DateTimeParseException e) {
                AFSubmissionResHeader messageList = new AFSubmissionResHeader();
                messageList.setErrorCode(System.getProperty("dataTypeErrorCode"));
                messageList.setErrorMessage(System.getProperty("invalidDataTypeErrorCode"));
                messageList.setErrorTag("dateJoined");
                if (e.getLocalizedMessage().contains(":"))
                    messageList.setErrorDesc(e.getLocalizedMessage().split(":")[1]);
                else messageList.setErrorDesc("Input data is invalid format");
                list.add(messageList);
            }
        }
        return calculateServiceMonth;
    }
}



