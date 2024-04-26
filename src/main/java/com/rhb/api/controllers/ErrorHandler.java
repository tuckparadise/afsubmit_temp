package com.rhb.api.controllers;
import com.google.gson.Gson;
import com.rhb.api.models.AFSubmissionResHeader;
import com.rhb.api.models.AFSubmissionResponse;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleAllUncaughtException(
            NullPointerException exception,
            WebRequest request) {
        exception.printStackTrace();
        AFSubmissionResponse response = new AFSubmissionResponse();
        AFSubmissionResHeader header = new AFSubmissionResHeader();
        List<AFSubmissionResHeader> list = new ArrayList<>();
        header.setErrorDesc(System.getProperty("invalidRequestErrorDesc"));
        header.setErrorCode(System.getProperty("invalidReqCode"));
        header.setErrorMessage(System.getProperty("invalidReqMsg"));
        header.setErrorTag("Request Payload");
        list.add(header);
        response.setHeader(list);
        Gson gson = new Gson();
        return gson.toJson(response);
    }
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleException(HttpMessageNotReadableException exception, HttpServletRequest request) {
        exception.printStackTrace();
        AFSubmissionResponse response = new AFSubmissionResponse();
        Gson gson = new Gson();
        List<AFSubmissionResHeader> list = new ArrayList<>();
        AFSubmissionResHeader messageList = new AFSubmissionResHeader();
        String[] errorArray = exception.getLocalizedMessage().split("Source:");
        if (errorArray.length > 0 && errorArray.length <= 4) {
            if(exception.getLocalizedMessage().contains("DateTimeParseException") || exception.getLocalizedMessage().contains("could not be parsed")){
                messageList.setErrorCode(System.getProperty("invalidFormatErrorCode"));
                messageList.setErrorMessage(System.getProperty("dateMismatchErrorCode"));
                messageList.setErrorTag(exception.getLocalizedMessage().split("\"")[3]);
                messageList.setErrorDesc(System.getProperty("invalidFormatErrorDesc"));
                list.add(messageList);
                response.setHeader(list);

                return gson.toJson(response);
            }
            else if(exception.getLocalizedMessage().contains("JsonParseException") || exception.getLocalizedMessage().contains("JsonMappingException") || exception.getLocalizedMessage().contains("HttpMessageNotReadableException") || exception.getLocalizedMessage().contains("expected a value") || exception.getLocalizedMessage().contains("Unrecognized field")) {
                messageList.setErrorCode(System.getProperty("invalidReqCode"));
                messageList.setErrorMessage(System.getProperty("invalidReqMsg"));
                messageList.setErrorTag("Json Format Error");
                messageList.setErrorDesc(System.getProperty("invalidRequestErrorDesc"));
                list.add(messageList);
                response.setHeader(list);

                return gson.toJson(response);
            }
            else  {

                if (exception.getLocalizedMessage().contains("BigDecimal") || exception.getLocalizedMessage().contains("int")) {
                    messageList.setErrorCode(System.getProperty("dataTypeErrorCode"));
                    messageList.setErrorMessage(System.getProperty("invalidDataTypeErrorCode"));
                    messageList.setErrorDesc(System.getProperty("datatypeErrorDesc"));
                    messageList.setErrorTag(exception.getLocalizedMessage().split("\"")[7]);
                }
                else {
                    messageList.setErrorMessage(System.getProperty("dateMismatchErrorCode"));
                    messageList.setErrorTag(exception.getLocalizedMessage().split("\"")[3]);
                    messageList.setErrorCode(System.getProperty("invalidFormatErrorCode"));
                    messageList.setErrorDesc(System.getProperty("invalidFormatErrorDesc"));
                }
            }
        }

        list.add(messageList);
        response.setHeader(list);

        return gson.toJson(response);
    }
}
